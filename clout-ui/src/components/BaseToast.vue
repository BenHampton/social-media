<template>
    <div class="toast-container">
        <span @click="snackbar = true"><slot></slot></span>
        <v-snackbar v-model="snackbar" :timeout="timeout" :top="y === 'top'">
            Coming Soon
        </v-snackbar>
    </div>
</template>

<script>
export default {
    name: 'BaseToast',
    data: () => ({
        snackbar: false,
        timeout: 2000,
        y: 'top'
    })
}
</script>

<style scoped lang="scss">
.toast-container {
    text-align: center;
    display: inline;
    font-weight: bold;
}
</style>
