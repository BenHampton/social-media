<template>
    <div class="clout-card-container">
        <span>
            <v-card class="clout-card">
                <v-card-title>TITLE</v-card-title>

                <v-card-subtitle class="pb-0">SUBTITLE</v-card-subtitle>

                <v-card-text class="text--primary">
                    <div>MESSAGE</div>
                    <div>MESSAGE</div>
                    <div>MESSAGE</div>
                    <div>MESSAGE</div>
                </v-card-text>

                <v-card-actions>
                    BUTTON ACTIONS
                </v-card-actions>
            </v-card>
        </span>
    </div>
</template>

<script>
export default {
    name: 'CloutCard'
}
</script>

<style scoped lang="scss">
.clout-card-container {
    height: 77vh; // subject to change
    padding-top: 2%;

    .clout-card {
        margin-left: 2%;
        margin-right: 2%;
    }
}
</style>
