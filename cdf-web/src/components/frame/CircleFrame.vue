<template>

<div class="container" >
      <div       class="area" v-for="(title,i) in titles" :key="i"> 
            <router-link   :to='"/shopmall/circledisplay/"+title'       class="circle"></router-link>
            <p   class="goodname">{{title}}</p>
      </div>

</div>
    
</template>


<script>
export default {
  data() {
    return {
     
      titles:["护肤品","彩妆","香喷","国产酒","进口酒","精品","百货","新品上架"],
    }
  },
  methods: {
    mounted() {
  
    },
    
  },
}
</script>



<style lang="less" scoped>
     .container{
        margin: 0;
        padding: 0;
        margin-top: 4px;
     }

     
        .circle{
            width: 45px;
            height: 45px;
            border-radius: 50%;
            display: flex;
            flex-direction: column;
            background-image: url("../../images/p10.png");
            
        }
        .container{
            display: flex;
            flex-direction: row;
            flex-wrap: wrap;
            align-content: space-between;
            margin:4px 4px;
        }
        .area{
            margin: 5px 33px;
        }

        .goodname{
          text-align: center;
        }
</style>