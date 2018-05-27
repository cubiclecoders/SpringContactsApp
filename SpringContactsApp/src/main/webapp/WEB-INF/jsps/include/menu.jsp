<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<spring:url var="url_logout" value="/logout"/>
<spring:url var="url_home_guest" value="/index"/>
<spring:url var="url_register_user" value="/user/registrationForm"/>
<spring:url var="url_home_user" value="/user/dashboard_user"/>
<spring:url var="url_home_admin" value="/admin/dashboard_admin"/>
<spring:url var="url_add_contact" value="/contact/createContact"/>
<spring:url var="url_list_contacts" value="/contact/clist"/>
<spring:url var="url_list_users" value="/user/userList"/>

<c:if test="${sessionScope.userId==null}">
<%--User is not logged in, Guest User --%>

<a href="<c:out value="${url_home_guest}"/>">Home</a>|<a href="<c:out value="${url_home_guest}"/>">Login</a>|<a href="<c:out value="${url_register_user}"/>">Register</a>|<a href="#">About</a>|<a href="#">Help</a>
</c:if>

<%--Admin user is logged in--%>
<c:if test="${sessionScope.userId!=null && sessionScope.role eq 'admin'}">
<a href="<c:out value="${url_home_admin}"/>">Home</a>|<a href="<c:out value="${url_list_users}"/>">User List</a>|<a href="<c:out value="${url_logout}"/>">Logout</a>

</c:if>

<%--General user is logged in--%>
<c:if test="${sessionScope.userId!=null && sessionScope.role eq 'user'}">
<a href="<c:out value="${url_home_user}"/>">Home</a>|<a href="<c:out value="${url_add_contact}" />">Add Contact</a>|<a href="<c:out value="${url_list_contacts}"/>">Contact List</a>|<a href="<c:out value="${url_logout}"/>">Logout</a>

</c:if>