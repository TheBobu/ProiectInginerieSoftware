<%-- 
    Document   : userManagement
    Created on : Jan 9, 2021, 1:10:54 PM
    Author     : andrei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style><%@include file="/WEB-INF/css/main.css"%></style>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages" />

<t:pageTemplate pageTitle="Jobs">

    <h1 class="mb-4"><fmt:message key="label.userManagement.title" /></h1>
    <div class="row">
            <div class="col-md">
                <fmt:message key="label.userManagement.username" />
            </div>

            <div class="col-md">
                <fmt:message key="label.userManagement.firstName" />
            </div>

            <div class="col-md">
                <fmt:message key="label.userManagement.lastName" />
            </div>

            <div class="col-md">
                <fmt:message key="label.userManagement.email" />
            </div>

            <div class="col-md">
                <fmt:message key="label.userManagement.position" />
            </div>

            <div class="col-md">
                <fmt:message key="label.userManagement.status" />
            </div>

            <div class="col-md">
                <fmt:message key="label.userManagement.view" />
            </div>
        </div>
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
                <a class="btn btn-secondary" href="${pageContext.request.contextPath}/UserManager?id=${user.id}" role="button"><fmt:message key="label.userManagement.button" /></a>
            </div>
        </div>
    </c:forEach>
</t:pageTemplate>
