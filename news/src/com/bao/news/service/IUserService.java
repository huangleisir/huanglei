package com.bao.news.service;

import java.util.List;

import com.bao.news.vo.UserVO;

public interface IUserService {
	public UserVO find(String id);
	public List<UserVO> findByName(String name);
	public String save(UserVO vo);
	public String update(UserVO vo);
	public String saveOrUpdate(UserVO vo);
	public Object[] findByParam(int pageNo, int pageSize, UserVO vo);
}
