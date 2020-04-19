<template>
    <v-btn @click="onClick" :color="backgroundColor" :disabled="disabled"
        ><slot />
    </v-btn>
</template>

<script>
export default {
    name: 'BaseButton',
    props: {
        onClick: {
            type: Function,
            required: true
        },
        disabled: {
            type: Boolean,
            default: false
        },
        backgroundColor: {
            type: String,
            default: 'white'
        }
    }
}
</script>

<style scoped></style>
