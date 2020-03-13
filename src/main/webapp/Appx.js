"use strict";

//
import ApolloClient from 'apollo-boost';
import gql from 'graphql-tag';

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
            state.tickets.splice(0);
            console.log(tickets);
            if (tickets && tickets.length > 0) {
                console.log("push");
                state.tickets.push(...tickets);
            }
            console.log(state.tickets);
        }
    },
    actions: {
        listTickets({ commit }) {
            gqlClient.query({
                query: gql`query { listTickets { id title status created_by created_at } }`,
                fetchPolicy: "network-only"
            })
                .then(({ data: { listTickets } }) => commit('updateTickets', { tickets: listTickets }))
                .catch((error) => console.log(error));
        },
        createTicket({ dispatch }, { title }) {
            gqlClient.mutate({
                mutation: gql`mutation($title:String!) { createTicket(title:$title) { id } }`,
                variables: { title },
            })
                .then(() => dispatch('listTickets'))
                .catch((error) => console.log(error));
        },
        deleteTicket({ commit }, { id }) {

        }
    },
};