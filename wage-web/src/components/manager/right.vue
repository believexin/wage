<template>
  <div class="rights">
    <el-tree 
    ref="tree"
    :data="data2"
    show-checkbox
    node-key="id"
    :default-expanded-keys="[2, 3]"
    :default-checked-keys="[5]"
    :props="defaultProps">
  </el-tree>
  <el-row>
      <el-col :span="24"><el-button type="primary" v-show="isEdit" class="save-btn" @click="saveRight">保存</el-button></el-col>
      </el-row>
  </div>
</template>

<script>
export default {
  name: 'rights',
  data () {
    return {
      data2: [],
      defaultProps: {
        children: 'children',
        label: 'label'
      },
      isEdit:false
    }
  },
  components:{

  },
  props:{
    data:{

    }
  },
  methods:{
    saveRight:function(){
      var rights = this.getCheckedKeys();
      this.$axios.put(this.HOST +"/saveAndUpdateRight",{
        userid:this.data.cId,
        rightKeys:rights
      })
      .then(res => {
        if(res.data == true){
          this.$message({
            showClose: true,
            message: '保存成功',
            type: 'success'
          });
        }
      })
      .catch(error => {
        console.log(error);
      })
    },
    setCheckedKeys(userid) {
      this.$axios.get(this.HOST +"/userRights?userid=" + userid)
      .then(res => {
        this.$refs.tree.setCheckedKeys(res.data);
      })
      .catch(error => {
        console.log(error);
      })
      
    },
    getCheckedKeys() {
      debugger
      return this.$refs.tree.getCheckedKeys();
    }
  },
  mounted(){
    this.$nextTick(function(){
     this.$axios.get(this.HOST +"/getRights")
      .then(res => {
        this.data2 = res.data;
      })
      .catch(error => {
        console.log(error);
      });
      this.setCheckedKeys();
      var loginid = sessionStorage.getItem("loginid");
      // 权限
      this.$axios.get(this.HOST + "/getUserRightsByloginid?loginid="+ loginid)
      .then(res => {
        var rights = res.data;
        for(var i = 0;i < this.data2.length;i ++){
          this.data2[i].disabled = true;
        }
        for(var i = 0;i < rights.length;i ++){
          if(rights[i] == 'manager.update'){
            this.isEdit = true;
            for(var i = 0;i < this.data2.length;i ++){
              this.data2[i].disabled = false;
            }
          }
        }
      })
      .catch(error => {
        console.log(error);
      })
    });

    
  }
}
</script>
<style scoped>
.el-tree{
  height: 400px;
}
.save-btn{
  margin-left: 300px;
}
</style>
