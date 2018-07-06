<template>
	<div>
      <div class="app-title" :class="appclass">{{ appname }}</div>
      <ul class="ul-nav" >
          <li v-for="(item,index) in links" :class="item.linkClass" v-on:click="activeExchange(index)" v-show="item.isShow"><router-link :to="item.linkPath" >{{ item.linkTitle }}</router-link></li>
      </ul>
      <ul class="ul-user">
        <li class="app-time"><span>日期：{{ getNowFormatDate() }}</span></li>
        <li class="fgx"><span> | </span></li>
        <li>欢迎：<span>{{ username }}</span></li>
        <li class="fgx"><span> | </span></li>
        <li class="exit" @click="logout"><span>退出</span></li>
      </ul>
    </div>
</template>
<script>
export default {
	name:'hader',
	data(){
		return{
			appname:"洁润有限公司工资管理信息系统",
			appclass:"appname",
			  links:[
			    {
			      linkClass:'active',
			      linkPath:'/home/wage',
			      linkTitle:'首页',
			      isShow:false
			    },
			    {
			      linkClass:'',
			      linkPath:'/home/user',
			      linkTitle:'员工信息',
			      isShow:false
			    },
			    {
			      linkClass:'',
			      linkPath:'/home/issue',
			      linkTitle:'工资发放',
			      isShow:false
			    },
			    {
			      linkClass:'/manager',
			      linkPath:'/home/manager',
			      linkTitle:'后台管理',
			      isShow:false
			    }
			],
			username:''
		}
	},
	methods:{
	    getNowFormatDate:function(data){
	      var date = new Date();
	      var sep1 = '-';
	      var sep2 = ':';
	      var month = date.getMonth() + 1;
	      var strDate = date.getDate();
	      if(month >= 1 && month <= 9){
	        month = '0' + month;
	      }
	      if(strDate >= 1 && strDate <= 9){
	        strDate = '0' + strDate;
	      }
	      var currentdate = date.getFullYear() + sep1 + month + sep1 + strDate;
	      return currentdate;
	    },
	    activeExchange:function(data){
	      for(let i = 0;i < this.links.length;i ++){
	        this.links[i].linkClass = '';
	      }
	      this.links[data].linkClass = 'active';
	    },
	    logout:function(){
	    	this.$axios.get(this.HOST + "/logout");
	    	this.$router.push({path:'/'});
	    }
	    
	},
	mounted(){
		this.$nextTick(function() {
	      for(let i = 0;i < this.links.length;i ++){
	      	if(this.$route.path === this.links[i].linkPath){
				this.links[i].linkClass = 'active';
	      	} else {
	      		this.links[i].linkClass = '';
	      	}
	      }
	      var loginid = sessionStorage.getItem("loginid");
	      this.$axios.get(this.HOST + "/getUserName?loginid="+ loginid)
          .then(res => {
            this.username = res.data;
          })
          .catch(error => {
            console.log(error);
          });
          // 权限
          this.$axios.get(this.HOST + "/getUserRightsByloginid?loginid="+ loginid)
          .then(res => {
          	var rights = res.data;
          	for(var i = 0;i < rights.length;i ++){
          		if(rights[i] == 'sy'){
          			this.links[0].isShow = true;
          		}
          		if(rights[i] == 'usermsg'){
          			this.links[1].isShow = true;
          		}
          		if(rights[i] == 'wage'){
          			this.links[2].isShow = true;
          		}
          		if(rights[i] == 'manager'){
          			this.links[3].isShow = true;
          		}
          	}
          	if(!this.links[0].isShow){
          		this.$router.push({path:'/home/user'});
          		if(!this.links[1].isShow){
          			this.$router.push({path:'/home/issue'});
          			if(!this.links[2].isShow){
	          			this.$router.push({path:'/home/manager'});
	          			if(!this.links[3].isShow){
		          			this.$router.push({path:'/home/403'});
		          		}
	          		}
          		}
          	}
          })
          .catch(error => {
            console.log(error);
          })
	  	})
	}
}
</script>
<style>

.app-title{
  height: 50px;
  float: left;
  color: #909399;
  font-size: 24px;
  font-family: cursive;
  line-height: 50px;
  padding: 0 0 0 14px;
}
.exit{
  float: right;
  font-size: 12px;
    
  margin: 0 20px 0 0;
    line-height: 50px;
    cursor: pointer;
    padding-left: 16px;
    background: url(../assets/exit.png) no-repeat left center;
}
.ul-user{
    overflow: hidden;
    float: right;
    font-size: 14px;
}
li{
  float: left;
  line-height: 50px;
}
.fgx{
  padding:0 10px 0 10px;
  font-size: 10px;
}
.ul-nav{
  float: left;
  height: 30px
}
.ul-nav li{
  margin-right: 10px;
  cursor: pointer;
  border-bottom:1px solid #000000;
  line-height: 28px;
  margin-top: 20px;
  width:90px;
  text-align: center;
}
.ul-nav li:hover{
  border-bottom:1px solid #FFEEB8;
}
.ul-nav .active{
  border-bottom:1px solid #FFEEB8;
}
.ul-nav li a{
  display: block;
  color: #909399;
  text-decoration: none;
  font-family: cursive;
  font-size: 18px;
}
</style>