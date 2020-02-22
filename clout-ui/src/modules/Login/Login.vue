<template>
    <div class="login-container">
        <v-container fluid class="login-form">
            <div class="form-header">Login in to Clout</div>
            <v-layout align-center justify-center>
                <v-flex>
                    <v-card class="card">
                        <v-form ref="loginForm" v-model="valid" lazy-validation>
                            <span @click="toggleUsernameLogin">
                                <v-text-field
                                    :disabled="disableEmail"
                                    v-model="email"
                                    placeholder="Email"
                                    :rules="rules.emailRules"
                                    required
                                >
                                </v-text-field>
                            </span>
                            <span @click="toggleEmailLogin">
                                <v-text-field
                                    :disabled="disableUsername"
                                    v-model="username"
                                    placeholder="Username"
                                    :rules="rules.usernameRules"
                                    required
                                >
                                </v-text-field>
                            </span>
                            <v-text-field
                                :type="passwordVisibility"
                                v-model="password"
                                placeholder="Password"
                                :rules="rules.passwordRules"
                                required
                            >
                                <span slot="append">
                                    <div
                                        class="eye-icon"
                                        @mousedown="showPasswordVisibility"
                                        @mouseup="hidePasswordVisibility"
                                    >
                                        <img
                                            src="../../assets/image/eye.png"
                                            width="18xp"
                                            height="18px"
                                        /></div
                                ></span>
                            </v-text-field>
                            <BaseButton
                                value="Login"
                                :onClick="handleLogin"
                            ></BaseButton>
                        </v-form>
                    </v-card>
                </v-flex>
            </v-layout>
        </v-container>
    </div>
</template>

<script>
import { mdiEye } from '@mdi/js'
import { mapActions, mapState } from 'vuex'
import BaseButton from '../../components/BaseButton'

export default {
    name: 'Login',
    components: {
        BaseButton
    },
    data() {
        return {
            valid: true,
            passwordVisibility: 'password',
            disableEmail: false,
            disableUsername: false,
            badPassword: false,
            badUsername: false,
            email: '',
            username: 'testy',
            password: 'test',
            rules: {
                usernameRules: [v => !!v || 'Username is required'],
                passwordRules: [v => !!v || 'Password is required']
            }
        }
    },
    methods: {
        ...mapActions(['login']),
        async handleLogin() {
            if (this.$refs.loginForm.validate()) {
                await this.login({
                    username: this.username,
                    email: this.email,
                    password: this.password
                })
                this.$router.push({ name: 'TimeLine' })
            }
        },
        toggleUsernameLogin() {
            this.disableEmail = false
            this.disableUsername = true
        },
        toggleEmailLogin() {
            this.disableEmail = true
            this.disableUsername = false
        },
        showPasswordVisibility() {
            this.passwordVisibility = 'text'
        },
        hidePasswordVisibility() {
            this.passwordVisibility = 'password'
        }
    },
    computed: {
        ...mapState(['userInformation'])
    }
}
</script>

<style scoped lang="scss">
.login-container {
    width: 100%;
    height: 93vh;
    background: #2e2d2d;

    .login-form {
        position: relative;
        padding-top: 5%;
        padding-right: 20%;
        padding-left: 20%;
    }
}

.form-header {
    color: white;
    text-align: center;
    font-size: 30px;
    padding-bottom: 2%;
}
.eye-icon {
    cursor: pointer;
}
.card {
    padding: 20px;
}
</style>
