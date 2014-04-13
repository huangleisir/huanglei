<%@page import="com.bao.news.utils.NewsUtil"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
function deleteNews(newsId){
	if(confirm("您确定要删除此新闻吗？")){
		$.post("delNews.action",{'newsId':newsId},function(data){
			if(data == '0'){
				window.location.reload(true);
			}else {
				alert(data);
			}
		},"text");
	}
}

function editNews(newsId){
	$.post("goEditNewsPage.action",{'newsId':newsId},function(data){
		if(data == '0'){
			window.location="homePage.action?switch=editPublish&newsId=" + newsId;
		}else {
			alert(data);
		}
	},"text");
}
</script>
<div>
<table border="0" style="width:100%;">
<c:forEach items="${news}" var="item">
	<tr>
		<td width="70%">
			${item.newsTitle}
		</td>
		<td width="15%" style="text-align:center;"> 
			<% 
			String currentRight2 = (String)session.getAttribute("CurrentRight");
			if(currentRight2!=null && currentRight2.equals(NewsUtil.USER_RIGHT_ADMIN)){
			%>
			<a href="#" onclick="editNews('${item.id}');" style="text-decoration:underline;color:gray;">编辑</a>
			<a href="#" onclick="deleteNews('${item.id}');" style="text-decoration:underline;color:gray;">删除</a> 
			<%}%>
		</td>
		<td width="15%" style="text-align:center;">
			<span style="color:black;">${item.createTimeStr}</span>
		</td>
	</tr>
</c:forEach>
<tr>
<tr>
<td style="text-align:center;">
<br>
<c:if test="${pageNo>1}">
<a href="#" style="text-decoration:underline;color:black;" onclick="gotoUrl('${pageNo-1}','${flag }','${classId}')">上一页</a>&nbsp;
</c:if>
<c:if test="${pageNo<totalNewsPageCount}">
<a href="#" style="text-decoration:underline;color:black;" onclick="gotoUrl('${pageNo+1}','${flag }','${classId}')">下一页</a>&nbsp;
</c:if>
当前第<span style="color:red;">${pageNo}</span>页 
共<span style="color:red;">${totalNewsPageCount} </span>页
共<span style="color:red;">${totalRecordsCount}</span>条新闻
<input type="text" style="width: 20px;height:20px;" value="${pageNo}" id="page">
<input type="button" value="跳转" style="height:25px;font:10px" onclick="gotoUrl(document.getElementById('page').value,'${flag }','${classId}');">
</td><td></td><td><br></td></tr>
</table></div>
<%-- ${request.news}
<s:property value="#request.news3"/>
<s:iterator value="#request.news2" var="news"  status="status">
	<tr>
		<td>
			<s:property value="#news.id" />
		</td>
		<td>
			<s:property value="#news.title" />
		</td>
		<td>
			<s:property value="#news.content" />
		</td>
	</tr>
</s:iterator>--%>
<s:debug></s:debug> 