import endpoints from '../../api/endpoints'

export default {
    async searchForUsers({ commit }, ID) {
        try {
            commit('setFriendSearchLoading', true)
            commit('setFriendSearchError', null)

            return await endpoints.searchForUsers(ID)
        } catch (error) {
            commit('setFriendSearchError', error)
        } finally {
            commit('setFriendSearchLoading', false)
        }
    },

    async findFriend({ commit }, ID) {
        try {
            commit('setFriendLoading', true)
            commit('setFriendError', null)

            let response = await endpoints.findFriend(ID)

            commit('setFriend', response)
        } catch (error) {
            commit('setFriendError', error)
        } finally {
            commit('setFriendLoading', false)
        }
    }
}
