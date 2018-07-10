package com.sixCoders.suse.service;

import com.sixCoders.suse.model.User;

/**
 * @author fxr
 * @date 创建时间：2018年7月5日 上午10:59:09
 * @version 1.0
 * @parameter
 * @throws @return
 */

public interface UserService {

	public User selectUser(int userId);

	public User queryUser(String userName);

	// 插入User
	public void insertUser(User u);

	// 更新user
	public void updateUser(User u);
	
	public boolean selectByUserNum(String usernum);

	public void updatePassword(User u);

}
