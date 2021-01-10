<%-- 
    Document   : filterForm
    Created on : Jan 10, 2021, 2:10:33 PM
    Author     : DENISA
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="message"%>

<form class="needs-validation row register-form" action="${action}" method="get" novalidate>

    <div class="row col-10">
        <div class="form-group col-md-4 mb-4">
            <label for="type" class="form-label">Title</label>
            <input type="text" class="form-control" id="title" name="title" value ="${title}">
        </div>
        <div class="form-group col-md-4 mb-4">
            <label for="type" class="form-label">Type</label>
            <select class="form-select" id="type" name="type">
                <c:forEach var = "etype" items = "${types}">
                    <option value="${etype}"
                            <c:if test="${etype eq type}">
                                selected
                            </c:if>
                            >${etype.label}</option>
                </c:forEach>
            </select>
            <t:displayError error="type"/>
        </div>
        <div class="form-group col-md-4 mb-4">
            <label for="type" class="form-label">Min-salary</label>
            <input type="number" class="form-control" value ="${salary}" id="salary" name="salary">
            <t:displayError error="type"/>
        </div>
    </div>
    <div class="col-2 mb-4 mt-auto">
        <button class=" btn rounded btn-primary"><i class="fas fa-search"></i></button>
    </div>
</form>