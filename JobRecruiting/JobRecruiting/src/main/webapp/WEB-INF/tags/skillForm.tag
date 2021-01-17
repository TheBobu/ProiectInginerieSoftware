<%-- 
    Document   : skillForm
    Created on : Jan 10, 2021, 5:04:09 PM
    Author     : DENISA
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="action"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:doBody />

<form class="needs-validation row register-form" action="${action}" method="POST" novalidate>
    <c:if test="${skill.id != null }">
        <input type="hidden" name="skill_id" value="${skill.id}" />
    </c:if>
    <input type="hidden" name="previous" value="${previous}">
    
    <div class="col-md-6 mx-auto">
        <div class="form-group mb-4">
            <label for="name" class="form-label">Name</label>
            <input type="text" minlength=6 class="form-control" id="name" name="name" value ="${skill.name}" required>
            <t:displayError error="name"/>
        </div>
        
        <input type="submit" class="btnRegister"  value="Save"/>
        <a type="submit" class="btnGoBack" href="${previous}" role="button">Go back</a>
    </div>
</form>