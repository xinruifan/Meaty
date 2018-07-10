<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();//
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/succulentIndex.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/index.css">
<link rel="stylesheet"
	href="<%=basePath%>bootstrap-3.3.7-dist/css/bootstrap.css" />
<script type="text/javascript"
	src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
<script type="text/javascript"
	src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<title>多肉商城</title>
<style>
.secendGuide {
	float: left;
	margin-left: 400px;
	margin-top: -30px;
}

.pages {
	margin-left: 550px;
	width: 300px;
	background: white;
}

.pageContainer {
	height: 50px;
	width: auto;
	background: white;
}

.search1 {
	float: right;
	margin-right: 200px;
	margin-top: -80px;
}
</style>


</head>

<body>

	<div class="head_guide">
		<ul class="nav nav-tabs guide">
			<li role="presentation" class="active">
			<!--如果为空 显示登陆  -->
			<c:if test="${empty sessionScope.user}">
			<a href="<%=basePath%>user/login.jsp">登录</a>
			</c:if>
			<c:if test="${not empty sessionScope.user}">
			<a href="<%=basePath%>user/login.jsp">${sessionScope.user.userName}</a>
			</c:if>
			</li>
			
			<li role="presentation"><a href="user/register.jsp">我的购物车</a></li>
			<li role="presentation">
			<!--如果为空 显示登陆  -->
			<c:if test="${empty sessionScope.user}">
			<a href="<%=basePath%>user/login.jsp">我的订单</a>
			</c:if>
			<c:if test="${not empty sessionScope.user}">
			<!--设置订单请求  -->
			<a href="<%=basePath%>order/orderlist">我的订单</a>
			</c:if>
			
			
			</li>

		</ul>
	</div>
	<header> <img src="<%=basePath%>images/head.jpg"> </header>

	<div>
		<div class="secendGuide">
			<div class="row">

				<hr>

				<div class="dropdown">
					<a id="dLabel" role="button" data-toggle="dropdown"
						class="btn btn-primary" data-target="#" href="javascript:;">
						筛选 <span class="caret"></span>
					</a>

					<ul class="dropdown-menu multi-level" role="menu"
						aria-labelledby="dropdownMenu">

						<li><a href="<%=basePath%>shop/selectAll">全部</a></li>
						<li class="divider"></li>

						<li class="dropdown-submenu"><a tabindex="-1"
							href="javascript:;">种类</a>

							<ul class="dropdown-menu">
								<li><a tabindex="-1" href="<%=basePath%>shop/selectByCondition/0" >仙人掌</a></li>
								<li><a tabindex="-1" href="<%=basePath%>shop/selectByCondition/1">白色</a></li>
								<li><a tabindex="-1" href="<%=basePath%>shop/selectByCondition/2">菊花</a></li>
								<li><a tabindex="-1" href="<%=basePath%>shop/selectByCondition/3">多肉</a></li>

							</ul></li>

					</ul>

				</div>

			</div>
		</div>
		<div class="border-radius">最新肉肉</div>
		<div class="search1">
			<form class="form-inline" action="<%=basePath%>shop/selectByProduct"
				method="post">
				<div class="form-group">

					<div class="input-group">
						<input type="text" class="form-control" name="productName"
							placeholder="输入商品名">
						<div class="input-group-addon"></div>
					</div>
				</div>
				<button type="submit" class="btn btn-primary">搜索</button>
			</form>
		</div>

	</div>
	</div>
	<div class="main">
		<c:forEach items="${allShop}" var="x">
			<div class="view">
				<div>
					<a href="<%=basePath%>shop/selectOneShop/${x.pId}"><img
						src="${x.path}" alt="" class="product_img"></a>
				</div>
				<div>
					<font size="3" color="#03A9F4">价格:${x.pPrice}</font>
				</div>

			</div>
		</c:forEach>

	</div>
	<!-- 底部分页栏 -->
	<div>
		<nav aria-label="Page navigation" class="pages">
		<ul class="pagination">
			<!-- 向前翻页 -->
			<c:if test="${sessionScope.position ne 1 and pageNum >= 0}">
				<!-- 默认状态 -->
				<c:if test="${allFlag>0}">
					<li><a
						href="<%=basePath%>shop/afterPage/${sessionScope.position-1}"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					</a></li>
				</c:if>
				<!--按条件筛选状态  -->
				<c:if test="${conditionFlag>0}">
					<li><a
						href="<%=basePath%>shop/afterPageByCondition/${sessionScope.position-1}"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					</a></li>
				</c:if>
				<!--按照产品名称筛选状态  -->
				<c:if test="${productNameFlag>0}">
					<li><a
						href="<%=basePath%>shop/afterPageByProductName/${sessionScope.position-1}"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					</a></li>

				</c:if>
			</c:if>

			<c:forEach begin="1" end="${pageNum}" var="x">
				<!-- 默认状态 -->

				<c:if test="${allFlag>0}">

					<li><a href="<%=basePath%>shop/afterPage/${x}">${x}</a></li>
				</c:if>
				<!-- 按照条件查询状态 -->
				<c:if test="${conditionFlag>0}">
					<li><a href="<%=basePath%>shop/afterPageByCondition/${x}">${x}</a>
					</li>
				</c:if>
				<!-- 按照商品名称查询状态 -->
				<c:if test="${productNameFlag>0}">
					<li><a href="<%=basePath%>shop/afterPageByProductName/${x}">${x}</a>
					</li>
				</c:if>


			</c:forEach>
			<!-- 向后翻页 -->
			<c:if
				test="${sessionScope.position ne sessionScope.pageNum and pagenum ne 0 }">
				<!--默认情况  -->
				<c:if test="${allFlag>0}">
					<li><a
						href="<%=basePath%>shop/afterPage/${sessionScope.position+1}"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					</a></li>
				</c:if>
				<!--按照条件查询情况  -->
				<c:if test="${conditionFlag>0}">
					<li><a
						href="<%=basePath%>shop/afterPageByCondition/${sessionScope.position+1}"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					</a></li>
				</c:if>
				<!--按照商品名称查询状况 -->
				<c:if test="${productNameFlag>0}">
					<li><a
						href="<%=basePath%>shop/afterPageByProductName/${sessionScope.position+1}"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					</a></li>
				</c:if>

			</c:if>
		</ul>
		</nav>

	</div>

	<section>
	<p>多肉植物是指植物营养器官肥大的高等植物，通常具根、茎、叶三种营养器官和花（Flower
		['flauə]）、果实、种子三种繁殖器官。在园艺上，又称肉质植物或多肉花卉，但以多肉植物这个名称最为常用。全世界共有多肉植物一万余种，它们绝大部分属于高等植物（绝大多数是被子植物）。在植物分类上隶属几十个科，个别专家认为有67个科中含有多肉植物，但大多数专家认为只有50余科。
	</p>
	</section>
	<footer>
	<p>偏安一偶 静静生活</p>
	<div class="services">品质保障|七天无理由退换货|特色服务体验</div>
	</footer>
</body>

</html>