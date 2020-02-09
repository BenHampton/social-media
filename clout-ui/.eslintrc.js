module.exports = {
    root: true,
    env: {
        node: true
    },
    extends: ['plugin:vue/essential', '@vue/prettier'],
    rules: {
        curly: 'error',
        'prettier/prettier': [
            'error',
            { singleQuote: true, semi: false, tabWidth: 4 }
        ],
        'no-console': process.env.NODE_ENV === 'production' ? 'error' : 'off',
        'no-debugger': process.env.NODE_ENV === 'production' ? 'error' : 'off'
    },
    globals: {
        "Atomics": "readonly",
        "SharedArrayBuffer": "readonly"
    },
    parserOptions: {
        parser: 'babel-eslint'
    },
    plugins: [
        "vue", "prettier"
    ]
};