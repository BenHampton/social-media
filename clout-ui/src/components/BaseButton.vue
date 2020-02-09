<template>
    <v-btn @click="onClick">{{ value }} </v-btn>
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
        }
    }
}
</script>

<style></style>
