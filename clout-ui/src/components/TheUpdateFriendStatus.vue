<template>
    <div class="updated-friend-status-container">
        <span v-if="!friend">
            <BaseButton :onClick="handleFriendshipStatus">
                <span
                    :class="{
                        'friend-pending': pending
                    }"
                >
                    {{ friendshipStatusText }}
                    <span>
                        <img
                            src="../assets/image/add.jpg"
                            class="friend-icon"
                        />
                    </span>
                </span>
            </BaseButton>
        </span>
    </div>
</template>

<script>
import { mapState, mapActions } from 'vuex'
import BaseButton from '../components/BaseButton'
export default {
    name: 'TheUpdateFriendStatus',
    components: { BaseButton },
    props: {
        relationship: {
            type: Object,
            required: true
        },
        ID: {
            type: Number,
            required: true
        }
    },
    computed: {
        ...mapState(['user']),
        ...mapState('referenceData', ['statusCodes']),
        ...mapState('relationship', [
            'relationship_isUpdating',
            'relationship_error',
            'relationship_isCreating',
            'creatingRelationship_error'
        ]),
        pending() {
            return this.friendShipStatus === 0
        },
        friend() {
            return this.friendShipStatus === 1
        },
        requestedFriendship() {
            return (
                this.pending &&
                this.relationship.lastUserActionID === this.user.id
            )
        },
        friendshipStatusText() {
            if (this.requestedFriendship) {
                return 'Requested'
            }
            if (this.pending) {
                return 'Pending'
            }
            return 'Add Friend'
        }
    },
    data() {
        return {
            isPending: false,
            isBlocked: false,
            friendShipStatus: null,
            lastActionUserID: null
        }
    },
    methods: {
        ...mapActions('relationship', ['updateFriendship', 'createFriendship']),
        async handleFriendshipStatus() {
            let request = {
                userOneId: this.user.id,
                userTwoId: this.ID,
                actionId: this.user.id
            }

            let response

            if (this.pending) {
                request.statusId = 2 // make util class for frozen object so as to not hard code these hard coded IDs
                this.friendShipStatus = await this.updateFriendship(request)
            } else {
                request.statusId = 0 // make util class for frozen object so as to not hard code these hard coded IDs
                this.friendShipStatus = await this.createFriendship(request)
            }
        }
    },
    async created() {
        this.friendShipStatus = this.relationship.statusCode.code
        //api call to this.findRelationship() to determine if user request or is the requestee
    }
}
</script>

<style scoped lang="scss">
.updated-friend-status-container {
    position: relative;
    display: flex;
    width: 100%;
}

.friend-icon {
    height: 18px;
    width: 18px;
}

.friend-pending {
    opacity: 0.3;
}
</style>
