<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

<s:url var="url_edit" value="/contact/editContact" />


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>User List - Contact App</title>
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

			<td valign="top"><c:if test="${err!=null}">
					<p class="error">
						<c:out value="${err}" />
					</p>
				</c:if> <c:if test="${param.act eq 'exp' }">
					<p class="error">
						<c:out value="Please select users to perform action!" />
					</p>
				</c:if> <c:if test="${param.act eq 'bd_s' }">
					<p class="success">
						Users Deleted Successfully!!
					</p>
				</c:if> <c:if test="${param.act eq 'ba_s' }">
					<p class="success">
						Users Activated Successfully!!
					</p>
				</c:if> 
				<c:if test="${param.act eq 'bb_s' }">
					<p class="success">
						Users Blocked Successfully!!
					</p>
				</c:if> 
				
			
                 <form action="searchText">
                 <input name="searchString" placeholder="Enter UserName or Email to search" value="<c:out value="${param.searchString}" />" /><input type="submit" value="Find">
                 </form>
                 
                 
                 <form action="<s:url value="/user/bulk_userBlock" />" >
                <button name="action_users" value="activate">Activate Selected Users</button><button name="action_users" value="block">Block Selected Users</button> <button name="action_users" value="delete">Delete Selected Users</button>
				<table border="1">

					<tr>
						<td>Select</td>
						<td>User Name</td>
						<td>Email</td>
						<td>Mobile</td>
						<td>Role</td>
						<td>User status</td>
						<td>Last Login</td>
					</tr>
					<c:if test="${empty listUsers}">
						<tr>
							<td colspan="6" class="error">No Users Found.</td>
						</tr>
					</c:if>

					<c:forEach var="user" items="${listUsers}" varStatus="s">
						<tr>
							<td align="center"><input type="checkbox" name="uid" value="<c:out value="${user.userId}"/>" /></td>
							<td><c:out value="${user.userName}" /></td>
							<td><c:out value="${user.email}" /></td>
							<td><c:out value="${user.mobile}" /></td>
							<td><c:out value="${user.role}" /></td>
							<td><c:out value="${user.active_yn}" /></td>
							<td><c:out value="${user.lastLogin}" /></td>


					</c:forEach>
				</table>
				
				</form>
				
				</td>


		</tr>


		<%-- Footer --%>
		<tr height="25px">
			<td><jsp:include page="include/footer.jsp" /></td>
		</tr>
	</table>
</body>
</html>
