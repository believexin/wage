<template>
  <div class="content">
  <el-row :gutter="10">
    <el-col :span="24"><div class="grid-content bg-purple-dark"><SwiperTop/></div></el-col>
  </el-row>
  <el-row :gutter="10">
    <el-col :span="10"><div class="grid-content bg-purple-dark"><EchartsWage/></div></el-col>
    <el-col :span="14"><div class="grid-content bg-purple-dark"><EchartsWageDate/></div></el-col>
  </el-row>
  </div>
</template>

<script>
import EchartsWage from './echarts-wage'
import EchartsWageDate from './echarts-wage-date'
import SwiperTop from './swiper'
export default {
  name: 'wage',
  data () {
    return {
      
    }
  },
  components:{
  EchartsWage,
  EchartsWageDate,
  SwiperTop
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.grid-content {
 border-radius: 5px;
 padding:5px;
 box-shadow: 0 0 8px 2px rgba(111,127,144,0.3);
}
</style>
