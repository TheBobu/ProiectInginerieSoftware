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
            <div class="media clearfix">
                <div class="row">
                    <div class="media-left col-sm-3 col-2">
                        <img class="media-object" src="${pageContext.request.contextPath}/ProfilePicture?id=${user.id}&typeId=0" width="300" alt="...">
                    </div>                      
                    <div class="media-body col-sm-9">
                        <div class="card-body">
                            <h2 class="media-heading">${user.firstName} ${user.lastName}  
                                <small> - Profile</small>
                            </h2>
                            <div class="row">
                                <div class="col-sm-3">
                                    <h6 >Full Name</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    ${user.firstName} ${user.lastName} 
                                </div>
                            </div>
                            <hr />
                            <div class="row">
                                <div class="col-sm-3">
                                    <h6>Email</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    ${user.email}
                                </div>
                            </div>
                            <hr />
                            <div class="row">
                                <div class="col-sm-3">
                                    <h6 >Birth Date</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    ${user.birthDate} 
                                </div>
                            </div>
                            <hr />
                            <div class="row">
                                <div class="col-sm-3">
                                    <h6>User Type</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    ${user.position} 
                                </div>
                            </div>
                            <hr />
                            <div class="row">
                                <div class="col-sm-3">
                                    <h6 >Address</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    ${ user.address }
                                </div>
                            </div>
                            <hr />
                            <div class="row">
                                <div class="col-sm-3">
                                    <h6>Department</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    ${user.department}
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xl">
                                    <a  target="_blank" href="${pageContext.request.contextPath}/ProfilePicture?id=${user.id}&typeId=1" class="col-xl btn btn-profile btn-primary"  role="button">Download CV</a>
                                </div>

                                <div class="col-xl">
                                    <a href="${pageContext.request.contextPath}/Profile/Update" role="button" class=" btn-profile col-xl btn btn-primary">Edit User</a>
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
                        <p> ${user.shortBio}
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
                    </div>
                </div>
                <div class="panel">
                    <div class="panel-heading">
                        <span class="panel-icon">
                            <i class="fa fa-pencil"></i>
                        </span>
                        <span class="panel-title">My Experience</span>
                    </div>
                    <div class="panel-body pb5">
                        <p>${user.userExperience}</p>
                    </div>
                </div>
            </div>
            <div class="col-md-8">
                <div class="tab-block">

                    <ul class="nav nav-tabs"  role="tablist">
                        <li class=" nav-item " role="presentation">
                            <a class="nav-link active" id="interviews" data-toggle="interviews" href="#interviews" role="tab" aria-controls="interviews" aria-selected="true">My Interviews</a>
                        </li>
                        <li class=" nav-item " role="presentation">
                            <a class="nav-link " id="applications" data-toggle="applications" href="#applications" role="tab" aria-controls="applications" aria-selected="false">My applications</a>
                        </li>

                    </ul>

                    <div class="tab-content" id="myTabContent" style="height: 470px;">
                        <div class="tab-pane fade show active" id="interviews" role="tabpanel" aria-labelledby="interviews">

                            <c:forEach var="interview" items="${interviews}" varStatus="status">
                                <div class="row">
                                    <div class="col-sm-3 interview-title">
                                        <h6 class="mb-0">${interview.jobpost.title}</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        <div class="row">
                                            <div class="col-md-8 interview-status">
                                                ${interview.interviewStatus}
                                            </div>
                                            <div class="col-md-4">
                                                <a href="#" role="button" class=" btn-profile col-xl btn btn-primary">View Interview</a>
                                            </div></div>
                                    </div>
                                </div>
                                <hr />
                            </c:forEach>
                        </div>

                        <div class="tab-pane fade " id="applications" role="tabpanel" aria-labelledby="applications">
                            <h2>Sunt!!!</h2>

                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</section>


<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

</t:pageTemplate>


