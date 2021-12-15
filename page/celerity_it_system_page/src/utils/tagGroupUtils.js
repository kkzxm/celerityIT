let name = 'tagGroupList'

export default {
  getTagGroupList () {
    return eval(localStorage.getItem(name))
  },
  setTagGroupList (tagGroupList) {
    localStorage.setItem(name, JSON.stringify(tagGroupList))
  }
}
