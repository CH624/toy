import Vue from 'vue';
import Router from 'vue-router';
import Account from '@/pages/Account';
import Register from '@/components/account/Register';
import Login from '@/components/account/Login';
import Forgot from '@/components/account/Forgot';
import Dashboard from '@/components/Dashboard';
import Common from '@/pages/Common';
import BoardList from '@/components/board/Board-list';
import BoardWrite from '@/components/board/Board-write';
import BoardContent from '@/components/board/Board-content';
import PageNotFound from '@/components/error/PageNotFound';


Vue.use(Router);
export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Main',
      redirect: 'dashboard',
    },
    {
      path: '/dashboard',
      name: 'Dashboard',
      component: Dashboard,
    },
    {
      path: '/board',
      name: 'Board',
      redirect: { name: 'boardList' },
      component: Common,
      children: [
        {
          path: 'list',
          name: 'boardList',
          component: BoardList,
        },
        {
          path: 'write',
          name: 'boardWrite',
          component: BoardWrite,
        },
        {
          path: ':id',
          name: 'boardContent',
          component: BoardContent,
        },
      ],
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
      ],
    },
    {
      path: '*',
      name: 'PageNotFound',
      components: PageNotFound,
      meta: { allRequired: true },
    },
  ],
});
