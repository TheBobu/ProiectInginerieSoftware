<%-- 
    Document   : jobPostsByDepartment
    Created on : Jan 16, 2021, 11:42:34 AM
    Author     : robert
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style><%@include file="/WEB-INF/css/main.css"%></style>

<t:pageTemplate pageTitle="Jobs">
     
    <h1 class="mb-4" style="color:white">Jobs posts from my department (${myDepartment})</h1>

    <div class="row" style="color:white">
        <div class="col-md">
            <b>Job Title</b>
        </div>

        <div class="col-md">
            <b>Posted by</b>
        </div>
        
        <div class="col-md">
            <b>Filled positions</b>
        </div>

        <div class="col-md">
            <b>Details & Edit</B>
        </div>

        <div class="col-md">
            <b>Proposed candidates by Recruiter/Interviewer</b>
        </div>
        
        <div class="col-md">
            <b>Accepted by me</b>
        </div>
        
        <div class="col-md">
            <b>Rejected by me</b>
        </div>
    </div>
    <c:forEach var="jobPost" items="${jobPosts}" varStatus="status">
        <div class="card">
            <div class="card-body">
                <div class="row">
                    <div class="col-md">
                        ${jobPost.title}
                    </div>

                    <div class="col-md">
                        ${jobPost.poster.name}
                    </div>
                    
                    <div class="col-md">
                        ${jobPost.noOfPositionsFilled} / ${jobPost.noOfPositionsAvailable}
                    </div>

                    <div class="col-md">
                        <a class="btn btn-secondary" href="${pageContext.request.contextPath}/JobPost/Edit?id=${jobPost.id}" role="button">View Details & Edit</a>
                    </div>

                    <div class="col-md">
                        <a class="btn btn-secondary" href="${pageContext.request.contextPath}/SuccessfulInterviewsForJobPost?id=${jobPost.id}" role="button">See proposal list</a>
                    </div>
                    
                    <div class="col-md">
                        <a class="btn btn-success" href="${pageContext.request.contextPath}/AcceptedByDepDirector?id=${jobPost.id}" role="button">See acceptance list</a>
                    </div>
                    
                    <div class="col-md">
                        <a class="btn btn-danger" href="${pageContext.request.contextPath}/RejectedByDepDirector?id=${jobPost.id}" role="button">See rejection list</a>
                    </div>
                </div>
            </div>
        </div>
        <br>
    </c:forEach>


</t:pageTemplate>
