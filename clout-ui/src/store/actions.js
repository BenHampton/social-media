import api from '../api/endpoints'

export default {
    async login({ commit }, { username, email, password }) {
        try {
            commit('setLoginLoading', true)
            let response = await api.login(username, email, password)
            commit('setUser', response)
        } catch (error) {
            commit('setLoginError', error)
        } finally {
            commit('setLoginLoading', false)
        }
    }
}
