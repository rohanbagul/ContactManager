<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Contact Manager Application</title>

<link rel="stylesheet"
 href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
 integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
 crossorigin="anonymous">

</head>

</head>
<body>
 <header>
  <nav class="navbar navbar-expand-md navbar-dark"
   style="background-color: tomato">
   <div>
    <a href="https://www.javaguides.net" class="navbar-brand"> Contacts Manager</a>
   </div>

   <ul class="navbar-nav">
    <li><a href="<%=request.getContextPath()%>/list"
     class="nav-link">Contacts</a></li>
   </ul>

   <ul class="navbar-nav navbar-collapse justify-content-end">
    <li><a href="<%=request.getContextPath()%>/logout"
     class="nav-link">Logout</a></li>
   </ul>
  </nav>
 </header>
 <div class="container col-md-5">
  <div class="card">
   <div class="card-body">
    <c:if test="${contacts != null}">
     <form action="update" method="post">
    </c:if>
    <c:if test="${contacts == null}">
     <form action="insert" method="post">
    </c:if>

    <caption>
     <h2>
      <c:if test="${contacts != null}">
               Edit Contacts
              </c:if>
      <c:if test="${contacts == null}">
               Add New Contact
              </c:if>
     </h2>
    </caption>

    <c:if test="${contacts != null}">
     <input type="hidden" name="id" value="<c:out value='${contacts.id}' />" />
    </c:if>

    <fieldset class="form-group">
     <label>First Name</label> <input type="text"
      value="<c:out value='${contacts.firstName}' />" class="form-control"
      name="firs_tName" required="required" minlength="5">
    </fieldset>

    <fieldset class="form-group">
     <label>Last Name</label> <input type = "text"
      value="<c:out value='${contacts.lastName}' />" class="form-control"
      name="last_Name" required="required" minlength="5">
    </fieldset>

    <fieldset class="form-group">
     <label>Todo Target Date</label> <input type="date"
      value="<c:out value='${todo.targetDate}' />" class="form-control"
      name="targetDate" required="required">
    </fieldset>
    <fieldset class="form-group">
     <label>Moile No</label> <input type = "number"
      value="<c:out value='${contacts.mobileNo}' />" class="form-control"
      name="mobile no." required="required" minlength="5">
    </fieldset>

    <button type="submit" class="btn btn-success">Save</button>
    </form>
   </div>
  </div>
 </div>

 <jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>