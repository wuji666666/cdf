<template>

    <div class="container">
	  <router-link to="/shopmall" class="show rank">
		<i class="bi bi-shop"  style="font-size: 3rem; color: cornflowerblue;"></i><br/>
		<span>商城</span>
	  </router-link>
	  <router-link   to="/classification"            class="show ">
		<i class="bi bi-grid"    style="font-size: 3rem; color: cornflowerblue;"></i><br/>
		<span>分类</span>
	  </router-link>		

      <router-link   to="/allgoods"            class="show">
		<i class="bi bi-layers"    style="font-size: 3rem; color: cornflowerblue;"></i><br/>
		<span>全部商品</span>
	  </router-link>

	  <router-link   to="/shopcart"           class="show">
		<i class="bi bi-cart"   style="font-size: 3rem; color: cornflowerblue;"></i><br/>
		<span>购物车</span>
		<span class="ball">{{$store.getters.getAllCounts}}</span>
	  </router-link>	
	  <router-link     to="/person"             class="show">
		<i class="bi bi-person-check"    style="font-size: 3rem; color: cornflowerblue;"></i><br/>
		<span>个人中心</span>
	  </router-link>	
	</div>
    
</template>

<script>
export default {
    
}
</script>


<style lang="scss" scoped>
.container{
	display: flex;
	flex-direction: row;
	flex-wrap: nowrap;
	order: 1;
	
	position: fixed;
	bottom: 0px;
	left: 0px;
	width: 100%;
	background-color: white!important; 
	z-index: 99;
}

.ball{
	position: absolute;
	bottom: 45px;
	right: 20px;
	width: 17px;
	height: 17px;
	border-radius: 50%;
	border: 1px solid red;
	font-size: 3px;
	

}
.show{
	display: flex;
	flex-direction: column;
	text-align: center;
	padding: 8px 9px ;
	margin: 3px 9px;
	position: relative;
	
	
}
.rank{
	margin-left: 40px;
	margin-right: 20px;
}


</style>