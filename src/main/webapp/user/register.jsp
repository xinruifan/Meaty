<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8" />
		<link rel="stylesheet" href="<%=basePath %>css/register.css" media="screen" type="text/css" />
		<title>注册</title>
		<script type="text/javascript" src="<%=basePath %>scripts/jquery-3.3.1.js" ></script>
		<script>
			$(document).ready(function () {
				$('#submit').click(function () {
					
					var userName=document.getElementById("userName").value;
					var userPassword=document.getElementById("userPassword").value;
					var repassword=document.getElementById("repassword").value;
					var userAddress=document.getElementById("userAddress").value;
					var userNum=document.getElementById("userNum").value;
					var data={"userName":userName,"userPassword":userPassword,"repassword":repassword,"userAddress":userAddress,"userNum":userNum}
					var url="<%=basePath%>user/register";
					$.ajax({
						type:"POST",
						url:"register",
						data:data,
						success:function(result){
							if(result==1){
								window.location.href = "<%=basePath%>shop/selectAll";
							}else if(result==2){
								$("#msg").show();
								$("#msg").html("<font color='red'>两次密码输入不相同</font>");
								$("#repassword").val("");
									
							}else if(result==3){
								$("#msg").show();
								$("#msg").html("<font color='red'>账号输入有误或已存在此账户</font>");
								$("#userNum").val("");
									
							}else{
								$("#msg").show();
								$("#userPassWord").val("");
								$("#userName").val("");
								$("#repassword").val("");
								$("#userAddress").val("");
								$("#userNum").val("");
							}
							
						}
					});
					return false;
				});
			});
			
		</script>
		<style>
		.msg{
		display : none
		}
		</style>
	</head>
	<body>
	<form  action="<%=basePath %>user/regiter" method="post">
		<div style="text-align: center;margin-bottom:20px"><span>注册</span></div>
		<div id="msg" class="msg"><font color="red">用户名已存在</font></div>
		<input type="text" id="userNum" name="userNum" placeholder="用户账号/电话号码">
		<input type="text" id="userName" name="userName" placeholder="用户名"/>
		<input type="password" id="userPassword" name="userPassword" placeholder="密码"/>
		<input type="password" id="repassword" name="repassword" placeholder="重复密码"/>
		<input type="text"  id="userAddress" name="userAddress" placeholder="用户地址"/>
		<input type="submit" id="submit" value="注册"  class="btn"/>
	</form> 
			
	</body>
</html>