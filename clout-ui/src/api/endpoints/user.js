import api from '../api'
import { users, host } from './URLS.js'

export default {
    async searchForUsers(searchTerm) {
        const config = {
            method: 'get',
            url: `${host}${users}/user-responses?searchTerm=${searchTerm}`
        }
        return api(config).catch(error => {
            throw error
        })
    },
    async createUser(signUp) {
        const config = {
            method: 'get',
            url: `${host}${users}`,
            data: signUp
        }
        return api(config).catch(error => {
            throw error
        })
    },
    async updateStatus(user) {
        const config = {
            method: 'put',
            url: `${host}${users}/status`,
            data: user
        }
        return api(config).catch(error => {
            throw error
        })
    },
    async findFriend(ID) {
        const config = {
            method: 'get',
            url: `${host}${users}/${ID}`
        }
        return api(config).catch(error => {
            throw error
        })
    }
}
