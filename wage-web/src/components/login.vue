<template>
	<div class="warp">
		<!-- 登陆界面主体开始 -->
		<div id="main">
			<!-- 头像区开始-->
			<div id="header-border">
				<!-- 头像内部开始-->
				<div id="header-pic">

				</div>
				<!-- 头像区内部结束-->

			</div>
			<!-- 头像区结束-->
			<!-- 账号密码区开始-->

				<form action="" >
				<div id="account">
					<div class="input" >
						<input type="text" id="userName" name="userName" placeholder="place input username" v-model="username"/>
					</div>
					<div class="input">
						<input type="password" id="userPwd" name="userPwd" placeholder="place input password" v-model="password"/>
					</div>
				</div>
					<input @click="login" type="button" value="Sign In" class="login-btn" />
				</form>
			<!-- 账号密码区结束-->
			<!-- 登录区的底部开始-->
			<div id="footer">
				<span style="color:#898972">洁润有限公司工资管理信息系统</span>
			</div>
			<!-- 登陆区的底部结束-->
		</div>
		<!-- 登陆界面主体结束 -->
	</div>
</template>
<script>
export default {
  name: 'login',
  data(){
    return{
      username:'',
      password:''
    }
    
  },
  methods:{
    login:function(){
    	debugger
    	var pamats = {
			username:this.username,
			password:this.password
		}

		this.$axios.post(this.HOST + "/login?username="+ this.username + "&password=" +  this.password)
        .then(res => {
        	debugger
          if(res.data == 'missing'){
				alert("用户名不存在");
			}else if(res.data == 'failure'){
				alert("密码错误");
			}else{
				/*document.cookie="username="+$('#userName').val();*/
				this.$router.push({path:'/home/wage'});
				sessionStorage.setItem("loginid", this.username);
			}
        })
        .catch(error => {
          console.log(error);
        })
    }
  }
}
</script>
<style scoped>
/*统一设置*/
* {
    margin: 0;
    padding: 0;
}

/*背景图片*/
.warp {
	width: 100%;
	height: 100%;
    background: url("../assets/main_bg2.jpg") no-repeat;
    background-size: cover;
}

/*登陆主体容器*/
#main {
    width: 350px;
    height: 600px;
    background:rgba(0,0,0,0.5);
    margin: 40px auto;
    border-top: 8px solid #00cccc;
    position: relative;
}

/*头像区*/
#header-border {
    width: 198px;
    height: 198px;
    margin: 50px auto;
    border-radius: 50%;
    position: relative;
}

/*头像区内部*/
#header-pic {
    width: 184px;
    height: 184px;
    border-radius: 50%;
    background: url("../assets/liudehua.jpg") no-repeat;
    background-size: cover;
    position: absolute;
    left: 7px;
    top: 7px;
}

/*账号密码区*/
#account {
    width: 75%;
    padding: 5px;
    margin: 0 auto;
    border-radius: 8px;
}

#account .input {
    height: 45px;
    line-height: 45px;
}

#account .input input {
    width: calc(100% - 10px);
    height: 40px;
    border: none;
    outline: none;
    color: #00cccc;
    font-size: 16px;
    padding: 0 5px;
    background: rgba(0,0,0,0.5);
}

/*登陆按钮*/
.login-btn {
    display: block;
    width: 75%;
    height: 40px;
    margin: 30px auto;
    border: none;
    outline: none;
    background: -webkit-linear-gradient(top,#00cccc,#00b0b0);
    /*background: -moz-linear-gradient(top,#00cccc,#00b0b0);*/
    color: #ffffff;
    cursor: pointer;
}

.login-btn:active {
    position: relative;
    top: 2px;
}

/*登陆区底部*/
#footer {
    width: 100%;
    line-height: 50px;
    text-align: center;
    border-top: 1px solid #cccccc;
    position: absolute;
    bottom: 0px;
}

#footer a {
    color: #898989;
    text-decoration: none;
}
</style>