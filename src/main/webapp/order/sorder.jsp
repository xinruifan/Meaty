<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();//
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	//basePath=http://localhost:8080/TEST
%>
<html>
	<head>
		<meta charset="utf-8">
		<title>订单详情</title>
		<style type="text/css">
			table{
				width: 70%;
				margin: 80px;
				margin-top: 10px;
			}
			td,th{
				width: 100px;
				height: 45px;
				overflow: hidden;
				padding: 10px;
				border-bottom: 1px solid #03A9F4;
				text-align: center;
			}
			th{
				border-bottom: 3px solid #03A9F4;
			}
			img{
				width: 60px;
				height: 60px;
			}
			button{
				width: 150px;
				height: 40px;
				background: #ff0036;
			}
			body {font-family:sans-serif;
					font-size:14px;
					}
		</style>
	</head>
	<body>
		<table border="0" cellspacing="" cellpadding="">
		<c:forEach items="${user}" var="user" begin="0" end="1" step="1">
			<tr><th style="border: 0;text-align: left;">订单号：${user.order.orderId}<br/>
			下单时间：${user.order.orderTime}</th></tr>
			<tr>
				<th>商品名称</th>
				<th>商品属性</th>
				<th>单价</th>
				<th>数量</th>
				<th>小计</th>
			</tr>
			
			<c:forEach items="${sorder}" var="sorder" varStatus="status">
				<tr>
					<td><img src="<%=basePath %>${sorder.oPicture}"></td>
					<td><span>${sorder.shop.pName}</span>
						<span>${sorder.shop.pContent}</span>
					</td>
					<td>￥${sorder.shop.pPrice}</td>
					<td>x${sorder.oNum}</td>
					<td>${sorder.oAmount}</td>
				</tr>
		
			</c:forEach>
			
			
				<tr>
					<td colspan="4" style="border: 0; text-align: left;">
						<span>收货地址：${user.userAddress}</span></br>
						<span>收件人：${user.userName}</span></br>
    					<span>收件电话：${user.userNum}</span></br>
    					
					</td>
					<th style="border: 0;font-size: 1em;">订单总额：${user.order.orderAmount}(元)</th>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>
