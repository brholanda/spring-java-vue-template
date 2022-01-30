<template>
  <v-card>
    <v-card-text class="pt-4">
      <div>
        <v-form ref="form">
          <v-text-field
            class="credential-input"
            type="text"
            label="Email:"
            autocapitalize="true"
            placeholder="E-mail"
            v-model="formUser.email"
            required
          ></v-text-field>
          <v-text-field
            class="credential-input"
            label="Password:"
            placeholder="Password"
            v-model="formUser.Password"
            type="password"
            required
          ></v-text-field>
          <v-layout class="bottom" justify-space-between>
            <v-btn @click="login(formUser)">Login</v-btn>
          </v-layout>
        </v-form>
      </div>
    </v-card-text>
  </v-card>
</template>

<script>
import {
  LOGIN,
} from "../../store/action-types";
import { createNamespacedHelpers } from "vuex";
import { mapLoginFields } from '../../store/modules/login';
const { mapActions } = createNamespacedHelpers("LoginModule");

export default {
  data() {
    return {
      formUser: {
        email: '',
        Password: ''
      }
    };
  },
  methods: {
    ...mapActions({
      login: LOGIN,
    }),
  }
};
</script>

<style>
</style>
