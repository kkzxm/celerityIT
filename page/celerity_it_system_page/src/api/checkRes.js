// 检测请求结果
// @param res
import { ElMessage } from 'element-plus'

export default (res, success, error) => {
  if (res && res.success) {
    if (!success) return res
    ElMessage.success({
      showClose: true,
      message: success.message,
      type: 'success'
    })
    success.fun()
  } else {
    ElMessage({
      showClose: true,
      message: res ? res.message : error.message,
      type: 'error'
    })
    error.fun()
  }
  return res
}

