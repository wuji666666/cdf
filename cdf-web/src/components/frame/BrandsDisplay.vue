<template>
<div>

<h5>{{brandname}}</h5>
<subsearchline v-bind:parentmsg="brandname"></subsearchline>
</div>
</template>


<script>
 import subsearchline from '../commonComponents/SubSearchLine.vue'
export default {
      data() {
        return {
            brandname:this.$route.params.brandname,
        }
    },
    mounted() {
       
    },
    methods: {
        
    },
   components:{
       subsearchline:subsearchline,
   }
   
    
}
</script>

<style lang="scss">
h5{
    margin-left: 15px;
}

</style>