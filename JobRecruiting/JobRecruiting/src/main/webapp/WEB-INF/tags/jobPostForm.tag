<%-- 
    Document   : jobPostForm
    Created on : Jan 7, 2021, 3:57:25 PM
    Author     : DENISA
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="action"%>

<jsp:doBody />

<form class="needs-validation row register-form" action="${action}" method="POST" novalidate>
    <c:if test="${jobPost.id != null }">
        <input type="hidden" name="id" value="${jobPost.id }">
    </c:if>

    <div class="col-md-6 ">
        <div class="form-group mb-4">
            <label for="title" class="form-label">Title</label>
            <input type="text" minlength=6 class="form-control" id="title" name="title" value ="${jobPost.title}" required>
            <t:displayError error="title"/>
        </div>
        <div class="form-group mb-4">
            <label for="department" class="form-label">Department</label>
            <select class="form-select" id="department" name="department" required>
                <c:forEach var = "department" items = "${departments}">
                    <option value="${department}"
                            <c:if test="${department eq jobPost.department}">
                                selected
                            </c:if>
                            >${department}</option>
                </c:forEach>
            </select>
            <t:displayError error="department"/>
        </div>
        <div class="form-group mb-4">
            <label for="noOfPositionsFilled" class="form-label">Positions occupied</label>
            <input type="number" class="form-control" min=0 value ="${jobPost.noOfPositionsFilled}" id="noOfPositionsFilled" name="noOfPositionsFilled">
            <t:displayError error="noOfPositionsFilled"/>
        </div>

        <div class="form-group mb-4">
            <label for="description" class="form-label">Description</label>
            <textarea type="text" wrap="hard" min=20 class="form-control" id="description" name="description" required>${jobPost.description}
            </textarea>
            <t:displayError error="description"/>
        </div>
        <c:if test="${(isEdit&&jobPost.statusShouldBeEditable()) || pageContext.request.isUserInRole('GeneralDirectorRole')}">
            <div class="form-group mb-4">
                <label for="status" class="form-label">Status</label>
                <select class="form-select" id="status" name="status" required>
                    <c:forEach var = "status" items = "${statuses}">
                        <option value="${status}"
                                <c:if test="${status eq jobPost.status}">
                                    selected
                                </c:if>
                                >${status.label}</option>
                        <t:displayError error="status"/>
                    </c:forEach>
                </select>
            </div>
        </c:if>
    </div>
    <div class="col-md-6">
        <div class="form-group mb-4">
            <label for="type" class="form-label">Type</label>
            <select class="form-select" id="type" name="type" required>
                <c:forEach var = "type" items = "${types}">
                    <option value="${type}"
                            <c:if test="${type eq jobPost.type}">
                                selected
                            </c:if>
                            >${type.label}</option>
                </c:forEach>
            </select>
            <t:displayError error="type"/>
        </div>

        <div class="form-group mb-4">

            <label for="salary" class="form-label">Salary</label>
            <input type="number" class="form-control" min=1 value ="${jobPost.salary}" id="salary" name="salary" required>
            <t:displayError error="salary"/>
        </div>

        <div class="form-group mb-4">
            <label for="noOfPositionsAvailable" class="form-label">Positions available</label>
            <input type="number" class="form-control" min=1 value ="${jobPost.noOfPositionsAvailable}" id="noOfPositionsAvailable" name="noOfPositionsAvailable" required>
            <t:displayError error="noOfPositionsAvailable"/>
        </div>

        <div class="form-group mb-4">
            <label for="skills" class="form-label">
                Skills 
                <a href="${pageContext.request.contextPath}/Skills/Create" class="link text-purple">
                    <i class="fas fa-plus-circle"></i></a> 
            </label>
            <select class="form-select" id="skills" name="skills" multiple required>
                <c:forEach var = "skill" items = "${skills}">
                    <option value="${skill.id}"
                            <c:if test="${true eq jobPost.skills.contains(skill)}">
                                selected
                            </c:if>
                            >${skill.name}</option>
                </c:forEach>
            </select>
            <t:displayError error="skills"/>
        </div>

        <input type="submit" class="btnRegister"  value="Save"/>
    </div>
</form>
