<template>
    <div class="status-container">
        <div>
            <v-text-field
                placeholder="Search for friend"
                v-model="value"
                @input="debounceInputChange"
            />

            <div v-for="(person, key) in suggestions" :key="key">
                <v-expand-transition>
                    <v-card class="card" @click="routeToFriendPage(person.id)">
                        <v-card-text>
                            <div>{{ person.logo }} {{ person.username }}</div>
                        </v-card-text>
                    </v-card>
                </v-expand-transition>
            </div>
        </div>
    </div>
</template>

<script>
import endpoints from '../api/endpoints'
import debounce from 'debounce'
export default {
    name: 'BaseAutoFriendSearch',
    props: {
        debounce: {
            type: Number,
            default: 300
        }
    },
    computed: {
        items() {
            return this.entries.map(entry => {
                const username = entry.username

                return Object.assign({}, entry, { username })
            })
        }
    },
    data() {
        return {
            minSearchLength: 1,
            suggestions: [],
            value: '',

            debounceInputChange: null,

            findUser_isLoading: false,
            findUser_error: null
        }
    },
    methods: {
        async querySearchAsync(queryString, autocomplete) {
            if (!queryString || queryString.length < this.minSearchLength) {
                console.log('in 2')
                autocomplete([])
                return
            }

            try {
                this.findUser_isLoading = true
                this.findUser_error = null

                let response = await endpoints.findUsers(queryString)
                autocomplete(response)
            } catch (error) {
                autocomplete([])
                this.findUser_error = error
            } finally {
                this.findUser_isLoading = false
            }
        },
        updatedSuggestions(results) {
            this.suggestions = results
        },
        inputChange() {
            if (this.value.length <= this.minSearchLength) {
                return
            }
            this.suggestions = []
            this.querySearchAsync(
                this.value,
                this.updatedSuggestions.bind(this)
            )
        },
        routeToFriendPage(id) {
            console.log('Coming Soon - routing to friend page, id: ', id)
        }
    },
    mounted() {
        this.debounceInputChange = debounce(this.inputChange, this.debounce)
    }
}
</script>

<style scoped lang="scss">
.status-container {
    position: relative;
    display: flex;
    width: 100%;
    padding: 5%;
}

.image-container {
    background: tan;
}

.status-button {
    margin-top: 5px;
    color: white;
}

.card {
    cursor: pointer;
    margin-bottom: 1px;

    &:hover {
        background: rgba(46, 45, 45, 0.1);
    }
}
</style>
