import { API } from '@/api'

export default {
  /**
   * 设置当前页显示的相关表格数据
   */
  setPageInData (that, pageInfo) {
    let thisPage = 1
    let pageSize = 10
    if (pageInfo) {
      thisPage = pageInfo.thisPage
      pageSize = pageInfo.pageSize
    }
    let routeName = that.$route.name
    if (routeName === 'login') return
    let apiElement = API[routeName]
    if (apiElement) {
      apiElement.getPage({
        thisPage,
        pageSize
      }).then((res) => {
        if (res.success) {
          let data = res.data
          that.page.dataList = data.records
          that.page.total = data.total
        }
      })
    } else {
      that.page.total = 0
    }
    return that.page.dataList
  },
}
