<template>
    <div class="user-profile-container">
        <div class="row-one-container">
            <div class="status">
                <BaseInputStatus
                    :user="user"
                    :image="user.logo"
                    :showLogo="false"
                />
            </div>
            <div class="info">
                <div class="image-container">{{ user.logo }}</div>
                <div class="user-info">
                    <div>{{ user.username }}</div>
                    <div>{{ user.email }}</div>
                    <div class="friends">
                        Friends:
                        <span class="friends-count" @click="routeToFriendsList"
                            ><BaseToast>#####</BaseToast></span
                        >
                    </div>
                </div>
                <div class="user-status">
                    <span class="status-prefix">Clouting:</span>
                    {{ user.status }}
                </div>
            </div>
        </div>
        <div class="row-two-container">
            personal feed
        </div>
    </div>
</template>

<script>
import { mapState } from 'vuex'
import BaseInputStatus from '../../components/BaseInputStatus'
import BaseToast from '../../components/BaseToast'
export default {
    name: 'UserProfile',
    components: { BaseInputStatus, BaseToast },
    computed: {
        ...mapState(['user'])
    },
    methods: {
        routeToFriendsList() {
            console.log('Friends List Page - Comming Soon')
        }
    }
}
</script>

<style scoped lang="scss">
.user-profile-container {
    margin-top: 20px;
}
.row-one-container {
    position: relative;
    width: 100%;

    .status {
        .status-container {
            padding: 0;
            padding-left: 25%;
            padding-right: 25%;
        }
    }

    .info {
        position: relative;
        display: flex;
        padding-left: 10%;
        padding-right: 10%;

        .image-container {
            background: pink;
            height: 10vh;
            width: 10%;
            margin-right: 1%;
        }
    }
    .user-info {
        padding: 1%;
    }

    .friends {
        font-size: 15px;
        margin-top: 18px;
        width: 100%;
        padding: 0;

        .friends-count {
            cursor: pointer;

            &:hover {
                color: #1a0dab;
            }
        }
    }

    .user-status {
        margin-left: 10%;
        margin-top: 30px;
        width: 100%;

        .status-prefix {
            font-size: 15px;
            padding-right: 2%;
        }
    }
}

.row-two-container {
    background: tan;
    position: relative;
    margin-top: 1%;
    width: 100%;
}
</style>
