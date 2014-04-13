package com.bao.news.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.bao.news.action.base.PublicAction;
import com.bao.news.service.INewsService;
import com.bao.news.utils.NewsUtil;
import com.bao.news.vo.NewsVO;
import com.opensymphony.xwork2.ActionSupport;

public class PublishAction extends ActionSupport {
	private INewsService newsService;

	/**
	 * ��������
	 */
	public String doPublishNews() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("utf-8");
		
		String title = this.getParm(request, "title");
		String author = this.getParm(request, "author");
		String content = this.getParm(request, "content");
		String wonderful = this.getParm(request, "wonderful");
		String classId = this.getParm(request, "classId");
		NewsVO vo = new NewsVO(title, content, author, wonderful, new Date(), classId, 0, 0);
		try {
			newsService.saveOrUpdate(vo);
			this.write(response, "0");
		} catch (Exception e) {
			e.printStackTrace();
			this.write(response, "Error:" + e.getMessage());
		}
		//request.setAttribute("switchPage", null);//switchΪ��ֵ��ʾ��ʾ�����б�
		
		System.out.println("�����ɹ���");
		return SUCCESS;
	}
	
	/**
	 * ��������
	 */
	public String editNews() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String currentRight = (String)session.getAttribute("CurrentRight");
		request.setCharacterEncoding("utf-8");
		String newId = request.getParameter("newsId");
		String title = this.getParm(request, "title");
		String author = this.getParm(request, "author");
		String content = this.getParm(request, "content");
		String wonderful = this.getParm(request, "wonderful");
		String classId = this.getParm(request, "classId");
		
		if(currentRight == null || !currentRight.equals(NewsUtil.USER_RIGHT_ADMIN)){
			this.write(response, "�Բ�������Ȩ���б༭���ţ�");
		}else {
			NewsVO vo = newsService.find(newId);
			if(vo==null){
				this.write(response, "�Բ�����Ҫ�༭�������ѱ�ɾ����");
			}else {
				try {
					vo.setAuthor(author);
					vo.setTitle(title);
					vo.setContent(content);
					vo.setWonderful(wonderful);
					vo.setClassId(classId);
					newsService.saveOrUpdate(vo);
					this.write(response, "0");
				} catch (Exception e) {
					e.printStackTrace();
					this.write(response, "Error:" + e.getMessage());
				}
			}
		}
		
		
		return "success";
	}

	// ��ȡ����
	public String getParm(HttpServletRequest request, String str) {
		return toTrim(request.getParameter(str));
	}

	/**
	 * ȥ���ַ�����β�ո�
	 * 
	 * @param str
	 * @return
	 */
	private String toTrim(String str) {
		if (StringUtils.isBlank(str)) {
			return null;
		}
		return str.trim();
	}

	private void write(HttpServletResponse response, String json)
			throws IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(json);
		pw.flush();
		pw.close();
	}

	public void setNewsService(INewsService newsService) {
		this.newsService = newsService;
	}
}
