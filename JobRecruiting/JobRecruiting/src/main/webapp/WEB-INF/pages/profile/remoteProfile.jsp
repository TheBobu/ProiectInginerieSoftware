<%-- 
    Document   : profile
    Created on : 16-Jan-2021, 12:13:31
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
                                <a  target="_blank" href="${pageContext.request.contextPath}/ProfilePicture?id=${user.id}&typeId=1" class="col-md-4 btn btn-profile btn-primary"  role="button">Download CV</a>
                                <div class="col-md-4"></div>
                          
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
        </div>
    </section>
</t:pageTemplate>