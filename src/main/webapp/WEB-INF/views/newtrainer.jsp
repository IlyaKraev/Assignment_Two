<%-- 
    Document   : list
    Created on : Dec 15, 2020, 7:11:54 PM
    Author     : Helios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trainer List</title>
        <c:url value="/css/style.css" var="jstlCss" />
        <link href="${jstlCss}" rel="stylesheet" />
        <script src="https://use.fontawesome.com/95932934dd.js"></script>
    </head>
    <body>
        <div class="header">
            <img src="/img/logo.png" alt="logo">
        </div>
        <div class="nav">
            <ul>
                <li><a href="<c:url value='/${listurl}' />">Trainer list</a></li>
                <li><a href="<c:url value='/${newurl}' />"">New Trainer</a></li>
            </ul>
        </div>    
        <h1>Project name: ${projectName}</h1>
        <div class="main">
            <div class="form">
                <h2><i class="fa fa-user-circle" aria-hidden="true"></i> New Trainer</h2>
                <form:form method="POST" action="new" id="tform" class="form" modelAttribute="trainer">
                    <form:input type="hidden" path="id" id="id"/>
                    <div class="form-field">
                        <form:input path="firstName" placeholder="First name" autocomplete="off"/>
                    </div>
                    <div class="form-field">
                        <form:input path="lastName" placeholder="Last name" autocomplete="off"/>
                    </div>
                    <div class="form-field">
                        <form:input path="dateOfBirth" value="${myDate}" type="date" /><br/>
                    </div>
                    <div class="form-field">
                        <form:input path="subject" placeholder="Subject" autocomplete="off"/>
                    </div>
                    <div class="form-field">
                        <input id="tsumbmit" type="submit" value="Submit" class="submit" />
                        <input id="treset" type="reset" value="Clear" class="clear" />
                    </div>
                </form:form>
            </div>
        </div>
        <div class="footer">Ilya Kraev - Coding Bootcamp 12 &copy; 2020</div>
    </body>
</html>
