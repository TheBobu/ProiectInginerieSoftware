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
<style>
    main.container{
        max-width: 1560px!important;
    }
    
    body{
    background-image: linear-gradient(to right, #5f72bd 0%, #9b23ea 100%);
    }

    .register{

        margin-top: 3%;
        padding: 3%;
    }
    .register-left{
        text-align: center;
        color: #fff;
        margin-top: 4%;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;

    }
    textarea.form-control {
        min-height: calc(5.4em + 0.85rem + 2px);
    }
    .register-left input{
        border: none;
        border-radius: 1.5rem;
        padding: 2%;
        width: 60%;
        background: #f8f9fa;
        font-weight: bold;
        color: #383d41;
        margin-top: 30%;
        margin-bottom: 3%;
        cursor: pointer;
    }
    .register-right{
        background: #f8f9fa;
        border-top-left-radius: 10% 50%;
        border-bottom-left-radius: 10% 50%;
    }
    .register-left img{
        margin-top: 15%;
        margin-bottom: 5%;
        width: 25%;
        -webkit-animation: mover 2s infinite  alternate;
        animation: mover 1s infinite  alternate;
    }
    @-webkit-keyframes mover {
        0% { transform: translateY(0); }
        100% { transform: translateY(-20px); }
    }
    @keyframes mover {
        0% { transform: translateY(0); }
        100% { transform: translateY(-20px); }
    }
    .register-left p{
        font-weight: lighter;
        padding: 12%;
        margin-top: -9%;
    }
    .register .register-form{
        padding: 10%;
        margin-top: 10%;
    }
    .btnRegister{
        float: right;
        margin-top: 10%;
        border: none;
        border-radius: 1.5rem;
        padding: 2%;
        background: #5f72bd;
        color: #fff;
        font-weight: 600;
        width: 50%;
        cursor: pointer;
    }
    .register .nav-tabs{
        margin-top: 3%;
        border: none;
        background: #0062cc;
        border-radius: 1.5rem;
        width: 28%;
        float: right;
    }
    .register .nav-tabs .nav-link{
        padding: 2%;
        height: 34px;
        font-weight: 600;
        color: #fff;
        border-top-right-radius: 1.5rem;
        border-bottom-right-radius: 1.5rem;
    }
    .register .nav-tabs .nav-link:hover{
        border: none;
    }
    .register .nav-tabs .nav-link.active{
        width: 100px;
        color: #0062cc;
        border: 2px solid #0062cc;
        border-top-left-radius: 1.5rem;
        border-bottom-left-radius: 1.5rem;
    }
    .register-heading{
        text-align: center;
        margin-top: 8%;
        margin-bottom: -15%;
        color: #495057;
    }
</style>

<div class="register">
    <div class="row">
        <div class="col-md-3 register-left">
            <img src="https://image.ibb.co/n7oTvU/logo_white.png" alt=""/>
            <h3>Hello there!</h3>
            <p>Have fun filling out this form!</p>
        </div>
        <div class="col-md-9 register-right">
            <jsp:doBody />
           
            <form class="needs-validation row register-form" action="${action}" method="POST" novalidate>
                <c:if test="${jobPost.id != null }">
                    <input type="hidden" name="id" value="${jobPost.id }">
                </c:if>

                <div class="col-md-6 ">
                    <div class="form-group mb-2">
                        <label for="title" class="form-label">Title</label>
                        <input type="text" minlength=6 class="form-control" id="title" name="title" value ="${jobPost.title}" required>
                        <t:displayError error="title"/>
                    </div>
                    <div class="form-group mb-2">
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
                        <t:displayError error="department"/>
                    </div>
                    <div class="form-group mb-2">
                        <label for="noOfPositionsFilled" class="form-label">Positions occupied</label>
                        <input type="number" class="form-control" min=0 value ="${jobPost.noOfPositionsFilled}" id="noOfPositionsFilled" name="noOfPositionsFilled" required>
                        <t:displayError error="noOfPositionsFilled"/>
                    </div>

                    <div class="form-group mb-2">
                        <label for="description" class="form-label">Description</label>
                        <textarea type="text" wrap="hard"  class="form-control" id="description" name="description" required>${jobPost.description}
                        </textarea>
                        <t:displayError error="description"/>
                    </div>


                    <div class="form-group mb-2">
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
                        <t:displayError error="status"/>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group mb-2">
                        <label for="description" class="form-label">Level</label>
                        <select class="form-select" id="status" name="level" required>
                            <option value="" disabled selected>Choose...</option>
                            <c:forEach var = "status" items = "${statuses}">
                                <option value="${status}"
                                        <c:if test="${status eq jobPost.status}">
                                            selected
                                        </c:if>
                                        >${status.label}</option>
                            </c:forEach>
                        </select>
                        <t:displayError error="description"/>
                    </div>

                    <div class="form-group mb-2">
                        <label for="noOfPositionsAvailable" class="form-label">Type</label>
                         <select class="form-select" id="status" name="type" required>
                            <option value="" disabled selected>Choose...</option>
                            <c:forEach var = "status" items = "${statuses}">
                                <option value="${status}"
                                        <c:if test="${status eq jobPost.status}">
                                            selected
                                        </c:if>
                                        >${status.label}</option>
                            </c:forEach>
                        </select>
                        <t:displayError error="noOfPositionsAvailable"/>
                    </div>

                    <div class="form-group mb-2">
                        <label for="noOfPositionsAvailable" class="form-label">Position availables</label>
                        <input type="number" class="form-control" min=1 value ="${jobPost.noOfPositionsAvailable}" id="noOfPositionsAvailable" name="noOfPositionsAvailable" required>
                        <t:displayError error="noOfPositionsAvailable"/>
                    </div>



                    <div class="form-group mb-2">
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
                        <t:displayError error="skills"/>
                    </div>
                    <div class="form-group mb-2">
                        <label for="noOfPositionsAvailable" class="form-label">Salary</label>
                        <input type="number" class="form-control" min=1 value ="${jobPost.noOfPositionsAvailable}" id="noOfPositionsAvailable" name="salary">
                        <t:displayError error="noOfPositionsAvailable"/>
                    </div>
                    <input type="submit" class="btnRegister"  value="Save"/>
                </div>
            </form>

        </div>
    </div>

</div>
