<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Admin Dashboard - Contact Application</title>
<link href="<s:url value="/static/css/style.css"/>" rel="stylesheet" type="text/css">
</head>

<body>
	<table border="1" width="100%">
		<%-- Header --%>
		<jsp:include page="include/header.jsp" />

		<%-- Menu --%>
		<tr height="25px">
			<td><jsp:include page="include/menu.jsp" /></td>
		</tr>

		<%-- Content Area --%>
		<tr height="400px">
	
			<td valign="top">	<h1>Admin DashBoard</h1><br>TO DO - Admin option in this page</td>
		</tr>


		<%-- Footer --%>
		<tr height="25px">
			<td><jsp:include page="include/footer.jsp"/></td>
		</tr>
	</table>
</body>
</html>
