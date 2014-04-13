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
	 * ��ѯ����
	 * @param pageNo
	 * @param pageSize
	 * @param vo
	 * @param flag ��ʶ��1Ϊ�����ŷ���ʱ������2Ϊ�����������3Ϊ������������
	 * @return
	 */
	public List<NewsVO> findByParam(int pageNo, int pageSize, NewsVO vo,int flag);
}
