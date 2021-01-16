<%-- 
    Document   : menu.jsp
    Created on : 12-Jan-2021, 23:35:33
    Author     : Andreea Purta
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <a class="navbar-brand" href="${pageContext.request.contextPath}">JobRecruiting</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item ">
                <a class="nav-link" href="${pageContext.request.contextPath}/JobPosts">Jobs</a>
            </li>
            <c:if test="${pageContext.request.isUserInRole('AdminRole')}">
                <li class="nav-item ${activePage eq 'Cars' ? ' active' : ''}">
                    <a class="nav-link" href="${pageContext.request.contextPath}/Administration">User Management</a>
                </li>
                <li class="nav-item ${activePage eq 'Cars' ? ' active' : ''}">
                    <a class="nav-link" href="${pageContext.request.contextPath}/JobAdministration">Job Management</a>
                </li>
            </c:if>
            <c:if test="${pageContext.request.isUserInRole('CandidateRole')}">
                <li class="nav-item ${activePage eq 'Users' ? ' active' : ''}">
                    <a class="nav-link" href="${pageContext.request.contextPath}/Profile">Profile</a>
                </li>
            </c:if>


        </ul>
        <ul class="navbar-nav ml-auto">

            <c:choose>
                <c:when test="${pageContext.request.getRemoteUser() == null}">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/Login">Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/Users/Create">Register</a>
                    </li>
                </c:when>
                <c:otherwise>
                     <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/Logout">Logout</a>
                    </li>
                </c:otherwise>
            </c:choose>
            </li>
        </ul>
    </div>
</nav>