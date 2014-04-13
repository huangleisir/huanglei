package com.bao.news.vo;

import java.util.Date;

public class NewsVO {
	private String id;
	private String newsTitle;
	private String title;
	private String content;
	private String author;
	private String wonderful;
	private Date createTime;
	private String createTimeStr;
	private String classId;
	private int clickNum;
	private int replyNum;
	
	public NewsVO(){}
	
	
	public NewsVO(String title, String content,
			String author, String wonderful, Date createTime,
			String classId, int clickNum, int replyNum) {
		super();
		this.title = title;
		this.content = content;
		this.author = author;
		this.wonderful = wonderful;
		this.createTime = createTime;
		this.classId = classId;
		this.clickNum = clickNum;
		this.replyNum = replyNum;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getWonderful() {
		return wonderful;
	}

	public void setWonderful(String wonderful) {
		this.wonderful = wonderful;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateTimeStr() {
		return createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}

	public int getClickNum() {
		return clickNum;
	}

	public void setClickNum(int clickNum) {
		this.clickNum = clickNum;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public int getReplyNum() {
		return replyNum;
	}

	public void setReplyNum(int replyNum) {
		this.replyNum = replyNum;
	}
}
