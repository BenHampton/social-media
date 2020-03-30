<template>
    <div class="fast-timeline-container">
        <div>
            <BaseAutoFriendSearch :user="user" />
        </div>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import BaseAutoFriendSearch from '../../../components/BaseAutoFriendSearch'
export default {
    name: 'FastTimeLine',
    components: {
        BaseAutoFriendSearch
    },
    computed: {
        ...mapState(['user'])
    },
    data() {
        return {
            searchQuery: ''
        }
    }
}
</script>

<style scoped></style>
