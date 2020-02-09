<template>
    <v-container fluid ma-0 pa-0>
        <v-layout row>
            <v-flex xs2 v-if="this.showLogo">
                <span @click="this.routeToProfile">
                    <img
                        src="https://via.placeholder.com/100x100.png"
                        class="profile-image"
                    />
                    {{ this.user.logo }}
                </span>
            </v-flex>
            <v-flex xs6 pa-2>
                <v-text-field placeholder="Clout Status" v-model="status">
                </v-text-field>
            </v-flex>
            <v-flex xs2 pa-2>
                <BaseButton value="Update Status" :onClick="postUpdatedStatus">
                </BaseButton>
            </v-flex>
        </v-layout>
        <v-layout row>
            <v-flex class="status">
                Status: <span class="status-text">{{ this.user.status }}</span>
            </v-flex>
        </v-layout>
    </v-container>
</template>

<script>
import { mapActions } from 'vuex'
import BaseButton from './BaseButton'
export default {
    name: 'InputStatus',
    components: {
        BaseButton
    },
    props: {
        showLogo: {
            type: Boolean,
            required: true
        },
        user: {
            type: Object,
            required: true
        }
    },
    data() {
        return {
            status: ''
        }
    },
    methods: {
        ...mapActions(['updateStatus']),
        async postUpdatedStatus() {
            if (this.status.length !== 0) {
                await this.updateStatus({
                    user: this.user,
                    status: this.status
                })
                this.status = ''
            }
        },
        routeToProfile() {
            this.$router.push({ name: 'UserProfile' })
        }
    }
}
</script>

<style scoped>
.profile-image {
    cursor: pointer;
}
.status {
    margin-left: 25%;
    font-size: 18px;
}
.status-text {
    font-size: 15px;
}
</style>
