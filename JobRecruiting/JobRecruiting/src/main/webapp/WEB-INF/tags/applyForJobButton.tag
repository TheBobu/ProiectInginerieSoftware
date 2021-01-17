<%-- 
    Document   : applyForJobButton
    Created on : Jan 17, 2021, 7:25:05 PM
    Author     : DENISA
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@attribute name="jobpost"%>

<c:if test="${jobpost.isAppliable()}">
    <c:choose>
        <c:when test="${jobPostsAppliedToIds.contains(jobpost.id)}">
            <a href="${pageContext.request.contextPath}/ApplyForJob?jobid=${jobpost.id}" class="btn btn-success">
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
