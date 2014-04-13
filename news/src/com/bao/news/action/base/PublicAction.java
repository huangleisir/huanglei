package com.bao.news.action.base;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.xwork.StringUtils;
import com.opensymphony.xwork2.ActionSupport;
public class PublicAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int getPageNo(HttpServletRequest request){
		String pageNoStr = request.getParameter("pageNo");
		int pageNo = 1;
		try {
			pageNo = StringUtils.isNotBlank(pageNoStr)?Integer.valueOf(pageNoStr):1;
			pageNo = pageNo>0?pageNo:1;
		} catch (Exception e) {
			pageNo = 1;
			e.printStackTrace();
		}
		return pageNo;
	}
	
	public int getRepPageNo(HttpServletRequest request){
		String pageNoStr = request.getParameter("repPageNo");
		int pageNo = 1;
		try {
			pageNo = StringUtils.isNotBlank(pageNoStr)?Integer.valueOf(pageNoStr):1;
			pageNo = pageNo>0?pageNo:1;
		} catch (Exception e) {
			pageNo = 1;
			e.printStackTrace();
		}
		return pageNo;
	}
	
	public String getSearch(HttpServletRequest request) throws UnsupportedEncodingException{
		String search = request.getParameter("search");
		search = StringUtils.isNotBlank(search)?URLDecoder.decode(search, "UTF-8"):null;
		return search;
	}
	
	public int getFlag(HttpServletRequest request) throws UnsupportedEncodingException{
		int flag = 1;
		String flagStr = request.getParameter("flag");
		flag = StringUtils.isNotBlank(flagStr)?Integer.valueOf(flagStr):1;
		return flag;
	}
	
	public String getClassId(HttpServletRequest request) throws UnsupportedEncodingException{
		return request.getParameter("classId");
	}
	
	public String getSwitch(HttpServletRequest request) throws UnsupportedEncodingException{
		String switchPage = request.getParameter("switch");
		return switchPage;
	}
}
