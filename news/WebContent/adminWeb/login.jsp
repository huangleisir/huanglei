<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
function login(){
	var loginName = $("#loginName").val();
	var Password = $("#Password").val();
	if(loginName == ''){
		alert('帐号不能为空');
	}else if(Password ==''){
		alert('密码不能为空');
	}else {
		$.post("loginPage.action",{'loginName':loginName,'Password':Password},function(data){
			if(data == '0'){
				window.location = "homePage.action";
			}else {
				alert('登录失败,请检查帐号密码！');     //其实在这里可以用Ajax局部刷新
			}
		},"text");
	}
}
</script>
<form action="">
	<table border="0" style="margin-left:200px;margin-top:50px;">
		<tr><td></td><td><span style="color:black;font:24px bold;">用户登录</span><br></td></tr>
		<tr>
			<td><span style="color:black;font:18px bold;">帐号:</span></td>
			<td><input id="loginName" name="user.userName" /> <span style="color:gray;">没有帐号？</span></td>
		</tr>
		<tr>
			<td><span style="color:black;font:18px bold;">密码:</span></td>
			<td>
				<input id="Password" type="password"  name="user.userName"   />
				<a href="homePage.action?switch=regist" style="color:black;text-decoration: underline;">立即注册</a>
			</td>
		</tr>
		<tr>
			<td></td>
			<td>&nbsp;&nbsp;
				<input type="button" style="height:25px;font:12px" value="登录" onclick="login();">
				<input type="reset" style="height:25px;font:12px" value="重置">
			</td>
		</tr>
	</table>
</form>
