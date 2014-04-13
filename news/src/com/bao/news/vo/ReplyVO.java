package com.bao.news.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReplyVO {
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private String id;
	private String newsId;
	private String userId;
	private String userName;
	private String reply;
	private Date createTime;
	private String createTimeStr;

	public ReplyVO(){}
	
	public ReplyVO(String id, String newsId, String userId, String userName,
			String reply,Date createTime) {
		super();
		this.id = id;
		this.newsId = newsId;
		this.userId = userId;
		this.userName = userName;
		this.reply = reply;
		this.createTime = createTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNewsId() {
		return newsId;
	}

	public void setNewsId(String newsId) {
		this.newsId = newsId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateTimeStr() {
		if(createTime != null)
			createTimeStr = sdf.format(this.getCreateTime());
		return createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}

}
