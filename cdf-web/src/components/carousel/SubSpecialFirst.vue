<template>
<div class="container">
    <h5>国家大奖酒款专场</h5>
  
    <img class="png" src="../../images/p2.png"/>
    
    <subsearchLine v-bind:parentmsg="msg"></subsearchLine>

</div>

    
</template>

<script>
import subsearchLine from '../commonComponents/SubSearchLine.vue'
export default {
    data() {
        return {
            msg:"白酒"
        }
    },
  
    methods: {
        
    },
    components:{
        "subsearchLine":subsearchLine
    }
    
}
</script>

<style lang="less" scoped>
.container{
margin: 0;
padding: 0;

h5{
    font-weight: bold;
   
    margin-left: 15px;
}

.png{
    width: 100%;   
}
}

</style>