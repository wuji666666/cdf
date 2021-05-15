<template>
    
   <div class="container">
      
      <h5> 分 类</h5>
      <div class="mui-input-row mui-search">
				<router-link to="/shopmall/searchgoods">
                <input type="search" class="mui-input-clear" placeholder="搜索商品">
            </router-link>    	
		</div>

       <div class="label-tab" >
        <div class="col-xs-4">
            <ul class="nav nav-tab vertical-tab" role="tablist" id="vtab">
                <li role="presentation" class="active"  v-for="(firstcategory,i) in firstcategorys" :key="i">
                    <a href="#tab2" aria-controls="home" role="tab"
                       data-toggle="tab"  @click="findSecondCategory(firstcategory)">{{firstcategory}}</a>
                </li>
            </ul>
        </div>
            <div class="tab-content vertical-tab-content col-xs-8" v-for="(secondcategory,i) in secondcategorys" :key="i">
                    <div role="tabpanel" class="tab-pane active" id="tab2">
                       <div class="content" >
                          <h5 ref="category">{{secondcategory}}</h5>
                           <span  class="area"  v-for="(thirdcategory,i) in thirdcategorys" :key="i">
                                <router-link  :to='"/shopmall/circledisplay/"+thirdcategory'><img src="../../images/p6.png"/></router-link>
                                <span  class="thirdcategory">{{thirdcategory}}</span>
                           </span>
                       </div>    
                   </div>
            </div>
    </div>

    <mastercategory></mastercategory>


   </div>

</template>

<script>
import '../../lib/bootstrap/bootstrap.min.js'
import mastercategory from '../commonComponents/MasterCategory.vue'
export default{
   data(){
      return{
       brandnames:[],
       firstcategorys:[],
       secondcategorys:[],
       thirdcategorys:[],
       secondcategory:"",
       
      }
   },

     mounted(){
      
       this.findFirstCategory();
      
      },
   methods:{
      findBrandName(){
       this.$http.get("http://localhost:8080/cdf/buyer/search/brandname").then(result=>{
           if(result.body.code===0){
              this.thirdcategorys=result.body.data;
           }
         }).catch(error=>{
          console.log(error.body.msg)
         })
     },
     
      findFirstCategory(){
         this.$http.get("http://localhost:8080/cdf/buyer/search/firstcategory").then(result=>{
           if(result.body.code===0){
              this.firstcategorys=result.body.data;
              this.firstcategorys.unshift("品牌");
           }
         }).catch(error=>{
          console.log(error.body.msg)
         })
      },

      findSecondCategory(firstcategory){
         this.$http.get("http://localhost:8080/cdf/buyer/search/secondcategory?firstCategory="+firstcategory).then(result=>{
           if(result.body.code===0){
              if(firstcategory=="品牌"){
               this.thirdcategorys=[];
               this.secondcategorys=[];
               this.secondcategorys.unshift("品牌展示");
               this.findBrandName();
               return;
              }
           }
            var arr=[];
             if(result.body.code===0){
                this.secondcategorys=result.body.data;
               // this.secondcategorys=[]
                this.secondcategorys.forEach(result=>{
                this.findThirdCategory(result);
               })    
           }
         }).catch(error=>{
          console.log(error.body.msg)
         }) 
      },
         
      findThirdCategory(secondcategory){
         this.$http.get("http://localhost:8080/cdf/buyer/search/thirdcategory?secondCategory="+secondcategory).then(result=>{
              if(result.body.code===0){
              if(secondcategory=="品牌展示"){
               this.findBrandName();
               return;
              }
           }
              if(result.body.code===0){  
                 this.thirdcategorys=result.body.data;

              }
         }).catch(error=>{
            console.log(error.body.msg);
         })
      } 
   },
   components:{
      "mastercategory":mastercategory 
   }
 



}


</script>


<style lang="scss" scoped>
.container{
  margin: 0;
  padding: 0;
   h5{
      margin-left: 15px;
   }
   .label-tab{
      margin: 0;
      padding: 0;

      .col-xs-4{
         margin: 0;
         padding: 0;
      }
   }
 
   
}



.picture{
   width: 25px;
   height: 30px;
}
.secondcategory{
   font-weight: bold;
}
h5{
   font-weight: bold;
}

img{
   display: inline;
   width: 15px;
   height: 20px;
}

.thirdcategory{
   display: inline;
   font-size: 9px;
}
.area{
   display: flex;
   flex-direction: column;
   width: 80px;
   height: auto;
   margin: 3px 0;
   padding: 0;
   display:inline-flex;
   text-align: center;
   

}
</style>