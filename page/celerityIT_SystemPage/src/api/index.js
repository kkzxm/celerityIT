import axios from 'axios'
import api_user from '@/api/api_user'
import checkResult from '@/api/checkRes'

axios.defaults.headers['token'] = sessionStorage.getItem('token')

export const API = api_user

export const checkRes = checkResult

export const setToken = (token) => {
  sessionStorage.setItem('token', token)
  axios.defaults.headers['token'] = token
}

export const getToken = () => {
  return sessionStorage.getItem('token')
}

