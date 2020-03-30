<template>
    <div class="header-container">
        <v-app-bar>
            <div class="d-flex align-center">
                <span>{{ nameLeft }}</span>
                <span class="name-right"> {{ nameRight }} </span>
            </div>

            <v-spacer></v-spacer>

            <BaseButton :onClick="routeHeaderButton" class="button-container">{{
                buttonName
            }}</BaseButton>
        </v-app-bar>
    </div>
</template>

<script>
import BaseButton from './BaseButton'
export default {
    name: 'TheHeader',
    components: {
        BaseButton
    },
    created() {
        this.retrievePathLocation()
    },
    props: {
        nameLeft: {
            type: String,
            required: true
        },
        nameRight: {
            type: String,
            required: true
        }
    },
    data() {
        return {
            buttonName: ''
        }
    },
    methods: {
        routeHeaderButton() {
            if (this.buttonName === 'Sign Up') {
                this.$router.push({ name: 'CreateUser' })
                this.buttonName = 'Sign Out'
            } else {
                this.$router.push({ name: 'Login' })
                this.buttonName = 'Sign Up'
            }
        },
        retrievePathLocation() {
            if (window.location.pathname === '/') {
                this.buttonName = 'Sign Up'
            } else {
                this.buttonName = 'Sign Out'
            }
        }
    }
}
</script>

<style scope lang="scss">
.header-container {
    font-size: 25px;
    background: #990909;
}
.name-right {
    margin-left: 5px;
    font-weight: bold;
}
.button-container {
    .v-btn__content {
        font-size: 20px;
    }
}
</style>
