package com.sixCoders.suse.dao;

import com.sixCoders.suse.model.User;
import java.util.List;

public interface UserMapper {

	int deleteByPrimaryKey(Integer userId);

	int insert(User record);

	User selectByPrimaryKey(Integer userId);

	List<User> selectAll();

	int updateByPrimaryKey(User record);

	public User selectByphonenum(String phonenum);
	
	public void updateUser(User u);
	
	public List<User> selectByUserNum(String usernum);

	void updatePassword(User u);
	
	
}