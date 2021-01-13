<%-- 
    Document   : comment-section
    Created on : Jan 11, 2021, 7:36:18 PM
    Author     : Deea
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style><%@include file="/WEB-INF/css/comment.css"%></style>

<!DOCTYPE html>
<t:pageTemplate pageTitle="Comment-section">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <section class="content-item" id="comments">
        <div class="container">   
            <div class="row">
                <div class="col-sm-8">   
                    <form method="POST" action="${pageContext.request.contextPath}/Comment?id=${id}">
                        <h3 class="pull-left">New Comment</h3>
                        <fieldset>
                            <div class="row">
                                <div class="col-sm-3 col-lg-2 hidden-xs">
                                    <img class="img-responsive" src="https://bootdey.com/img/Content/avatar/avatar1.png" alt="">
                                </div>
                                <div class="form-group col-xs-12 col-sm-9 col-lg-10">
                                    <textarea name="comment" class="form-control" id="message" placeholder="Your message" required=""></textarea>
                                </div>
                            </div>  	
                        </fieldset>
                        <button type="submit" class="btn btn-normal pull-right">Submit</button>
                    </form>

                    <h3>${numberOfComments} Comments</h3>

                    <!-- COMMENT - START -->
                    <c forEach var="comment" items="${comments}" varStatus="status">
                        <div class="media">
                            <a class="pull-left" href="#"><img class="media-object" src="https://bootdey.com/img/Content/avatar/avatar1.png" alt=""></a>
                            <div class="media-body">
                                <h4 class="media-heading">${comment.username}</h4>
                                <p>${comment.comment}</p>
                                <ul class="list-unstyled list-inline media-detail pull-left">
                                    <li><i class="fa fa-calendar"></i>${comment.date}</li>
                                </ul>
                            </div>
                        </div>
                    </c>
                    <!-- COMMENT - END -->
                </div>
            </div>
        </div>
    </section>
</t:pageTemplate>