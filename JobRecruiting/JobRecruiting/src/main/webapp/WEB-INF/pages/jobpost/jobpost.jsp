<%-- 
    Document   : jobposting
    Created on : Jan 3, 2021, 9:57:22 PM
    Author     : DENISA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style><%@include file="/WEB-INF/css/main.css"%></style>

<t:pageTemplate pageTitle="${jobPost.title}">

    <div class="col-10 mt-5 mb-5 mx-auto bg-white position-relative shadow-sm rounded p-5">
        <div class="d-flex align-items-center">
            <img src="https://cdn.logo.com/hotlink-ok/logo-social-sq.png" alt="" width="100" class="img-fluid rounded-circle mb-3 me-4 img-thumbnail shadow-sm">
            <h1 class="text-uppercase">${jobPost.title}</h1>
        </div>
        <div class="d-flex mt-3">
            <c:forEach var ="skill" items = "${jobPost.skills}">
                <span class="badge badge-pill bg-dark me-2">${skill.name}</span>
            </c:forEach>
        </div>

        <div class="mt-5 d-flex align-items-center" style="line-height: 1.2;">
            <div class="me-4">
                <div class="d-flex align-items-center mb-3">
                    <i class="fas fa-briefcase"></i><h6 class="mb-0 ms-2"> Tip job:</h6> 
                </div>

                <div class="me-2">
                    <div class="d-flex align-items-center mb-3">
                        <i class="fas fa-users"></i><h6 class="mb-0 ms-2"> Posturi disponibile:</h6> 
                    </div>
                </div>

                <div class="me-2">
                    <div class="d-flex align-items-center mb-3">
                        <i class="far fa-money-bill-alt"></i><h6 class="mb-0 ms-2"> Salariu:</h6> 
                    </div>
                </div>

                <div class="me-2">
                    <div class="d-flex align-items-center mb-3">
                        <i class="fas fa-building"></i><h6 class="mb-0 ms-2"> Departament:</h6> 
                    </div>
                </div>

            </div>
            <div class="">
                <div class="mb-3">
                    <span>${jobPost.type.label}</span>
                </div>

                <div class="mb-3">
                    <span>${jobPost.noOfPositionsAvailable}</span>
                </div>

                <div class="mb-3">
                    <span>${jobPost.salary} $</span>
                </div>

                <div class="mb-3">
                    <span>${jobPost.department}</span>
                </div>

            </div>

        </div>
        <div class="">
            <c:if test="${jobPost.isAppliable(pageContext.request.getRemoteUser())}">
                <c:choose>
                    <c:when test="${!jobPostsAppliedToIds.contains(jobPost.id)}">
                        <a href="${pageContext.request.contextPath}/ApplyForJob?jobid=${jobPost.id}" class="btn btn-success">
                            <span class="d-flex align-items-baseline">
                                <i class="far fa-check-square me-2"></i> 
                                <span>Apply</span>

                            </span>
                        </a>
                    </c:when>
                    <c:otherwise>
                        <p><span class="badge bg-success">Applied</span></p>
                    </c:otherwise>
                </c:choose>
            </c:if>
        </div>

        <h5 class="card-text mt-4">Cerinte:</h5>
        <ul>
            <c:forEach var ="bullet" items = "${jobPost.bullets(jobPost.requirements)}">
                <c:if test="${!bullet.equals('')}">
                    <li class="">${bullet}</li>
                    </c:if>
                </c:forEach>
        </ul>

        <h5 class="card-text mt-4">Responsabilitati:</h5>
        <ul>
            <c:forEach var ="bullet" items = "${jobPost.bullets(jobPost.responsabilities)}">
                <c:if test="${!bullet.equals('')}">
                    <li class="">${bullet}</li>
                    </c:if>
                </c:forEach>
        </ul>


    </div>
</t:pageTemplate>
