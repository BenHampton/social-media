export default {
    setRelationshipStatusCodesLoading(state, isLoading) {
        state.relationshipStatusCodes_loading = isLoading
    },
    setRelationshipStatusCodesError(state, error) {
        state.relationshipStatusCodes_error = error
    },
    setRelationshipStatusCodes(state, error) {
        state.relationshipStatusCodes = error
    }
}
