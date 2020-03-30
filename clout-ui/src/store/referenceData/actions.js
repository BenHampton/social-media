import endpoints from '../../api/endpoints'

export default {
    async getRelationshipStatusCodes({ commit }) {
        try {
            commit('setRelationshipStatusCodesLoading', true)
            commit('setRelationshipStatusCodesError', null)

            let response = await endpoints.getRelationshipStatusCodes()

            commit('setRelationshipStatusCodes', response)

            return response
        } catch (error) {
            commit('setRelationshipStatusCodesError', error)
        } finally {
            commit('setRelationshipStatusCodesLoading', false)
        }
    }
}
