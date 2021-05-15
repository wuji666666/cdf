<template>
<div>
  <sr v-bind:parentmsg="msg"></sr>
</div>
</template>


<script>
import sr from '../commonComponents/SubSearchResult.vue'
export default{
    data(){
        return{
            msg:{content:"",title:"搜 索"}
        }
    },
    methods: {
        
    },
    components:{
        "sr":sr
    }
}

</script>


<style lang="less" scoped>

</style>