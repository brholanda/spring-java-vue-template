import axios from 'axios'
import { execute } from './GenericAPI'
const url = `${process.env.VUE_APP_BASE_URL}user`

export async function findOrderedByCreationDate() {
  return await execute(() => axios.get(`${url}/findorderedbycreationdate`))
}