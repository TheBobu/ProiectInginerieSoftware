<%-- 
    Document   : card
    Created on : Jan 5, 2021, 9:27:01 PM
    Author     : DENISA
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="title"%>
<%@attribute name="description"%>
<%@attribute name="viewLink"%>
<%@attribute name="deleteLink"%>
<%@attribute name="id"%>

<div class="card mb-3" style="max-width: 540px;">
    <div class="row g-0">
        <div class="col-md-4">
            <img src="https://picsum.photos/seed/picsum/400" class="card-img-top" alt="...">
        </div>
        <div class="col-md-8">
            <div class="card-body">
                <h5 class="card-title">${title}</h5>
                <p class="card-text">${description}</p>
                <div class="card-text">
                    <a href="${viewLink}" class="btn btn-primary me-2">View</a>
                    <form method="post" class="d-inline" action="${deleteLink}">
                        <input type="hidden" value="${id}">
                        <button type="submit" class="btn btn-danger">Delete</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
