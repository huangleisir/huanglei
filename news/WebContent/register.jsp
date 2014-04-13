<%@page import="com.bao.news.utils.NewsUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
function register(){
	var registName = $("#registName").val();
	var registPw = $("#registPw").val();
	var registPw2 = $("#registPw2").val();
	var sex = $("#sex").val();
	var age = $("#age").val();
	var email = $("#email").val();
	if( registName == ''){
		alert("帐号不能为空");
	}else if( registPw == ''){
		alert("密码不能为空");
	}else if( registPw2 == ''){
		alert("请重复输入密码");
	}else if(registPw != registPw2){
		alert("两次输入的密码不一样！");
	}else if( email == ''){
		alert("邮箱不能为空");
	}else if( !isEmail(email)){
		alert("邮箱不合法");
	}else {
		$.post("doRegistAction.action",{'registName':registName,'registPw':registPw,'sex':sex,'age':age,'email':email},function(data){
			if(data == '0'){
				alert("恭喜您，注册成功！页面将自动跳转至登录页面！");
				window.location = 'homePage.action?switch=login';
			}else {
				alert(data);
			}
		},"text");
	}
}
</script>
<form action="">
	<table border="0" style="margin-left:200px;margin-top:50px;">
		<tr><td></td><td><span style="color:black;font:24px bold;">用户注册</span><br></td></tr>
		<tr>
			<td><span style="color:black;font:18px bold;">帐号:</span></td>
			<td><input id="registName" type="text"> <span style="color:red;">*</span></td>
		</tr>
		<tr>
			<td><span style="color:black;font:18px bold;">密码:</span></td>
			<td>
				<input id="registPw" type="password">
				<span style="color:red;">*</span>
			</td>
		</tr>
		<tr>
			<td><span style="color:black;font:18px bold;">重复密码:</span></td>
			<td>
				<input id="registPw2" type="password">
				<span style="color:red;">*</span>
			</td>
		</tr>
		<tr>
			<td><span style="color:black;font:18px bold;">性别:</span></td>
			<td>
				<select id="sex">
					<option value="<%=NewsUtil.NEWS_SEX_BOY%>">男</option>
					<option value="<%=NewsUtil.NEWS_SEX_GIRL%>">女</option>
				</select>
				<span style="color:red;">*</span>
			</td>
		</tr>
		<tr>
			<td><span style="color:black;font:18px bold;">年龄:</span></td>
			<td>
				<select id="age">
					<% 
						for(String str:NewsUtil.AgesList){
							out.println("<option value="+str+">"+str+"</option>");
						}
					%>
				</select>
				<span style="color:red;">*</span>
			</td>
		</tr>
		<tr>
			<td><span style="color:black;font:18px bold;">邮箱:</span></td>
			<td>
				<input id="email" type="text">
				<span style="color:red;">*</span>
			</td>
		</tr>
		<tr>
			<td></td>
			<td>&nbsp;&nbsp;
				<input type="button" style="height:25px;font:12px" value="注册" onclick="register();">
				<input type="reset" style="height:25px;font:12px" value="重置">
			</td>
		</tr>
	</table>
</form>
