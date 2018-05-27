<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>User Registration Form - Contact App</title>
<s:url var="url_css" value="/static/css/style.css" />
<link href="<c:out value="${url_css}" />" rel="stylesheet"
	type="text/css">
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
			<c:if test="${err!=null}">
					<p class="error">
						<c:out value="${err}" />
					</p>
				</c:if>
			 <form:form action="register" method="post" modelAttribute="command">
					<br>
					<br>
					<table border=1>
						<tr>
							<td colspan="2" align="center">New User Registration</td>
						</tr>
						<tr>
							<td>Name:</td>
							<td><form:input path="user.userName" />
								<form:errors path="user.userName" cssClass="error" /></td>
						</tr>

						<tr>
							<td>Email:</td>
							<td><form:input path="user.email" />
							<form:errors path="user.email" cssClass="error" /></td>
						</tr>

						<tr>
							<td>Password:</td>
							<td><form:password path="user.password" />
							<form:errors path="user.password" cssClass="error" /></td>
						</tr>
						<tr>
							<td>Confirm Password:</td>
							<td><form:password path="confirmPassword" />
							<form:errors path="confirmPassword" cssClass="error" /></td>
						</tr>


						<tr>
							<td>Gender:</td>
							<td><form:radiobutton path="user.gender" value="Male" />Male<form:radiobutton
									path="user.gender" value="Female" />Female
									<form:errors path="user.gender" cssClass="error" /></td>
						</tr>

						<tr>
							<td>Address:</td>
							<td><form:input path="user.address" /><form:errors path="user.address" cssClass="error" /></td>
						</tr>



						<tr>
							<td>Mobile:</td>
							<td><form:input path="user.mobile" /><form:errors path="user.mobile" cssClass="error" /></td>
						</tr>

						<tr>

							<td colspan="2" align="center"><form:button>Submit</form:button><input
								type="reset" value="Reset"></td>
						</tr>
					</table>
				</form:form></td>
		</tr>


		<%-- Footer --%>
		<tr height="25px">
			<td><jsp:include page="include/footer.jsp" /></td>
		</tr>
	</table>
</body>
</html>
