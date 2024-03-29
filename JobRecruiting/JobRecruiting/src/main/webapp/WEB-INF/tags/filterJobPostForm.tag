<%-- 
    Document   : filterForm
    Created on : Jan 10, 2021, 2:10:33 PM
    Author     : DENISA
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="message"%>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages" />

<form class="needs-validation row register-form" action="${action}" method="get" novalidate>

    <div class="row col-10">
        <div class="form-group col-md mb-4">
            <label for="keyword" class="form-label"><fmt:message key="label.jobpost.keyword" /></label>
            <input type="text" class="form-control" id="keyword" name="keyword" value ="${keyword}">
        </div>
        <div class="form-group col-md mb-4">
            <label for="type" class="form-label"><fmt:message key="label.jobpost.type" /></label>
            <select class="form-select" id="type" name="type">
                <option value="" ><fmt:message key="label.jobpost.any" /></option>
                <c:forEach var = "existingtype" items = "${types}">
                    <option value="${existingtype}"
                            <c:if test="${existingtype eq type}">
                                selected
                            </c:if>
                            >${existingtype.label}</option>
                </c:forEach>
            </select>
            <t:displayError error="type"/>
        </div>
        <div class="form-group col-md mb-4">
            <label for="type" class="form-label"><fmt:message key="label.jobpost.minSalary" /></label>
            <input type="number" class="form-control" value ="${salary}" id="salary" name="salary">
        </div>

        <t:ifHasRole role="RecruiterRole">
            <div class="form-group col-md mb-4">
                <label for="status" class="form-label"><fmt:message key="label.jobpost.status" /></label>
                <select class="form-select" id="status" name="status">
                    <c:forEach var = "existingstatus" items = "${statuses}">
                        <option value="${existingstatus}"
                                <option value="${existingstatus}"
                                <c:if test="${existingstatus eq status}">
                                    selected
                                </c:if>
                                ><fmt:message key="label.jobpost.${existingstatus}" /></option>
                    </c:forEach>
                    <option value="" ><fmt:message key="label.jobpost.any" /></option>    
                </select>
            </div>
        </t:ifHasRole>
    </div>
    <div class="col-2 mb-4 mt-auto">
        <button class=" btn rounded btn-primary"><i class="fas fa-search"></i></button>
    </div>
</form>