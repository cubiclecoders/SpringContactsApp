<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>User Login Page</title>
<s:url var="url_css" value="/static/css/style.css" />
<link href="<c:out value="${url_css}"/>" rel="stylesheet" type="text/css">
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
	
			<td valign="top">
				<h1>User Login Form</h1><br>
				<c:if test="${err!=null}">
				<p class="error"><c:out value="${err}"/></p>
				</c:if>
				
				<c:if test="${param.act eq 'lo'}">
				<p class="success">User logout successfully.</p>
				</c:if>
				
				<c:if test="${param.act eq 'reg'}">
				<p class="success">User registered successfully.</p>
				</c:if>
			<form:form action="login" method="post" modelAttribute="loginCommand">
			Email:<form:input path="email"/>
			Password:<form:password path="password"/>
			<button>LogIn</button> | <a href="user/registrationForm">New User</a>
			</form:form>
			
			</td>
		</tr>


		<%-- Footer --%>
		<tr height="25px">
			<td><jsp:include page="include/footer.jsp"/></td>
		</tr>
	</table>
</body>
</html>
