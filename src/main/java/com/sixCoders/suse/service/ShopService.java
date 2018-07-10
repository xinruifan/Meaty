package com.sixCoders.suse.service;

import java.util.List;

import com.sixCoders.suse.model.Shop;

/** 
* @author  fxr
* @date 创建时间：2018年7月5日 上午11:27:50 
* @version 1.0 
* @parameter 
* @throws
* @return  
*/
public interface ShopService {
	public Shop selectByPrimaryKey(int id);
	public List<Shop> selectAll();
	public List<Shop> selectByCondition(String condition);
	public List<Shop> selectByProductName(String name);
}
