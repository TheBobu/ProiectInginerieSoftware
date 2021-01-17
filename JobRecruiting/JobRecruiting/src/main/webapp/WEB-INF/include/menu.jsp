<%-- 
    Document   : menu
    Created on : Jan 14, 2021, 10:01:29 PM
    Author     : DENISA
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>  

<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <a class="navbar-brand" href="${pageContext.request.contextPath}">Job Recruiting</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link ${pageContext.request.contextPath eq '/test2b/about.jsp'? 'active' :''}" 
                   href="${pageContext.request.contextPath}/JobPosts">Jobs <span class="sr-only">(current)</span></a>
            </li>
        </ul>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <c:choose>
                    <c:when test="${pageContext.request.getRemoteUser()==null}">
                        <a class="nav-link ${pageContext.request.contextPath eq '/test2b/Login'? 'active' :''}" 
                           href="${pageContext.request.contextPath}/Login">Login</a>
                    </c:when>
                    <c:otherwise>
                        <a class="nav-link ${pageContext.request.contextPath eq '/test2b/Logout'? 'active' :''}" 
                           href="${pageContext.request.contextPath}/Logout">Logout</a>
                    </c:otherwise>
                </c:choose>
            </li>
        </ul>
    </div>
</nav>
