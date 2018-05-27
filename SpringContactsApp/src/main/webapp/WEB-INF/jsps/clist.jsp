<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

<s:url var="url_edit" value="/contact/editContact" />


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Contact List - Contact App</title>
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

			<td valign="top"><c:if
					test="${err!=null}">
					<p class="error">
						<c:out value="${err}" />
					</p>
				</c:if> <c:if test="${param.act eq 'exp' }">
					<p class="error">
						<c:out value="${err}" />
					</p>
				</c:if> <c:if test="${param.act eq 'd_s' }">
					<p class="success">Contact deleted Successfully.</p>
				</c:if>
				
				<c:if test="${param.act eq 'bd_s' }">
					<p class="success">Contacts deleted Successfully.</p>
				</c:if>
				<c:if test="${param.act eq 'upd' }">
					<p class="success">Contact updated Successfully.</p>
				</c:if>
			     <c:if test="${param.searchString eq ''}">
					<p class="error">
						Please enter text to search!!
					</p>
					</c:if>
                 <form action="searchText">
                 <input name="searchString" placeholder="Enter text to search" value="<c:out value="${param.searchString}" />" /><input type="submit" value="Find">
                 </form>
                 
                 
                 <form action="<s:url value="/contact/bulk_contactDelete" />" >
                 
				<table border="1">

					<tr>
						<td>Select</td>
						<td>Contact Name</td>
						<td>Mobile</td>
						<td>Email</td>
						<td>Address</td>
						<td>Action</td>
					</tr>
					<c:if test="${empty listContacts}">
						<tr>
							<td colspan="6" class="error">No Records Found.</td>
						</tr>
					</c:if>

					<c:forEach var="contact" items="${listContacts}" varStatus="s">
						<tr>
							<td align="center"><input type="checkbox" name="cid" value="<c:out value="${contact.contactId}"/>" /></td>
							<td><c:out value="${contact.contactName}" /></td>
							<td><c:out value="${contact.mobile}" /></td>
							<td><c:out value="${contact.email}" /></td>
							<td><c:out value="${contact.address}" /></td>
							
				<s:url var="url_delete" value="/contact/deleteContact">
                  <s:param name="contactId"><c:out value="${contact.contactId}"/></s:param>
                </s:url>
                
                <s:url var="url_edit" value="/contact/editContact">
                <s:param name="cid"><c:out value="${contact.contactId}"/></s:param>
                </s:url>
							<td><a href="<c:out value="${url_edit}"/>">Edit</a> | <a
								href="<c:out value="${url_delete}"/>">Delete</a></td>
						</tr>


					</c:forEach>
				</table>
				<button>Bulk Contact Delete</button>
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
