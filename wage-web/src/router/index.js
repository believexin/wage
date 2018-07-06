import Vue from 'vue'
import Router from 'vue-router'
import Wage from '@/components/wage'
import User from '@/components/users/user'
import Issue from '@/components/wage/wageIssue'
import Manager from '@/components/manager/manager'
import Login from '@/components/login'
import Home from '@/components/home'
import Error403 from '@/components/403'
Vue.use(Router)

export default new Router({
  routes: [

    {
      path: '/',
      name: 'Login',
      component: Login
    },
    {
      path: '/home',
      name: 'Home',
      component: Home
    },
    {
      path: '/home',
      component: Home,
      children:[
        {
          path: '/home/wage',
          name: 'Wage',
          meta: {
            requireAuth: true,
          },
          component: Wage
        },
        {
          path: '/home/user',
          name: 'User',
          meta: {
            requireAuth: true,
          },
          component: User
        },
        {
          path: '/home/issue',
          name: 'Issue',
          meta: {
            requireAuth: true,
          },
          component: Issue
        },
        {
          path: '/home/manager',
          name: 'Manager',
          meta: {
            requireAuth: true,
          },
          component: Manager
        },
        {
          path: '/home/403',
          name: '403',
          meta: {
            requireAuth: true,
          },
          component: Error403
        }
      ]
    }
  ]
})
