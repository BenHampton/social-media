<template>
    <div>
        <div class="clout-feed-container">
            <div class="row-container">
                <span class="nav-container">NAVIGATION - coming soon</span>

                <div class="clout-container">
                    <BaseInputStatus
                        :user="user"
                        :image="user.logo"
                        :showLogo="true"
                    />
                    <CloutCard />
                </div>
                <div class="user-container">
                    <FastTimeLine class="search" />
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import { mapState, mapMutations } from 'vuex'
import CloutCard from './components/CloutCard'
import BaseInputStatus from '../../components/BaseInputStatus'
import FastTimeLine from './components/FastTimeLine'
export default {
    name: 'TimeLine',
    components: {
        CloutCard,
        BaseInputStatus,
        FastTimeLine
    },
    methods: {
        ...mapMutations(['setUser'])
    },
    computed: {
        ...mapState(['user'])
    }
}
</script>

<style scoped lang="scss">
.clout-feed-container {
    background: white;
    height: 93vh;
    display: flex;
    position: relative;
}

.row-container {
    width: 100%;
    height: 93vh;
    display: flex;
    position: relative;

    .nav-container {
        width: 25%;
        border-right: #2e2d2d solid 1px;
    }
    .clout-container {
        width: 50%;
    }

    .user-container {
        width: 25%;
        border-left: #2e2d2d solid 1px;
        .search {
        }
    }
}
</style>
