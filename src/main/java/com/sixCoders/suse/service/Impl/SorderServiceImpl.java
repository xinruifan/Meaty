package com.sixCoders.suse.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sixCoders.suse.dao.SorderMapper;
import com.sixCoders.suse.model.Sorder;
import com.sixCoders.suse.model.User;
import com.sixCoders.suse.service.SorderService;

/** 
* @author  fxr
* @date 创建时间：2018年7月9日 上午10:07:50 
* @version 1.0 
* @parameter 
* @throws
* @return  
*/
@Service
public class SorderServiceImpl implements SorderService{

	@Autowired
	SorderMapper sorderMapper;
	
	public List<Sorder> selectByOrderId(int orderid) {
		
		return sorderMapper.selectByOrderId(orderid);
	}

	public List<User> selectUserByOrderId(int orderid) {
		
		return sorderMapper.selectUserByOrderId(orderid);
	}

}
