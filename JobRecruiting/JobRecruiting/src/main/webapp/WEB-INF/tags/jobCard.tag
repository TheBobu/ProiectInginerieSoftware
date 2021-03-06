<%-- 
    Document   : card
    Created on : Jan 5, 2021, 9:27:01 PM
    Author     : DENISA
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="title"%>
<%@attribute name="description"%>
<%@attribute name="viewLink"%>
<%@attribute name="deleteLink"%>
<%@attribute name="editLink"%>
<%@attribute name="id"%>
<%@attribute name="salary"%>
<%@attribute name="type"%>

<div class="text-center col-11 bg-white position-relative shadow-sm rounded">
    <div class="d-flex justify-content-end w-100 position-absolute mt-2">
        <form method="post" class="d-inline" action="${deleteLink}">
            <input type="hidden" value="${id}">
            <button type="submit" class="mt-1 me-4 btn p-0 text-decoration-none link-danger fs-5"> <i class="fas fa-trash"></i></button>
        </form>
        <a href="${editLink}" class=" mt-1 me-3 text-decoration-none link-secondary fs-5">
            <i class="far fa-edit"></i>
        </a>
    </div>
    <div class=" py-5 px-4">
        <img src="https://cdn.logo.com/hotlink-ok/logo-social-sq.png" alt="" width="100" class="img-fluid rounded-circle mb-3 img-thumbnail shadow-sm">
        <h5 class="mb-0"><a href="${viewLink}" class="text-decoration-none ">${title}</a></h5>
        <span class="small text-uppercase text-muted">${type}</span>
        <p class="card-text mt-4">${description}</p>
        <div class="card-text">
            <p class="card-text mt-1 ">Salary: <span style="font-weight:bold">${salary}$</span></p>
        </div>
    </div>
</div>

