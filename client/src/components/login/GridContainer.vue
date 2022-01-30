<template>
  <v-container class="login-container">
    <v-flex>
      <v-flex>
        <Login/>
      </v-flex>
    </v-flex>
  </v-container>
</template>

<script>
import { Login } from "./index";
export default {
  components: {
    Login
  },
  data: () => ({})
};
</script>

<style>
@import "../../assets/css/login.css";
</style>