import api from '../api'
import { relationships, host } from './URLS.js'

export default {
    // async findRelationship(userID) {
    //     const config = {
    //         method: 'get',
    //         url: `${host}${users}/${userID}`
    //     }
    //     return api(config).catch(error => {
    //         throw error
    //     })
    // },
    async findRelationship(userID, friendID) {
        const config = {
            method: 'GET',
            url: `${host}${relationships}/user/${userID}/friend/${friendID}`
        }
        return api(config).catch(error => {
            throw error
        })
    },

    async createRelationship(createRelationship) {
        const config = {
            method: 'POST',
            url: `${host}${relationships}`,
            data: createRelationship
        }

        return api(config).catch(error => {
            throw error
        })
    },

    async updateRelationship(updateRelationship) {
        const config = {
            method: 'PUT',
            url: `${host}${relationships}`,
            data: updateRelationship
        }

        return api(config).catch(error => {
            throw error
        })
    }
}
