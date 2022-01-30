import {
  LOGIN
} from '../action-types'
import { execute, mapFunctions } from './BaseFunctions'

import UserForm from './forms/UserForm'

const actions = {
  async [LOGIN]({ dispatch, commit }, user) {
    await execute(() => dispatch('UserForm/LOGIN', user), commit)
  },
}

const modules = {
  UserForm
};

export const { mapFields: mapLoginFields } = mapFunctions('Login', 'User')

export const LoginModule = {
  namespaced: true,
  modules,
  actions,
}