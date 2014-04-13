package com.bao.news.service.impl;

import java.util.List;

import org.apache.commons.lang.xwork.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bao.news.service.IReplyService;
import com.bao.news.utils.GetUUIDKey;
import com.bao.news.utils.NewsUtil;
import com.bao.news.vo.NewsVO;
import com.bao.news.vo.ReplyVO;

public class ReplyServiceImpl extends HibernateDaoSupport implements
		IReplyService {

	@Override
	public ReplyVO find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String save(ReplyVO vo) {
		vo.setId(GetUUIDKey.getUUID());
		this.getHibernateTemplate().save(vo);
		return vo.getId();
	}

	@Override
	public String update(ReplyVO vo) {
		this.getHibernateTemplate().update(vo);
		return vo.getId();
	}

	@Override
	public String saveOrUpdate(ReplyVO vo) {
		String id = null;
		if(StringUtils.isNotBlank(vo.getId())){
			id = this.update(vo);
		}else {
			id = this.save(vo);
		}
		return id;
	}
	
	public void delete(ReplyVO vo) {
		this.getHibernateTemplate().delete(vo);
	}
	
	public void deleteByNewsId(String newsId) {
		this.getHibernateTemplate().bulkUpdate("delete from ReplyVO vo where vo.newsId=?",newsId);
	}

	@Override
	public List<ReplyVO> findByParam(int pageNo, int pageSize, ReplyVO vo) {
		Session session = this.getSession();
		String hql = "select new ReplyVO(vo1.id,vo1.newsId,vo1.userId,vo2.userName,vo1.reply,vo1.createTime) " +
				" from ReplyVO vo1,UserVO vo2 where vo1.userId=vo2.id ";
		if(StringUtils.isNotBlank(vo.getNewsId())){
			hql += " and vo1.newsId='"+vo.getNewsId()+"'";
		}
		hql += " order by vo1.createTime desc ";   //按照回复的创建时间降序排列
		Query query = session.createQuery(hql);
		//获取每条新闻下面回复的总数量
		List<ReplyVO> replyList = query.list();
		NewsUtil.totalRecordsCount=replyList.size();
		//通过获取总记录数计算总页数
		NewsUtil.totalReplyPageCount = NewsUtil.totalRecordsCount%pageSize==0?NewsUtil.totalRecordsCount/pageSize:NewsUtil.totalRecordsCount/pageSize+1;
				
		
		return (List<ReplyVO>)NewsUtil.pageQuery(query, pageNo, pageSize);
	}

}
