<%-- 
    Document   : card
    Created on : Jan 5, 2021, 9:27:01 PM
    Author     : DENISA
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="title"%>
<%@attribute name="viewLink"%>
<%@attribute name="copyLink"%>
<%@attribute name="editLink"%>
<%@attribute name="id"%>
<%@attribute name="salary"%>
<%@attribute name="type"%>
<%@attribute name="appliable"%>

<div class="text-center col-11 bg-white position-relative shadow-sm rounded">
    <t:ifHasRole role="RecruiterRole">
        <div class="d-flex justify-content-end w-100 position-absolute mt-2">
            <form method="post" class="d-inline" action="${copyLink}">
                <input type="hidden" value="${id}">
                <button type="submit" class="mt-1 me-4 btn p-0 text-decoration-none link-secondary fs-5"> <i class="far fa-copy"></i></button>
            </form>
            <a href="${editLink}" class=" mt-1 me-3 text-decoration-none link-secondary fs-5">
                <i class="far fa-edit"></i>
            </a>
        </div>
    </t:ifHasRole>

    <div class=" py-5 px-4">
        <img src="https://cdn.logo.com/hotlink-ok/logo-social-sq.png" alt="" width="100" class="img-fluid rounded-circle mb-3 img-thumbnail shadow-sm">
        <h5 class="mb-0"><a href="${viewLink}" class="text-decoration-none ">${title}</a></h5>
        <span class="small text-uppercase text-muted">${type}</span>

        <div class="card-text mt-3">
            <p class="card-text mt-1 ">Salary: <span style="font-weight:bold">${salary}$</span></p>
            <div class="mt-3">
                <t:applyForJobButton id="${id}" appliable="${appliable}"/>
            </div>
        </div>
    </div>
</div>

