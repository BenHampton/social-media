<template>
    <div class="status-container">
        <div class="search">
            <v-text-field
                placeholder="Search for friend"
                v-model="value"
                @input="debounceInputChange"
            />

            <div v-for="(suggestion, key) in suggestions" :key="key">
                <!-- !suggestion.getRelationship.code === 3 will be updated and should be handled at the backend -->
                <v-expand-transition>
                    <v-card class="card">
                        <v-card-text class="card-text-container">
                            <div
                                class="text"
                                @click="
                                    handleSelectedOption(suggestion.friend.id)
                                "
                            >
                                <div class="image">
                                    {{ suggestion.friend.logo }}
                                </div>
                                <div>
                                    {{ suggestion.friend.username }}
                                </div>
                            </div>
                            <div class="status-container">
                                <TheUpdateFriendStatus
                                    :relationship="suggestion.relationship"
                                    :ID="suggestion.friend.id"
                                />
                            </div>
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
import TheUpdateFriendStatus from './TheUpdateFriendStatus'
import { mapActions, mapState } from 'vuex'
export default {
    name: 'BaseAutoFriendSearch',
    components: { TheUpdateFriendStatus },
    props: {
        debounce: {
            type: Number,
            default: 500
        },
        user: {
            type: Object,
            required: true
        }
    },
    computed: {
        ...mapState('friend', ['friend', 'friendSearch'])
        //WTF WAS I DOING LOL
        // items() {
        //     return this.entries.map(entry => {
        //         const username = entry.username

        //         return Object.assign({}, entry, { username })
        //     })
        // }
    },
    data() {
        return {
            minSearchLength: 1,
            suggestions: [],
            value: '',

            searchResults: [],

            debounceInputChange: null,

            searchUser_isLoading: false,
            searchUser_error: null
        }
    },
    methods: {
        ...mapActions('friend', ['searchForUsers', 'findFriend']),
        ...mapActions('relationship', ['findRelationship']),
        async querySearchAsync(queryString, autocomplete) {
            if (!queryString || queryString.length < this.minSearchLength) {
                autocomplete([])
                return
            }

            try {
                this.searchUser_isLoading = true
                this.searchUser_error = null

                let results = await endpoints.searchForUsers(queryString)

                let promises = []

                results.forEach(result =>
                    promises.push(this.getRelationship(result))
                )

                await Promise.all(promises).catch(error => {
                    throw error
                })

                this.searchResults = this.searchResults.filter(() => true)

                autocomplete(this.searchResults)
            } catch (error) {
                autocomplete([])
                this.searchUser_error = error
            } finally {
                this.searchUser_isLoading = false
            }
        },
        async getRelationship(friend) {
            const friendID = friend.id
            try {
                this.$set(this.searchResults, friendID, {
                    loading: true,
                    error: null,
                    friend: null,
                    relationship: null
                })

                let response = await this.findRelationship({
                    userID: this.user.id,
                    friendID: friendID
                })

                this.searchResults[friendID].relationship = response
                this.searchResults[friendID].friend = friend
            } catch (error) {
                this.searchResults[friendID].error = error
            } finally {
                this.searchResults[friendID].loading = false
            }
        },
        updateSuggestions(results) {
            this.suggestions = results
        },
        inputChange() {
            if (this.value.length <= this.minSearchLength) {
                return
            }
            this.suggestions = []
            this.searchResults = []
            this.querySearchAsync(this.value, this.updateSuggestions.bind(this))
        },
        async handleSelectedOption(ID) {
            await this.findFriend(ID)
            this.routeToFriend()
        },
        routeToFriend() {
            if (!this.friend) {
                return
            }
            this.$router.push({
                name: 'Friend',
                params: { userID: this.friend.id }
            })
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

.search {
    width: 100%;
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

    .card-text-container {
        display: flex;

        .text {
            width: 100%;
            display: flex;
        }

        .image {
            margin-right: 30%;
        }
    }
}
</style>
