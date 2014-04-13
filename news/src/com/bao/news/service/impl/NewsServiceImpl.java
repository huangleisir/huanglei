package com.bao.news.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bao.news.action.LoginAction;
import com.bao.news.service.INewsService;
import com.bao.news.utils.GetUUIDKey;
import com.bao.news.utils.NewsUtil;
import com.bao.news.vo.NewsVO;

public class NewsServiceImpl extends HibernateDaoSupport implements

		INewsService {

	@Override
	public NewsVO find(String id) {
		return this.getHibernateTemplate().get(NewsVO.class, id);
	}

	@Override
	public String save(NewsVO vo) {
		vo.setId(GetUUIDKey.getUUID());
		this.getHibernateTemplate().save(vo);
		return vo.getId();
	}

	@Override
	public String update(NewsVO vo) {
		this.getHibernateTemplate().update(vo);
		return vo.getId();
	}

	@Override
	public String saveOrUpdate(NewsVO vo) {
		String id = null;
		if(StringUtils.isNotBlank(vo.getId())){
			id = this.update(vo);
		}else {
			id = this.save(vo);
		}
		return id;
	}

	public void delete(NewsVO vo) {
		this.getHibernateTemplate().delete(vo);
	}
	
	public void delete(String id) {
		NewsVO news = this.find(id);
		if(news != null) this.delete(news);
	}
	
	
	@Override
	public List<NewsVO> findByParam(int pageNo, int pageSize, NewsVO vo,int flag) {
		Session session = this.getSession();
		String hql = "select vo from NewsVO vo where 1=1 ";
		if(StringUtils.isNotBlank(vo.getTitle())){
			hql += " and vo.title like '%"+vo.getTitle()+"%' ";
		}
		if(StringUtils.isNotBlank(vo.getClassId())){
			hql += " and vo.classId='"+vo.getClassId()+"' ";
		}
		if(flag == 1){//按时间排序
			hql += " order by createTime desc ";
		}else if(flag == 2){// 按点击量排序
			hql += " order by clickNum desc ";
		}else if(flag == 3){// 按评论量排序
			hql += " order by replyNum desc  ";
		}
		Query query = session.createQuery(hql);
		
		//获取总记录数显示在网页上
		NewsUtil.totalRecordsCount=query.list().size();
		//通过获取总记录数计算总页数
		System.out.println("****************************************************************************************************");
		NewsUtil.totalNewsPageCount = NewsUtil.totalRecordsCount%NewsUtil.NEWS_NEWS_LEFT_PAGESIZE==0?NewsUtil.totalRecordsCount/NewsUtil.NEWS_NEWS_LEFT_PAGESIZE:NewsUtil.totalRecordsCount/NewsUtil.NEWS_NEWS_LEFT_PAGESIZE+1;
		System.out.println("****************************************************************************************************");
		return (List<NewsVO>)NewsUtil.pageQuery(query, pageNo, pageSize);
	}
	
	public void test(){
		HibernateTemplate h = this.getHibernateTemplate();
		System.out.println(h);
		
	}
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-service.xml");
		INewsService newsService =(NewsServiceImpl) context.getBean("newsService");
		NewsVO newsVO=null;
		try {
			 newsVO = newsService.find("8");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(newsVO.getId());
	}

}
