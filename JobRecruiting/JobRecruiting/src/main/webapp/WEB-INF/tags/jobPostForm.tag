<%-- 
    Document   : jobPostForm
    Created on : Jan 7, 2021, 3:57:25 PM
    Author     : DENISA
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="action"%>

<%-- any content can be specified here e.g.: --%>
<div class="col-md-7 col-lg-8">
    <h2 class="mb-3">Add job post</h2> 
    <form class="needs-validation" action="${action}" method="POST" novalidate>
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
                ${skills}
                <label for="parking_spot" class="form-label">Skills</label>
                <select class="form-select" id="country" name="skills" multiple required>
                    <option value="">Choose...</option>
                    <c:forEach var = "skill" items = "${skills}">
                        <option value="${skill.id}">${skill.name}</option>
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