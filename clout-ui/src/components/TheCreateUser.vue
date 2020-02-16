<template>
    <div class="create-container">
        <div class="create-user-form">
            <v-form ref="createUser" v-model="valid" lazy-validation>
                <div class="rows-container">
                    <div>
                        <v-text-field
                            v-model="email"
                            placeholder="Email"
                            :rules="rules.emailRules"
                            required
                        >
                        </v-text-field>
                    </div>
                    <div>
                        <v-text-field
                            v-model="username"
                            placeholder="Username"
                            :rules="rules.usernameRules"
                            required
                        >
                        </v-text-field>
                    </div>
                    <div>
                        <v-text-field
                            v-model="password"
                            placeholder="Password"
                            :rules="rules.passwordRules"
                            required
                        >
                        </v-text-field>
                    </div>
                    <div>
                        <v-text-field
                            v-model="confirmPassword"
                            placeholder="password Comfirmation"
                            :rules="rules.passwordComfirmationRules"
                            required
                        >
                        </v-text-field>
                    </div>
                    <div>
                        <BaseButton
                            value="Login"
                            :onClick="createUser"
                        ></BaseButton>
                    </div>
                </div>
            </v-form>
        </div>
    </div>
</template>

<script>
import axios from 'axios'
import { mapMutations } from 'vuex'
import BaseButton from './BaseButton'
export default {
    name: 'TheCreateUser',
    components: {
        BaseButton
    },
    data() {
        return {
            valid: true,
            username: '',
            email: '',
            logo: 'N/A',
            password: '',
            confirmPassword: '',
            rules: {
                emailRules: [v => !!v || 'Email is required'],
                usernameRules: [v => !!v || 'UserName is required'],
                passwordRules: [v => !!v || 'Password is required'],
                passwordComfirmationRules: [
                    v => !!v || 'Password Comfirmation is required',
                    v => v === this.password || 'Passwords do not match'
                ]
            }
        }
    },
    methods: {
        ...mapMutations(['setUser']),
        async createUser() {
            if (!this.$refs.createUser.validate()) {
                return
            }
            let signUp = {
                passwordConfirmation: this.confirmPassword,
                userEntity: {
                    username: this.username,
                    email: this.email,
                    password: this.password,
                    logo: this.logo
                }
            }

            await axios
                .post('http://localhost:8080/sign-up', signUp, {
                    headers: {
                        Accept: 'application/json',
                        'Content-type': 'application/json',
                        'Access-Control-Allow-Origin': '*'
                    }
                })
                .then(response => {
                    this.setUser(response.data)
                    console.log(response.data)
                    this.$router.push({ name: 'NewsFeed' })
                })
        }
    }
}
</script>

<style>
.create-container {
    width: 100%;
    height: 93vh;
    background: #2e2d2d;
}
.create-user-form {
    position: relative;
    padding-top: 5%;
    padding-right: 20%;
    padding-left: 20%;
}
.rows-container {
    background: white;
    padding: 5%;
}
</style>
