import Vue from 'vue'
import Router from 'vue-router'
import Login from '../modules/Login/Login'
import TheCreateUser from '../components/TheCreateUser'
import TimeLine from '../modules/TimeLine/TimeLine'
import UserProfile from '../modules/UserProfile/UserProfile'
import Welcome from '../modules/Welcome/Welcome'

Vue.use(Router)

export default new Router({
    routes: [
        { path: '/', name: 'Welcome', component: Welcome },
        { path: '/Login', name: 'Login', component: Login },
        { path: '/create', name: 'TheCreateUser', component: TheCreateUser },
        { path: '/timeline', name: 'TimeLine', component: TimeLine },
        {
            path: '/user/:userID',
            name: 'UserProfile',
            component: UserProfile
        },
        {
            path: '/user/:userID',
            name: 'Friend',
            component: UserProfile
        },
        { path: '*', redirect: '/' }
    ]
})
