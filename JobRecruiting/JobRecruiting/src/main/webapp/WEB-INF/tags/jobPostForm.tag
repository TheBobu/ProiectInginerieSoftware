<%-- 
    Document   : jobPostForm
    Created on : Jan 7, 2021, 3:57:25 PM
    Author     : DENISA
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="action"%>

<%-- any content can be specified here e.g.: --%>
<div class="col-md-7 col-lg-8">
    <jsp:doBody />
    <form class="needs-validation" action="${action}" method="POST" novalidate>
        <div class="row g-3 mb-4">
            <div class="col-12">
                <label for="title" class="form-label">Title</label>
                <input type="text" minlength=6 class="form-control" id="title" name="title" value ="${jobPost.title}" required>
                <div class="invalid-feedback">
                    Valid title required.
                </div>
            </div>

            <div class="col-12">
                <label for="description" class="form-label">Description</label>
                <textarea type="text" wrap="hard"  class="form-control" id="description" name="description" required>${jobPost.description}
                </textarea>
                <div class="invalid-feedback">
                    Valid description required.
                </div>
            </div>

            <div class="col-12">
                <label for="noOfPositionsFilled" class="form-label">Positions occupied</label>
                <input type="number" class="form-control" min=0 value ="${jobPost.noOfPositionsFilled}" id="noOfPositionsFilled" name="noOfPositionsFilled" required>
                <div class="invalid-feedback">
                    Valid number required.
                </div>
            </div>

            <div class="col-12">
                <label for="noOfPositionsAvailable" class="form-label">Positions available</label>
                <input type="number" class="form-control" min=1 value ="${jobPost.noOfPositionsAvailable}" id="noOfPositionsAvailable" name="noOfPositionsAvailable" required>
                <div class="invalid-feedback">
                    Valid number required.
                </div>
            </div>

            <div class="col-10">
                <label for="skills" class="form-label">Skills</label>
                <select class="form-select" id="skills" name="skills" multiple required>
                    <c:forEach var = "skill" items = "${skills}">
                        <option value="${skill.id}"
                                <c:if test="${true eq jobPost.skills.contains(skill)}">
                                    selected
                                </c:if>
                                >${skill.name}</option>
                    </c:forEach>
                </select>
                <div class="invalid-feedback">
                    Valid skills required.
                </div>
            </div>

            <div class="col-10">
                <label for="department" class="form-label">Department</label>
                <select class="form-select" id="department" name="department" required>
                    <option value="" disabled selected>Choose...</option>
                    <c:forEach var = "department" items = "${departments}">
                        <option value="${department}"
                                <c:if test="${department eq jobPost.department}">
                                    selected
                                </c:if>
                                >${department}</option>
                    </c:forEach>
                </select>
                <div class="invalid-feedback">
                    Please select a valid department.
                </div>
            </div>

            <div class="col-10">
                <label for="status" class="form-label">Status</label>
                <select class="form-select" id="status" name="status" required>
                    <option value="" disabled selected>Choose...</option>
                    <c:forEach var = "status" items = "${statuses}">
                        <option value="${status}"
                                <c:if test="${status eq jobPost.status}">
                                    selected
                                </c:if>
                                >${status.label}</option>
                    </c:forEach>
                </select>
                <div class="invalid-feedback">
                    Please select a valid status.
                </div>
            </div>
        </div>
        <c:if test="${jobPost.id != null }">
            <input type="hidden" name="id" value="${jobPost.id }">
        </c:if>

        <button class="w-100 btn btn-primary btn-lg" type="submit">save</button>
    </form>
</div>