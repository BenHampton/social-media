import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify'
import router from './router/index'
import VueMeta from 'vue-meta'
import { store } from './store/index'

Vue.use(VueMeta)

Vue.config.productionTip = false

new Vue({
    render: h => h(App),
    router,
    store,
    vuetify
}).$mount('#app')
