import api from '../api'
import { relationships, host } from './URLS.js'

export default {
    async findRelationship(userID) {
        const config = {
            method: 'get',
            url: `${host}${users}/${userID}`
        }
        return api(config).catch(error => {
            throw error
        })
    },

    async createRelationship(relationship) {
        const config = {
            method: 'post',
            url: `${host}${users}`,
            data: relationship
        }
        return api(config).catch(error => {
            throw error
        })
    },

    async updateRelationship(relationship) {
        const config = {
            method: 'put',
            url: `${host}${users}`,
            data: relationship
        }
        return api(config).catch(error => {
            throw error
        })
    }
}
