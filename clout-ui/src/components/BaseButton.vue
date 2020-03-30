<template>
    <v-btn @click="onClick" :color="backgroundColor"><slot /> </v-btn>
</template>

<script>
export default {
    name: 'BaseButton',
    props: {
        onClick: {
            type: Function,
            required: true
        },
        backgroundColor: {
            type: String,
            default: 'white'
        }
    }
}
</script>

<style scoped></style>
