package com.bao.news.service;


import java.util.List;

import com.bao.news.vo.ReplyVO;

public interface IReplyService {
	public ReplyVO find(String id);

	public String save(ReplyVO vo);

	public String update(ReplyVO vo);

	public String saveOrUpdate(ReplyVO vo);
	
	public void delete(ReplyVO vo);
	public void deleteByNewsId(String newsId);

	public List<ReplyVO> findByParam(int pageNo, int pageSize, ReplyVO vo);
}
