import Vue from 'vue';
import Router from 'vue-router';
import Account from '@/pages/Account';
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
      component: Account,
      meta: { allRequired: true },
    },
    {
      path: '/register',
      name: 'Register',
      component: Account,
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
