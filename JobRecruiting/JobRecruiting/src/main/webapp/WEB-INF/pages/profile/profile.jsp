<%-- 
    Document   : profile
    Created on : 12-Jan-2021, 12:13:31
    Author     : Andreea Purta
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style><%@include file="/WEB-INF/css/profile.css"%></style>
<style><%@include file="/WEB-INF/css/main.css"%></style>

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
                                <a href="${pageContext.request.contextPath}/PasswordReseter?id=${user.id}" role="button" class=" btn-profile col-xl btn btn-warning">Change Password</a>
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
                    <ul class="nav nav-tabs">
                        <li class="active">
                            <a href="#tab1" data-toggle="tab">My Interviews</a>
                        </li>
                        <li>
                            <a href="#tab1" data-toggle="tab">My job Applications</a>
                        </li>
                    </ul>
                    <div class="tab-content p30" style="height: 730px;">
                        <div id="tab1" class="tab-pane active">
                            <div class="media">
                                <a class="pull-left" href="#"> <img class="media-object mn thumbnail mw50" src="https://bootdey.com/img/Content/avatar/avatar1.png" alt="..."> </a>
                                <div class="media-body">
                                    <h5 class="media-heading mb20">Simon Rivers Posted
                                        <small> - 3 hours ago</small>
                                    </h5>
                                    <img src="https://bootdey.com/img/Content/avatar/avatar6.png" class="mw140 mr25 mb20">
                                    <img src="https://bootdey.com/img/Content/avatar/avatar8.png" class="mw140 mr25 mb20"> 
                                    <img src="https://bootdey.com/img/Content/avatar/avatar7.png" class="mw140 mb20">
                                    <div class="media-links">
                                        <span class="text-light fs12 mr10">
                                            <span class="fa fa-thumbs-o-up text-primary mr5"></span> Like </span>
                                        <span class="text-light fs12 mr10">
                                            <span class="fa fa-share text-primary mr5"></span> Share </span>
                                        <span class="text-light fs12 mr10">
                                            <span class="fa fa-floppy-o text-primary mr5"></span> Save </span>
                                        <span class="text-light fs12 mr10">
                                            <span class="fa fa-comment text-primary mr5"></span> Comment </span>
                                    </div>
                                </div>
                            </div>
                            <div class="media mt25">
                                <a class="pull-left" href="#"> <img class="media-object mn thumbnail thumbnail-sm rounded mw40" src="https://bootdey.com/img/Content/avatar/avatar6.png" alt="..."> </a>
                                <div class="media-body mb5">
                                    <h5 class="media-heading mbn">Simon Rivers Posted
                                        <small> - 3 hours ago</small>
                                    </h5>
                                    <p> Omg so freaking sweet dude.</p>
                                    <div class="media pb10">
                                        <a class="pull-left" href="#"> <img class="media-object mn thumbnail thumbnail-sm rounded mw40" src="https://bootdey.com/img/Content/avatar/avatar1.png" alt="..."> </a>
                                        <div class="media-body mb5">
                                            <h5 class="media-heading mbn">Jessica Wong
                                                <small> - 3 hours ago</small>
                                            </h5>
                                            <p>Omgosh I'm in love</p>
                                        </div>
                                    </div>
                                    <div class="media mtn">
                                        <a class="pull-left" href="#"> <img class="media-object mn thumbnail thumbnail-sm rounded mw40" src="https://bootdey.com/img/Content/avatar/avatar2.png" alt="..."> </a>
                                        <div class="media-body mb5">
                                            <h5 class="media-heading mbn">Jessica Wong
                                                <small> - 3 hours ago</small>
                                            </h5>
                                            <p>Omgosh I'm in love</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="media mt25">
                                <a class="pull-left" href="#"> <img class="media-object thumbnail mw50" src="https://bootdey.com/img/Content/avatar/avatar2.png" alt="..."> </a>
                                <div class="media-body">
                                    <h5 class="media-heading mb20">Simon Rivers Posted
                                        <small> - 3 hours ago</small>
                                    </h5>
                                    <img src="https://bootdey.com/img/Content/avatar/avatar2.png" class="mw140 mr25 mb20">
                                    <img src="https://bootdey.com/img/Content/avatar/avatar3.png" class="mw140 mr25 mb20"> 
                                    <img src="https://bootdey.com/img/Content/avatar/avatar4.png" class="mw140 mb20">
                                    <div class="media-links">
                                        <span class="text-light fs12 mr10">
                                            <span class="fa fa-thumbs-o-up text-primary mr5"></span> Like </span>
                                        <span class="text-light fs12 mr10">
                                            <span class="fa fa-share text-primary mr5"></span> Share </span>
                                        <span class="text-light fs12 mr10">
                                            <span class="fa fa-floppy-o text-primary mr5"></span> Save </span>
                                        <span class="text-light fs12 mr10">
                                            <span class="fa fa-comment text-primary mr5"></span> Comment </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div id="tab2" class="tab-pane"></div>
                        <div id="tab3" class="tab-pane"></div>
                        <div id="tab4" class="tab-pane"></div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</t:pageTemplate>