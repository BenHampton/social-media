export default {
    setUser(state, user) {
        state.user = user
    },

    setLoginLoading(state, isLoading) {
        state.isLogin_loading = isLoading
    },
    setLoginError(state, error) {
        state.login_error = error
    },

    setStatus(state, status) {
        state.status = status
    },
    setStatusLoading(state, isLoading) {
        state.isFriend_loading = isLoading
    },
    setStatusdError(state, error) {
        state.friend_error = error
    }
}
