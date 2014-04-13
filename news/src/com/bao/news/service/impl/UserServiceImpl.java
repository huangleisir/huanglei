package com.bao.news.service.impl;

import java.util.List;

import org.apache.commons.lang.xwork.StringUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bao.news.service.IUserService;
import com.bao.news.utils.GetUUIDKey;
import com.bao.news.vo.UserVO;

public class UserServiceImpl extends HibernateDaoSupport implements
		IUserService {

	@Override
	public UserVO find(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<UserVO> findByName(String name){
		return this.getHibernateTemplate().find("from UserVO vo where vo.userName=?",name);
	}

	@Override
	public String save(UserVO vo) {
		vo.setId(GetUUIDKey.getUUID());
		this.getHibernateTemplate().save(vo);
		System.out.println(this.getHibernateTemplate());
		return vo.getId();
	}

	@Override
	public String update(UserVO vo) {
		System.out.println("========"+this.getHibernateTemplate());
		this.getHibernateTemplate().update(vo);
		return vo.getId();
	}

	@Override
	public String saveOrUpdate(UserVO vo) {
		String id = null;
		if(StringUtils.isNotBlank(vo.getId())){
			id = this.update(vo);
		}else {
			id = this.save(vo);
		}
		return id;
	}

	@Override
	public Object[] findByParam(int pageNo, int pageSize, UserVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
	public static void main(String[] args) {
		
		new UserServiceImpl().update(null);
		System.out.println();
	}

}
