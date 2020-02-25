<template>
    <div class="status-container">
        <span
            v-if="showLogo"
            class="image-container"
            @click="routeToUserProfile"
            >{{ image }}</span
        >
        <v-text-field
            placeholder="What's Happening?"
            v-model="status"
        ></v-text-field>
        <BaseButton
            value="Update Status"
            :onClick="handleStatusUpdate"
            backgroundColor="#2e2d2d"
            class="status-button"
        >
        </BaseButton>
        <!-- <div>{{ user.status }}</div> -->
    </div>
</template>

<script>
import endpoint from '../api/endpoints'
import BaseButton from './BaseButton'
import { mapMutations } from 'vuex'
export default {
    name: 'BaseInputStatus',
    components: {
        BaseButton
    },
    props: {
        user: {
            type: Object,
            required: true
        },
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
        ...mapMutations(['setUser']),
        async handleStatusUpdate() {
            if (!this.status) {
                return
            }
            let updatedUser = {
                ...this.user,
                status: this.status
            }
            let response = await endpoint.updateStatus({
                ...this.user,
                status: this.status
            })
            this.setUser(response)
            this.status = ''
        },
        routeToUserProfile() {
            this.$router.push({
                name: 'UserProfile',
                params: { userID: this.userID }
            })
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
