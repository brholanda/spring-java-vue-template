<template>
  <v-snackbar
    :color="snackbarColor"
    class="text--black ma-3"
    v-model="showSnackbar"
    :timeout="snackbarTimeOut"
    :absolute="false"
    :top="true"
    :auto-height="true"
  >
    {{ snackbarMessage }}
    <v-btn flat color="black" @click="closeSnackbar">Fechar</v-btn>
  </v-snackbar>
</template>

<script>
import { CLOSE_SNACKBAR } from "./../../store/mutation-types";
import { mapState, mapMutations } from "vuex";
export default {
  data() {
    return {};
  },
  computed: {
    ...mapState(["snackbarMessage", "snackbarColor", "snackbarTimeOut"]),
    showSnackbar: {
      get () {
        return this.$store.state.showSnackbar
      },
      set (value) {
        this.$store.commit('CHANGE_SHOW_SNACKBAR', value)
      }
    }
  },
  methods: {
    ...mapMutations({
      closeSnackbar: CLOSE_SNACKBAR
    })
  }
};
</script>