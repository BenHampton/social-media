<template>
    <v-container>
        <v-layout row>
            <v-flex v-if="this.getPosts.length !== 0" xs12 fluid ma-0 pa-0>
                <span class="posts-title">
                    Clout Posts
                </span>
                <div
                    v-for="post in this.getPosts"
                    :key="post.id"
                    class="post-card"
                >
                    <v-card>
                        <v-card-title>
                            createBy/friendPostedToUser - {{ post.createdAt }}
                        </v-card-title>
                        <v-card-text class="post-content">
                            {{ post.content }}
                        </v-card-text>
                        <v-card-actions class="post-actions" fluid ma-0 pa-0>
                            <span class="emoji">
                                emojis
                            </span>
                            <span class="like">
                                like
                            </span>
                            <span class="comment">
                                comment
                            </span>
                        </v-card-actions>
                    </v-card>
                </div>
            </v-flex>
        </v-layout>
    </v-container>
</template>

<script>
import { mapState, mapActions, mapGetters } from 'vuex'

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
        ...mapState('Post', ['posts']),
        ...mapGetters('Post', ['getPosts'])
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
