import api from '../api'
import { comments, host } from './URLS.js'

export default {
    async getComments(postID) {
        const config = {
            method: 'get',
            url: `${host}/post/${postID}${comments}`
        }
        return api(config).catch(error => {
            throw error
        })
    },

    async createComment(postID, comment) {
        const config = {
            method: 'post',
            url: `${host}/post/${postID}${comments}`,
            data: comment
        }
        return api(config).catch(error => {
            throw error
        })
    },

    async updatePost(postID, commentID, comment) {
        const config = {
            method: 'update',
            url: `${host}/post/${postID}${comments}/${commentID}`,
            data: comment
        }
        return api(config).catch(error => {
            throw error
        })
    }
}
