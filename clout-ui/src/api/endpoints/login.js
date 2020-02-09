import api from '../api'
const host = 'http://localhost:8080'
const loginAPI = '/login'
let headers = {
    Accept: 'application/json',
    'Content-type': 'application/json',
    'Access-Control-Allow-Origin': '*'
}

export default {
    async login(request) {
        const config = {
            method: 'post',
            url: `${host}${loginAPI}`,
            data: request,
            headers: headers
        }
        return api(config).catch(error => {
            throw error
        })
    }
}
