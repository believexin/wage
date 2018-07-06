<template>
  <div class="manager">
  <el-row>
    <el-col :span="8">
      <h4>组织机构</h4>
     <div class="grid-content bg-purple-dark organ"><Organ @parentEvent="userMsg"/></div>
    </el-col>
    <el-col :span="16">
      <h4>权限配置</h4>
      <div class="grid-content bg-purple-dark"><Rights :data="userInfo" ref="rights"/></div>
      
    </el-col>
  </el-row>
  </div>
</template>

<script>
import Organ from '../users/organ'
import Rights from './right'
export default {
  name: 'manager',
  data () {
    return {
      userInfo:{

      }
    }
  },
  components:{
    Organ,
    Rights,
  },
  methods:{
    userMsg(data){
      this.userInfo = data;
      this.$refs.rights.setCheckedKeys(data.cId)
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
