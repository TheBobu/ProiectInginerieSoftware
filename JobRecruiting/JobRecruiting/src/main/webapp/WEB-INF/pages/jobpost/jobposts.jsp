<%-- 
    Document   : jobpostings
    Created on : Jan 3, 2021, 9:56:51 PM
    Author     : DENISA
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style><%@include file="/WEB-INF/css/main.css"%></style>
<style><%@include file="/WEB-INF/css/jobs.css"%></style>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages" />

<t:pageTemplate pageTitle="Jobs">

    <!-- Team item -->
    <div class="job-container"> 
    <t:filterJobPostForm/>
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/JobPost/Create"><fmt:message key="label.jobPosts.create" /></a>
    <div class="row row-cols-1 row-cols-md-2 g-4 mt-4">
        <c:forEach var="jobpost" items="${jobPosts}">
            <div class="col">
                <t:jobCard 
                    title="${jobpost.title}" 
                    description="${jobpost.description}" 
                    salary="${jobpost.salary}" 
                    type="${jobpost.type.label}"
                    viewLink="${pageContext.request.contextPath}/JobPost?id=${jobpost.id}"
                    deleteLink="${pageContext.request.contextPath}/JobPost?id=${jobpost.id}"
                    editLink="${pageContext.request.contextPath}/JobPost/Edit?id=${jobpost.id}"
                    />
            </div>
        </c:forEach>
    </div>
    </div>
</t:pageTemplate>
