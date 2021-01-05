<%-- 
    Document   : addjobposting
    Created on : Jan 3, 2021, 9:57:36 PM
    Author     : DENISA
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Add job post">

    <div class="col-md-7 col-lg-8">
        <h2 class="mb-3">Add job post</h2> 
        <form class="needs-validation" action="${pageContext.request.contextPath}/AddJobPost" method="POST" novalidate>
            <div class="row g-3">
                <div class="col-12">
                    <label for="licence_plate" class="form-label">Title</label>
                    <input type="text" class="form-control" id="licence_plate" name="title" required>
                    <div class="invalid-feedback">
                        Valid title required.
                    </div>
                </div>

                <div class="col-12">
                    <label for="parking_spot" class="form-label">Description</label>
                    <textarea type="text" class="form-control" id="parking_spot" name="description" required>
                    </textarea>
                    <div class="invalid-feedback">
                        Valid description required.
                    </div>
                </div>

                <div class="col-12">
                    <label for="parking_spot" class="form-label">Positions available</label>
                    <input type="number" class="form-control" id="parking_spot" name="noOfPositionsAvailable" required>
                    <div class="invalid-feedback">
                        Valid number of positions available required.
                    </div>
                </div>

                <div class="col-10">
                    <label for="parking_spot" class="form-label">Skills</label>
                    <select class="form-select" id="country" name="skills" required>
                        <option value="">Choose...</option>
                        <c:forEach var = "skill" items = "${skills}">
                            <option value="${skill}">${skill.label}</option>
                        </c:forEach>
                    </select>
                    <div class="invalid-feedback">
                        Valid skills required.
                    </div>
                </div>

                <div class="col-10">
                  
                    <label for="country" class="form-label">Department</label>
                    <select class="form-select" id="country" name="department" required>
                        <option value="">Choose...</option>
                        
                        <c:forEach var = "department" items = "${departments}">
                            <option value="${department}">${department}</option>
                        </c:forEach>
                    </select>
                    <div class="invalid-feedback">
                        Please select a valid department.
                    </div>
                </div>

                <div class="col-10">
                    <label for="country" class="form-label">Status</label>
                    <select class="form-select" id="country" name="status" required>
                        <option value="">Choose...</option>
                        <c:forEach var = "status" items = "${statuses}">
                            <option value="${status}">${status.label}</option>
                        </c:forEach>
                    </select>
                    <div class="invalid-feedback">
                        Please select a valid status.
                    </div>
                </div>
            </div>
            <hr class="my-4">

            <button class="w-100 btn btn-primary btn-lg" type="submit">save</button>
        </form>
    </div>
<t:formValidate></t:formValidate>
</t:pageTemplate>
