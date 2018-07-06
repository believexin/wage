<template>
  <el-carousel>
    <el-carousel-item v-for="item in 4" :key="item" class="">
      
    </el-carousel-item>
  </el-carousel>
</template>
<script>
export default {
  name: 'swiper',
  data () {
    return {
      
    }
  }
}
</script>
<style>
  
  .el-carousel__item:nth-of-type(1) {
    background: url(../assets/banner02.jpg) no-repeat;
    background-size: 100% 100%;
  }
  
  .el-carousel__item:nth-of-type(2) {
    background: url(../assets/banner03.jpg) no-repeat;
    background-size: 100% 100%;
  }
  .el-carousel__item:nth-of-type(3) {
    background: url(../assets/banner04.jpg) no-repeat;
    background-size: 100% 100%;
  }
  .el-carousel__item:nth-of-type(4) {
    background: url(../assets/banner05.jpg) no-repeat;
    background-size: 100% 100%;
  }
  .el-carousel__container{
    height: 200px;
  }
</style>