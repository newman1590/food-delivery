
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);






import MypageView from "./components/MypageView"
import MypageViewDetail from "./components/MypageViewDetail"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [




            {
                path: '/customers/mypages',
                name: 'MypageView',
                component: MypageView
            },
            {
                path: '/customers/mypages/:id',
                name: 'MypageViewDetail',
                component: MypageViewDetail
            },


    ]
})
