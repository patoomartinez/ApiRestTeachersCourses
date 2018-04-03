package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SocialMediaDao;
import com.example.demo.model.SocialMedia;
import com.example.demo.model.TeacherSocialMedia;

@Service("socialMediaService")
@Transactional
public class SocialMediaServiceImpl implements SocialMediaService {

	
	@Autowired
	private SocialMediaDao _socialMediaDao;
	
	
	public void saveSocialMedia(SocialMedia socialMedia) {
		_socialMediaDao.saveSocialMedia(socialMedia);
	}

	
	public void deleteSocialMediaById(Long id) {
		// TODO Auto-generated method stub
		_socialMediaDao.deleteSocialMediaById(id);
	}

	
	public void updateSocialMedia(SocialMedia socialMedia) {
		// TODO Auto-generated method stub
		_socialMediaDao.updateSocialMedia(socialMedia);
		
	}


	public List<SocialMedia> findAllSocialMedias() {
		// TODO Auto-generated method stub
		return _socialMediaDao.findAllSocialMedias();
	}

	
	public SocialMedia findyById(Long idSocialMedia) {
		// TODO Auto-generated method stub
		return _socialMediaDao.findyById(idSocialMedia);
	}


	public SocialMedia findyByName(String name) {
		// TODO Auto-generated method stub
		return _socialMediaDao.findyByName(name);
	}


	public TeacherSocialMedia findSocialMediaByIdAndName(Long idSocialMedia, String nickname) {
		// TODO Auto-generated method stub
		return _socialMediaDao.findSocialMediaByIdAndName(idSocialMedia, nickname);
	}

}
