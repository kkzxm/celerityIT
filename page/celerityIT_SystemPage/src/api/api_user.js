import * as API from './methods'

export default {
    //密码登录
    login: params => {
        return API.POST('admin/login', params)
    },
    word: {
        getPage: params => {
            return API.GET('word/getPage', params)
        }
    }
}

