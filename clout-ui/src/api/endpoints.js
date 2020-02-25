import login from './endpoints/login'
import user from './endpoints/user'
export default {
    login: login.login,
    findUsers: user.findUsers,
    findFriend: user.findFriend,
    updateStatus: user.updateStatus
}
