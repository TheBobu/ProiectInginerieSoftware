<%-- 
    Document   : successfulInterviews
    Created on : Jan 16, 2021, 9:54:29 PM
    Author     : Robert-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style><%@include file="/WEB-INF/css/main.css"%></style>

<t:pageTemplate pageTitle="Jobs">

    <h1 class="mb-4">Proposed Candidates (by Recruiter/Interviewer) for the JobPost <br> ${jobPostTitle}</h1>
    <div class="row">
        <div class="col-md">
            <b>Candidate Name</b>
        </div>

        <div class="col-md">
            <b>Candidate Profile</b>
        </div>

        <div class="col-md">
            <b>Interview details</B>
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
                        <a class="btn btn-secondary" href="${pageContext.request.contextPath}/Profile?id=${interview.candidate.id}" role="button">View profile</a>
                    </div>

                    <div class="col-md">
                        <a class="btn btn-secondary" href="${pageContext.request.contextPath}/Comment?id=${interview.candidate.id}" role="button">View interview history</a>
                    </div>

                    <div class="col-md">
                        <a class="btn btn-success" href="${pageContext.request.contextPath}/Interview/FinalAccept?id=${interview.id}">Final accept</a>
                        <a class="btn btn-danger" href="${pageContext.request.contextPath}/Interview/FinalReject?id=${interview.id}">Final reject</a>
                    </div>
                </div>
            </div>
        </div>
        <br>
    </c:forEach>
</t:pageTemplate>
