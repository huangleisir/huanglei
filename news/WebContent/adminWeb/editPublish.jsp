<%@page import="com.bao.news.vo.NewsVO"%>
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
		var newsId = $("#newsId").val();
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
		$.post("editNews.action",{'newsId':newsId,'title':title,'author':author,'content':content,'wonderful':wonderful,'classId':classId},function(data){
			if(data=='0'){
				alert('新闻编辑成功！');
			}else {
				alert(data);
			}
		},"text");
	}
	
	function reset(){
		document.forms.pform.reset(); 
	}
	
</script>
<form id="pform" name="pform" action="" >
	<table border="0" style="margin-left:20px;margin-top:50px;" class="claro">
		<tr><td></td><td style="text-align:center;"><span style="color:black;font:24px bold;">新闻编辑</span><br></td></tr>
		<tr>
			<td><span style="color:black;font:18px bold;">标题:</span><input type="hidden" id="newsId" value="${detail.id}"></td>
			<td><input id="title" type="text" value="${detail.title }"></td>
		</tr>
		<tr>
			<td><span style="color:black;font:18px bold;">来源:</span></td>
			<td><input id="author" type="text" value="${detail.author }" ></td>
		</tr>
		<tr>
			<td><span style="color:black;font:18px bold;">类别:</span></td>
			<td>
				<select id="classId">
					<%
					NewsVO news = (NewsVO)request.getAttribute("detail");
					Map<String,String> menus2 = NewsUtil.MenuItems;
					for(String key : menus2.keySet()){
						String str = "<option value='"+key+"' ";
						if(news.getClassId().equals(key)){
							str += " selected=\"selected'\"";
						}
						str += ">"+menus2.get(key)+"</option>";
						out.print(str);
					}
					%>
				</select>
			</td>
		</tr>
		<tr>
			<td><span style="color:black;font:18px bold;">主要内容:</span></td>
			<td>
				<textarea rows="2" cols="85" id="wonderful" >${detail.wonderful }</textarea>
			</td>
		</tr>
		<tr>
			<td><span style="color:black;font:18px bold;">内容:</span></td>
			<td>
				<!-- <textarea rows="10" cols="85" id="content"></textarea> -->
				<div style="border: 1px solid #ccc">
				  <textarea id="content" dojoType="dijit.Editor" >${detail.content }</textarea>
				</div>
			</td>
		</tr>
		<tr>
			<td></td>
			<td style="text-align:center;"><br>
				<input type="button" style="height:25px;font:12px" value="编辑" onclick="publish();">
				<input type="button" style="height:25px;font:12px" value="重置"  onclick="reset();">
			</td>
		</tr>
	</table>
</form>
