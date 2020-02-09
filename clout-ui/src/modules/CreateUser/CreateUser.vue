<template>
    <v-container fluid fill-height class="sign-up-container">
        <v-layout align-center justify-center>
            <v-flex>
                <v-card class="card">
                    <v-form ref="createUser" v-model="valid" lazy-validation>
                        <v-text-field
                            v-model="email"
                            placeholder="Email"
                            :rules="rules.emailRules"
                            required
                        >
                        </v-text-field>
                        <v-text-field
                            v-model="username"
                            placeholder="Username"
                            :rules="rules.usernameRules"
                            required
                        >
                        </v-text-field>
                        <v-text-field
                            v-model="password"
                            placeholder="Password"
                            :rules="rules.passwordRules"
                            required
                        >
                        </v-text-field>
                        <v-text-field
                            v-model="confirmPassword"
                            placeholder="password Comfirmation"
                            :rules="rules.passwordComfirmationRules"
                            required
                        >
                        </v-text-field>
                        <BaseButton
                            value="Login"
                            :onClick="createUser"
                        ></BaseButton>
                    </v-form>
                </v-card>
            </v-flex>
        </v-layout>
    </v-container>
</template>

<script>
import axios from 'axios'
import { mapMutations } from 'vuex'
import BaseButton from '../../components/BaseButton'
export default {
    name: 'CreateUser',
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
.sign-up-container {
    width: 50%;
}
.card {
    padding: 20px;
}
</style>
