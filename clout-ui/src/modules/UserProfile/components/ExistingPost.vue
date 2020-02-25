<template>
    <div>
        EXISTING_POST
    </div>
</template>

<script>
import { mapState, mapActions } from 'vuex'

export default {
    name: 'ExistingPost',
    created() {
        this.fetchPost(this.userId)
    },
    props: {
        userId: {
            type: Number,
            required: true
        }
    },
    methods: {
        ...mapActions('Post', ['fetchPost']),
        async retrievePosts() {
            await this.fetchPost({
                userId: this.userId
            })
        }
    },
    computed: {
        ...mapState('Post', ['posts'])
    }
}
</script>

<style scoped>
.posts-title {
    font-size: 25px;
    width: 100%;
    margin-bottom: 1%;
}
.post-content {
    margin-left: 5%;
}
.post-card {
    margin-bottom: 1%;
}
.post-actions {
    margin-left: 75%;
}
.emoji {
    cursor: pointer;
}
.like {
    padding-left: 5%;
    cursor: pointer;
}
.comment {
    padding-left: 5%;
    padding-right: 3%;
    cursor: pointer;
}
</style>
