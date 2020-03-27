import Vue from 'vue';
import Router from 'vue-router';
import Account from '@/pages/Account';
import Dashboard from '@/components/Dashboard';
import PageNotFound from '@/components/error/PageNotFound';

import Register from "@/components/account/Register";
import Login from "@/components/account/Login";
import Forgot from "@/components/account/Forgot";

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
      path: '/account',
      name: 'Account',
      component: Account,
      meta: { allRequired: true },
      children: [
        {
          path: 'login',
          name: 'Login',
          component: Login,
          meta: { allRequired: true },
        },
        {
          path: 'register',
          name: 'Register',
          component: Register,
          meta: { allRequired: true },
        },
        {
          path: 'forgot',
          name: 'Forgot',
          component: Forgot,
          meta: { allRequired: true },
        },
      ]
    },
    {
      path: '*',
      name: 'PageNotFound',
      components: PageNotFound,
      meta: { allRequired: true },
    },
  ],
});
