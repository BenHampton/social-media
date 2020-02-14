<template>
    <div>
        <TheHeader nameLeft="The" nameRight="Clout"></TheHeader>
        <div class="app-container">
            <router-view></router-view>
        </div>
    </div>
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

<style scoped>
.app-container {
    width: 100%;
    font-size: 20px;
}
</style>

<style>
html,
body {
    height: 100%;
}
</style>
