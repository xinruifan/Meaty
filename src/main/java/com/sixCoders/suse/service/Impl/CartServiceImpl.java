package com.sixCoders.suse.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sixCoders.suse.dao.CartMapper;
import com.sixCoders.suse.dao.OrderMapper;
import com.sixCoders.suse.model.Cart;
import com.sixCoders.suse.model.Order;
import com.sixCoders.suse.service.CartService;

/** 
* @author  fxr
* @date 创建时间：2018年7月5日 下午9:00:49 
* @version 1.0 
* @parameter 
* @throws
* @return  
*/

@Service("CartService")
public class CartServiceImpl implements CartService {

	@Autowired
    CartMapper cartMapper;
	@Autowired
	OrderMapper orderMapper;
	public List<Cart> search(int userId) {
		// TODO Auto-generated method stub
		List<Cart> carts=cartMapper.selectAll(userId);
		return carts;
	}
	public int deleteGoods(int cartId) {
		// TODO Auto-generated method stub
		cartMapper.deleteByPrimaryKey(cartId);
		return 0;
	}

	public void deleteAll(int UserId) {
		cartMapper.deleteAll(UserId);
	}
	
	
	public void updateFlag(int CartId) {
		// TODO Auto-generated method stub
		
	}

	public void insterOneProductToCart(Cart cart) {
		// TODO Auto-generated method stub
		cartMapper.insert(cart);
	}

}
