import mockUser from './mock-data/user'
const isTesting = process.env.NODE_ENV === 'test'
function wait(ms) {
    return new Promise(resolve => {
        if (isTesting) {
            resolve()
        } else {
            setTimeout(resolve, ms)
        }
    })
}
export default {
    async login() {
        await wait(100)
        return JSON.parse(JSON.stringify(mockUser))
    }
}
