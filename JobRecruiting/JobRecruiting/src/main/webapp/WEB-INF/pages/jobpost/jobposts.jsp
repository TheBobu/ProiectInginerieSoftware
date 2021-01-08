<%-- 
    Document   : jobpostings
    Created on : Jan 3, 2021, 9:56:51 PM
    Author     : DENISA
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Jobs">

    <h1 class="mb-4">Jobs posts</h1>
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/JobPost/Create">create</a>
    <div class="row row-cols-1 row-cols-md-2 g-4 mt-4">
        <c:forEach var="jobpost" items="${jobPosts}">
            <div class="col">
                <t:card 
                title="${jobpost.title}" 
                description="${jobpost.description}" 
                viewLink="${pageContext.request.contextPath}/JobPost?id=${jobpost.id}"
                deleteLink="${pageContext.request.contextPath}/JobPost?id=${jobpost.id}"
                editLink="${pageContext.request.contextPath}/JobPost/Edit?id=${jobpost.id}"
               />
            </div>
        </c:forEach>
    </div>
</t:pageTemplate>