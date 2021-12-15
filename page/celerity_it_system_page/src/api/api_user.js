import * as API from './methods'

export default {
  //密码登录
  login: params => {
    return API.POST('admin/login', params)
  },
  word: {
    getPage: params => {
      return API.GET('word/getPage', params)
    },
    add: params => {
      return API.POST('word/add', params)
    },
    del: params => {
      return API.DELETE('word/deleteById', params)
    },
    update: params => {
      return API.POST('word/updateById', params)
    }
  },
  chinese: {
    getPage: params => {
      return API.GET('chinese/getPage', params)
    },
    add: params => {
      return API.POST('chinese/add', params)
    },
    del: params => {
      return API.DELETE('chinese/deleteById', params)
    },
    update: params => {
      return API.POST('chinese/updateById', params)
    }
  },
  wordToChinese: {
    getPage: params => {
      return API.GET('wordToChinese/getPage', params)
    },
    add: params => {
      return API.POST('wordToChinese/add', params)
    },
    del: params => {
      let par = new URLSearchParams()
      par.append('wordId', params.word.wordId)
      par.append('chineseId', params.chinese.chineseId)
      return API.DELETE('wordToChinese/deleteById', par)
    },
    update: params => {
      return API.POST('wordToChinese/updateById', params)
    }
  },
  wordType: {
    getPage: params => {
      return API.GET('wordType/getPage', params)
    },
    add: params => {
      return API.POST('wordType/add', params)
    },
    del: params => {
      return API.DELETE('wordType/deleteById', params)
    },
    update: params => {
      return API.POST('wordType/updateById', params)
    },
  },
  wordToType: {
    getPage: params => {
      return API.GET('wordToType/getPage', params)
    },
    add: params => {
      return API.POST('wordToType/add', params)
    },
    del: params => {
      let par = new URLSearchParams()
      par.append('wordId', params.word.wordId)
      par.append('wordTypeId', params.wordType.wordTypeId)
      return API.DELETE('wordToType/deleteById', par)
    },
    update: params => {
      return API.POST('wordToType/updateById', params)
    }
  },
  wordTag: {
    getPage: params => {
      return API.GET('wordTag/getPage', params)
    },
    add: params => {
      return API.POST('wordTag/add', params)
    },
    update: params => {
      return API.POST('wordTag/updateById', params)
    },
    del: params => {
      return API.DELETE('wordTag/deleteById', params)
    }
  },
  wordToTag: {
    getPage: params => {
      return API.GET('wordToTag/getPage', params)
    },
    add: params => {
      return API.POST('wordToTag/add', params)
    },
    update: params => {
      return API.POST('wordToTag/updateById', params)
    },
    del: params => {
      let par = new URLSearchParams()
      par.append('wordId', params.word.wordId)
      par.append('wordTagId', params.wordTag.wordTagId)
      return API.DELETE('wordToTag/deleteById', par)
    }
  },
  wordTagGroup: {
    getPage: params => {
      return API.GET('wordTagGroup/getPage', params)
    },
    add: params => {
      return API.POST('wordTagGroup/add', params)
    },
    del: params => {
      let par = new URLSearchParams()
      par.append('tagGroupId', params.tagGroupId)
      return API.DELETE('wordTagGroup/deleteById', par)
    },
    update: params => {
      return API.POST('wordTagGroup/updateById', params)
    },
  },
}

