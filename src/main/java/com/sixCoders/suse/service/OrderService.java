package com.sixCoders.suse.service;

import java.util.List;

import com.sixCoders.suse.model.Order;

/** 
* @author  fxr
* @date 创建时间：2018年7月5日 上午11:28:15 
* @version 1.0 
* @parameter 
* @throws
* @return  
*/
public interface OrderService {
	
	 List<Order> selectAllorder(int userid);

	 List<Order> selectAll(int orderid,int userid);
	 
	 List<Order> selectByLikepName(String LikeName,int userid);
	 
	 List<Order> selectByOrderId(int orderid,int userid);
}
