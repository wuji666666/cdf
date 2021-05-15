<template>
  <div id="container">
     <h5 >美肤活动周</h5>
     <div  class="png">
          <p class="one">美肤活动周</p>
          <p class="two">共计{{12}}件商品</p>
     </div>

     <div class="discount">
          <p class="precious">美丽时刻</p>
          <p class="fromnow">限时8.8折起</p>
     </div>
      
     <div class="endinfo">
          <p  class="end">距离 美夫活动周 结束还剩{{perid}}天</p>
          <p  class="moment">2021-04-15 17:20------2021-4-21 23:59</p>
     </div>
     
     <subsearchtwo @func="getMsg" v-bind:parentmsg="msg"></subsearchtwo>
 

     
  </div>

</template>

</template>



<script>
import subsearchtwo from '../commonComponents/SubSearchTwoLi.vue'
export default {
    data() {
         return {
              perid:"",
              productList:[], 
              num:0,
              msg:"美肤",
         }
    },
    mounted() {
         this.calculatePerid();
         this. getMsg();
    },
    methods: {
         calculatePerid(){
             var date=new Date();
            var now= date.getDate();
            this.perid=21-now+1
            if(this.perid<=0){
                 this.perid=0;
            }    
         },
        getMsg(msg){
              this.productList=msg;        
             
         }
    },
    components:{
        "subsearchtwo":subsearchtwo,
    }
}



</script>


<style lang="less" scoped>
    

     h5{
          font-weight: bold;
          margin-left: 17px;
     }
     .png{
          width: 100%;
          height: 82px;
          background-image: url("../../images/p4.png");
         
       
       .one{
             color: black;
             font-size: 6px;
             font-weight: bold;
              margin-left: 10px;
        }
         .two{
             color: black;
             font-weight: bold;
             margin-left: 10px; 
        }

     }
   

      .precious{
              margin-top: 6px;
              margin-left: 10px;
              font-size: 10px;
              font-weight: bold;
         }

     .fromnow{
              margin-left: 10px;
              font-size: 6px;
         }  

        .end{
               font-size: 10px;
               width: 100%;
               text-align: center;
          }
          .moment{
                    font-size: 6px;
                    width: 100%;
                    background-color: blanchedalmond;
                    text-align: center;
          }

</style>