package com.sixCoders.suse.model;

import java.math.BigDecimal;
import java.security.KeyStore.PrivateKeyEntry;

import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;

/** 
* @author  fxr
* @date 创建时间：2018年7月8日 下午11:42:35 
* @version 1.0 
* @parameter 
* @throws
* @return  
*/
public class Sorder {
	
	private Integer oId;
	
	private String oPicture;
	
	private Integer oNum;
	
	private BigDecimal oAmount;
	
	private Integer orderId;
	
	private Integer pId;
	
	private Integer sId;
	
	private Integer userId;
	
	private Order order;
	
	private Shop shop;
	
	private Seller seller;
	
	private User user;

	public Integer getoId() {
		return oId;
	}

	public void setoId(Integer oId) {
		this.oId = oId;
	}

	public String getoPicture() {
		return oPicture;
	}

	public void setoPicture(String oPicture) {
		this.oPicture = oPicture;
	}

	public Integer getoNum() {
		return oNum;
	}

	public void setoNum(Integer oNum) {
		this.oNum = oNum;
	}

	public BigDecimal getoAmount() {
		return oAmount;
	}

	public void setoAmount(BigDecimal oAmount) {
		this.oAmount = oAmount;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public Integer getsId() {
		return sId;
	}

	public void setsId(Integer sId) {
		this.sId = sId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Sorder [oId=" + oId + ", oPicture=" + oPicture + ", oNum=" + oNum + ", oAmount=" + oAmount
				+ ", orderId=" + orderId + ", pId=" + pId + ", sId=" + sId + ", userId=" + userId + ", order=" + order
				+ ", shop=" + shop + ", seller=" + seller + ", user=" + user + "]";
	}
	
	
}
