<template>
<div>
    
    <subsearchresult v-bind:parentmsg="msg"></subsearchresult>
</div>
</template>


<script>
import subsearchresult from '../commonComponents/SubSearchResult.vue'

export default {
  
    data() {
        return {
            msg:{content:"木林",title:"皮包专区"}
        }
    }, 
    
    methods: {    
    },
    components:{
        "subsearchresult":subsearchresult,
    }

    
}
</script>

<style lang="scss">

</style>