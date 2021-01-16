<%-- 
    Document   : inerviews
    Created on : Jan 14, 2021, 1:39:31 PM
    Author     : Doly
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Interviews">

    <h1 class="mb-4">Interviews</h1>
    <c:forEach var="interview" items="${interviews}">
        <div class="row">
            <div class="col-md">
                ${interview.jobpost.title}
            </div>
            
            <c:choose>
                <c:when test="${pageContext.request.isUserInRole(CandidateRole)}">
                </c:when>
                <c:otherwise>
                    <div class="col-md">
                        ${interview.getCandidateFullName()}
                    </div>
                </c:otherwise>
            </c:choose>
            
            <div class="col-md">
                ${interview.interviewStatus}
            </div>
        </div>
    </c:forEach>
</t:pageTemplate>
