import 'material-design-icons-iconfont/dist/material-design-icons.css' // Ensure you are using css-loader
import Vue from 'vue'
import './plugins/vuetify'
import App from './App.vue'
import axios from 'axios'
import dayjs from 'dayjs'
import router from './router'
import store from './store'
import Vuetify from 'vuetify/lib';
import 'vue-directive-tooltip/dist/vueDirectiveTooltip.css';
import IdleVue from 'idle-vue';

let url = process.env.VUE_APP_BASE_URL
Vue.prototype.$_url = url
Vue.prototype.$_axios = axios
Vue.prototype.$_dayjs = dayjs

Vue.filter('userFormatDate', (v) => {
  if (!v || !dayjs(v).isValid) return ''
  return dayjs(v).format('DD/MM/YYYY')
})

Vue.filter('userFormatDateTime', (v) => {
  if (!v || !dayjs(v).isValid) return ''
  return dayjs(v).format('DD/MM/YYYY HH:mm:ss')
})

Vue.filter('javaFormatDate', function (v) {
  if (!v || !dayjs(v).isValid) return 'date parse error'
  return dayjs(v).format('YYYYMMDD')
})

Vue.filter('vueFormatDate', function (v) {
  if (!v || !dayjs(v).isValid) return 'date parse error'
  return dayjs(v).format('YYYY-MM-DD')
})

Vue.filter('javaFormatLocalDateTime', function (v) {
  if (!v || !dayjs(v).isValid)
    return ''
  return dayjs(v).format('YYYY-MM-DDT00:00:00')
})

Vue.use(Vuetify, {
  iconfont: 'md'
})

const eventsHub = new Vue()

Vue.use(IdleVue, {
  eventEmitter: eventsHub,
  idleTime: 1000 * 60 * 60, //1 hora
  store
})

Vue.config.productionTip = false;
new Vue({
  el: '#app',
  router,
  store,
  render: h => h(App),
});
