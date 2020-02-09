<template>
    <v-container fluid ma-0 pa-0>
        <v-layout row>
            <v-flex xs10>
                <v-text-field
                    placeholder="Clout Material"
                    v-model="postContent"
                >
                </v-text-field>
            </v-flex>
            <v-flex xs2>
                <BaseButton value="Post" :onClick="postStatus"> </BaseButton>
            </v-flex>
        </v-layout>
    </v-container>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import BaseButton from '../../../components/BaseButton'

export default {
    name: 'PostMaterial',
    components: {
        BaseButton
    },
    props: {
        userId: {
            type: Number,
            required: true
        }
    },
    data() {
        return {
            postContent: ''
        }
    },
    methods: {
        ...mapActions('Post', ['createPost']),
        async postStatus() {
            if (this.postContent.length !== 0) {
                await this.createPost({
                    post: this.postContent,
                    userId: this.userId
                })
                this.postContent = ''
            }
        }
    }
}
</script>

<style></style>
