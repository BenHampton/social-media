import api from '../api/endpoints'

export default {
    async login({ commit }, login) {
        try {
            commit('setLoginLoading', true)
            let response = await api.login(login)
            commit('setUser', response)
        } catch (error) {
            commit('setLoginError', error)
        } finally {
            commit('setLoginLoading', false)
        }
    }
}
