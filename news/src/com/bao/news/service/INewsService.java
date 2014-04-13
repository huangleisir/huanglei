package com.bao.news.service;

import java.util.List;

import com.bao.news.vo.NewsVO;

public interface INewsService {
	public NewsVO find(String id);

	public String save(NewsVO vo);

	public String update(NewsVO vo);

	public String saveOrUpdate(NewsVO vo);
	
	public void delete(NewsVO vo);
	
	public void delete(String id);

	/**
	 * 查询新闻
	 * @param pageNo
	 * @param pageSize
	 * @param vo
	 * @param flag 标识，1为按新闻发布时间排序，2为按点击量排序，3为按评论数排序
	 * @return
	 */
	public List<NewsVO> findByParam(int pageNo, int pageSize, NewsVO vo,int flag);
}
