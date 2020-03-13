<template>
  <div>
    <form action="/logout" method="GET">
      <input type="submit" value="Logout" />
    </form>
    <h1>Tickets</h1>
    <h2>New</h2>
    <form @submit.prevent.stop="submitNewTicket">
      <input type="text" v-model="title" />
      <input type="submit" value="Create" />
    </form>
    <h2>List</h2>
    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>TITLE</th>
          <th>STATUS</th>
          <th>BY</th>
          <th>AT</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="ticket in tickets" v-bind:key="ticket.id">
          <td>{{ticket.id}}</td>
          <td>{{ticket.title}}</td>
          <td>{{ticket.status}}</td>
          <td>{{ticket.created_by}}</td>
          <td>{{ticket.created_at}}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>
<script>
import { mapState } from "vuex";
export default {
  data() {
    return {
      title: null
    };
  },
  computed: {
    ...mapState(["tickets"])
  },
  methods: {
    submitNewTicket() {
      const title = this.title;
      this.$store.dispatch("createTicket", { title });
      this.title = "";
    }
  },
  created() {
    this.$store.dispatch("listTickets");
  }
};
</script>