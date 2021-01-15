<%-- 
    Document   : userManager
    Created on : Jan 13, 2021, 8:09:38 PM
    Author     : Deea
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="User">

    <h1 class="mb-4">User Management</h1>
    <h3>${username}</h3>
    <form method="POST" action="${pageContext.request.contextPath}/UserManager">
        <select name="position" id="position">
            <c:forEach var="position" items="${positions}" varStatus="status">
                <option value="${position}" ${user.position eq position? 'selected':''}>${position}</option>
            </c:forEach>
        </select>
        <input type="hidden" name="id" value="${user.id}">
        <input type="submit">
    </form>
    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/UserActivator?id=${user.id}" role="button">Activate User</a>
    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/UserDeactivator?id=${user.id}" role="button">Deactivate User</a>

    <form method="POST" action="${pageContext.request.contextPath}/PasswordReseter">
        <input type="hidden" name="id" value="${user.id}">
        <input type="submit" value="Send Reset password link">
    </form>
</t:pageTemplate>
