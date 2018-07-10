package com.sixCoders.suse.controller;/** 
										* @author  fxr
										* @date 创建时间：2018年7月5日 上午11:02:51 
										* @version 1.0 
										* @parameter 
										* @throws
										* @return  
										*/

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sixCoders.suse.model.User;
import com.sixCoders.suse.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService Userservice;

	// 注册
	@RequestMapping("/register")
	public void register(User u, Map<String, Object> map, HttpServletResponse response,
			@RequestParam("repassword") String repassword,HttpSession session) throws IOException {
		boolean flag = Userservice.selectByUserNum(u.getUserNum());
		if (u.getUserNum().length() == 11 && flag == true) {
			if (u.getUserPassword().equals(repassword)) {
				u.setUserBalance(100);
				u.setFlag(0);
				User userFromDb = Userservice.queryUser(u.getUserNum());
				if (userFromDb == null) {
					Userservice.insertUser(u);
					map.put("user", u);
					session.setAttribute("user", userFromDb);
					response.getWriter().println(1);
				} else {
					if (userFromDb.getUserNum().equals(u.getUserNum())) {
						response.getWriter().println(0);
					} else {
						Userservice.insertUser(u);
						response.getWriter().println(1);
					}
				}
			} else {
				response.getWriter().println(2);
			}
		} else {
			response.getWriter().println(3);
		}
	}

	// 登陆
	@RequestMapping("/login")
	public void login(User u, Map<String, Object> map, String code, HttpServletResponse response, HttpSession session)
			throws IOException {
		User userFromDB = Userservice.queryUser(u.getUserNum());
		// 获取session中的验证码
		String result = (String) session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		// 如果验证码正确在查询数据库
		if (result.equals(code)) {
			if (userFromDB != null) {
				if (userFromDB.getUserPassword().equals(u.getUserPassword())) {
					map.put("user", userFromDB);
					session.setAttribute("user", userFromDB);
					response.getWriter().println(1);

				} else {
					response.getWriter().println(3);
				}
			} else {
				response.getWriter().println(0);
			}
		} else {
			response.getWriter().println(2);
		}

	}

	// 重置密码
	@RequestMapping("/ResetPassword")
	public void ResetPassword(User u, HttpServletResponse response, @RequestParam("repassword") String repassword)
			throws IOException {
		boolean flag = Userservice.selectByUserNum(u.getUserNum());
		if (flag == false) {
			if (u.getUserPassword().equals(repassword)) {
				
				Userservice.updatePassword(u);
				response.getWriter().println(1);

			} else {
				response.getWriter().println(2);
			}
		} else {
			response.getWriter().println(3);
		}
	}
}
