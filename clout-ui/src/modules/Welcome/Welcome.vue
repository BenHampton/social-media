<template>
    <div>
        <v-container>
            <v-layout row>
                <v-flex>
                    1
                </v-flex>
                <v-flex>
                    2
                </v-flex>
            </v-layout>
        </v-container>
        <RightColunm />
        <LeftColunm />
    </div>
</template>

<script>
import RightColunm from './components/RightColunm'
import LeftColunm from './components/LeftColunm'
export default {
    name: 'Welcome',
    components: { RightColunm, LeftColunm }
}
</script>

<style scoped></style>
