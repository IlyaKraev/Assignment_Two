<%-- 
    Document   : list
    Created on : Dec 15, 2020, 7:11:54 PM
    Author     : Helios

    Note       : Try removing the .js to see if the form will accept your wrong input (it won't)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Trainer</title>
        <c:url value="/css/style.css" var="jstlCss" />
        <link href="${jstlCss}" rel="stylesheet" />
        <link rel="shortcut icon" href="/img/favicon.ico" />
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
        <div class="main">
            <div class="form">
                <h2><i class="fa fa-user-circle" aria-hidden="true"></i> Edit Trainer</h2>
                <f:form method="POST" action="/update" modelAttribute="trainer">
                    <f:input type="hidden" path="id" id="id"/>
                    <div class="form-field">
                        <f:input path="firstname" placeholder="First name" autocomplete="off"/><br>
                        <small></small>
                    </div>
                    <div class="form-field">
                        <f:input path="lastname" placeholder="Last name" autocomplete="off"/><br>
                        <small></small>
                    </div>
                    <div class="form-field">
                        <f:label path="dateofbirth" for="dateofbirth" >Date of Birth</f:label>
                        <f:input path="dateofbirth" type="date" /><br>
                        <small></small>
                    </div>
                    <div class="form-field">
                        <f:input path="subject" placeholder="Subject" autocomplete="off"/><br>
                        <small></small>
                    </div>
                    <div class="form-field">
                        <input type="submit" value="Update" class="submit" />
                        <input type="reset" value="Clear" class="clear" /><br>
                    <f:errors path="*" >${error}</f:errors> 
                    </div>
                </f:form>
            </div>
        </div>
        <div class="footer">Ilya Kraev - Coding Bootcamp 12 &copy; 2020</div>
        <script src="/js/script.js"></script>
    </body>
</html>
