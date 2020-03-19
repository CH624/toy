// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import BootstrapVue from 'bootstrap-vue';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap-vue/dist/bootstrap-vue.css';
import '@/assets/css/adminlte.min.css';
import '@/assets/css/icheck-bootstrap.min.css';
import toastr from 'vue-toastr';
import axios from 'axios';
import { library } from '@fortawesome/fontawesome-svg-core';
import { fas } from '@fortawesome/free-solid-svg-icons';
import { far } from '@fortawesome/free-regular-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';

import Vue from 'vue';
import App from './App';
import router from './router';

library.add(fas);
library.add(far);
Vue.component('font-awesome-icon', FontAwesomeIcon);
Vue.use(BootstrapVue);
Vue.use(toastr, {
  defaultTimeout: 3000,
  defaultProgressBar: true,
  defaultPosition: 'toast-top-center',
});

router.beforeEach((to, from, next) => {
  const token = sessionStorage.getItem('token');
  to.matched.some(routeInfo => !routeInfo.meta.allRequired) && (token == null || token === '') ? next('/login') : next();
});

//axios.defaults.headers.common['X-AUTH-TOKEN'] = sessionStorage.getItem('token');

Vue.config.productionTip = false;

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>',
});
