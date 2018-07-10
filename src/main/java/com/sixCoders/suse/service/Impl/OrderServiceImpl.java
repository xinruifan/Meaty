package com.sixCoders.suse.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sixCoders.suse.dao.OrderMapper;
import com.sixCoders.suse.model.Order;
import com.sixCoders.suse.model.User;
import com.sixCoders.suse.service.OrderService;

/**
 * @author fxr
 * @date 创建时间：2018年7月5日 下午2:37:29
 * @version 1.0
 * @parameter
 * @throws @return
 */
@Service("orderservice")
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderMapper orderMapper;

	public List<Order> selectAllorder(int userid) {

		List<Order> orderlist = orderMapper.selectAll(userid);
		return orderlist;
	}

	public List<Order> selectAll(int orderid,int userid) {

		Order torder=orderMapper.selectById(orderid);
		
		boolean updateByState = orderMapper.updateByStateCollect(torder);
		
		List<Order> orderlist = orderMapper.selectAll(userid);
		
		return orderlist;
	}

	public List<Order> selectByLikepName(String LikeName,int userid) {
		
		List<Order> selectByLikeName = orderMapper.selectByLikeName(LikeName,userid);
		
		return selectByLikeName;
	}

	public List<Order> selectByOrderId(int orderid,int userid) {
		
		List<Order> torder = orderMapper.selectByOrderId(orderid,userid);
		
		return torder;
	}

}
