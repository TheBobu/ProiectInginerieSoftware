<%-- 
    Document   : acceptedByDepDirector
    Created on : Jan 20, 2021, 10:27:27 AM
    Author     : Robert-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style><%@include file="/WEB-INF/css/main.css"%></style>

<t:pageTemplate pageTitle="Jobs">

    <h1 class="mb-4" style="color:white">Final <span style="color:green; background-color:white"> acceptance</span>  list for <br> ${jobPostTitle}</h1>
    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/JobPostsByDepartment" role="button"><<</a>
    <div class="row" style="color:white">
        <div class="col-md">
            <b>Candidate Name</b>
        </div>

        <div class="col-md">
            <b>Candidate's mail</b>
        </div>

        <div class="col-md">
            <b>Candidate Profile</b>
        </div>

        <div class="col-md">
            <b>Final Decision</b>
        </div>
    </div>
    <c:forEach var="interview" items="${interviews}" varStatus="status">
        <div class="card">
            <div class="card-body">
                <div class="row">
                    <div class="col-md">
                        ${interview.candidate.firstName} ${interview.candidate.lastName}
                    </div>

                    <div class="col-md">
                        ${interview.candidate.email}
                    </div>

                    <div class="col-md">
                        <a class="btn btn-secondary" href="${pageContext.request.contextPath}/Profile?id=${interview.candidate.id}" role="button">View profile</a>
                    </div>

                    <div class="col-md">
                        ${interview.status} 
                    </div>
                </div>
            </div>
        </div>
        <br>
    </c:forEach>
</t:pageTemplate>
