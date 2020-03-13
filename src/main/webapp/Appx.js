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
            state.tickets = (tickets ? tickets : []);
        }
    },
    actions: {
        listTickets({ commit }) {
            gqlClient.query({
                query: gql`query {
                    listTickets {
                        id
                        title
                        status
                        created_by
                        created_at
                    }
                }`
            })
                .then(({ listTickets }) => commit('updateTickets', { tickets: listTickets }))
                .catch((error) => { console.log(error) });
        },
    },
};