<template>
  <v-container class="home-container">
    <v-flex>
      <v-card>
        <h2 class="centered-text">Home</h2>
      </v-card>
      <br>
      <Home/>
    </v-flex>
  </v-container>
</template>

<script>
import { Home } from "./index";
export default {
  components: {
    Home
  },
  data: () => ({})
};
</script>

<style>
@import "../../assets/css/home.css";
</style>