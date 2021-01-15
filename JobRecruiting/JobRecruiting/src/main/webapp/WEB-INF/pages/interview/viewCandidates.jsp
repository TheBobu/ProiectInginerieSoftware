<%-- 
    Document   : viewCandidates
    Created on : Jan 15, 2021, 10:26:33 AM
    Author     : Doly
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Candidates">

    <h1 class="mb-4">Candidates</h1>
    <c:forEach var="candidate" items="${candidates}">
        <div class="row">
            <div class="col-md">
                ${candidate.getCandidateFullName()}
            </div>
            
            <div class="col-md">
                ${candidate.jobpost.title}
            </div>
            
            <div class="col-md">
                <a class="btn btn-secondary" href="${pageContext.request.contextPath}/Profile?id=${candidate.candidate.id}" role="button">View profile</a>
            </div>
            
            <div class="col-md"> <%-------------------TO DO---------------------------------%>
                <a class="btn btn-secondary" href="${pageContext.request.contextPath}/Profile?id=${candidate.candidate.id}" role="button">Schedule interview</a>
            </div>
        </div>
    </c:forEach>
</t:pageTemplate>
