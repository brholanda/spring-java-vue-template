<template>
  <v-container>
    <v-flex>
      <v-card>
        <h2 class="centered-text">Users</h2>
      </v-card>
      <br>
      <v-flex>
        <Table/>
      </v-flex>
    </v-flex>
  </v-container>
</template>

<script>
import { Table } from "./index";
export default {
  components: {
    Table
  },
  data: () => ({})
};
</script>
