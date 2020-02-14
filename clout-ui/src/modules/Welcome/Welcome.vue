<template>
    <div>
        <v-row class="row-container" no-gutters>
            <v-col cols="6" class="col-container left-col-container">
                <div class="left">
                    <div class="text-container">
                        <span class="text">
                            Welcome to The Clout, a social media web application
                            powered by VueJS using Vuetify, Spring Boot and
                            PostgreSQL
                        </span>
                    </div>
                </div>
            </v-col>
            <v-col cols="6" class="col-container right-col-container">
                <RightColunm></RightColunm>
            </v-col>
        </v-row>
    </div>
</template>

<script>
import RightColunm from './components/RightColunm'
export default {
    name: 'Welcome',
    components: { RightColunm }
}
</script>

<style scoped lang="scss">
.row-container {
    background: #2e2d2d;
    height: 93vh;
}

.left-col-container {
    border-right: white solid 1px;
    background-image: url('https://developerlife.com/assets/vue-hero.svg');
    background-repeat: no-repeat;
    background-size: 100% 60%;
    .left {
        margin-top: 50px;
        text-align: center;

        .text-container {
            margin-top: 65%;
            padding-right: 10%;
            padding-left: 10%;
            line-height: 1.5;
            color: white;

            .text {
                font-size: 25px;
            }
        }
    }
}

.right-col-container {
    height: 93vh;
    background: white;
}
</style>
