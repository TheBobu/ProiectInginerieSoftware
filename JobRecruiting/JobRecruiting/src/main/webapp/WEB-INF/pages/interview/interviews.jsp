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
            
            <div class="col-md">
                <c:choose>
                    <c:when test="${candidate}">    
                        ${interview.interviewer.getName()}
                    </c:when>
                    <c:otherwise>
                        ${interview.candidate.getName()}
                    </c:otherwise>
                </c:choose>
            </div>
            
            <div class="col-md">
                ${interview.interviewStatus}
            </div>
            
            <div class="col-md">
            <c:choose>
                <c:when test="${interview.isAppliedFor()}">    
                </c:when>
                <c:otherwise>      
                    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/Comment?id=${interview.id}" role="button">View details</a>               
                </c:otherwise>
            </c:choose>
            </div>
            
        </div>
    </c:forEach>
</t:pageTemplate>
