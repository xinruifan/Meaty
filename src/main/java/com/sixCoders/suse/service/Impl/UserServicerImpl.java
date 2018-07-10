package com.sixCoders.suse.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sixCoders.suse.dao.UserMapper;
import com.sixCoders.suse.model.User;
import com.sixCoders.suse.service.UserService;

/**
 * @author fxr
 * @date 创建时间：2018年7月5日 上午11:01:06
 * @version 1.0
 * @parameter
 * @throws @return
 */
@Service("userService")
public class UserServicerImpl implements UserService {

	@Autowired
	UserMapper userdao;

	public User selectUser(int userId) {
		User TUser = userdao.selectByPrimaryKey(userId);
		return TUser;
	}

	// 通过用户账号查对象
	public User queryUser(String userNum) {
		User user = userdao.selectByphonenum(userNum);
		return user;
	}

	public void insertUser(User u) {
		userdao.insert(u);

	}

	public void updateUser(User u) {
		userdao.updateUser(u);

	}

	public boolean selectByUserNum(String usernum) {
		List<User> list = userdao.selectByUserNum(usernum);
		if (list.size() == 0) {
			System.out.println(list.size());
			return true;
		} else
			System.out.println(list.size());
			return false;
	}

	public void updatePassword(User u) {

		userdao.updatePassword(u);
		
	}
}
