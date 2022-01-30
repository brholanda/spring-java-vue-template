import axios from 'axios'
const url = process.env.VUE_APP_BASE_URL

export async function execute(dispatcher) {
  try {
    let response = await dispatcher()
    return response.data
  } catch (error) {
    console.log(error)
    if (!error.response)
      throw 'Erro de comunicação com o servidor.'
    else
      throw error.response.data.message
  }
}

export async function login(user) {
  return await execute(() => axios.post(`${url}login`, user))
}

export async function logout() {
  return await execute(() => axios.post(`${url}logout`))
}

export async function getOne(entity, entityName) {
  return await execute(() => axios.get(`${url}${entityName}/findbyid${entityName}`, {
    params: {
      id: entity.id
    }
  }))
}

export async function get(path = '') {
  return await execute(() => axios.get(`${url}${path}`))
}

export async function fetchByFilter(eFilter, path = '') {
  return await execute(() => axios.post(`${url}${path}/findbyfilter`, eFilter))
}

export async function put(entity, path = '') {
  return await execute(() => axios.put(`${url}${path}`, entity))
}

export async function post(entity, path = '') {
  return await execute(() => axios.post(`${url}${path}`, entity))
}

export async function deleteEntity(entity, path = '') {
  return await execute(() => axios.delete(`${url}${path}`, {
    params: {
      id: entity.id
    }
  }))
}