package com.sixCoders.suse.controller;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sixCoders.suse.model.Order;
import com.sixCoders.suse.model.User;
import com.sixCoders.suse.service.OrderService;

/**
 * @author fxr
 * @date 创建时间：2018年7月5日 下午10:27:16
 * @version 1.0
 * @parameter
 * @throws @return
 */
@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService orderservice;

	@RequestMapping(value = "orderlist")
	public ModelAndView OrderList(HttpSession session) {
		User u = (User) session.getAttribute("user");
		List<Order> OrderAll = orderservice.selectAllorder(u.getUserId());

		ModelAndView orderlist = new ModelAndView();
		orderlist.addObject("orderlist", OrderAll);

		orderlist.setViewName("order/order");
		return orderlist;
	}

	@RequestMapping(value = "CollectGoods/{orderid}")
	public ModelAndView CollectGoods(@PathVariable(value = "orderid") int orderid, HttpSession session) {
		User u = (User)session.getAttribute("user");
		ModelAndView orderlist = new ModelAndView();
		List<Order> OrderAll = orderservice.selectAll(orderid,u.getUserId());
		orderlist.addObject("orderlist", OrderAll);
		orderlist.setViewName("order/order");
		return orderlist;
	}

	@RequestMapping("selectByLikepName")
	public ModelAndView selectByLikepName(@RequestParam(value = "likename") String likename,HttpSession session) {
		User u = (User)session.getAttribute("user");
		ModelAndView orderlist = new ModelAndView();
		boolean matches = likename.matches("[0-9]+");
		if (matches == false) {
			List<Order> OrderAll = orderservice.selectByLikepName(likename,u.getUserId());
			orderlist.addObject("orderlist", OrderAll);
		}else {
			int orderid = Integer.parseInt(likename); 
			List<Order> torder=orderservice.selectByOrderId(orderid,u.getUserId());
			orderlist.addObject("orderlist",torder);
		}

		orderlist.setViewName("order/order");

		return orderlist;
	}
	
}
