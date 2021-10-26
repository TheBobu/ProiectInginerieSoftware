<%-- 
    Document   : viewCandidates
    Created on : Jan 15, 2021, 10:26:33 AM
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

<t:pageTemplate pageTitle="Candidates">
    <div class="container-management">
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
                    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/Profile?id=${candidate.candidate.id}" role="button"><fmt:message key="label.viewCandidates.viewProfile" /></a>
                </div>

                <div class="col-md"> <%-------------------TO DO---------------------------------%>
                    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/Comment?id=${candidate.id}" role="button"><fmt:message key="label.viewCandidates.planInterview" /></a>
                </div>
            </div>
        </c:forEach>
    </div>
</t:pageTemplate>
