<%-- 
    Document   : profile
    Created on : 12-Jan-2021, 12:13:31
    Author     : Andreea Purta
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style><%@include file="/WEB-INF/css/profile.css"%></style>
<t:pageTemplate pageTitle="Login">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <section id="content" style="    margin-top: 5%" class="container">
        <!-- Begin .page-heading -->
        <div class="page-heading">
            <form method="POST" enctype="multipart/form-data" class="needs-validation" action="${pageContext.request.contextPath}/Profile/Update">
                <div class="media clearfix">
                    <div class="row">
                        <div class="media-left col-sm-3">
                         
                            <img class="media-object" src="${pageContext.request.contextPath}/ProfilePicture?id=${user.id}&typeId=0" width="300" alt="...">
                            <input type="hidden" id="photoId" name="photoId" value="${user.id}">
                               <label style="margin-bottom:1%; margin-top:2%">Change Image</label>
                            <input type="file"  class="form-control-file" name="image" >
                        </div>                      
                        <div class="media-body col-sm-9">
                            <h2 class="media-heading">${user.firstName} ${user.lastName}  
                                <small> - Profile</small>
                            </h2>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Full Name</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        <h6 class="mb-0"> <input type="text" class="form-control" name="firstName" value="${user.firstName}"  placeholder="First Name"></h6>
                                        <h6 class="mb-0"> <input type="text" class="form-control" name="lastName" value="${user.lastName}" placeholder="Last Name"></h6>
                                    </div>
                                </div>
                                <hr />
                                <div class="row">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Email</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        <h6 class="mb-0"> <input type="email" class="form-control" name="email" value="${user.email}"  placeholder="Email"></h6>
                                    </div>
                                </div>
                                <hr />
                                <div class="row">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Birth Date</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        <h6 class="mb-0"> <input type="date" class="form-control" name="birthDate"  value="${user.birthDate}" placeholder="Birth Date"></h6>
                                    </div>
                                </div>
                                <hr />
                                <div class="row">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">User Type</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        ${user.position} 
                                    </div>
                                </div>
                                <hr />
                                <div class="row">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Address</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        <h6 class="mb-0"> <input type="text" class="form-control" name="address" value="${user.address}"  placeholder="Address"></h6>
                                    </div>
                                </div>
                                <hr />
                                <div class="row">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Department</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        <select name="department" class="form-control" >
                                            <c:forEach var="department" items="${departments}" varStatus="status">
                                                <option value="${department}" ${user.department eq department ? 'selected' : ''}> ${department}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                 <hr />
                                <div class="row">
                                     <div class="col-sm-3">
                                        <h6 class="mb-0">Change CV</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        <h6 class="mb-0"><input type="file" class="form-control-file" name="cv"></h6>
                                  
                                    </div>
                                </div>
                                  <hr />
                                <div class="row">
                                    <input type="hidden" id="id" name="id" value="${user.id}">
                                        <div class="col-md-8"></div>
                                    <div class="col-xl col-md-4" style="float:right;">
                                        <a href="${pageContext.request.contextPath}/PasswordReseter?id=${user.id}"   role="button" class=" btn btn-profile btn-profile">Change Password</a>
                                        <button class=" btn btn-profile"  type="submit">Update profile</button>
                                    </div>
                                
                                  
                                </div>
                            </div>
                        </div>
                    </div>
                </div>                   
        </div>
        <div class="row">
            <div class="col-md-4">
                <div class="panel">
                    <div class="panel-heading">
                        <span class="panel-icon">
                            <i class="fa fa-star"></i>
                        </span>
                        <span class="panel-title"> About Me</span>
                    </div>
                    <div class="panel-body pn">
                        <p> 
                        <h6 class="mb-0"> <input type="text" class="form-control" name="shortBio" value="${user.shortBio}"  placeholder="Short Description"></h6>
                        </p>
                    </div>
                </div>
                <div class="panel">
                    <div class="panel-heading">
                        <span class="panel-icon">
                            <i class="fa fa-trophy"></i>
                        </span>
                        <span class="panel-title"> My Skills</span>
                    </div>
                    <div class="panel-body pb5">
                        <ul id="faves">
                            <li>C#</li>
                            <li>Java</li>
                            <li>C</li>
                        </ul>
                        <div class="form-group mb-4">
                            <label for="name" class="form-label">Name</label>
                            <input type="text" minlength=6 class="form-control" id="add" name="name"  >
                            <input type="button" id="btnAdd" value="Add" onclick="addItem()">
                            <t:displayError error="name"/>
                        </div>
                    </div>
                </div>
                <div class="panel">
           
                    <div class="panel-body pb5">
                        <h6>Experience</h6>
                        <h6 class="mb-0"> <input type="text" class="form-control" name="userExperience" value="${user.userExperience}"  placeholder="Experience"></h6>
                    </div>
                </div>
            </div>
            </form>
            <div class="col-md-8">
                <div class="tab-block">
                    <ul class="nav nav-tabs">
                        <li class="active">
                            <a href="#tab1" data-toggle="tab">My Interviews</a>
                        </li>
                        <li>
                            <a href="#tab1" data-toggle="tab">My job Applications</a>
                        </li>
                    </ul>
                    <div class="tab-content p30" style="height: 578px;">
                        <div id="tab1" class="tab-pane active">
                        </div>
                        <div id="tab2" class="tab-pane"></div>
                        <div id="tab3" class="tab-pane"></div>
                        <div id="tab4" class="tab-pane"></div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <script>
        (function () {
            'use strict'
            window.addEventListener('load', function () {
// Fetch all the forms we want to apply custom Bootstrap validation styles to
                var forms = document.getElementsByClassName('needs-validation')
// Loop over them and prevent submission
                Array.prototype.filter.call(forms, function (form) {
                    form.addEventListener('submit', function (event) {
                        if (form.checkValidity() === false) {
                            event.preventDefault()
                            event.stopPropagation()
                        }
                        form.classList.add('was-validated')
                    }, false)
                })
            }, false)
        })()
    </script>
    <script>
        function addItem() {
            var li = document.createElement("LI");
            var input = document.getElementById("add");
            li.innerHTML = input.value;
            input.value = "";
            document.getElementById("faves").appendChild(li);
        }
    </script>
    <input type="button" id="btnAdd" value="Add" onclick="addItem()">
</t:pageTemplate>