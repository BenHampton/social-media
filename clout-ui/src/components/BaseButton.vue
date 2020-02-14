<template>
    <v-btn @click="onClick" :color="backgroundColor">{{ value }} </v-btn>
</template>

<script>
export default {
    name: 'BaseButton',
    props: {
        value: {
            type: String,
            required: true
        },
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
