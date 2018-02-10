<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<!-- Bootstrap core CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery-1.6.js" type="text/javascript"></script>
<script src="js/jquery.myPagination.js" type="text/javascript"></script>
<style type="text/css">
        .table1{
            border:1px solid #ddd;
            width:900px;
            
        }
        thead{
            background-color:lightblue;
        }

    </style>
<body>
<table border="0" width="900px" >
<tr>
<td align="center" style="font-size:24px; color:#666"> 人员管理</td>
</tr>
<tr>
<td align="right" > <a href="${pageContext.request.contextPath}/person/addPrompt">添加</a></td>
</tr>
</table>
<br/>
<table  class="table1">
<thead>
   <tr>
    	<th width="300">姓名</th>
    	<th width="300">身份证号</th>
    	<th width="300">电话</th>
    	<th width="300">地址</th>
   		<th  width="300">编辑</th>
   		<th  width="300">删除</th>
   </tr>
</thead>
<tbody>

<c:forEach var="p" items="${requestScope.persons }">
	<tr>
		<td align="center">${p.name }</td>
		<td align="center">${p.idCard }</td>
		<td align="center">${p.phone }</td>
		<td align="center">${p.address }</td>
		<td align="center">
			<a href="${pageContext.request.contextPath}/person/updatePrompt?id=${p.id}"><img src="<%=basePath %>images/编辑.png"></a>
		</td>
		<td align="center">
			<a href="${pageContext.request.contextPath}/person/deletePersonbyId?id=${p.id}" onclick='return confirm("确认要删除吗?")'><img src="<%=basePath %>images/trash.gif"></a>
		</td>
	</tr>
</c:forEach>
</tbody>
</table>
<br/>


</body>

</html>