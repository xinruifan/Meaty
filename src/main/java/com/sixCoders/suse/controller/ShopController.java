package com.sixCoders.suse.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sixCoders.suse.model.Cart;
import com.sixCoders.suse.model.Picture;
import com.sixCoders.suse.model.Shop;
import com.sixCoders.suse.service.Impl.CartServiceImpl;
import com.sixCoders.suse.service.Impl.PictureServiceImpl;
import com.sixCoders.suse.service.Impl.ShopServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/shop")
public class ShopController {
	@Autowired
	private ShopServiceImpl shopServiceImpl;
	@Autowired
	private PictureServiceImpl pictureServiceImpl; 
	@Autowired
	private CartServiceImpl cartServiceImp;
	
	@RequestMapping("/selectOneShop/{id}")
	public ModelAndView selectOneShop(@PathVariable("id") int shopId) {
		ModelAndView mv =new ModelAndView("product/productInfo");
	Shop shop = shopServiceImpl.selectByPrimaryKey(shopId);
	//以Json形式读取出来图片ID
	String ids=shop.getpPicture();
	JSONObject jsonObject=JSONObject.fromObject(ids);
	//json转Map
	Map<String,Integer> map=jsonObject;
	//用来保存图片
	List<Picture> pics=new ArrayList<Picture>();
	
	Set<String> keySet = map.keySet();
	for (String key : keySet) {
		Integer id=map.get(key);
		System.out.println("收到的id"+id);
		Picture pic=pictureServiceImpl.findPictureById(id);
	pics.add(pic);
	}
	
	mv.addObject("pics", pics);
	mv.addObject("shop", shop);
	mv.addObject("onePic", pics.get(0));
		return mv;
	}
	
	//查询所有商品
	@RequestMapping("/selectAll")
	public ModelAndView selectAll(HttpSession  session) {
		ModelAndView mv= new ModelAndView("index");
		PageHelper.startPage(1,8);
		List<Shop> allShop = shopServiceImpl.selectAll();
		for (Shop shop : allShop) {
			System.out.println(shop.getPath());
		}
		PageInfo<Shop> pageInfo = new PageInfo(allShop);
		int pageNum = pageInfo.getPages();
		
		System.out.println(pageNum);
		session.setAttribute("pageNum", pageNum);
		session.setAttribute("position", 1);
		mv.addObject("allShop", allShop);
		mv.addObject("allFlag", 1);
		return mv;
	}
	@RequestMapping("/afterPage/{pageNum}")
	public ModelAndView afterPage(@PathVariable("pageNum") int page,HttpSession session) {
		ModelAndView mv =new ModelAndView("index");
		PageHelper.startPage(page,8);
		List<Shop> allShop = shopServiceImpl.selectAll();
		PageInfo<Shop> pageInfo = new PageInfo(allShop);
		int pageNum = pageInfo.getPages();
		
		System.out.println(pageNum);
		mv.addObject("pageNum", pageNum);
		mv.addObject("allShop", allShop);
		session.setAttribute("position", page);
		mv.addObject("allFlag", 1);
		return mv;
	}
	//按条件筛选商品
	@RequestMapping("/selectByCondition/{condition}" )
	public ModelAndView selectByCondition(@PathVariable("condition")String condition,HttpSession session) {	
		ModelAndView mv= new ModelAndView("index");
		PageHelper.startPage(1,8);
		List<Shop> allShop = shopServiceImpl.selectByCondition(condition);
		PageInfo<Shop> pageInfo = new PageInfo(allShop);
		int pageNum = pageInfo.getPages();
		mv.addObject("allShop", allShop);
		session.setAttribute("pageNum", pageNum);
		mv.addObject("conditionFlag",1);
		session.setAttribute("position",1);
		session.setAttribute("condition",condition);
		return mv;
	}
	//按商品名称筛选商品
		@RequestMapping("/selectByProduct" )
		public ModelAndView selectByProductName(String productName,HttpSession session) {	
			ModelAndView mv= new ModelAndView("index");
			System.out.println(productName);
			PageHelper.startPage(1,8);
			List<Shop> allShop = shopServiceImpl.selectByProductName(productName);
			System.out.println(allShop.size());
			PageInfo<Shop> pageInfo = new PageInfo(allShop);
			int pageNum = pageInfo.getPages();
			mv.addObject("allShop", allShop);
			mv.addObject("flag", 1);
			mv.addObject("productNameFlag", 1);
			session.setAttribute("productName", productName);
			session.setAttribute("pageNum", pageNum);
			session.setAttribute("position", 1);
			return mv;
		}
		//按照条件查询筛选分页点击上一页 下一页 实现跳转
		@RequestMapping("/afterPageByCondition/{pageNum}")
		public ModelAndView afterPageByCondition(@PathVariable("pageNum") int page,HttpSession session) {
			ModelAndView mv =new ModelAndView("index");
			PageHelper.startPage(page,8);
			String condition =(String) session.getAttribute("condition");
			List<Shop> allShop = shopServiceImpl.selectByCondition(condition);
			PageInfo<Shop> pageInfo = new PageInfo(allShop);
			int pageNum = pageInfo.getPages();
			
			System.out.println(pageNum);
			//返回总共的页数
			mv.addObject("pageNum", pageNum);
			//返回所有活动
			mv.addObject("allShop", allShop);
			//前端判断状态的条件
			mv.addObject("conditionFlag",1);
			//设置当前页码值
			session.setAttribute("position", page);
			return mv;
		}
		
		//根据商品名字筛选分页，点击上一页，下一页实现跳转
		@RequestMapping("/afterPageByProductName/{pageNum}")
		public ModelAndView afterPageByProductName(@PathVariable("pageNum") int page,HttpSession session) {
			ModelAndView mv =new ModelAndView("index");
			PageHelper.startPage(page,8);
			String productName =(String) session.getAttribute("productName");
			List<Shop> allShop = shopServiceImpl.selectByProductName(productName);
			PageInfo<Shop> pageInfo = new PageInfo(allShop);
			int pageNum = pageInfo.getPages();
			//返回总共的页数
			mv.addObject("pageNum", pageNum);
			//返回所有活动
			mv.addObject("allShop", allShop);
			//前端判断状态的条件
			mv.addObject("productNameflag",1);
			//设置当前页码值
			session.setAttribute("position", page);
			return mv;
		}
		
		@RequestMapping("/insterOneProductToCart")
		public ModelAndView insterOneProductToCart(Cart cart) {
			ModelAndView mv =new ModelAndView("success");
			System.out.println(cart);
			cartServiceImp.insterOneProductToCart(cart);
			return mv;
		}
		
}
