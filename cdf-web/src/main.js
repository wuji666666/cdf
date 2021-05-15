import Vue from 'vue'

import app from './App.vue'

import './lib/mui/css/mui.min.css'
//import './lib/mui/js/mui.min.js'
import './lib/mui/css/icons-extra.css'
import './lib/mui/css/app.css'
import VueRouter from 'vue-router'
import router from './router.js'

import {Header, Switch} from 'mint-ui';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css'
import '../node_modules/bootstrap-icons/font/bootstrap-icons.css'
import './lib/swiper/css/swiper-bundle.min.css'

import VueResource from 'vue-resource'
import Vuex from 'vuex'

Vue.use(VueRouter)

Vue.component(Header.name, Header);

//导入bootsrap

Vue.component(Switch.name, Switch);


Vue.use(VueResource)
Vue.use(Vuex)

var product=JSON.parse(localStorage.getItem("product")||"[]")
var store=new Vuex.Store({
    state:{
      productInfo:product,
    },
    mutations:{
      addToCart(state,productKeyInfo){
        var flag=false;//作为是否添加到数组的判断标志
        state.productInfo.some(item=>{
            if(item.id===productKeyInfo.id){
                item.quantity+=1;
                flag=true;
                return true;
            }
        });
        if(flag===false){
            state.productInfo.push(productKeyInfo);
            flag=true;
        }
        localStorage.setItem("product",JSON.stringify(state.productInfo))

      },
      upDatedCounts(state,infor){
        state.productInfo.findIndex(item=>{
            if(item.id===infor.id){
                item.quantity=parseInt(infor.quantity)
                return true;
            }
        })
        localStorage.setItem("product",JSON.stringify(state.productInfo))
      },
    },
    getters:{
        getAllCounts(state){
            var count=0
             state.productInfo.forEach(item=>{
              count+=item.quantity;
             });
             return count;
        },
       
        initCount(state){
            var count={};
            state.productInfo.forEach(item=>{
               count[item.id]=item.quantity;
            })
            return count;
        }
    }
})

var vm=new Vue({
    el:"#app",
    data:{},
    methods: {},
    render:function(element){
        return element(app);
    },
    router,
    store,
    
})

