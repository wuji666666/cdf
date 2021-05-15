<template>
<div class="container">


<subsearchresult v-bind:parentmsg="msg"></subsearchresult>

<mastercategory></mastercategory>

</div>
    
</template>

<script>
import subsearchresult from '../commonComponents/SubSearchResult.vue';
import mastercategory from '../commonComponents/MasterCategory.vue'
export default {
    data() {
        return {
             msg:{content:"护肤品",title:"全部商品"}
        }
    },
    methods: {
        
    },
    components:{
       subsearchresult: subsearchresult,
       mastercategory: mastercategory 
    }
    
}
</script>


<style lang="less" scoped>
.container{
    margin: 0;
    padding: 0;
}

</style>