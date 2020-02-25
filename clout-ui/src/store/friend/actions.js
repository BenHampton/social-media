import endpoints from '../../api/endpoints'

export default {
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
