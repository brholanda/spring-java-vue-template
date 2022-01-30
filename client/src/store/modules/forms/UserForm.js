import {
  getField,
  updateField
} from 'vuex-map-fields';
import {
  User
} from '../../../models/User';
import {
  FIND_ORDERED_BY_CREATION_DATE
} from '../../action-types';
import {
  findOrderedByCreationDate
} from '../../../API/UserAPI';
import {
  SUCCESS,
} from '../../mutation-types';

const actions = {
  async [FIND_ORDERED_BY_CREATION_DATE]({ commit }) {
    const found = await findOrderedByCreationDate()
    commit(SUCCESS, found)
    commit(SUCCESS, found[0])
  }
}
const mutations = {
  updateField,
  [SUCCESS](state, payload) {
    if (Array.isArray(payload)) state.listaUser = payload
    else state.user = payload || new User()
  }
}
const getters = {
  getField,
};
const state = () => ({
  user: new User(),
  userList: [],
});

export default {
  namespaced: true,
  mutations,
  actions,
  getters,
  state,
};