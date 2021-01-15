<%-- 
    Document   : jobAdministration
    Created on : 15-Jan-2021, 18:28:43
    Author     : Andreea Purta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Jobs">

    <h1 class="mb-4">Job Management</h1>
    <c:forEach var="job" items="${jobs}" varStatus="status">
        <div class="row">
            <div class="col-md">
                ${job.title}
            </div>

            <div class="col-md">
                ${job.poster}
            </div>

            <div class="col-md">
                ${job.status}
            </div>
            <div class="col-md">
                <a class="btn btn-secondary" href="${pageContext.request.contextPath}/JobManager?id=${job.id}" role="button">View Job</a>
            </div>
        </div>
    </c:forEach>
</t:pageTemplate>
