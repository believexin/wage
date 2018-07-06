<template>
  <div id="home">
    <el-container>
      <el-header><Hader/></el-header>
    
    <el-main><router-view/></el-main>
  </el-container>
    
  </div>
</template>

<script>
import Hader from './hader'
export default {
  name: 'Home',
  data(){
    return{
      
    }
    
  },
  components:{
    Hader
  },
  methods:{
    getCookie: function(objName) {//获取指定名称的cookie的值
      var arrStr = document.cookie.split("; ");
      for (var i = 0; i < arrStr.length; i++) {
          var temp = arrStr[i].split("=");
          if (temp[0] == objName) 
          return unescape(temp[1]);
      }
      return "";
    }
  },
  mounted(){
    this.$nextTick(function() {
        var username = this.getCookie("username");
        debugger
        if(username == undefined){
          this.$axios.get(this.HOST + "/helloRedirect2?name=login");
        }
      })
  }
}
</script>

<style>
html,body{
  margin:0;
  padding:0;
  height: 100%;
/*  background: #011219;
  color: #606266;*/
}
ul,li{
  list-style: none;
  margin: 0;
}
#home{
  height: 100%;
}
.el-header{
    background: #000;
    height: 50px!important;
    color: #909399;
    line-height: 50px;
    font-size: 22px;
    padding-left: 10px;
}
.el-main{
  padding: 5px 10px;
}
.el-container{
  height: 100%;
}
.el-main{
  height: calc(100% - 50px);
}
.el-select-dropdown{
/*  background-color: #011219!important;
  border-color: #606266;*/
}
.popper__arrow:after{
  top: 0px!important;
  /*border-bottom-color: #827f7f!important;*/
}
</style>
