package com.sixCoders.suse.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sixCoders.suse.dao.PictureMapper;
import com.sixCoders.suse.model.Picture;
import com.sixCoders.suse.service.PictureService;
@Service("pictureServiceImpl")
public class PictureServiceImpl implements PictureService {
	@Autowired
	private PictureMapper pictureMapper;
	
	public Picture findPictureById(int id) {
		// TODO Auto-generated method stub
		Picture picture=pictureMapper.findPictureById(id);
		return picture;
	}

}
