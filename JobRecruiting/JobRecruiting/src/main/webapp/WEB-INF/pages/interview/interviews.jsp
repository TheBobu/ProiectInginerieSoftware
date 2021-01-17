<%-- 
    Document   : inerviews
    Created on : Jan 14, 2021, 1:39:31 PM
    Author     : Doly
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style><%@include file="/WEB-INF/css/main.css"%></style>
<style><%@include file="/WEB-INF/css/management.css"%></style>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages" />

<t:pageTemplate pageTitle="Interviews">

  
 <div class="container-management">
    <c:forEach var="interview" items="${interviews}">
        <div class="row">
            <div class="col-md">
                ${interview.jobpost.title}
            </div>
            
            <div class="col-md">
                <c:choose>
                    <c:when test="${candidate}">    
                        ${interview.getInterviewerFullName()}
                    </c:when>
                    <c:otherwise>
                        ${interview.getCandidateFullName()}
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
                        <a class="btn btn-secondary" href="${pageContext.request.contextPath}/Comment?id=${interview.id}" role="button"><fmt:message key="label.interviews.viewconversation" /></a>               
                </c:otherwise>
            </c:choose>
            </div>
            
        </div>
    </c:forEach>
</div>
</t:pageTemplate>
