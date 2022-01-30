import {
  FIND_ORDERED_BY_CREATION_DATE
} from '../action-types'
import { execute, mapFunctions } from './BaseFunctions'

import UserForm from './forms/UserForm'

const actions = {
  async [FIND_ORDERED_BY_CREATION_DATE]({ dispatch, commit }) {
    await execute(() => dispatch('UserForm/FIND_ORDERED_BY_CREATION_DATE'), commit)
  }
}

const modules = {
  UserForm
};

export const { mapFields: mapUserFields } = mapFunctions('Users', 'User')

export const UserModule = {
  namespaced: true,
  modules,
  actions,
}