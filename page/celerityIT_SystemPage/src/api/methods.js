import Env from '@/api/env'

let base = Env.baseURL

//通用方法
/*
post
向服务器端提交数据，请求数据在报文body里
发送一个修改数据的请求，需求数据要从新创建
用于创建，更新，删除资源，查询资源都可以，是不幂等的
 */
import axios from 'axios'

export const POST = (url, params) => {
  const getTimestamp = new Date().getTime()
  return axios.post(`${base}${url}?timer=${getTimestamp}`, params).then(res => res.data)
}
/*
get
从服务器端获取数据，请求body在地址栏上
用于获取资源，是幂等的，无副作用
 */
export const GET = (url, params) => {
  const getTimestamp = new Date().getTime()
  return axios.get(`${base}${url}?timer=${getTimestamp}`, { params: params }).then(res => res.data)
}

/*
put
向服务器端提交数据，请求数据在报文body里
发送一个修改数据的请求，需求数据更新（全部更新）
用于添加/更新资源
 */
export const PUT = (url, params) => {
  return axios.put(`${base}${url}`, params).then(res => res.data)
}

/*
delete
向服务器端提交数据，请求数据在报文body里
发送一个删除数据的请求
用于删除资源
 */
export const DELETE = (url, params) => {
  return axios.delete(`${base}${url}`, { params: params }).then(res => res.data)
}
/*
patch
向服务器端提交数据，请求数据在报文body里
发送一个修改数据的请求，需求数据更新（部分更新）
用于更新资源，且是局部更新，比如：user对象，你只更改了name属性，那么他的其他属性值是不会变的，如果你用post，那么其他属性值会被设置为null（全局更新）
 */
export const PATCH = (url, params) => {
  return axios.patch(`${base}${url}`, params).then(res => res.data)
}
