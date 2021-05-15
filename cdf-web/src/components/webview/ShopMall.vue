<template>
    
   <div class="container">
      <!--头部查询区-->
     <div class="first">
        <header class="mui-bar mui-bar-nav">
         
         <div class="textsize">
            <span class="mui-title">cdF会员购</span><br/>
            <p>足不出户 尊享全球奢侈品</p><br/>  
         </div>
			
         <div class="mui-input-row mui-search">
				<router-link to="/shopmall/searchgoods">
                <input type="search" class="mui-input-clear" placeholder="搜索商品">
            </router-link>    	
		  </div>
		</header>
     </div>
       <!--轮播区-->
      <div class="two">
          <autoplayvue ></autoplayvue>
      </div>
     <!--商品分类区-->
     <div   class="three">
         <circleframe></circleframe>
     </div>

<!--左右手拨滚动区-->
   <div  class="four">
        <moveleftright></moveleftright>
   </div>
   <!--用户可能喜欢区展示-->
   <div class="five">
      <evensearch></evensearch>
   </div>

   <mastercategory></mastercategory>

    


        
    
      

   </div>

</template>


<script>
import autoplayvue from '../carousel/Carousel.vue'
import circleframe from '../frame/CircleFrame.vue'
import moveleftright from '../frame/MoveLeftRight.vue'
import evensearch from '../frame/EvenSearch.vue'
import mastercategory from '../commonComponents/MasterCategory.vue'

export default{
   data() {
      return {
         
      }
   },
   methods: {
      
   },
    components: {
     'autoplayvue':autoplayvue,
     'circleframe':circleframe,
     'moveleftright':moveleftright,
     'evensearch':evensearch,
     'mastercategory':mastercategory,
     
     
     
   }
}

</script>


<style lang="scss" scoped>
.container{
  margin: 0;
  padding: 0;
  overflow: scroll;
  
  .first{
     width: 100%;
     height: 94px;
  }
  .two{
     margin: 0;
     padding: 0;
     width: 100%;
     height: 81px;
     margin-left: 0px;
  }

  .three{
     margin:0;
     padding: 0;
     width: 100%;
     height: 160px;
  }

  .four{
       margin:0;
     padding: 0;
     width: 100%;
     height: 180px;
  }
  .five{
   
     width: 100%;
     height: 1700px;
  }

   .frame{
      margin: 0;
      padding: 0;
      display: absolute;
      top:176px;
      left:0;
   }


   header{
       width:100%;
       height:94px;
       padding-left:0;
       padding-top: 0;
       background-color: red;
      
       .textsize{ 
          padding-left: 0;
          text-align: center;
          
      .mui-title{
             margin-top: 1px;
             margin-bottom: 3px;
          }
      p{
             padding-top: 12px;
             color: black;
          }

       }
       div{
          margin-left: 6px;
          margin-top: -15px;

      .mui-input-clear{
            background-color: white;
          }
       }
       
   }
}

 .mui-bar,.mui-bar-nav{
    margin-bottom: 0px;
 }

 .mui-input-rows,.mui-search{
   
    background-color: red;

 }










 






</style>