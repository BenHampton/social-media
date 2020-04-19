<template>
    <div
        :class="showItems ? 'container-open' : 'container'"
        tabindex="0"
        @blur="handleBlur"
    >
        <div @click="handleClick()" class="jest--toggle-item">
            <v-text-field
                :value="value ? value[itemLabel] : ''"
                label="Regular"
                placeholder="Placeholder"
            ></v-text-field>
            <el-input
                :value="value ? value[itemLabel] : ''"
                :disabled="true"
                suffix-icon="el-icon-caret-bottom"
                @blur="handleBlur"
                :placeholder="placeholder"
                ref="input"
                class="jest--el-input"
            />
        </div>
        <div :class="showItems ? 'scrollbar' : ''" id="scrollbar">
            <li
                v-if="placeholder && placeholderDropdownOption"
                @click="handleSelectedItem(null)"
                :class="showItems ? 'item-list-show' : 'item-list-hidden'"
            >
                <div class="item">
                    {{ placeholder }}
                </div>
            </li>
            <li
                v-for="item in items"
                :key="item[itemID]"
                @click="handleSelectedItem(item)"
                :class="showItems ? 'item-list-show' : 'item-list-hidden'"
            >
                <slot name="default" :item="item">
                    <div class="item">
                        {{ item[itemLabel] }}
                    </div>
                </slot>
            </li>
        </div>
    </div>
</template>
<script>
export default {
    name: 'BaseSelect',
    model: {
        prop: 'value',
        event: 'change'
    },
    props: {
        value: {
            type: Object,
            required: false
        },
        showDropDown: {
            type: Boolean,
            default: true
        },
        items: {
            type: Array,
            required: true
        },
        itemID: {
            type: String,
            required: true
        },
        itemLabel: {
            type: String,
            required: true
        },
        placeholder: {
            type: String,
            required: false
        },
        placeholderDropdownOption: {
            type: Boolean,
            default: false
        }
    },
    data() {
        return {
            showItems: false
        }
    },
    methods: {
        handleSelectedItem(item) {
            this.$emit('change', item)
            this.showItems = !this.showItems
        },
        handleClick() {
            if (this.showDropDown) {
                this.showItems = !this.showItems
            }
        },
        handleBlur() {
            this.showItems = false
        }
    }
}
</script>
<style lang="scss" scoped>
@import '../styles/index';
​ /deep/ .el-input.is-disabled .el-input__icon {
    cursor: pointer;
}
​ /deep/ .el-input.is-disabled .el-input__inner {
    background: white;
    cursor: pointer;
    padding: 6%;
    color: black;
    border-radius: 0;
    width: 100%;
}
​ /deep/ .el-input__suffix-inner {
    color: $gray-100;
}
​ /deep/ .el-input__inner {
    &::placeholder {
        font-size: 20px;
        position: relative;
        color: $gray-100;
        font-weight: bold;
    }
}
​ .container {
    position: relative;
    display: inline-block;
    width: 30%;
}
​ .container-open {
    box-shadow: $dropdown-box-shadow;
    position: relative;
    display: inline-block;
    width: 30%;
}
​ .container-open:focus {
    outline: none;
}
​ .container:focus {
    outline: none;
}
​ .item-list-hidden {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
    z-index: 1;
}
​ .item-list-show {
    display: block;
    width: 100%;
    ​ & :hover {
        background: $gray-100;
        color: $hyperlink-color;
        cursor: pointer;
    }
}
.items {
    padding: 0;
    margin: 0;
    height: 30vh;
    overflow: hidden;
}
​ .item {
    padding: 3%;
    padding-left: 5%;
    background: white;
    border-top: $gray-200 solid 1px;
    z-index: $z-index_dropdowns;
}
​ #scrollbar::-webkit-scrollbar-track {
    -webkit-box-shadow: inset 0 0 6px $gray-100;
    background-color: $gray-100;
}
​ #scrollbar::-webkit-scrollbar {
    width: 10px;
    background-color: $gray-400;
}
​ #scrollbar::-webkit-scrollbar-thumb {
    -webkit-box-shadow: inset 0 0 6px $gray-400;
    background-color: $gray-400;
}
​ .scrollbar {
    height: 300px;
    overflow-y: scroll;
    position: absolute;
    width: 100%;
    z-index: $z-index_dropdowns;
    box-shadow: $dropdown-box-shadow;
}
</style>
