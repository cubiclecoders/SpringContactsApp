<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Add Contact Page</title>
<s:url var="url_css" value="/static/css/style.css" />
<link href="<c:out value="${url_css}"/>" rel="stylesheet"
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
				<h1>Add Contact Form</h1> <br> <c:if test="${err!=null}">
					<p class="error">
						<c:out value="${err}" />
					</p>
				</c:if> <c:if test="${param.act eq 'sv'}">

					<p class="success">Contact added successfully.</p>
				</c:if> <form:form action="saveContact" method="post"
					modelAttribute="contactCommand">
					<table border=1>
						<tr>
							<td colspan="2" align="center">Add Contact(TO DO: Displaying messages through Exception handling)</td>
						</tr>

						<tr>
							<td>Contact Name:</td>
							<td><form:input path="contactName"/><form:errors path="contactName" cssClass="error"/></td>
						</tr>
						<tr>
							<td>Mobile:</td>
							<td><form:input path="mobile"/><form:errors path="mobile" cssClass="error"/></td>
						</tr>
						<tr>
							<td>Email:</td>
							<td><form:input path="email"/><form:errors path="email" cssClass="error"/></td>
						</tr>
						<tr>
							<td>Address:</td>
							<td><form:input path="address"/><form:errors path="address" cssClass="error"/></td>
						</tr>
						<tr>
							<td colspan="2" align="center"><button>Save</button></td>
						<tr>
					</table>

				</form:form>

			</td>
		</tr>


		<%-- Footer --%>
		<tr height="25px">
			<td><jsp:include page="include/footer.jsp" /></td>
		</tr>
	</table>
</body>
</html>
