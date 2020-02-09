<template>
    <v-container fluid class="login-container">
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
                            v-model="password"
                            placeholder="Password"
                            :rules="rules.passwordRules"
                            required
                        >
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
</template>

<script>
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
                let login = {
                    username: this.username,
                    password: this.password,
                    emial: this.email
                }
                await this.login(login)
                this.$router.push({ name: 'NewsFeed' })
            }
        },
        toggleUsernameLogin() {
            this.disableEmail = false
            this.disableUsername = true
        },
        toggleEmailLogin() {
            this.disableEmail = true
            this.disableUsername = false
        }
    },
    computed: {
        ...mapState(['userInformation'])
    }
}
</script>

<style scope>
.login-container {
    margin-top: 10%;
    width: 50%;
}
.card {
    padding: 20px;
}
</style>
