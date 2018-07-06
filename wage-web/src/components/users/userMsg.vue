<template>
  <div class="userMsg">
   <el-form :label-position="labelPosition" label-width="80px" :model="formLabelAlign">
    <el-form-item label="名称" v-show="data.cName" size="small">
      <el-input v-model="data.cName" :disabled="!isEdit"  label-width="100px"></el-input>
    </el-form-item>
    <el-form-item label="登录名称" v-show="data.cLoginid" size="small">
      <el-input v-model="data.cLoginid" :disabled="!isEdit"></el-input>
    </el-form-item>
    <el-form-item label="单位" v-show="data.cCorp" size="small">
      <el-input v-model="data.cCorp" :disabled="!isEdit"></el-input>
    </el-form-item>
    <el-form-item label="部门" v-show="data.cDept" size="small">
      <el-input v-model="data.cDept" :disabled="!isEdit"></el-input>
    </el-form-item>
    <el-form-item label="性别" v-show="data.cXmjp != null">
      <el-radio-group v-model="data.cXmjp == 0 ? '女' : '男'" size="small">
        <el-radio label="男" name="1" :disabled="!isEdit"></el-radio>
        <el-radio label="女" name="0" :disabled="!isEdit"></el-radio>
      </el-radio-group>
    </el-form-item>
  </el-form>
  </div>
</template>

<script>
export default {
  name: 'userMsgsg',
  data () {
    return {
      userData:"",
      isEdit:false,
      labelPosition: 'right',
        formLabelAlign: {
          name: '',
          region: '',
          type: '',
          resource:''
        }
    }
  },
  props:{
    data:{

    }
  },
   mounted(){
      this.$nextTick(function() {
          this.$axios.get(this.HOST +"/getSalaryLevel")
          .then(res => {
            this.opinion = res.data.opinions;
            this.drawPie('main');
          })
          .catch(error => {
            console.log(error);
          })
      })
  }
}
</script>
<style scoped>
tr:nth-of-type(odd) {
  background: #fff
}

tr:nth-of-type(even) {
  background: #eee
}
tr>td{
  padding: 8px 10px 8px 10px;
}
.el-form-item >>> .el-input.is-disabled .el-input__inner{
/*  background-color: #011219;
  border-color: #606266;*/
}

</style>
