<%-- 
    Document   : card
    Created on : Jan 5, 2021, 9:27:01 PM
    Author     : DENISA
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="title"%>
<%@attribute name="description"%>
<%@attribute name="link"%>

<!--  <div class="card">
    <img src="https://picsum.photos/seed/picsum/400" class="card-img-top" alt="...">
    <div class="card-body">
      <h5 class="card-title">${title}</h5>
      <p class="card-text">${description}</p>
    </div>
      <div class="card-footer">
      <small class="text-muted">Last updated 3 mins ago</small>
    </div>
  </div>-->
      
    <div class="card mb-3" style="max-width: 540px;">
  <div class="row g-0">
    <div class="col-md-4">
      <img src="https://picsum.photos/seed/picsum/400" class="card-img-top" alt="...">
    </div>
    <div class="col-md-8">
      <div class="card-body">
       <h5 class="card-title">${title}</h5>
         <p class="card-text">${description}</p>
        <p class="card-text"><a href="${link}" class="card-link">Go to job post</a></p>
      </div>
    </div>
  </div>
</div>
      