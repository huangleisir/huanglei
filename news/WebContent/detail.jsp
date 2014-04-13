<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
function doreply(){
	var newsId = '${detail.id}';
	var repcontent = $("#repcontent").val();
	if(repcontent==''){
		alert('亲，要输入回复内容哦!');
		return false;
	}
	$.post("doReply.action",{'newsId':newsId,'repcontent':repcontent},function(data){
		if(data == '0'){
			alert('恭喜您，回复成功！');
			window.location = 'homePage.action?switch=detail&newsId=' + newsId;
		}else {
			alert(data);
		}
	},"text");
}
</script>
<form action="">
	<table border="0" width="100%" style="padding:10px;">
		<tr><td style="text-align:center;">
			<span style="text-align:center;color:black;font-size:18px;font-weight:bold;">${detail.title}</span>
		<br></td></tr>
		<tr><td style="text-align:center;color:gray;">来源:${detail.author }&nbsp;&nbsp;&nbsp;时间:${detail.createTimeStr}</td></tr>
		<tr>
			<td style="">
				<div style="color:gray;font:18px bold font-family:Tahoma,Verdana,微软雅黑,新宋体;border: 1px solid #CCCCFF;padding:2px;">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${detail.wonderful }
				</div>
			</td>
		</tr>
		<tr><td>
		<div style="color:black;font:18px bold font-family:Tahoma,Verdana,微软雅黑,新宋体;">
		${detail.content }
		</div>
		</td></tr>
		<tr><td><br><hr><br>
			<table style="color:black;width:100%;border: 1px solid #CCCCFF;">
				<tr>
					<td style="font-weight:bold;">
						讨论吧
					</td>
				</tr>
				<tr>
					<td style="text-align:center;">
						<textarea id="repcontent" rows="" cols="" style="width: 98%;" ></textarea>
					</td>
				</tr>
				<tr>
					<td style="text-align:right;">
						<input type="button" value="发布" onclick="doreply();" style="margin-right:10px;height:25px;font:12px">
					</td>
				</tr>
				<c:forEach items="${replys}" var="rep" varStatus="status">
					<tr style="margin:10px;">
						<td style="text-align:left;border: 1px solid #CCCCFF;">
							${ 10*(repPageNo-1) + (status.index+1)}楼&nbsp;&nbsp;<span style="font-weight:bold;">${rep.userName }</span>&nbsp;&nbsp;${rep.createTimeStr}
							<br>&nbsp;&nbsp;&nbsp;${rep.reply}
						</td>
					</tr>
				</c:forEach>
				<tr>
					<td style="text-align:center;margin:10px;"><br>
						<c:if test="${repPageNo>1}">
								<a href="homePage.action?switch=detail&newsId=${detail.id}&repPageNo=${repPageNo-1}" style="text-decoration:underline;color:black;" >上一页</a>&nbsp;
						</c:if>
						<c:if test="${repPageNo<totalPageCount}">
								<a href="homePage.action?switch=detail&newsId=${detail.id}&repPageNo=${repPageNo+1}" style="text-decoration:underline;color:black;" >下一页</a>&nbsp;
						</c:if>		
								共<span style="color:red;">${totalRecordsCount}</span>条回复
								共<span style="color:red;">${totalPageCount}</span>页
								<input type="text" style="width: 20px;height:20px;" value="${repPageNo}" id="repPage">
								<input type="button" value="跳转" style="height:25px;font:10px" 
									onclick="window.location='homePage.action?switch=detail&newsId=${detail.id}&repPageNo='+document.getElementById('repPage').value"><br><br>
					</td>
				</tr>
			</table>
		</td></tr>
		
	</table>
</form>
