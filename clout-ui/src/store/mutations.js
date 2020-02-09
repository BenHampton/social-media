export default {
    setUser(state, user) {
        state.user = user
    },

    setLoginLoading(state, isLoading) {
        state.isLogin_loading = isLoading
    },
    setLoginError(state, error) {
        state.login_error = error
    }
}
