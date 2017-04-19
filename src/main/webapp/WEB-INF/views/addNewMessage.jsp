<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
    <title>add-edit message</title>
     <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
    </head>
    <body>

        <div class="generic-container">
            <form:form method="POST" modelAttribute="message" class="form-horizontal">
                <form:input type="hidden" path="id" id="id"/>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="recipient">User name</label>
                            <form:input type="text" path="recipient.name" id="recipient" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="recipient.name" class="help-inline"/>
                            </div>
                    </div>
                </div>

                <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-3 control-lable" for="content">Message text</label>
                            <div class="col-md-7">
                                <form:textarea type="text" path="content" id="content" class="form-control" />
                            </div>
                        </div>
                    </div>

                <div class="row">
                    <c:choose>
                        <c:when test="${edit}">
                            <input type="submit" value="Update" class="btn btn-primary btn-sm"/>
                            <a href="<c:url value='/' />" class="cancel-link">Cancel</a>
                        </c:when>
                        <c:otherwise>
                            <input type="submit" value="Add" class="btn btn-primary btn-sm"/>
                            <a href="<c:url value='/' />" class="cancel-link">Cancel</a>
                        </c:otherwise>
                    </c:choose>
                </div>
            </form:form>
        </div>

  </body>
</html>