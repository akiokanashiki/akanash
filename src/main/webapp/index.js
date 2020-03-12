"use strict";

// 
import Vue from 'vue';
import Vuex from 'vuex';
import App from './App';
import Appx from './Appx';

// 
Vue.use(Vuex);

// 
new Vue({
    el: '#app',
    render: h => h(App),
    store: new Vuex.Store(Appx),
});