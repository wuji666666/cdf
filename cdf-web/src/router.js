import VueRouter from 'vue-router'
import Classification from './components/webview/Classification.vue'
import PersonCenter from './components/webview/PersonCenter.vue'
import ShopCart from './components/webview/ShopCart.vue'
import ShopMall from './components/webview/ShopMall.vue'
import SearchGoods from './components/search/SearchGoods.vue'
import SearchResult from './components/search/SearchResult.vue'
import SubSpecialFirst from './components/carousel/SubSpecialFirst.vue'
import SubSpecialSecond from './components/carousel/SubSpecialSecond.vue'
import SpecialThird from './components/carousel/SpecialThird.vue'
import CircleDisplay from './components/frame/CircleDisplay.vue'
import BrandsDisplay from './components/frame/BrandsDisplay.vue'
import ShopMessage from './components/shopcart/ShopMessage.vue'
import ShopChart from './components/shopcart/ShopChart.vue'
import AllGoods from './components/webview/AllGoods.vue'


var router=new VueRouter({
    routes:[
        {path:'/',  redirect:'/shopmall'},
        {path:'/shopmall',component:ShopMall},
        {path:'/classification',component:Classification },
        {path:'/allgoods',component:AllGoods},
        {path:'/shopcart',component:ShopCart },
        {path:'/person',component:PersonCenter},
    
        {path:'/shopmall/searchgoods/searchresult/:content/',component:SearchResult},
        {path:"/shopmall/searchgoods", component:SearchGoods},
        {path:"/shopmall/subspecial",component:SubSpecialFirst},
        {path:"/shopmall/subspecialsecond",component:SubSpecialSecond},
        {path:"/shopmall/thirdspecial",component:SpecialThird},
        {path:'/shopmall/circledisplay/:title',component:CircleDisplay},
        {path:'/shopmall/branddisplay/:brandname',component:BrandsDisplay},
        {path:'/shopcart/message/:id',component:ShopMessage},
        {path:'/chart',component:ShopChart}
      
        


     ],
     linkActiveClass: 'mui-active'
})

export default router



