import api from '../api'
import { posts, host } from './URLS.js'

export default {
    async getPost(ID) {
        const config = {
            method: 'get',
            url: `${host}${posts}/${ID}`
        }
        return api(config).catch(error => {
            throw error
        })
    },

    async createPost(post) {
        const config = {
            method: 'post',
            url: `${host}${posts}`,
            data: post
        }
        return api(config).catch(error => {
            throw error
        })
    },

    async updatePost(ID, post) {
        const config = {
            method: 'update',
            url: `${host}${posts}/${ID}`,
            data: post
        }
        return api(config).catch(error => {
            throw error
        })
    }
}
