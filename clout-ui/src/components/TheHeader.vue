<template>
    <v-toolbar>
        <v-toolbar-title class="headline text-uppercase header-title">
            <span>{{ nameLeft }}</span>
            <span class="font-weight-light"> {{ nameRight }} </span>
        </v-toolbar-title>
        <v-spacer></v-spacer>
        <BaseButton
            :value="buttonName"
            :onClick="routeHeaderButton"
        ></BaseButton>
    </v-toolbar>
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

<style scope>
.header-title {
    width: 150px;
}
</style>
