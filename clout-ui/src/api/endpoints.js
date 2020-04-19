import login from './endpoints/login'
import user from './endpoints/user'
import relationship from './endpoints/relationship'
import referenceData from './endpoints/referenceData'
import webScrapper from './endpoints/webScrapper'

export default {
    login: login.login,

    searchForUsers: user.searchForUsers,
    findFriend: user.findFriend,

    updateStatus: user.updateStatus,

    findRelationship: relationship.findRelationship,
    updateRelationship: relationship.updateRelationship,
    createRelationship: relationship.createRelationship,

    getRelationshipStatusCodes: referenceData.getRelationshipStatusCodes,

    retrieveUrlData: webScrapper.retrieveUrlData
}
