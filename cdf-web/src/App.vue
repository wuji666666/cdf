<template>
    <div  id="app-container">
       <!--主体部分-->
       <!--查询区-->
      <a class="glyphicon glyphicon-chevron-left" href="#"   @click.prevent="goBack"></a>
       <router-view></router-view>
     
       



        <!--不变底部区域-->
      
    </div>
 
</template>

<script>

export default{
   data:{
     return:{

     },

   },
   methods: {
     goBack(){
       this.$router.go(-1)
     }
   },
  
}



</script>

<style lang="scss" scoped>

.glyphicon-chevron-left{
  position: absolute;
  left: 2px;
  top: 10px;
  margin-right: 4px;
}


</style>


