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

    <section id="content" class="container">
        <!-- Begin .page-heading -->
        <div class="page-heading">
            <div class="media clearfix">
                <div class="row">
                <div class="media-left col-sm-3">
                    <a href="#">
                        <img class="media-object mw150" 
                             src="https://bootdey.com/img/Content/avatar/avatar7.png" alt="...">
                    </a>
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
                                ${user.firstName} ${user.lastName} 
                            </div>
                        </div>
                        <hr />
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Email</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                ${user.email} 
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
                                ${ user.address }
                            </div>
                        </div>
                        <hr />
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Department</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                               ${user.department}
                            </div>
                        </div>
                         <div class="row">
                        <button class=" col-md-4 btn btn-primary">Download CV</button>
                         <div class="col-md-4"></div>
                         <button class="col-md-4 btn btn-primary">Edit User</button>
                        
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
                        <span class="panel-title"> User Popularity</span>
                    </div>
                    <div class="panel-body pn">
                        <table class="table mbn tc-icon-1 tc-med-2 tc-bold-last">
                            <thead>
                                <tr class="hidden">
                                    <th class="mw30">#</th>
                                    <th>First Name</th>
                                    <th>Revenue</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>
                                        <span class="fa fa-desktop text-warning"></span>
                                    </td>
                                    <td>Television</td>
                                    <td>
                                        <i class="fa fa-caret-up text-info pr10"></i>$855,913</td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="fa fa-microphone text-primary"></span>
                                    </td>
                                    <td>Radio</td>
                                    <td>
                                        <i class="fa fa-caret-down text-danger pr10"></i>$349,712</td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="fa fa-newspaper-o text-info"></span>
                                    </td>
                                    <td>Newspaper</td>
                                    <td>
                                        <i class="fa fa-caret-up text-info pr10"></i>$1,259,742</td>
                                </tr>
                            </tbody>
                        </table>
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
                        <span class="label label-warning mr5 mb10 ib lh15">Default</span>
                        <span class="label label-primary mr5 mb10 ib lh15">Primary</span>
                        <span class="label label-info mr5 mb10 ib lh15">Success</span>
                        <span class="label label-success mr5 mb10 ib lh15">Info</span>
                        <span class="label label-alert mr5 mb10 ib lh15">Warning</span>
                        <span class="label label-system mr5 mb10 ib lh15">Danger</span>
                        <span class="label label-info mr5 mb10 ib lh15">Success</span>
                        <span class="label label-success mr5 mb10 ib lh15">Ui Design</span>
                        <span class="label label-primary mr5 mb10 ib lh15">Primary</span>

                    </div>
                </div>
                <div class="panel">
                    <div class="panel-heading">
                        <span class="panel-icon">
                            <i class="fa fa-pencil"></i>
                        </span>
                        <span class="panel-title">About Me</span>
                    </div>
                    <div class="panel-body pb5">

                        <h6>Experience</h6>

                        <h4>Facebook Internship</h4>
                        <p class="text-muted"> University of Missouri, Columbia
                            <br> Student Health Center, June 2010 - 2012
                        </p>

                        <hr class="short br-lighter">

                        <h6>Education</h6>

                        <h4>Bachelor of Science, PhD</h4>
                        <p class="text-muted"> University of Missouri, Columbia
                            <br> Student Health Center, June 2010 through Aug 2011
                        </p>

                        <hr class="short br-lighter">

                        <h6>Accomplishments</h6>

                        <h4>Successful Business</h4>
                        <p class="text-muted pb10"> University of Missouri, Columbia
                            <br> Student Health Center, June 2010 through Aug 2011
                        </p>

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
