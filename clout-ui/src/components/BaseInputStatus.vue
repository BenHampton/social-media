<template>
    <div class="status-container">
        <span
            v-if="showLogo"
            class="image-container"
            @click="routeToUserProfile"
            >{{ image }}</span
        >
        <v-text-field placeholder="What's Happening?"></v-text-field>
        <BaseButton
            value="Update Status"
            :onClick="postUpdatedStatus"
            backgroundColor="#2e2d2d"
            class="status-button"
        >
        </BaseButton>
    </div>
</template>

<script>
import { mapActions } from 'vuex'
import BaseButton from './BaseButton'
export default {
    name: 'BaseInputStatus',
    components: {
        BaseButton
    },
    props: {
        showLogo: {
            type: Boolean,
            required: true
        },
        image: {
            type: String,
            required: true
        }
    },
    data() {
        return {
            status: ''
        }
    },
    methods: {
        ...mapActions(['updateStatus']),
        async postUpdatedStatus() {
            if (this.status.length !== 0) {
                await this.updateStatus({
                    user: this.user,
                    status: this.status
                })
                this.status = ''
            }
        },
        routeToUserProfile() {
            this.$router.push({ name: 'UserProfile' })
        }
    }
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
    cursor: pointer;
    background: tan;
}

.status-button {
    margin-top: 5px;
    color: white;
}
</style>
