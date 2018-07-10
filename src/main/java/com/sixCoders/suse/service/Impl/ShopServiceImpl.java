package com.sixCoders.suse.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.sixCoders.suse.dao.PictureMapper;
import com.sixCoders.suse.dao.ShopMapper;
import com.sixCoders.suse.model.Picture;
import com.sixCoders.suse.model.Shop;
import com.sixCoders.suse.service.ShopService;

import net.sf.json.JSONObject;

/** 
* @author  fxr
* @date 创建时间：2018年7月5日 下午2:38:37 
* @version 1.0 
* @parameter 
* @throws
* @return  
*/
@Service
public class ShopServiceImpl implements ShopService {
    @Autowired 
	private ShopMapper shopMapper;
    @Autowired
    private PictureMapper pictureMapper;
	public Shop selectByPrimaryKey(int id) {
		// TODO Auto-generated method stub
		Shop shop=shopMapper.selectByPrimaryKey(id);
		return shop;
	}
	public List<Shop> selectAll() {
		// TODO Auto-generated method stub
		List<Shop> allShop = shopMapper.selectAll();
		/*for (Shop shop : allShop) {
			//以Json形式读取出来图片ID
			String ids=shop.getpPicture();
			JSONObject jsonObject=JSONObject.fromObject(ids);
			//json转Map
			Map<String,Integer> map=jsonObject;
			Set<String> keySet = map.keySet();
			for (String key : keySet) {
			Picture pic = pictureMapper.findPictureById(map.get(key));
				shop.setPath(pic.getPath());
				break;
			}
		}*/
		List<Shop> newShop=getPicByJson(allShop);
		
		return newShop;
	}
	
	public List<Shop> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		List<Shop> allShop = shopMapper.selectByCondition(condition);
		List<Shop> newShop=getPicByJson(allShop);
		return newShop;
	}
	
	public List<Shop> selectByProductName(String name) {
		// TODO Auto-generated method stub
		List<Shop> allShop = shopMapper.selectByProductName(name);
		List<Shop> newShop=getPicByJson(allShop);
		return newShop;
	}
	
	//解析json
	public List<Shop> getPicByJson(List<Shop> allShop){
		
		for (Shop shop : allShop) {
			//以Json形式读取出来图片ID
			String ids=shop.getpPicture();
			JSONObject jsonObject=JSONObject.fromObject(ids);
			//json转Map
			Map<String,Integer> map=jsonObject;
			Set<String> keySet = map.keySet();
			for (String key : keySet) {
			Picture pic = pictureMapper.findPictureById(map.get(key));
				shop.setPath(pic.getPath());
				break;
			}
	}
		return allShop;
	
	
	}
	
}
