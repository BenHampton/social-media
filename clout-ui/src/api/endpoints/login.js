import api from '../api'
import { login, host } from './URLS.js'
// let headers = {
//     Accept: 'application/json',
//     'Content-type': 'application/json',
//     'Access-Control-Allow-Origin': '*'
// }

export default {
    async login(username, email, password) {
        const config = {
            method: 'get',
            url: `${host}${login}?username=${username}&email=${email}&password=${password}`
        }
        return api(config).catch(error => {
            throw error
        })
    }
}
