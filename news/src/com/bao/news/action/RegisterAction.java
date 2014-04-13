package com.bao.news.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.bao.news.action.base.PublicAction;
import com.bao.news.service.IUserService;
import com.bao.news.utils.NewsUtil;
import com.bao.news.vo.UserVO;

public class RegisterAction extends PublicAction{
	private IUserService userService;
	
	public void RegistUser() throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		String registName = this.getParm(request, "registName");
		String password = this.getParm(request, "registPw");
		String sex = this.getParm(request, "sex");
		int age = Integer.valueOf(this.getParm(request, "age"));
		String email = this.getParm(request, "email");
		List<UserVO> users = userService.findByName(registName);
		if(users.isEmpty()){
			try {
				UserVO vo = new UserVO( registName, password, sex, age, email, NewsUtil.USER_RIGHT_NORMAL, new Date());
				userService.saveOrUpdate(vo);
				this.write(response, "0");
			} catch (Exception e) {
				e.printStackTrace();
				this.write(response, "Error:"+e.getMessage());
			}
		}else {
			this.write(response, "注册用户已经存在，请更改帐户名！");
		}
	}
	
	
	//获取参数
	public String getParm(HttpServletRequest request,String str){
		return toTrim(request.getParameter(str));
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

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
}
