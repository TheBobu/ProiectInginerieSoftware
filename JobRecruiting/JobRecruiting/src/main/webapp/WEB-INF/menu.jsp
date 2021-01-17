<%-- 
    Document   : menu.jsp
    Created on : 12-Jan-2021, 23:35:33
    Author     : Andreea Purta
--%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style><%@include file="/WEB-INF/css/menu.css"%></style>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <a class="navbar-brand" href="${pageContext.request.contextPath}">JobRecruiting</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item ">
                <a class="nav-link" href="${pageContext.request.contextPath}/JobPosts"><fmt:message key="label.jobs" /></a>
            </li>
            <c:if test="${pageContext.request.isUserInRole('AdminRole')}">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/Administration"><fmt:message key="label.userManagement" /></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/JobAdministration"><fmt:message key="label.jobManagement" /></a>
                </li>
            </c:if>
            <c:if test="${pageContext.request.isUserInRole('DepartmentDirectorRole')}">
                <li class="nav-item ">
                    <a class="nav-link" href="${pageContext.request.contextPath}/JobPostsByDepartment"><fmt:message key="label.jobManagementByDepartment" /></a>
                </li>
            </c:if>
            <c:if test="${pageContext.request.isUserInRole('CandidateRole')}">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/Profile"><fmt:message key="label.profile" /></a>
                </li>
            </c:if>
            <c:if test="${pageContext.request.isUserInRole('RecruiterRole')}">
                <li class="nav-item ">
                    <a class="nav-link" href="${pageContext.request.contextPath}/Skills"><fmt:message key="label.skills" /></a>
                </li>
            </c:if>


        </ul>

        <ul class="navbar-nav ml-auto">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><fmt:message key="label.language" /></a>
                <div class="dropdown-menu" aria-labelledby="dropdown01">
                    <a class="dropdown-item" href="?sessionLocale=en">EN</a>
                    <a class="dropdown-item" href="?sessionLocale=ro">RO</a>
                    <a class="dropdown-item" href="?sessionLocale=de">DE</a>
                </div>
            </li>
            <c:choose>
                <c:when test="${pageContext.request.getRemoteUser() == null}">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/Login"><fmt:message key="label.login" /></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/Users/Create"><fmt:message key="label.register" /></a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/Logout"><fmt:message key="label.logout" /></a>
                    </li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</nav>