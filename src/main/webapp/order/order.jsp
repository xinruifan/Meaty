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
<title>我的订单</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="description" content="" />
<meta name="format-detection" content="telephone=no" />
<meta name="" />

<link rel="stylesheet" type="text/css" href="<%=basePath%>css/tasp.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/orderconfirm.css" />

<style>
#page {
	width: auto;
}

#comm-header-inner, #content {
	width: 950px;
	margin: auto;
}

#logo {
	padding-top: 26px;
	padding-bottom: 12px;
}

#header .wrap-box {
	margin-top: -67px;
}

#logo .logo {
	position: relative;
	overflow: hidden;
	display: inline-block;
	width: 140px;
	height: 35px;
	font-size: 35px;
	line-height: 35px;
	color: #f40;
}

#logo .logo .i {
	position: absolute;
	width: 140px;
	height: 35px;
	top: 0;
	left: 0;
}

.sousuo {
	width: 15em;
	height: 2em;
	border-radius: 5px;
}

.chaxun {
	height: 2.5em;
	width: 5em;
	border-radius: 5px;
	background-color: #76ee00;
}
</style>

</head>

<body data-spm="1">

	<div id="page">

		<div id="content" class="grid-c">

			<div id="address" class="address" style="margin-top: 20px;"
				data-spm="2"></div>
			<div>

				<div>
					<h3 class="dib">确认订单信息</h3>
					<form action="<%=basePath%>order/selectByLikepName"
						style="display: block; float: right;">
						<input type="text" name="likename" placeholder="搜索订单名称或者订单号"
							class="sousuo"> <input type="submit" value="查询"
							class="chaxun">
					</form>
				</div>
				<table cellspacing="0" cellpadding="0" class="order-table"
					id="J_OrderTable" summary="统一下单订单信息区域">

					<thead>

						<tr>
							<th class="s-amount">订单序号
								<hr />
							</th>
							<th class="s-agio">订单名称
								<hr />
							</th>

							<th class="s-amount">发货状态
								<hr />
							</th>
							<th class="s-agio">付款状态
								<hr />
							</th>
							<th class="s-total">总额(元)
								<hr />
							</th>
							</th>
							<th class="s-price">下单时间
								<hr />
							<th class="s-price">查看详情
								<hr />
							<th class="s-amount">确认收货
								<hr />
						</tr>
					</thead>

					<tbody>

						<c:forEach items="${orderlist}" var="order" varStatus="status">
							<tr class="item" style="margin-top: 20px">
								<td class="s-price">${order.orderId}</td>
								<td class="s-price">${order.orderName}</td>
								<td class="s-agio"><c:if test="${order.orderState==0 }">
											未发货
										</c:if> <c:if test="${order.orderState== 1 }">
											发货中
										</c:if> <c:if test="${order.orderState == 2}">
											已发货
										</c:if>
										 <c:if test="${order.orderState == 3 }">
																已收货
															</c:if></td>
								<td class="s-agio"><c:if test="${order.orderState==0  }">
											支付中
										</c:if> <c:if test="${order.orderState != 0 }">
											已支付
										</c:if></td>
								<td class="s-amount" data-point-url="">${order.orderAmount }
								</td>
								<td class="s-price">${order.orderTime}</td>
								<td class="s-amount"><a href="<%=basePath %>sorder/details/${order.orderId}">订单详情</a></td>
								<td class="s-agio"><c:if test="${order.orderState!= 3 }">
										<a href="<%=basePath %>order/CollectGoods/${order.orderId}">确认收货</a>
									</c:if> <c:if test="${order.orderState == 3 }">
																已收货
															</c:if></td>
							</tr>




						</c:forEach>
					</tbody>

				</table>
			</div>


		</div>

	</div>

</body>

</html>