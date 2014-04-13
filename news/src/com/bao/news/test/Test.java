package com.bao.news.test;

import java.util.Date;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bao.news.utils.GetUUIDKey;
import com.bao.news.vo.NewsVO;
public class Test extends HibernateDaoSupport {
	
	public String save(NewsVO news){
		String str=null;
		HibernateTemplate h=this.getHibernateTemplate();
		System.out.println(h);
		this.getHibernateTemplate().save(news);
		System.out.println(str);
		return str;
		
	}
		
	
	public static void main(String[] args) {
		NewsVO news=new NewsVO();
		news.setId(GetUUIDKey.getUUID());
		news.setNewsTitle("newstitle");
		news.setAuthor("23");
		news.setClassId("2");
		news.setClickNum(2);
		news.setContent("32421");
		news.setTitle("1231");
		news.setWonderful("2312");
		news.setCreateTimeStr("2011-01-01");
		news.setReplyNum(0);
		news.setCreateTime(new Date());
		new Test().save(news);
		
		
	}
	
	

}
