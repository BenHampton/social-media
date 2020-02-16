<template>
    <div class="fast-timeline-container">
        <div>
            <BaseAutoFriendSearch />
        </div>
    </div>
</template>

<script>
import { mapActions } from 'vuex'
import BaseAutoFriendSearch from '../../../components/BaseAutoFriendSearch'
export default {
    name: 'FastTimeLine',
    components: {
        BaseAutoFriendSearch
    },
    data() {
        return {
            searchQuery: ''
        }
    }
}
</script>

<style scoped></style>
