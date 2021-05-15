<template>
<div>
    <div>
        <h5>搜索</h5>
        <div class="mui-input-row mui-search  ">
           
	         <input type="search" class="mui-input-clear search-goods" placeholder="搜索店铺内的商品" v-model="content"/> 
             <router-link :to=this.urls  class="cancel" value="搜索" @click.native="searchgoods"> 搜索</router-link>
        </div>
    </div>

    <div>
        <h4>最近搜索</h4>
        <span>
             <button class="btn btn-default">兰蔻</button>
             <button class="btn btn-default">雅诗兰黛</button>
        </span>
    </div>


     <div>
        <h4>热门搜索</h4>
        <span v-for="(item,i) in productList" :key="i">
            <router-link :to="'/shopmall/searchgoods/searchresult/'+item.product_name"     class="btn btn-default">{{item.product_name}} </router-link>  
        </span>
    </div>

</div>
</template>


<script>
export default{
    data() {
        return {
            content:"",  
            urls:"",
            productList:[]
        }
    },
    mounted(){
           this.performTitle();
    },
    methods: {
        searchgoods(){
            if(this.content=="" ||this.content.length==0){
                this.urls="searchgoods";
            }else{
            this.urls="searchgoods/searchresult/"+this.content
            }
        },
       
        performTitle(){
            this.$http.get("http://localhost:8080/cdf/buyer/search/by/page/group/desc").then(result=>{
              if(result.body.code===0){
                 this.productList=result.body.data;
              }
            }).catch(error=>{
                console.log(error.body.msg);
               
            })
        }
    },
}

</script>


<style lang="less" scoped>

 h5{
        margin-left: 15px;
    }
.mui-placeholder{
   
   
    .mui-icon mui-icon-search{
            position: absolute;
            left: 3px;
            top: 2px;

    }
    
}

.mui-search,
.mui-placeholder{
      width:250px;
      margin-left: 4px;
     
  }
.cancel{
      width:60px;
      height: 34px;
      position: fixed;
      top:40px;
      right:75px;
      background-color:palegreen;
      text-align: center;
      padding-top: 6px;
      
  }
    
.btn{
    width:109px;
    height:32px;
    margin-left: 8px;
    margin-bottom: 15px;
}
h4{
    margin-left: 2px;
}
* {
    touch-action: pan-y;
}
</style>