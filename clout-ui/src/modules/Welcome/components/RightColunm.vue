<template>
    <div class="right-container">
        <div class="text-container">
            <div class="text-header">
                Imagination is
                <p class="tab">only the begining.</p>
            </div>
            <p class="button-header-text">Join Clout today.</p>
        </div>
        <div class="sign-up-container">
            <BaseButton
                :onClick="handleSignUp"
                backgroundColor="#2e2d2d"
                class="button-container"
            >
                Sign Up
            </BaseButton>
        </div>
        <div class="login-container">
            <BaseButton :onClick="handleLogin" class="button-container">
                Login
            </BaseButton>
        </div>
    </div>
</template>

<script>
import BaseButton from '../../../components/BaseButton'
export default {
    name: 'RightColunm',
    components: { BaseButton },
    methods: {
        handleLogin() {
            this.$router.push({ name: 'Login' })
        },
        handleSignUp() {
            this.$router.push({ name: 'TheCreateUser' })
        }
    }
}
</script>

<style scoped lang="scss">
.right-container {
    width: 100%;
    text-align: center;
    margin-top: 20%;

    .text-container {
        text-align: left;
        margin-left: 26%;
        margin-bottom: 2%;
        font-weight: bold;

        .text-header {
            margin-bottom: 10%;
            font-size: 35px;
        }
        .button-header-text {
            font-size: 18px;
            margin-bottom: -2%;
        }
    }

    .sign-up-container {
        width: 100%;
        position: relative;

        .button-container {
            color: white;
        }
    }
    .login-container {
        margin-top: 2%;
        width: 100%;
        position: relative;
    }
}
.tab {
    margin-left: 30%;
}
.button-container {
    width: 50%;
    border-radius: 20px;
}
</style>
