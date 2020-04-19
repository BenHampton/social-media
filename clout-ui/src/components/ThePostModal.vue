<template>
    <div class="post-container">
        <BaseButton
            :onClick="openPostDialog"
            backgroundColor="#2e2d2d"
            class="clout-out-button"
        >
            Clout Out
        </BaseButton>
        <v-app>
            <v-dialog v-model="showPostDialog" width="500">
                <div class="custom">
                    <v-card>
                        <v-card-text>
                            <v-text-field
                                label="URL"
                                v-model="url"
                                @input="updatePost"
                                :disabled="isUrlData_loading"
                            >
                            </v-text-field>
                            <BaseSpinner v-if="isUrlData_loading" />
                        </v-card-text>
                        <span v-if="showPostPreview">
                            <v-card-text>
                                <div>
                                    Tag a friend
                                </div>

                                <!-- TODO add BaseSelect -->
                            </v-card-text>

                            <v-divider></v-divider>

                            <v-img
                                v-if="post.image"
                                height="200px"
                                :src="post.image"
                            >
                            </v-img>
                            <v-card-title>
                                {{ post.title }}
                            </v-card-title>
                            <v-card-text>
                                <div v-if="post.description">
                                    {{ post.description }}
                                </div>
                            </v-card-text>

                            <v-divider></v-divider>
                        </span>
                        <v-card-actions>
                            <v-spacer></v-spacer>
                            <BaseButton
                                :onClick="handleSharePost"
                                :disabled="!showPostPreview"
                            >
                                Share Post
                            </BaseButton>
                            <BaseButton :onClick="closePostDialog">
                                Cancel
                            </BaseButton>
                        </v-card-actions>
                    </v-card>
                </div>
            </v-dialog>
        </v-app>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import BaseButton from './BaseButton'
import BaseSpinner from './BaseSpinner'
export default {
    name: 'ThePostModal',
    components: { BaseButton, BaseSpinner },
    props: {
        user: {
            type: Object,
            required: true
        }
    },
    data() {
        return {
            showPostDialog: false,
            url: '',
            post: []
        }
    },
    computed: {
        ...mapState(['isUrlData_loading', 'isUrlData_error']),
        showPostPreview() {
            if (this.post.length) {
                return false
            }
            return (
                (this.post.image || this.post.description) &&
                this.post.title &&
                !this.isUrlData_loading &&
                !this.isUrlData_error
            )
        }
    },
    methods: {
        ...mapActions(['retrieveUrlData']),
        async updatePost() {
            if (this.url.length > 3) {
                this.post = await this.retrieveUrlData(this.url)
            }
        },
        async handleSharePost() {
            console.log('handleSharePost')
        },
        openPostDialog() {
            this.showPostDialog = true
        },
        closePostDialog() {
            this.resetDialog()
            this.showPostDialog = false
        },
        resetDialog() {
            this.url = ''
            this.post = []
        }
    }
}
</script>

<style scoped lang="scss">
.post-container {
    .post {
        background: #2e2d2d;
        color: white;
        margin: 0 20% 0 20%;
    }

    .post-button-container {
        width: 100%;
        text-align: center;
    }

    .card-text {
        color: white;
    }

    .share-button {
        margin-top: 5px;
        color: #2e2d2d;
    }
    .clout-out-button {
        margin-top: 5px;
        color: white;
    }
}
</style>
