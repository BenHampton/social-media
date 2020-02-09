import Vue from 'vue'
import Router from 'vue-router'
import Login from '../modules/Login/Login'
import CreateUser from '../modules/CreateUser/CreateUser'
import NewsFeed from '../modules/NewsFeed/NewsFeed'
import UserProfile from '../modules/UserProfile/UserProfile'
import Welcome from '../modules/Welcome/Welcome'

Vue.use(Router)

export default new Router({
    routes: [
        { path: '/', name: 'Welcome', component: Welcome },
        { path: '/Login', name: 'Login', component: Login },
        { path: 'sign-up', name: 'CreateUser', component: CreateUser },
        { path: '/news-feed', name: 'NewsFeed', component: NewsFeed },
        { path: '/user-profile', name: 'UserProfile', component: UserProfile },
        { path: '*', redirect: '/' }
    ]
})
