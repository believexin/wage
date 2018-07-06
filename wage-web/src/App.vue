<template>
  <div id="app">
<!--     <el-container>
      <el-header><Hader/></el-header>
    
    <el-main><router-view/></el-main>
  </el-container> -->
    <!-- <Home/> -->
    <router-view/>
  </div>
</template>

<script>
import Home from './components/home'
export default {
  name: 'App',
  data(){
    return{
      
    }
    
  },
  components:{
    Home
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
#app{
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
