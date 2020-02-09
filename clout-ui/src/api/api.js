import axios from 'axios'
//import i18n from '@/localization'
/**
 * Actual API request function (called from specific endpoints)
 * @param  {Object} endpoint Config object containing method, url, and payload
 * @return {[Any]}           Data returned from API
 */
export default async function(config) {
    try {
        const response = await axios(config)
        return response.data
    } catch (error) {
        if (error.response) {
            // The request was made and the server responded with a status code
            // that falls out of the range of 2xx
            const { status, statusText, data } = error.response
            const e = new Error(
                `${status} ${statusText} <pre>${JSON.stringify(
                    data,
                    null,
                    2
                )}</pre>`
            )
            /*eslint-disable */
            console.error(e)
            /*eslint-enable */
            throw e
        } else if (error.request) {
            // The request was made but no response was received
            // `error.request` is an instance of XMLHttpRequest in the browser and an instance of
            // http.ClientRequest in node.js
            // throw new Error(
            //     `${i18n.t(
            //         'messages.serverError.serverConnection'
            //     )} <pre>${JSON.stringify(error.request, null, 2)}</pre>`
            // )
        } else {
            // Something happened in setting up the request that triggered an Error
            const message = error.message // || i18n.t('messages.serverError.unknown')
            throw new Error(message)
        }
    }
}
