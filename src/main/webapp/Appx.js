"use strict";

//
import ApolloClient from 'apollo-boost';
import gql from 'graphql-tag';
import axios from 'axios';

//
const gqlClient = new ApolloClient();

// 
export default {
    state: {
        tickets: [],
    },
    getters: {

    },
    mutations: {
        updateTickets(state, { tickets }) {
            state.tickets = [...tickets];
        }
    },
    actions: {
        listTickets({ commit }) {
            gqlClient.query({
                query: gql`query { tickets { id title status created_by created_at } }`,
                fetchPolicy: "network-only"
            })
                .then(({ data: { tickets } }) => commit('updateTickets', { tickets }))
                .catch((error) => console.log(error));
        },
        createTicket({ dispatch }, { title }) {
            axios.post('./api/tickets/create-ticket', { title })
                .then(() => dispatch('listTickets'))
                .catch((error) => console.log(error));
        },
        deleteTicket({ dispatch }, { id }) {
            axios.post('./api/tickets/delete-ticket', { id })
                .then(() => dispatch('listTickets'))
                .catch((error) => console.log(error));
        }
    },
};