<template>
     <div class="swiper-container">
        <div class="swiper-wrapper">
            <router-link class="swiper-slide"   to='/shopmall/thirdspecial'>
                 <img class ="picture" src="../../images/p20.png"/>
            </router-link>
         </div> 
      
         <div class="swiper-wrapper">
            <router-link class="swiper-slide"  to="/shopmall/subspecial">
                 <img class ="picture" src="../../images/p21.png"/>
            </router-link>
         </div> 

          <div class="swiper-wrapper">
            <router-link class="swiper-slide"   to="/shopmall/subspecialsecond">
                 <img class ="picture" src="../../images/p22.png"/>
            </router-link>
         </div> 

      </div>

     
       


   
</template>


<script>
import Swiper from '../../lib/swiper/js/swiper-bundle.min.js'

 
  export default{
    data() {
      return {
        
      }
    },
    mounted() {
        var swiper = new Swiper('.swiper-container', {
          slidesPerView: 3,
          spaceBetween: 30, 
        });
    },
    methods: {
      
    },

  }

</script>


<style lang="scss" scoped>


    .swiper-container {
          margin: 0;
          padding: 0;
          width: 100%;
          height: 80px ;       
          display:flex;
          flex-direction: row;
        }
       p{
           margin: 0;
           padding: 0;
       }
        .picture{
            width: 120px;
            height: 80px;
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
    
</style>