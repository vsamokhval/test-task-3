<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
    <title>Messages list</title>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  </head>
  <body ng-app="myApp" class="ng-cloak">
      <div class="generic-container">
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">List of Messagess </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>User name</th>
                              <th>Message text</th>
                              <th width="20%">Actions</th>
                          </tr>
                      </thead>
                      <tbody>

                          <c:forEach items="${messages}" var="msg">
                              <tr>
                                  <td>${msg.recipient.name}</td>
                                  <td>${msg.content}</td>
                                  <td>
                                      <a href="<c:url value='/edit-msg-${msg.id}' />" class="btn btn-success custom-width">Edit</a>
                                      <button type="button" class="btn btn-danger custom-width delete-button" data-id="${msg.id}">Delete</button>
                                  </td>
                              </tr>
                          </c:forEach>

                      </tbody>
                  </table>
              </div>
          </div>


          <div class="well">
              <a href="<c:url value='/newmessage' />" class="btn btn-lg btn-primary">Add New Message</a>
          </div>

      </div>

      <script src="<c:url value='/static/js/index.js' />"></script>
  </body>
</html>