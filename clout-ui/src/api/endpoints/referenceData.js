import api from '../api'
import { referenceData, host } from './URLS.js'

export default {
    async getStatusCodes() {
        const config = {
            method: 'get',
            url: `${host}${referenceData}/status-codes`
        }
        return api(config).catch(error => {
            throw error
        })
    }
}
