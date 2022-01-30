<template>
  <v-card>
    <v-card-text>
      <v-data-table
        :headers="headers"
        :items="userList"
        class="elevation-1"
        no-data-text="No records found"
      >
        <template slot="items" slot-scope="props">
          <td>{{props.item.name}}</td>
          <td>{{props.item.email}}</td>
          <td>{{props.item.profile.name}}</td>
          <td>{{props.item.creationDate | userFormatDateTime}}</td>
        </template>
      </v-data-table>
    </v-card-text>
  </v-card>
</template>

<script>
import { FIND_ORDERED_BY_CREATION_DATE } from "../../store/action-types";
import { mapUserFields } from "../../store/modules/user";
import { createNamespacedHelpers } from "vuex";
const { mapActions } = createNamespacedHelpers("UsersModule");

export default {
  data: () => ({
    headers: [
      { text: "Name", value: "name", align: "left", sortable: false },
      { text: "E-mail", value: "email", align: "left", sortable: false },
      { text: "Profile", value: "profile", align: "left", sortable: false },
      { text: "Creation Date", value: "creationDate", align: "left", sortable: false }
    ]
  }),
  async created() {
    this.findUsers()
  },
  computed: {
    ...mapUserFields(["userList"])
  },
  methods: {
    ...mapActions({
      findUsers: FIND_ORDERED_BY_CREATION_DATE
    }),
  }
};
</script>

<style>
</style>
