package com.bao.news.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bao.news.action.base.PublicAction;
import com.bao.news.service.IUserService;
import com.bao.news.vo.UserVO;


public class LoginAction extends PublicAction implements RequestAware,SessionAware,ApplicationAware {
	private IUserService userService;
	private UserVO user;
	private Map<String, Object> session;
	private Map<String, Object> request;
	private Map<String, Object> application;
	HttpServletResponse response = ServletActionContext.getResponse();
	
	public UserVO getUser() {
		return user;
	}

	public void setUser(UserVO user) {
		this.user = user;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
		System.out.println("********************"+this.userService);
	}
	
	public String login() throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
//		HttpServletRequest request = ServletActionContext.getRequest();
//		HttpSession session = request.getSession();
//		String name = toTrim(request.getParameter("loginName"));
		String name = toTrim(user.getUserName());
		
//		String password = toTrim(request.getParameter("Password"));
		String password = toTrim(user.getPassword());
		System.out.println(name+"=========="+password);
		List<UserVO> users = userService.findByName(name);
		UserVO vo = users.get(0);
		if(users.isEmpty()){
			this.write(response, "1");//登录失败
		}else {
			
			if(vo.getPassword().equals(password)){//一旦确认用户名和密码准确无误，马上存入session
//				HttpSession session = request.getSession();
				session.put("CurrentID", vo.getId());
				session.put("CurrentName", vo.getUserName());
				session.put("CurrentRight", vo.getFlag());
				
				
				this.write(response, "0");//登录成功  给Jquery回调函数的一个响应
				
//				if(vo.getFlag()=="0"){
//					
//					return  "manager";
//					
//				}
				
				
			}else {
				this.write(response, "1");//登录失败
			}
		}
		return SUCCESS;
	}
	
	public void LoginOut()throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		request.getSession().invalidate();
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

	@Override
	public void setApplication(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		session=arg0;
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-action.xml");
		
		LoginAction loginAction =(LoginAction) context.getBean("loginAction");
//		User user=userDao.findUserById("1");
//		System.out.println(user.getId());
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("userName", "a");
		request.setAttribute("Password", "a");
		String str=null;
		try {
			str = loginAction.login();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(str);
	}
	
}
