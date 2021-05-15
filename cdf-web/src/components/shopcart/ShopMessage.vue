<template>
<div  class="container" >
    <h5>商品详情</h5>
    <img class="picture" :src="product.product_icon"/>
  
    <div class="text">
    <span class="price">原价￥</span>
    <span class="num">{{product.cost_price}}</span>
    <span class="extra-msg">包邮包税</span>
    </div>
    <p class="description">{{product.product_description}}</p>
    <div class="bottom-main">
    <router-link  to="/shopmall"          class="service first">
       <span class="mui-icon-extra mui-icon-extra-university"></span>
       <span>首页</span>
    </router-link>
    <router-link to="/chart"   class="service">
       <span      class="mui-icon-extra mui-icon-extra-addpeople"></span>
       <span>客服</span>
    </router-link>
    <router-link  to='/shopcart'  class="service">
       <span class="mui-icon-extra mui-icon-extra-cart"></span>
       <span>购物车</span>
       <span class="circle">{{$store.getters.getAllCounts}}</span>
    </router-link>

   
    <button class="btn btn-warning" @click="addToCart">加入购物车
          <transition @befor-enter="beforeEnter"
                      @enter="enter"
                      @after-enter="afterEnter">
               <span class="ball" v-show="flag">+1</span>
          </transition>
    </button>
  

     <button class="btn btn-info buyer">立即购买</button>


    </div>

    



</div>
    
</template>


<script>
export default {
    data() {
        return {
            id:"",
            product:{},
            flag:false,
            quantity:0,
            price:0,
            productKeyInfo:{}
        }
    },
    mounted() {
        this.productId=this.$route.params.id;
        this.findById();
    },
   
    methods: {
        findById(){
            this.$http.get("http://localhost:8080/cdf/buyer/search/product?productId="+this.productId).then(result=>{
                if(result.body.code===0){
                  this.product=result.body.data;
                }
            }).catch(error=>{
                console.log(error.body.msg)
            })
        },
        addToCart(){
           this.flag=!this.flag
           this.quantity+=1;
           var productKeyInfo={id:this.product.product_id,quantity:this.quantity,price:this.product.discount_price,selected:true}
           this.$store.commit('addToCart',productKeyInfo); 
        },
        beforeEnter(el){
         el.style.transform="translate(0,0)";
        },
         enter(el,done){
          el.offsetWidth;
          el.style.transform="translate(-80px,0)";
          el.style.transition="all 0.5s cubic-bezier(.05,.99,0,1.03)";
          done();
        },
        afterEnter(el){
          this.flag=!this.flag;
          
        },
        
     },
    
}
</script>


<style lang="scss" scoped>
.container{
   margin: 0;
   padding: 0;
}
.ball{
    width: 16px;
    height: 16px;
    border-radius: 50%;
    background-color: red;
    position: absolute;
    left: 15px;
    bottom: 30px;
    
}
.text{
    margin-left: 15px;
}
.picture{
    margin: 0;
    padding: 0;
    width: 440px;
    height: 300px;
    margin-left: 8px;

}
.price{
    font-size: 10px;
    font-weight: bold;
    color: red; 
}
.num{
    font-size: 25px;
    font-weight: bold;
    color: red;
}

.description{
    overflow: auto;
    margin-left: 15px;
}

.extra-msg{
  color: red;
  font-size: 5px;
  margin-left: 15px;
  font-weight: bold;
}
.bottom-main{
    display: flex;
    flex-direction: row;
    flex-wrap: nowrap;
    justify-content: space-between;
    position: fixed;
    bottom: 0px;
    left: 0px;  
    background-color: white; 
    width: 440px;
    z-index: 99;
    
}


.service{
   display: flex;
   flex-direction: column;
   margin:6px 15px;
   position: relative;
}
.circle{
    width: 16px;
    height: 16px;
    border-radius: 50%;
    
    position: absolute;
    bottom: 32px;
    right: 17px;
    color: red;
    border: 1px solid red;
    text-align: center;
    font-size: 3px;
    


}
.first{
    margin-left: 15px;
}

.btn{
    margin: 3px 10px;
    width: 96px;
    height: 45px;
}
h5{
    margin-left: 15px;
    font-weight: bold;
    border-left: 10px;
}



</style>