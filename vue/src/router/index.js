import Vue from 'vue';
import Router from 'vue-router';
import Login from '@/components/login/Login';
import Register from '@/components/login/Register';
import Dashboard from '@/components/Dashboard';
import PageNotFound from '@/components/error/PageNotFound';

Vue.use(Router);

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Dashboard',
      component: Dashboard,
    },
    {
      path: '/login',
      name: 'Login',
      component: Login,
      meta: { allRequired: true },
    },
    {
      path: '/register',
      name: 'register',
      component: Register,
      meta: { allRequired: true },
    },
    {
      path: '*',
      name: 'PageNotFound',
      components: PageNotFound,
      meta: { allRequired: true },
    },
  ],
});
