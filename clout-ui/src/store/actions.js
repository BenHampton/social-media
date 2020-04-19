import endpoints from '../api/endpoints'

export default {
    async login({ commit }, { username, email, password }) {
        try {
            commit('setLoginLoading', true)
            let response = await endpoints.login(username, email, password)
            commit('setUser', response)
        } catch (error) {
            commit('setLoginError', error)
        } finally {
            commit('setLoginLoading', false)
        }
    },

    async retrieveUrlData({ commit }, url) {
        try {
            commit('setUrlDataLoading', true)
            commit('setUrlDataError', null)

            return await endpoints.retrieveUrlData(url)
        } catch (error) {
            commit('setUrlDataError', error)
        } finally {
            commit('setUrlDataLoading', false)
        }
    }
}
