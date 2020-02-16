<template>
    <div class="status-container">
        <v-text-field placeholder="What's Happening?"></v-text-field>
    </div>
</template>

<script>
export default {
    name: 'BaseAutoFriendSearch'
}
</script>

<style scoped lang="scss">
.status-container {
    position: relative;
    display: flex;
    width: 100%;
    padding: 5%;
}

.image-container {
    background: tan;
}

.status-button {
    margin-top: 5px;
    color: white;
}
</style>
