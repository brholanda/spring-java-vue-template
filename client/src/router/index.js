import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      name: 'home',
      path: '/',
      component: require('../components/home/GridContainer').default
    },
    {
      name: 'users',
      path: '/users',
      component: require('../components/user/GridContainer').default
    },
  ]
})

router.beforeEach((to, from, next) => {
  next()
})
export default router