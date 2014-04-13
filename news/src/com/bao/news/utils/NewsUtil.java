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
	
	public static final int NEWS_NEWS_LEFT_PAGESIZE = 25;//���Ĭ��һҳ����
	
	public static final int NEWS_NEWS_RIGHT_PAGESIZE = 10;//�ұ�Ĭ��һҳ����
	
	public static final int NEWS_NEWS_REPLY_PAGESIZE = 10;//�ظ�Ĭ��һҳ����

	public static final int NEWS_LEFT_ROW_LENGTH = 32;//��ҳ�棬���һ��������ʾ����������
	public static final int NEWS_RIGHT_ROW_LENGTH = 20;//��ҳ�棬�ұ�һ��������ʾ����������
	
	public static final String NEWS_SEX_BOY = "0";//ע���û����Ա���
	public static final String NEWS_SEX_GIRL = "1";//ע���û����Ա�Ů
	
	public static final String USER_RIGHT_ADMIN = "0";//����ԱȨ��
	public static final String USER_RIGHT_NORMAL = "1";//��ͨ��ԱȨ��
	/**
	 * 13.11.12
	 * �����ڹ������ж���һ��ȫ�ֵľ�̬������Ų�ѯ�����ܼ�¼����
	 * ��������һ�������п���˳���õ���ֵ�ֲ����㷵�ص�ʱ���ⲻʧΪһ���ð취
	 * ���Ǹ��ö�������������ͨ�������ֵ���Ѵ�����
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
	
	//���Ų˵���<String,String>��ӦΪ<class_id,����>
	//��̬�������ʲôʱ�����
	public static final Map<String,String> MenuItems = new LinkedHashMap<String, String>();
	static {
		MenuItems.put("1", "����");
		MenuItems.put("2", "����");
		MenuItems.put("3", "���");
		MenuItems.put("4", "����");
		MenuItems.put("5", "����");
		MenuItems.put("6", "�ƾ�");
		MenuItems.put("7", "����");
		MenuItems.put("8", "��ʷ");
		MenuItems.put("9", "����");
		MenuItems.put("10", "����");
		MenuItems.put("11", "����");
		MenuItems.put("12", "�Ļ�");
	}
	
	
	//�������ż�¼���HTML����
	//�������ű��ǰ��ı���ͼ��1��2,3Ϊ��ɫ��������ǻ�ɫ
	/**
	 * ���Դ����￴��һ����������������ľ�̬��������ζ����ʹ�õġ�
	 * ������һ���������б���д���ķ�����
	 * @param news   �����б�List����,����ȥ���ǵ�ֵַ��ֱ���ڶ����������޸����Բ���Ҫ����ֵ
	 * @param rowLength ���ű�����ʾ�ĳ���
	 * @param color  ��ʾ���ŵ�������ɫ "#FFDD33"
	 * @param isPre Ϊtrue��ʾ��Ҫ��ʾǰ��ı���ͱ��ⱳ��
	 */
	public static void newsListHandle(List<NewsVO> news,int rowLength,String color,boolean isPre){
		int i = 0;
		for (NewsVO vo : news) {
			i++;
			String title = vo.getTitle();
			if(title.length() > rowLength){
				title = title.substring(0,rowLength) + "...";//�����ⳬ��һ������ʱ�����ǽ�ȡǰ��һ���ֽ�����ʾ
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
											
	//��JSPҳ�������ұߵ�����к��������в���
	public static void setNewsByClickAndReply(  HttpServletRequest  request ,INewsService newsService,NewsVO vo){
		List<NewsVO> news2 = newsService.findByParam(1, NewsUtil.NEWS_NEWS_RIGHT_PAGESIZE, vo, 2);//2�����������
		NewsUtil.newsListHandle(news2, NewsUtil.NEWS_RIGHT_ROW_LENGTH,"blue",true);
		List<NewsVO> news3 = newsService.findByParam(1, NewsUtil.NEWS_NEWS_RIGHT_PAGESIZE, vo, 3);//3������������
		NewsUtil.newsListHandle(news3, NewsUtil.NEWS_RIGHT_ROW_LENGTH,"blue",true);
		request.setAttribute("news2", news2);
		request.setAttribute("news3", news3);
	}
	
	// ��ҳ��ѯ
	public static List pageQuery(Query query, int pageNo, int pageSize) {
		if (pageNo > 0 && pageSize > 0) {
			query.setFirstResult((pageNo - 1) * pageSize);
			query.setMaxResults(pageSize);
		}
		return query.list();
	}
}
