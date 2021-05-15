<template>
<div class="container">
    <h4 class="header">cdf会员购</h4>
    <div class="chart-area">

    </div>
    <div class="chart">
      <input  class="information" type="text" @mousedown="saying" v-model="msg"/> 
      <i class="bi bi-emoji-laughing"  style="font-size: 2rem; color: cornflowerblue;"></i>
      <i class="bi bi-plus-circle " v-show="flag" style="font-size: 2rem; color: cornflowerblue;"></i>
      <button class="btn btn-info " v-show="!flag" > 发送</button>
    </div>

</div>


    
</template>


<script>
export default {
  data() {
    return {
      msg:"",
      flag:true,
    }
  },
  mounted() {
   

  
  },
  methods: {
    saying(){
     if(this.msg.length==0||this.msg==""){
        this.flag=!this.flag
        
        console.log(this.msg.length)
     }else{
       this.flag=this.flag;
       console.log(this.msg)
     }
    }
    
  },

    
}
</script>


<style lang="scss" scoped>
.container{
  margin: 0;
  padding: 0;
}
.chart{
  display: flex;
  flex-direction: row;
  flex-wrap: nowrap;
  line-height: 30px;
  text-align: center;
  margin-left: 6px;
  position: fixed;
  bottom: 0px;
  left: 15px;
 
}

.information{
  width: 350px;
  height: 30px;
  margin-right: 6px;
}
i{
  margin:auto 8px;
  margin-bottom: 14px;
}

.header{
  text-align: center;
  position: fixed;
  top: 0px;
  left: 200px;
}
.btn, .btn-info{
 width: 45px;
 height: 30px;
 padding: 0;
 margin: 0;
 font-size: 6px;
}



</style>