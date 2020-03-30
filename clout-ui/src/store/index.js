import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

import state from './state'
import actions from './actions'
import mutations from './mutations'
import getters from './getters'
import friend from './friend'
import relationship from './relationship'
import referenceData from './referenceData'

export const store = new Vuex.Store({
    state,
    actions,
    mutations,
    getters,
    modules: {
        friend,
        relationship,
        referenceData
    }
})
