<%@page import="java.util.Map"%>
<%@page import="com.bao.news.utils.NewsUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<% 
	if(session==null || (String)session.getAttribute("CurrentRight")==null || 
		!((String)session.getAttribute("CurrentRight")).equals(NewsUtil.USER_RIGHT_ADMIN) ){
		response.sendRedirect("homePage.action");
	}
%>
<link rel="stylesheet" href="js/dojo-release-1.7.2/dijit/themes/claro/claro.css"/>
<script type="text/javascript" src="js/dojo-release-1.7.2/dojo/dojo.js" djConfig="parseOnLoad:true, isDebug:true"></script>
<script type="text/javascript">
//编辑器组件
dojo.require("dijit.Editor");
//解析器
dojo.require("dojo.parser");
	function publish(){
		var title = $("#title").val();
		var author = $("#author").val();
		var content = dijit.byId('content').getValue();
		var wonderful = $("#wonderful").val();
		var classId = $("#classId").val();
		if(title == ''){
			alert('标题不能为空');
			return;
		}else if(author == ''){
			alert('来源不能为空');
			return;
		}else if(content == ''){
			alert('内容不能为空');
			return;
		}else if(wonderful == ''){
			alert('主要内容不能为空');
			return;
		}
		$.post("doPublishNews.action",{'title':title,'author':author,'content':content,'wonderful':wonderful,'classId':classId},function(data){
			if(data=='0'){
				alert('发布新闻成功！');
				window.location = 'homePage.action?switch=newsList';//难怪我们发布之后页面不能跳转，是没有给switch重新赋值
				reset();
			}else {
				alert(data);
			}
		},"text");
	}
	
	function reset(){
		dijit.byId('content').setValue(null);
		document.forms.pform.reset(); 
		//window.location = "homePage.action?switch=publish";
	}
</script>
<form id="pform" name="pform" action="">
	<table border="0" style="margin-left:20px;margin-top:50px;" class="claro">
		<tr><td></td><td style="text-align:center;"><span style="color:black;font:24px bold;">新闻发布</span><br></td></tr>
		<tr>
			<td><span style="color:black;font:18px bold;">标题:</span></td>
			<td><input id="title" type="text" ></td>
		</tr>
		<tr>
			<td><span style="color:black;font:18px bold;">来源:</span></td>
			<td><input id="author" type="text" ></td>
		</tr>
		<tr>
			<td><span style="color:black;font:18px bold;">类别:</span></td>
			<td>
				<select id="classId">
					<%
					Map<String,String> menus2 = NewsUtil.MenuItems;
					for(String key : menus2.keySet()){
						out.print("<option value='"+key+"'>"+menus2.get(key)+"</option>");
					}
					%>
				</select>
			</td>
		</tr>
		<tr>
			<td><span style="color:black;font:18px bold;">主要内容:</span></td>
			<td>
				<textarea rows="2" cols="85" id="wonderful"></textarea>
			</td>
		</tr>
		<tr>
			<td><span style="color:black;font:18px bold;">内容:</span></td>
			<td>
				<!-- <textarea rows="10" cols="85" id="content"></textarea> -->
				<div style="border: 1px solid #ccc">
				  <textarea id="content" dojoType="dijit.Editor" >
				  </textarea>
				</div>
			</td>
		</tr>
		<tr>
			<td></td>
			<td style="text-align:center;"><br>
				<input type="button" style="height:25px;font:12px" value="发布" onclick="publish();">
				<input type="button" style="height:25px;font:12px" value="重置"  onclick="reset();">
			</td>
		</tr>
	</table>
</form>
