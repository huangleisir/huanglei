package com.bao.news.utils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Query;
import com.bao.news.service.INewsService;
import com.bao.news.vo.NewsVO;
public class NewsUtil {
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd HH:mm");
	
	public static final int NEWS_NEWS_LEFT_PAGESIZE = 25;//左边默认一页数量
	
	public static final int NEWS_NEWS_RIGHT_PAGESIZE = 10;//右边默认一页数量
	
	public static final int NEWS_NEWS_REPLY_PAGESIZE = 10;//回复默认一页数量

	public static final int NEWS_LEFT_ROW_LENGTH = 32;//首页面，左边一行新闻显示的数字数量
	public static final int NEWS_RIGHT_ROW_LENGTH = 20;//首页面，右边一行新闻显示的数字数量
	
	public static final String NEWS_SEX_BOY = "0";//注册用户，性别：男
	public static final String NEWS_SEX_GIRL = "1";//注册用户，性别：女
	
	public static final String USER_RIGHT_ADMIN = "0";//管理员权限
	public static final String USER_RIGHT_NORMAL = "1";//普通会员权限
	/**
	 * 13.11.12
	 * 我们在公共类中定义一个全局的静态变量存放查询到的总记录数，
	 * 当我们在一个方法中可以顺表拿到的值又不方便返回的时候，这不失为一个好办法
	 * 真是个好东西，否则用普通变量这个值很难传出来
	 */
	public static int totalNewsPageCount = 0;
	
	public static int totalRecordsCount=0;
	public static int totalReplyPageCount=0;
	
	public static final List<String> AgesList = new ArrayList<String>();
	static{
		for (int i = 1; i < 120; i++) {
			AgesList.add(String.valueOf(i));
		}
	}
	
	//新闻菜单栏<String,String>对应为<class_id,名称>
	//静态代码块在什么时候加载
	public static final Map<String,String> MenuItems = new LinkedHashMap<String, String>();
	static {
		MenuItems.put("1", "国内");
		MenuItems.put("2", "国际");
		MenuItems.put("3", "社会");
		MenuItems.put("4", "军事");
		MenuItems.put("5", "娱乐");
		MenuItems.put("6", "财经");
		MenuItems.put("7", "体育");
		MenuItems.put("8", "历史");
		MenuItems.put("9", "房产");
		MenuItems.put("10", "汽车");
		MenuItems.put("11", "健康");
		MenuItems.put("12", "文化");
	}
	
	
	//生成新闻记录点击HTML代码
	//生成新闻编号前面的背景图，1，2,3为红色，后面的是灰色
	/**
	 * 可以从这里看看一般来讲公共类下面的静态方法是如何定义和使用的。
	 * 下面是一个对新闻列表进行处理的方法。
	 * @param news   新闻列表List集合,传进去的是地址值，直接在对象上做了修改所以不需要返回值
	 * @param rowLength 新闻标题显示的长度
	 * @param color  显示新闻的字体颜色 "#FFDD33"
	 * @param isPre 为true表示需要显示前面的标题和标题背景
	 */
	public static void newsListHandle(List<NewsVO> news,int rowLength,String color,boolean isPre){
		int i = 0;
		for (NewsVO vo : news) {
			i++;
			String title = vo.getTitle();
			if(title.length() > rowLength){
				title = title.substring(0,rowLength) + "...";//当标题超过一定长度时，我们截取前面一部分进行显示
			}
			String image = "01.gif";
			if(i>3)image = "02.gif";
			String url = "";
			if(isPre){
				url = "<span style='color:white;background:url(images/"+image+") no-repeat;'>";
				if(i<10)url += "&nbsp;";
				url += i+"</sapn>";
			}
			url += "<a href='homePage.action?switch=detail&newsId="+vo.getId()+"' " +
				   " style='margin-left:10px;text-decoration:underline;color:"+color+
				   ";' target='_blank' title='"+vo.getTitle()+"'>"+title+"</a>";
			vo.setNewsTitle(url);
			vo.setCreateTimeStr(sdf.format(vo.getCreateTime()));
		}
	}
											
	//往JSP页面设置右边点击排行和评论排行参数
	public static void setNewsByClickAndReply(  HttpServletRequest  request ,INewsService newsService,NewsVO vo){
		List<NewsVO> news2 = newsService.findByParam(1, NewsUtil.NEWS_NEWS_RIGHT_PAGESIZE, vo, 2);//2按点击量排序
		NewsUtil.newsListHandle(news2, NewsUtil.NEWS_RIGHT_ROW_LENGTH,"blue",true);
		List<NewsVO> news3 = newsService.findByParam(1, NewsUtil.NEWS_NEWS_RIGHT_PAGESIZE, vo, 3);//3按评论量排序
		NewsUtil.newsListHandle(news3, NewsUtil.NEWS_RIGHT_ROW_LENGTH,"blue",true);
		request.setAttribute("news2", news2);
		request.setAttribute("news3", news3);
	}
	
	// 分页查询
	public static List pageQuery(Query query, int pageNo, int pageSize) {
		if (pageNo > 0 && pageSize > 0) {
			query.setFirstResult((pageNo - 1) * pageSize);
			query.setMaxResults(pageSize);
		}
		return query.list();
	}
}
