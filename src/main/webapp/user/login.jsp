<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8" />
		<link rel="stylesheet" href="<%=basePath %>css/login.css" media="screen" type="text/css" />
		<title>登陆</title>
		<script type="text/javascript"  src="<%=basePath %>scripts/jquery-3.3.1.js" ></script>
		<script type="text/javascript">	
		$(document).ready(function() {
			
			$('#submit').click(function(){
				var userName = document.getElementById("userName").value;
			
				var code=$('#code').val();
				var passWord = document.getElementById("passWord").value;
				var data={"userNum":userName,"userPassword":passWord,"code":code};
				$.ajax({
					type:"POST",
					url:"login",
					data:data,
					success:function(result) {
						/* 成功进行跳转 */
					 	if(result==1){
					 		window.location.href = "<%=basePath%>shop/selectAll";
						}else if(result==0){
						//显示错误消息 0:用户不存在 2：验证码错误 3：密码错误
							$("#msg").show();
							$("#msg").html("<font color='red'>用户不存在</font>");
							$("#userPassword").val("");
							$("#userNum").val("");
						}else if(result==2){
							$("#msg").html("<font color='red'>验证码错误</font>");
							$("#msg").show();
							$("#code").val("")
							$("#image").attr("src","<%=basePath%>captcha.jpg?+Math.random()");
							
						} else if(result==3){
							$("#msg").html("<font color='red'>密码错误</font>");
							$("#msg").show();
							$("#userPassword").val("");
						}
						
					}
				});
				return false;
			});
		});
		</script>
		<style type="text/css">
		  .msg_css{
		display:none
		}  
		
		
		</style>
	</head>
	<body>	
	
	<form  action="<%=basePath %>user/login" method="post" name="login" >
		<div style="text-align: center;"><span>登录</span></div>
		<div id="msg" name="msg" class="msg_css"><font name="error" color="red">账号或密码错误</font></div><br>
		<input type="text"  id="userName" name="userNum" placeholder="用户账号"/>
		<input type="password" id="passWord" name="userPassword" placeholder="密码"/>
		<div >
		<input type="text" class="code" name="code" id="code" placeholder="验证码" width="100px">
		<img  onclick="this.src='<%=basePath%>captcha.jpg?'+Math.random()" id="image" class="img" src="<%=basePath%>captcha.jpg">
		</div>
		<input type="submit"  value="登录"  id="submit" class="btn"/>
		<a href="register.jsp">点此注册</a>
		<span style="display: block;float: right;"><a href="ResetPassword.jsp">忘记密码</a></span>
	</form> 		
	</body>
</html>