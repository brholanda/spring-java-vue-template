<template>
  <v-app id="inspire">
    <Snackbar />
    <Loader />
    <v-toolbar
      :clipped-left="$vuetify.breakpoint.lgAndUp"
      color="#FFFFFF"
      app
      dense
    >
      <v-toolbar-title style="width: 150px" class="ml-0 pl-3">
        <v-btn
          color="white"
          class="button-icon pa-1"
          depressed
          @click="$router.push('/')"
        >
          <v-icon>home</v-icon>
        </v-btn>
      </v-toolbar-title>
    </v-toolbar>
    <v-container
      fluid
      align-center
      justify-start
      column
      fill-height
      class="pa-0"
    >
      <v-flex>
        <router-view></router-view>
      </v-flex>
    </v-container>
    <v-footer absolute>
      <div class="footer">{{ new Date().getFullYear() }} — <strong>by Bruno Holanda</strong></div>
      <v-spacer></v-spacer>
      <div class="footer"><strong>v1.0.0</strong></div>
    </v-footer>
  </v-app>
</template>

<script>
import Snackbar from "./components/shared/Snackbar";
import Loader from "./components/shared/Loader";
export default {
  name: "app",
  components: {
    Snackbar,
    Loader,
  }
};
</script>

<style>
@import "./assets/css/home.css";
</style>