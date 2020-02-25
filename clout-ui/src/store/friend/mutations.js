export default {
    setFriend(state, friend) {
        state.friend = friend
    },
    setFriendLoading(state, isLoading) {
        state.isFriend_loading = isLoading
    },
    setFriendError(state, error) {
        state.friend_error = error
    }
}
