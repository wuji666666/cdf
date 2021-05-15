<template>
  <div>
    <h4>品牌专区</h4> 
   <div class="swiper-container">
       <div class="swiper-wrapper"  v-for="(product,i) in productList" :key="i" >
          <router-link :to='"/shopmall/branddisplay/"+product.brand' class="swiper-slide">
              <img class ="picture" :src="product.picture"/>
              <p>{{product.brand}} </p>
          </router-link>
        </div> 
    </div>  

    </div>
    
</template>
<script>
import Swiper from '../../lib/swiper/js/swiper-bundle.min.js'
export default {
   data() {
       return {
       
        productList:[{brand:"欧莱雅",picture:"https://img14.360buyimg.com/n7/jfs/t1/178069/36/243/347270/607ff664E7cbe4cc3/1509097ff6440f92.jpg"},
                     {brand:"兰蔻",picture:"https://img13.360buyimg.com/n7/jfs/t1/181444/22/223/197840/607fdf14E004b06b7/c90b41f1c0b15177.jpg"},
                     {brand:"木林",picture:"https://img11.360buyimg.com/n7/jfs/t1/179161/16/102/450926/607ea21fEfdfd8751/3d0b73c4ea032918.jpg"},
                     {brand:"飞利浦",picture:"https://img11.360buyimg.com/n7/jfs/t1/173396/10/5641/81335/607ea7ceE5256429b/847b15b00d941714.jpg"},
                     {brand:"帮宝舒",picture:"https://img12.360buyimg.com/n7/jfs/t1/171669/29/5890/190311/607fec00E1f0d3903/e956cc01eadc197e.jpg"},
                     {brand:"茅台",picture: "https://img13.360buyimg.com/n7/jfs/t1/97097/12/15694/245806/5e7373e6Ec4d1b0ac/9d8c13728cc2544d.jpg"},
                    ]

       }


   },
    mounted() {
         var swiper = new Swiper('.swiper-container', {
          slidesPerView: 3,
          spaceBetween: 30, 
        });
    },
  
}
</script>

<style lang="scss" scoped>

        .swiper-container {
          margin: 0;
          padding: 0;
          width: 100%;
          height: 180px ;       
          display:flex;
          flex-direction: row;
        }
       p{
           margin: 0;
           padding: 0;
       }
        .picture{
            width: 120px;
            height: 150px;
            margin: 0; 
            padding: 0; 
        }


        .swiper-slide {
        margin: 0;
        padding: 0;
      
      display: flex;
    
      justify-content: center;
      flex-wrap: wrap;
    
      align-items: center;
}
h5{
   
    font-weight: bold;
}


</style>