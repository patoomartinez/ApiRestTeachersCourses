package com.example.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.model.SocialMedia;
import com.example.demo.model.TeacherSocialMedia;

@Repository
@Transactional
public class SocialMediaDaoImpl extends AbstractSession implements SocialMediaDao {

	@Override
	public void saveSocialMedia(SocialMedia socialMedia) {
		getSession().persist(socialMedia);
	}

	@Override
	public void deleteSocialMediaById(Long id) {
		SocialMedia socialMedia = findyById(id);
		if (socialMedia != null) {
			getSession().delete(socialMedia);
		}

	}

	@Override
	public void updateSocialMedia(SocialMedia socialMedia) {
		// TODO Auto-generated method stub
		getSession().update(socialMedia);

	}

	@Override
	public List<SocialMedia> findAllSocialMedias() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from SocialMedia").list();
	}

	@Override
	public SocialMedia findyById(Long idSocialMedia) {
		// TODO Auto-generated method stub
		return (SocialMedia) getSession().get(SocialMedia.class, idSocialMedia);
	}

	@Override
	public SocialMedia findyByName(String name) {
		// TODO Auto-generated method stub
		return (SocialMedia) getSession().createQuery("from SocialMedia where name = :name").setParameter("name", name)
				.uniqueResult();
	}

	@Override
	public TeacherSocialMedia findSocialMediaByIdAndName(Long idSocialMedia, String nickname) {
		// TODO Auto-generated method stub
		 List<Object[]> objects = getSession().createQuery(
				"from TeacherSocialMedia tsm join tsm.socialMedia sm"
				+ " where sm.idSocialMedia = :idSocialMedia and tsm.nickname = :nickname")
				.setParameter("idSocialMedia", idSocialMedia).setParameter("nickname", nickname).list();
				if(objects.size()>0) {
					for (Object[] obj : objects) {
						for (Object object : obj) {
							if(object instanceof TeacherSocialMedia) {
								return (TeacherSocialMedia) object;
							} 
						}
					}
				}
				return null;
	}

}
