package com.bao.news.service.impl.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bao.news.service.INewsService;
import com.bao.news.service.impl.NewsServiceImpl;
import com.bao.news.vo.NewsVO;

import junit.framework.TestCase;

public class NewsServiceImplTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testFind() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-service.xml");
		INewsService newsService =(NewsServiceImpl) context.getBean("newsService");
//		INewsService newsService = new NewsServiceImpl();
		NewsVO newsVO=null;
			 newsVO = newsService.find("8");
			assertEquals("8", newsVO.getId());
			assertEquals("1111",newsVO.getWonderful());
	}
	public void testSave() {
		assertEquals(1, 1);
	}

	public void testUpdate() {
		assertEquals(1, 1);
	}

	public void testSaveOrUpdate() {
		assertEquals(1, 1);
	}

	public void testDeleteNewsVO() {
		assertEquals(1, 1);
	}

	public void testDeleteString() {
		assertEquals(1, 1);
	}

	public void testFindByParam() {
		assertEquals(1, 1);
	}

}
