package com.bao.news.action;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.xwork.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.bao.news.action.base.PublicAction;
import com.bao.news.service.INewsService;
import com.bao.news.service.IReplyService;
import com.bao.news.service.impl.NewsServiceImpl;
import com.bao.news.utils.NewsUtil;
import com.bao.news.vo.NewsVO;
import com.bao.news.vo.ReplyVO;

public class NewsAction extends PublicAction implements RequestAware,SessionAware,ApplicationAware {
	private static final long serialVersionUID = 1L;
	HttpServletResponse response = ServletActionContext.getResponse();
	HttpServletRequest request = ServletActionContext.getRequest();
//	private Map<String, Object> request;
	private IReplyService replyService;
	private INewsService newsService;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	public void setReplyService(IReplyService replyService) {
		this.replyService = replyService;
	}

	public void setNewsService(INewsService newsService) {
		this.newsService = newsService;
	}
	
	public String gotoIndexPage() throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("utf-8");
		String switchPage = this.getSwitch(request);
		String search = this.getSearch(request);
		int pageNo = this.getPageNo(request);
		int flag = this.getFlag(request);
		String classId = this.getClassId(request);
		NewsVO vo = new NewsVO();
		vo.setTitle(search);
		vo.setClassId(classId);
		List<NewsVO> news = newsService.findByParam(pageNo, NewsUtil.NEWS_NEWS_LEFT_PAGESIZE, vo,flag);
		//为了计算总页数我们通过这个总记录数
		NewsUtil.newsListHandle(news,NewsUtil.NEWS_LEFT_ROW_LENGTH,"black",true);
		//就是在这里拿到了news2和news3，找了一个多小时，然后放进request容器里面，我就知道一定会在gotoIndexPage()里面加载进来，否则说不通啊
		NewsUtil.setNewsByClickAndReply( request,newsService,new NewsVO());
		
		
		if(switchPage!=null && switchPage.equals("detail")){
			String newsId = request.getParameter("newsId");
			NewsVO detail = newsService.find(newsId);
			if(detail != null){
				int repPageNo = this.getRepPageNo(request);
				classId = detail.getClassId();
				detail.setClickNum(detail.getClickNum() + 1);
				detail.setCreateTimeStr(sdf.format(detail.getCreateTime()));
				newsService.saveOrUpdate(detail);
				ReplyVO repvo = new ReplyVO();
				repvo.setNewsId(newsId);
				List<ReplyVO> replys = replyService.findByParam(repPageNo, NewsUtil.NEWS_NEWS_REPLY_PAGESIZE, repvo);
				request.setAttribute("replys", replys);
				request.setAttribute("repPageNo", repPageNo);
			}else {
				detail = new NewsVO();
				detail.setTitle("您查看的新闻已被删除！");
				detail.setAuthor("无");
				detail.setCreateTimeStr("无");
				detail.setWonderful("您查看的新闻已被删除！");
			}
			request.setAttribute("detail", detail);
		}else if(switchPage!=null && switchPage.equals("editPublish")){
			String newsId = request.getParameter("newsId");
			NewsVO detail = newsService.find(newsId);
			request.setAttribute("detail", detail);
		}
		
		request.setAttribute("news", news);//将新闻列表集合装入request
		request.setAttribute("pageNo", pageNo);//当前第几页
		request.setAttribute("flag", flag);
		request.setAttribute("search", search);
		
		request.setAttribute("switchPage", switchPage);
		
		request.setAttribute("totalNewsPageCount", NewsUtil.totalNewsPageCount);
		request.setAttribute("totalRecordsCount", NewsUtil.totalRecordsCount);
		
		request.setAttribute("classId", StringUtils.isNotBlank(classId)?classId:"");
		request.setAttribute("className", StringUtils.isNotBlank(NewsUtil.MenuItems.get(classId))?NewsUtil.MenuItems.get(classId):"首页");
		return SUCCESS;
	}
	
	public void doReply() throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String currentID = (String)session.getAttribute("CurrentID");
		String newsId = request.getParameter("newsId");
		String repcontent = request.getParameter("repcontent");
		System.out.println("=========="+repcontent);
		if(StringUtils.isNotBlank(currentID)){
			NewsVO news = newsService.find(newsId);
			if(news == null){
				this.write(response, "亲，您要回复的新闻已被删除了哦！");
			}else {
				try {
					ReplyVO repvo = new ReplyVO();
					repvo.setCreateTime(new Date());
					repvo.setNewsId(newsId);
					repvo.setReply(repcontent);
					repvo.setUserId(currentID);
					
					news.setReplyNum(news.getReplyNum() +1);
					newsService.saveOrUpdate(news);
					replyService.saveOrUpdate(repvo);
					this.write(response, "0");//回复成功
				} catch (Exception e) {
					e.printStackTrace();
					this.write(response, "Error:" + e.getMessage());
				}
			}
		}else {
			this.write(response, "亲，要登录才能回复哦！");
		}
	}
	
	public void delNews() throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String currentRight = (String)session.getAttribute("CurrentRight");
		String newsId = request.getParameter("newsId");
		if(currentRight == null || !currentRight.equals(NewsUtil.USER_RIGHT_ADMIN)){
			this.write(response, "对不起，您无权进行删除新闻！");
		}else {
			try {
				newsService.delete(newsId);
				replyService.deleteByNewsId(newsId);
				this.write(response, "0");
			} catch (Exception e) {
				e.printStackTrace();
				this.write(response, "Error:" + e.getMessage());
			}
		}
	}
	
	public void goEditNewsPage() throws Exception{
		
		HttpSession session = request.getSession();
		String currentRight = (String)session.getAttribute("CurrentRight");
		String newsId = request.getParameter("newsId");
		if(currentRight == null || !currentRight.equals(NewsUtil.USER_RIGHT_ADMIN)){
			this.write(response, "对不起，您无权进行编辑新闻！");
		}else {
			NewsVO news = newsService.find(newsId);
			if(news==null){
				this.write(response, "对不起，您要编辑的新闻已被删除！");
			}else {
				this.write(response, "0");
			}
		}
	}
	
	/**
	 * 去掉字符串首尾空格
	 * @param str
	 * @return
	 */
	private String toTrim(String str) {
		if (StringUtils.isBlank(str)) {
			return null;
		}
		return str.trim();
	}

	private void write(HttpServletResponse response, String json) throws IOException {
		response.setContentType("text/html"); 
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(json);
		pw.flush();
		pw.close();
	}
	
	
	public void test(){
//		this.newsService.find("234123");
		System.out.println(newsService.toString());
		newsService.delete("12323");
	}
	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-action.xml");
//		NewsAction newsAction =(NewsAction) context.getBean("newsAction");
		String str=  new NewsAction().toTrim("  aaa   ");
		System.out.println(" --------"+str);
		System.out.println("=========="+new NewsAction().toString());//为什么这里可以通过new拿到对象呢
//		newsAction.test();
		
	}

	@Override
	public void setApplication(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
//		application=arg0;
		
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

}
