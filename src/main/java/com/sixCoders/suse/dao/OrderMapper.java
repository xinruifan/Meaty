package com.sixCoders.suse.dao;

import com.sixCoders.suse.model.Order;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Primary;

public interface OrderMapper {

	// int deleteByPrimaryKey(Integer orderId);
	//
	//
	// int insert(Order record);
	//
	// Order selectByPrimaryKey(Integer orderId);
	//
	List<Order> selectAll(int userid);

	boolean updateByStateCollect(Order torder);

	List<Order> selectByLikeName(@Param("likepname") String likepname,@Param("userid")int userid);

	Order selectById(int orderid);

	// int updateByPrimaryKey(Order record);
	List<Order> selectByOrderId(@Param("orderid")int orderid,@Param("userid")int userid);
}