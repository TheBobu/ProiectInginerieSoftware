  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style><%@include file="/WEB-INF/css/main.css"%></style>


<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages" />
<t:pageTemplate pageTitle="Jobs">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-6"><img style="width:670px;height:500px;margin-top: 15%;margin-left:20%;" src="http://andreeapurta.com/proiectIngSoftware/imageHomepage1-min.png" alt="JobIcons">
            </div>
            <div class="col-md-6">
                <h2 class="main-title-homepage"><fmt:message key="label.home.title" /></h2>
                <p class="main-subtitle-homepage">Lorem ipsum dolor sit amet, consectetur adipiscing elit.<br> Aenean in vulputate mauris. Morbi interdum orci sit amet lobortis lobortis. <br>Maecenas id finibus dolor. Suspendisse tincidunt pharetra fringilla.</p>
                <button type="button" class="btn btn-homepage"><fmt:message key="label.home.button" /></button>
            </div>
        </div>
    </div>
</t:pageTemplate>