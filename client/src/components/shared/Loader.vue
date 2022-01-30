<template>
  <v-dialog v-model="showLoader" persistent width="300">
    <v-card>
      <v-card-text>
        {{ loaderMessage }}
        <v-progress-linear indeterminate color="#00adef" class="mb-0"></v-progress-linear>
      </v-card-text>
    </v-card>
  </v-dialog>
</template>

<script>
import { mapState } from "vuex";
export default {
  data() {
    return {};
  },
  computed: mapState(["showLoader", "loaderMessage"])
};
</script>
