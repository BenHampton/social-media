<template>
    <v-container fluid ma-0 pa-0>
        <v-layout row>
            {{ user }}
            <SearchFriends></SearchFriends>
        </v-layout>
        <v-layout row>
            <v-flex xs12>
                <v-card>
                    <v-card-text>
                        <InputStatus :user="this.user" :showLogo="true">
                        </InputStatus>
                    </v-card-text>
                </v-card>
            </v-flex>
        </v-layout>
        <v-layout row>
            <v-flex>
                <v-card dark tile flat>
                    <v-card-text>
                        <NewsFeedCard></NewsFeedCard>
                    </v-card-text>
                </v-card>
            </v-flex>
        </v-layout>
    </v-container>
</template>

<script>
import { mapState, mapMutations } from 'vuex'
import NewsFeedCard from './components/NewsFeedCard'
import InputStatus from '../../components/InputStatus'
import SearchFriends from './components/SearchFriends'
export default {
    name: 'Newsfeed',
    components: {
        NewsFeedCard,
        InputStatus,
        SearchFriends
    },
    methods: {
        ...mapMutations(['setUser'])
    },
    computed: {
        ...mapState(['user'])
    }
}
</script>

<style></style>
