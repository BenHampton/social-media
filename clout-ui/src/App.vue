<template>
    <v-app>
        <TheHeader nameLeft="The" nameRight="Clout"></TheHeader>
        <v-content>
            <router-view></router-view>
        </v-content>
    </v-app>
</template>

<script>
import TheHeader from './components/TheHeader'

export default {
    name: 'App',
    components: {
        TheHeader
    }
}
</script>
