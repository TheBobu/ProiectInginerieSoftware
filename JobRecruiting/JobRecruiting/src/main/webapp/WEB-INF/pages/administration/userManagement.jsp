<%-- 
    Document   : userManagement
    Created on : Jan 9, 2021, 1:10:54 PM
    Author     : andrei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Jobs">

    <h1 class="mb-4">User Management</h1>
    <c:forEach var="user" items="${users}" varStatus="status">
        <div class="row">
            <div class="col-md">
                ${user.username}
            </div>

            <div class="col-md">
                ${user.firstName}
            </div>

            <div class="col-md">
                ${user.lastName}
            </div>

            <div class="col-md">
                ${user.email}
            </div>

            <div class="col-md">
                ${user.position}
            </div>

            <div class="col-md">
                ${user.status}
            </div>

            <div class="col-md">
                <a class="btn btn-secondary" href="${pageContext.request.contextPath}/UserManager?id=${user.id}" role="button">View User</a>
            </div>
        </div>
    </c:forEach>
</t:pageTemplate>
