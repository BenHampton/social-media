<template>
    <v-container fluid ma-0 pa-0>
        <v-layout row>
            <v-flex xs3>
                <div class="profile-image">
                    <img src="https://via.placeholder.com/250x250.png" />
                    {{ this.userInformation.user.logo }}
                </div>
            </v-flex>
            <v-flex xs3 class="profile-info">
                <div class="profile-username">
                    {{ this.userInformation.user.username }}
                </div>
                <div class="profile-email">
                    {{ this.userInformation.user.email }}
                </div>
                <div class="profile-friends">
                    View Friends (<span
                        @click="this.routeToFriendsList"
                        class="friends"
                        >X</span
                    >)
                </div>
            </v-flex>
            <v-flex xs6 pa-5>
                <PostMaterial :userId="this.userInformation.user.id">
                </PostMaterial>
            </v-flex>
        </v-layout>
        <v-layout row class="status">
            <InputStatus :user="this.userInformation.user" :showLogo="false">
            </InputStatus>
        </v-layout>
        <v-layout row class="post-container">
            <ExistingPost :userId="this.userInformation.user.id">
            </ExistingPost>
        </v-layout>
    </v-container>
</template>

<script>
import { mapState } from 'vuex'
import PostMaterial from './components/PostMaterial'
import ExistingPost from './components/ExistingPost'
import InputStatus from '../../components/InputStatus'

export default {
    name: 'UserProfile',
    components: {
        PostMaterial,
        ExistingPost,
        InputStatus
    },
    methods: {
        routeToFriendsList() {
            this.$router.push({ name: 'Friends' })
        }
    },
    computed: {
        ...mapState(['userInformation'])
    }
}
</script>

<style scoped>
.status {
    margin-left: 25%;
}
.friends {
    cursor: pointer;
    color: blue;
}
.profile-image {
    cursor: pointer;
}
.profile-info {
    font-size: 18px;
    margin-top: 4%;
    padding-bottom: 5%;
    padding-left: 2%;
}
.profile-email {
    margin-top: 5%;
}
.profile-friends {
    margin-top: 5%;
}
.post-container {
    margin-top: 2%;
}
</style>
