<template>
  <div class="container">
    <subselectall ></subselectall>
  </div>


    
</template>

<script>
 import subselectall from "../commonComponents/SubSelectAll.vue"
export default {
    data() {
        return {
            
        }
    },
    methods: {
       mounted() {
          
       },
        
    },
    components:{
        "subselectall":subselectall,
    }
   
    
}
</script>

<style lang="scss">
.container{
    margin: 0;
    padding: 0;
}

</style>