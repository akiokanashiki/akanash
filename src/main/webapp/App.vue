<template>
  <div>
    <form action="/logout" method="GET">
      <input type="submit" value="Logout" />
    </form>
    <h1>Tickets</h1>
    <h2>New</h2>
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
import { mapActions } from "vuex";
export default {
  data() {
    return {
      tickets: []
    };
  },
  methods: {
    ...mapActions("listTickets")
  },
  created() {
    this.$store.dispatch('listTickets')
  }
};
</script>