<%-- 
    Document   : jobAdministration
    Created on : 15-Jan-2021, 18:28:43
    Author     : Andreea Purta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style><%@include file="/WEB-INF/css/main.css"%></style>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages" />

<t:pageTemplate pageTitle="Jobs">

    <h1 class="mb-4"><fmt:message key="label.jobManagement.title" /></h1>
    <div class="row">
        <div class="col-md">
            <fmt:message key="label.jobManagement.jobTitle" />
        </div>

        <div class="col-md">
            <fmt:message key="label.jobManagement.poster" />
        </div>

        <div class="col-md">
            <fmt:message key="label.jobManagement.status" />
        </div>

        <div class="col-md">
            <fmt:message key="label.jobManagement.view" />
        </div>
    </div>
    <c:forEach var="job" items="${jobs}" varStatus="status">
        <div class="row">
            <div class="col-md">
                ${job.title}
            </div>

            <div class="col-md">
                ${job.poster.username}
            </div>

            <div class="col-md">
                ${job.status}
            </div>
            <div class="col-md">
                <a class="btn btn-secondary" href="${pageContext.request.contextPath}/JobManager?id=${job.id}" role="button"><fmt:message key="label.jobManagement.button" /></a>
            </div>
        </div>
    </c:forEach>
</t:pageTemplate>
