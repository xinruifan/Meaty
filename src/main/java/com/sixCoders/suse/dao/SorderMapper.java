package com.sixCoders.suse.dao;

import java.util.List;

import com.sixCoders.suse.model.Sorder;
import com.sixCoders.suse.model.User;

/** 
* @author  fxr
* @date 创建时间：2018年7月9日 上午12:18:43 
* @version 1.0 
* @parameter 
* @throws
* @return  
*/
public interface SorderMapper {

	List<Sorder> selectByOrderId(int orderid);
	
	List<User> selectUserByOrderId(int orderid); 
}
