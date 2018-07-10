package com.sixCoders.suse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sixCoders.suse.model.Sorder;
import com.sixCoders.suse.model.User;
import com.sixCoders.suse.service.SorderService;

/** 
* @author  fxr
* @date 创建时间：2018年7月9日 上午10:09:56 
* @version 1.0 
* @parameter 
* @throws
* @return  
*/
@Controller
@RequestMapping("/sorder")
@SessionAttributes(types = { String.class })
public class SorderController {

	@Autowired
	SorderService sorderService;
	
	@RequestMapping(value="details/{orderid}")
	public ModelAndView details(@PathVariable(value = "orderid") int orderid) {
		ModelAndView detailsList = new ModelAndView();
		List<Sorder> sorder=sorderService.selectByOrderId(orderid);
		List<User> users=sorderService.selectUserByOrderId(orderid);
		
		detailsList.addObject("sorder",sorder);
		detailsList.addObject("user",users);
		detailsList.setViewName("order/sorder");
		return detailsList;
	}
}
