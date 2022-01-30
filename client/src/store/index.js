import Vue from "vue";
import Vuex from "vuex";
import { UserModule } from "./modules/user";

Vue.use(Vuex);

export default new Vuex.Store({
  strict: true,
  state: {
    showSnackbar: false,
    snackbarMessage: "",
    snackbarColor: "",
    snackbarTimeOut: 0,
    showLoader: false,
    loaderMessage: ""
  },
  mutations: {
    SHOW_LOADER(state, loaderMessage) {
      state.showLoader = true;
      state.loaderMessage = loaderMessage || "Please, wait...";
    },
    CLOSE_LOADER(state) {
      state.showLoader = false;
      state.loaderMessage = "";
    },
    SHOW_SNACKBAR(state, payload) {
      const { message, color, timeOut } = payload;
      state.snackbarMessage = message == null && payload ? payload : message;
      if (state.snackbarMessage) {
        state.snackbarColor = color ? color : "red";
        state.snackbarTimeOut = timeOut ? timeOut : 0;
        state.showSnackbar = true;
      }
    },
    CLOSE_SNACKBAR(state) {
      state.showSnackbar = false;
      state.snackbarMessage = "";
      state.snackbarColor = "";
      state.snackbarTimeOut = 0;
    },
  },
  modules: {
    UserModule
  }
});
