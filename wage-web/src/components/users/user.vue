<template>
  <div class="user">
  <el-row>
    <el-col :span="6">
      <h4>组织机构</h4>
     <div class="grid-content bg-purple-dark organ"><Organ @parentEvent="userMsg"/></div>
    </el-col>
    <el-col :span="8">
      <h4>用户详情</h4>
      <div class="grid-content bg-purple-dark"><UserMsg :data="userInfo"/></div>
    </el-col>
    <el-col :span="10">
      <h4>用户工资分析</h4>
      <div class="grid-content bg-purple-dark"><UserEchart :data="userInfo" ref="userEchart"/></div>
    </el-col>
  </el-row>
  </div>
</template>

<script>
import Organ from './organ'
import UserMsg from './userMsg'
import UserEchart from './userEchart'
export default {
  name: 'user',
  data () {
    return {
      userInfo:{

      }
    }
  },
  components:{
    Organ,
    UserMsg,
    UserEchart
  },
  methods:{
    userMsg(data){
      this.userInfo = data;
      this.$refs.userEchart.exchangeCharts(data.cId)
    }
  }
}
</script>
<style scoped>
.user{
  height: 100%;
}
.grid-content {
 padding:5px;
}
h4{
  margin: 5px 10px 2px;
}
.organ{
  height: 100%;
}
.el-row{
  height: 100%;
}
</style>
