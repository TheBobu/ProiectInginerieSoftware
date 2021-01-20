<%-- 
    Document   : jobpostings
    Created on : Jan 3, 2021, 9:56:51 PM
    Author     : DENISA
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style><%@include file="/WEB-INF/css/main.css"%></style>
<style><%@include file="/WEB-INF/css/jobs.css"%></style>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages" />

<t:pageTemplate pageTitle="Jobs">

    <!-- Team item -->
    <div class="job-container"> 
    <t:filterJobPostForm/>
    <t:ifHasRole role="RecruiterRole">
       <a class="btn btn-primary" href="${pageContext.request.contextPath}/JobPost/Create"><fmt:message key="label.jobPosts.create" /></a>
    </t:ifHasRole>

    <div class="row row-cols-1 row-cols-md-2 g-4 mt-4">
        <c:forEach var="jobpost" items="${jobPosts}">
            <div class="col">

                <div class="text-center col-11 bg-white position-relative shadow-sm rounded">
                    <t:ifHasRole role="RecruiterRole">
                        <div class="d-flex justify-content-end w-100 position-absolute mt-2">
                            <form method="post" class="d-inline" action="${pageContext.request.contextPath}/JobPost/Copy?id=${jobpost.id}">
                                <input type="hidden" value="${jobpost.id}">
                                <button type="submit" class="mt-1 me-4 btn p-0 text-decoration-none link-secondary fs-5"> <i class="far fa-copy"></i></button>
                            </form>
                            <a href="${pageContext.request.contextPath}/JobPost/Edit?id=${jobpost.id}" class=" mt-1 me-3 text-decoration-none link-secondary fs-5">
                                <i class="far fa-edit"></i>
                            </a>
                        </div>
                    </t:ifHasRole>

                    <div class=" py-5 px-4">
                        <img src="https://cdn.logo.com/hotlink-ok/logo-social-sq.png" alt="" width="100" class="img-fluid rounded-circle mb-3 img-thumbnail shadow-sm">
                        <h5 class="mb-0"><a href="${pageContext.request.contextPath}/JobPost?id=${jobpost.id}" class="text-decoration-none ">${jobpost.title}</a></h5>
                        <span class="small text-uppercase text-muted">${jobpost.type.label}</span>

                        <div class="card-text mt-3">
                            <p class="card-text mt-1 "><fmt:message key="label.jobpost.salary" /> :<span style="font-weight:bold">${jobpost.salary}$</span></p>
                            <div class="mt-3">
                                <c:if test="${showApplyButton && jobpost.isAppliable(pageContext.request.getRemoteUser())}">
                                    <c:choose>
                                        <c:when test="${!jobPostsAppliedToIds.contains(jobpost.id)}">
                                            <a href="${pageContext.request.contextPath}/ApplyForJob?jobid=${jobpost.id}" class="btn btn-success">
                                                <span class="d-flex align-items-baseline">
                                                    <i class="far fa-check-square me-2"></i> 
                                                    <span><fmt:message key="label.jobpost.apply" /></span>

                                                </span>
                                            </a>
                                        </c:when>
                                        <c:otherwise>
                                            <p><span class="badge bg-success"><fmt:message key="label.jobpost.aplied" /></span></p>
                                        </c:otherwise>
                                    </c:choose>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    </div>
</t:pageTemplate>
