<%-- 
    Document   : list
    Created on : Dec 15, 2020, 7:11:54 PM
    Author     : Helios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trainer List</title>
        <c:url value="/css/style.css" var="jstlCss" />
        <link href="${jstlCss}" rel="stylesheet" />
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
        <h1>Welcome to the Sisyphus Private School Management System!</h1>
        <p id="error">Due to an unknown error you may only access the trainers section.</p>
        <div class="main">
            <form class="form" method="POST">
                <table>
                    <tr>
                        <th>Id (Click to edit) </th><th>First Name</th><th>Last Name</th><th>Date of Birth</th><th>Subject</th><th>X</th>
                    </tr>
                    <c:forEach items="${trainers}" var="trainer">
                    <tr>
                        <td><a class="tid" href="<c:url value='${editurl}/${trainer.id}' />">${trainer.id}</a></td>
                        <td>${trainer.firstname}</td>
                        <td>${trainer.lastname}</td>
                        <td>${trainer.dateofbirth}</td>
                        <td>${trainer.subject}</td>
                        <td><a class="delete" href="<c:url value='${deleteurl}/${trainer.id}' />">delete</a></td>
                    </tr>
                    </c:forEach>
                </table>
            </form>
        </div>
        <div class="footer">Ilya Kraev - Coding Bootcamp 12 &copy; 2020</div>
    </body>
</html>
