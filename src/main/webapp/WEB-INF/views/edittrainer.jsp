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
        <title>Edit Trainer</title>
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
        <div class="main">
            <div class="form">
                <h2><i class="fa fa-user-circle" aria-hidden="true"></i> Edit Trainer</h2>
                <%
                    String updateUrlFINAL = request.getContextPath() + "/" + request.getAttribute("updateurl");
                    session.setAttribute("updateUrlFINAL", updateUrlFINAL);
                %>
                <form:form method="POST" action="${updateUrlFINAL}" modelAttribute="trainer">
                    <form:input type="hidden" path="id" id="id"/>
                    <div class="form-field">
                        <form:input path="firstname" placeholder="First name" autocomplete="off"/>
                    </div>
                    <div class="form-field">
                        <form:input path="lastname" placeholder="Last name" autocomplete="off"/>
                    </div>
                    <div class="form-field">
                        <form:input path="dateofbirth" value="${myDate}" type="date" /><br/>
                    </div>
                    <div class="form-field">
                        <form:input path="subject" placeholder="Subject" autocomplete="off"/>
                    </div>
                    <div class="form-field">
                        <input type="submit" value="Update" class="edit" />
                        <input type="reset" value="Clear" class="clear" />
                    </div>
                </form:form>
            </div>
        </div>
        <div class="footer">Ilya Kraev - Coding Bootcamp 12 &copy; 2020</div>
    </body>
</html>
