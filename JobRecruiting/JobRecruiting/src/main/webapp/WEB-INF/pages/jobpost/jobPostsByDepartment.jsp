<%-- 
    Document   : jobPostsByDepartment
    Created on : Jan 16, 2021, 11:42:34 AM
    Author     : robert
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Jobs">

    <h1 class="mb-4">Jobs posts from my department (${myDepartment})</h1>
    <div class="row">
        <div class="col-md">
            <b>Job Tile</b>
        </div>

        <div class="col-md">
            <b>Posted by</b>
        </div>

        <div class="col-md">
            <b>Details & Edit</B>
        </div>

        <div class="col-md">
            <b>Proposed candidates by Recruiter/Interviewer</b>
        </div>
    </div>
    <c:forEach var="jobPost" items="${jobPosts}" varStatus="status">
        <div class="row">
            <div class="col-md">
                ${jobPost.title}
            </div>

            <div class="col-md">
                ${jobPost.poster}
            </div>

            <div class="col-md">
                <a class="btn btn-secondary" href="${pageContext.request.contextPath}/JobPost/Edit?id=${jobPost.id}" role="button">View Details & Edit</a>
            </div>

            <div class="col-md">
                <a class="btn btn-secondary" href="${pageContext.request.contextPath}/SuccessfulInterviewsForJobPost?id=${jobPost.id}" role="button">See proposed candidates</a>
            </div>
        </div>
        <br>
    </c:forEach>


</t:pageTemplate>
