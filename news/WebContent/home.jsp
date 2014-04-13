<%@page import="java.util.*"%>
<%@page import="com.bao.news.utils.NewsUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<%	
	String path = request.getContextPath();	
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()	+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>新闻信息推荐系统</title>
	<link rel="stylesheet" type="text/css" href="css/common.css">
	<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="js/common.js"></script>
	<script type="text/javascript">
		$(function(){
			
		});
		function gotoUrl(pageNo,flag,classId){//pageNo页码、flag排序标识(1按时间顺序，2按点击量，3按评论量)、classId新闻类别
			var url = 'homePage?pageNo='+pageNo+'&classId='+classId+'&flag='+flag+'&search=' + encodeURI(encodeURI(document.getElementById('search').value));
			window.location = url;
		}
		function loginOut(){
			if(confirm("您确定要退出系统吗？")){
				$.post("loginoutPage.action",{},function(data){
					window.location = 'homePage.action';
				},"text");
			}
		}
		function guanggao(){
			alert('广告提示：欢迎来到新闻信息发布系统!');
		}
		document.onkeydown=function(){  
       if (event.keyCode == 27) {  
       		loginOut();
       }  
   } 
		
		
	</script>
	</head>
<body id="body" >
<center>
<table id="t" border="0" >
<tr>
<td style="text-align:right;padding-right:5px;background: url('images/bolder.jpg') repeat-x;">
<%
	String currentName = (String)session.getAttribute("CurrentName");
	String currentRight = (String)session.getAttribute("CurrentRight");
	if(currentName==null){
	%>
		&nbsp;<a href="homePage.action?switch=login" style="color:black;text-decoration:underline;">登录</a>
		&nbsp;<a href="homePage.action?switch=regist" style="color:black;text-decoration:underline;">注册</a>
<%}else{%>
	&nbsp;欢迎光临：<span style="font-weight:bold;"><%=currentName %></span>
<%if(currentRight.equals(NewsUtil.USER_RIGHT_ADMIN)){%>
	&nbsp;<a href="homePage.action?switch=publish" style="color:black;text-decoration:underline;">新闻发布</a>
<%}%>
	&nbsp;<a href="javascript:loginOut();" style="color:black;text-decoration:underline;" id="logout">退出</a>
<%} %>
&nbsp;
</td></tr>
<tr><td><a href="javascript:guanggao()"><img alt="广告" src="images/top.jpg" ></a></td></tr>
<tr style="height:40px;">
<td style="text-align:left;vertical-align:middle;background: url('images/bolder2.jpg') repeat-x;">
<div>
<span style="margin-left:10px;margin-right:10px;">

<a href='#' style='color:black;text-decoration: underline;' onclick='gotoUrl(1,1,"");'>首页</a>
<%
	Map<String,String> menus = NewsUtil.MenuItems;
	for(String key:menus.keySet()){
		out.print("&nbsp;|&nbsp<a href='#' style='color:black;text-decoration: underline;' onclick='gotoUrl(1,1,"+key+");'>"+menus.get(key)+"</a>");
	}
%>
</span><span style="float:right;margin-right:10px;" >
<input type="text" id="search" style="width:150px;height:20px;" value="${search}">
<input type="button" onclick="gotoUrl('${pageNo}','1','');" value="搜索" style="height:25px;font:12px">
</span> 
</div>
</td></tr>
<tr><td ><table border="0" width="100%" align="left" style="color:black;text-align:left;border: 1px solid #CCCCFF;"><tr><td>
当前位置:新闻>>
<a href="#" style="color:black;text-decoration: underline;" onclick="gotoUrl('1','1','${classId}');">${className}</a>>>
</td></tr></table></td></tr>
<tr><td>
<table border="0" style="bolder:0px;" width="100%">
<tr>
<td width="680" height="100%" style="color:blue;text-align:left;border: 1px solid #CCCCFF;vertical-align :top;padding:18px;">

<div style="height:100%;" >
<c:choose>
		<c:when test="${switchPage == 'login' }">
		<%@include file="login.jsp" %>
		</c:when>
		<c:when test="${switchPage == 'regist' }">
		<%@include file="register.jsp" %> 
		</c:when>
		<c:when test="${switchPage == 'publish' }">
		<%@include file="publish.jsp" %> 
		</c:when>
		<c:when test="${switchPage == 'detail' }">
		<%@include file="detail.jsp" %>
		</c:when>
		<c:when test="${switchPage == 'editPublish' }">
		<%@include file="editPublish.jsp" %>
		</c:when>
	<%-- switch为其他值的时候显示新闻列表--%>	 
		<c:otherwise>
		<%@include file="news.jsp" %> 
		</c:otherwise>
</c:choose>
</div>
<br></td>
<td width="302" style="color:blue;text-align:left;border: 0px solid #CCCCFF;vertical-align :top;">
<div style="color:black;font:18px bold font-family:Tahoma,Verdana,微软雅黑,新宋体;border: 1px solid #CCCCFF;">
>>点击排行榜:<a style="color:gray; " href="#" onclick="gotoUrl('1','2','');">&nbsp;>>more..</a>
</div>
<hr color="#CCCCFF" >
<div style="border: 1px solid #CCCCFF;">
<div>
<c:forEach items="${news2}" var="item2" varStatus="i">          
	<div <c:if test="${i.index%2==1}" >style="background-color:pink;"</c:if> >${item2.newsTitle}</div>
</c:forEach>
</div>
</div>
<a href="javascript:guanggao()"><img src="images/gg.jpg"></a>
<div style="color:black;font:18px bold font-family:Tahoma,Verdana,微软雅黑,新宋体;border: 1px solid #CCCCFF;">
&nbsp;>>热评排行榜:<a style="color:gray;" href="#" onclick="gotoUrl('1','3','');">&nbsp;>>more..</a>
</div>
<hr color="#CCCCFF" >
<div style="border: 1px solid #CCCCFF;">
		<c:forEach items="${news3}" var="item3" varStatus="i">
			<div <c:if test="${i.index%2==1}">style="background-color:#dddddd;"</c:if>  >${item3.newsTitle}</div>
		</c:forEach>
</div>
<a href="javascript:guanggao()"><img src="images/gg1.jpg"></a>
</td>
</tr>
</table>
</td></tr>
</table>
<br>
<hr style="color:gray;">
<%@ include file="foot.jsp" %>
<br>
</center>
<s:debug />
</body>
</html>