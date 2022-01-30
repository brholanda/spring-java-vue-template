import { CLOSE_LOADER, SHOW_LOADER, SHOW_SNACKBAR } from '../mutation-types'
import { createHelpers } from 'vuex-map-fields'

export async function execute(dispatcher, commit, loaderInitMessage, loaderEndMessage) {
  try {
    if(loaderInitMessage) {
      commit(SHOW_LOADER, loaderInitMessage, { root: true })
    }
    await dispatcher()
    if(loaderEndMessage) {
      commit(SHOW_SNACKBAR, { message: loaderEndMessage, color: 'info' }, { root: true })
    }
  } catch(error) {
    commit(SHOW_SNACKBAR, error, { root: true })
  } finally {
    commit(CLOSE_LOADER, null, { root: true })
  }
}

export function mapFunctions(moduleName, formName = moduleName) {
  return createHelpers({
    getterType: `${moduleName}Module/${formName}Form/getField`,
    mutationType: `${moduleName}Module/${formName}Form/updateField`
  })
}