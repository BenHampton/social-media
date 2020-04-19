import api from '../api'
import { webScrappingHost, openGraph } from './URLS.js'

export default {
    async retrieveUrlData(url) {
        const config = {
            method: 'get',
            url: `${webScrappingHost}${openGraph}?url=${url}`
        }
        return api(config).catch(error => {
            throw error
        })
    }
}
