<template>
    <v-layout align-center justify-end row fill-height>
        <v-text-field
            placeholder="Seach For Friend"
            class="search-bar"
            v-model="searchQuery"
        >
        </v-text-field>
        <BaseButton value="Search" :onClick="queryFriendSearch"> </BaseButton>
    </v-layout>
</template>

<script>
import { mapActions } from 'vuex'
import BaseButton from '../../../components/BaseButton'
export default {
    name: 'SearchFriends',
    components: {
        BaseButton
    },
    data() {
        return {
            searchQuery: ''
        }
    },
    methods: {
        ...mapActions('SearchFriend', ['fetchQueryFriendSearch']),
        async queryFriendSearch() {
            if (this.searchQuery.length !== 0) {
                await this.fetchQueryFriendSearch(this.searchQuery)
                this.searchQuery = ''
                this.$router.push({ name: 'Friends' })
            }
        }
    }
}
</script>

<style scoped></style>
