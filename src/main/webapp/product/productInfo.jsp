<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
	String path = request.getContextPath();//
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="<%=basePath%>bootstrap-3.3.7-dist/css/bootstrap.min.css" />
<script type="text/javascript" src="<%=basePath%>scripts/jquery-3.3.1.js"></script>
<title>商品详情</title>
		<script type="text/javascript">
			$(document).ready(function() {
				//加的效果
				//加的效果
				$(".add").click(function() {
					var n = $(this).prev().val();
					var num = parseInt(n) + 1;
					var price1=$(".price").text();
					var price2=parseFloat(price1);
					if(num == 0) {
						return;
					}
					var allPrice=price2*num;
					$(this).prev().val(num);
					$(".totalPrice").val(allPrice);
				});
				//减的效果
				$(".jian").click(function() {
					var n = $(this).next().val();
					var num = parseInt(n) - 1;
					var price1=$(".price").text();
					var price2=parseFloat(price1);
					var allPrice=$(".totalPrice").val();
					if(num == 0) {
						return
					}
					var totalPrice=allPrice-price1;
					$(this).next().val(num);
					$(".totalPrice").val(totalPrice);
				});
			}) 
		</script>
		<style>
			body {
				background: white;
			}
			
			.header1 {
				height: 120px;
				width: auto;
				background-image: url(<%=basePath%>images/shop_head.jpg);
				/* background-repeat:no-repeat; */
				background-repeat:no-repeat;
				margin-left: 150px;
			}
			
			.container {
				margin-top: 50px;
				height: auto;
				width: 800px;
				background: white;
				overflow: auto;
			}
			
			.productImg {
				width: 300px;
				float: left;
				margin-top: 50px;
				background: white;
				height: 300px;
			}
			
			.productInfo {
				width: 60%;
				float: right;
				margin-top: 50px;
				background: white;
				height: 400px;
			}
			
			
			.gw_num {
				border: 1px solid #dbdbdb;
				width: 110px;
				line-height: 26px;
				overflow: hidden;
			}
			
			.gw_num em {
				display: block;
				height: 26px;
				width: 26px;
				float: left;
				color: #7A7979;
				border-right: 1px solid #dbdbdb;
				text-align: center;
				cursor: pointer;
			}
			
			.gw_num .num {
				display: block;
				float: left;
				text-align: center;
				width: 52px;
				font-style: normal;
				font-size: 14px;
				line-height: 24px;
				border: 0;
			}
			
			.gw_num em.add {
				float: right;
				border-right: 0;
				border-left: 1px solid #dbdbdb;
			}
			.pic{
				width: 500px;
				height: 500px;
				margin-left: 100px;
				background: red;
			}
		</style>
	</head>

	<body>
		<div class="header1" >
			
		</div>
		<div class="container">
			<div class="productImg">
				<img src="${onePic.path}" class="img-circle"/>
			</div>

			<div class="productInfo">
				<form action="<%=basePath%>shop/insterOneProductToCart" method="post">
				<input type="hidden" name="pId" value="${shop.pId}"/>
				<input type="hidden" name="userId" value="1"/>
					<div class="form-group">
						<label>商品描述</label>
						<h3>${shop.pContent}</h3>
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">商品价格</label>
						<h3 class="price">${shop.pPrice}</h3>
						<input type="hidden" name="totalPrice" value="5.00" class="totalPrice" />
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">商品个数</label>
						<div class="gw_num">
							<em class="jian">-</em>
							<input type="text" value="1" name="cartNum" class="num" />
							<em class="add">+</em>
						</div><br />
						<div class="form-group">
						<button type="submit" class="btn btn-default">加入购物车</button>
						</div>
						
				</form>
				</div>
			</div>
			<!-- 商品详情图片 -->
		<div>
			<c:forEach items="${pics}" var="x">
			<img class="pic" src="${x.path}"/>
				<div>
					<h3>————————————————————————————————————————————————————</h3>
				</div>
			</c:forEach>
	
		</div>
      
</body>

</html>