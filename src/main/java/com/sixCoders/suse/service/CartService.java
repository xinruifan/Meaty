package com.sixCoders.suse.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sixCoders.suse.model.Cart;

/** 
* @author  fxr
* @date 创建时间：2018年7月5日 下午9:00:18 
* @version 1.0 
* @parameter 
* @throws
* @return  
*/

public interface CartService {
	//查询所有uerId商品
	public List<Cart> search(int userId);
	//删除一个商品
	public int deleteGoods(int CartId);
	//清空购物车
	public void deleteAll(int UserId);
	//去付款修改 flag
	public void updateFlag(int CartId) ;
	//插入一个购物车
	public void insterOneProductToCart(Cart cart);
		
	
	

}
