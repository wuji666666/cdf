<template>
    
   <div class="container">

      <h3>个人中心组件</h3>

       <mastercategory></mastercategory>
   

   </div>

</template>


<script>
   import mastercategory from '../commonComponents/MasterCategory.vue'
export default{
   data(){
      return{

      }
   },
   methods: {
      
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
}

</style>