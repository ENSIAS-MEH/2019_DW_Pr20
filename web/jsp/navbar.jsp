<%--
  Created by IntelliJ IDEA.
  User: Mohamed Amine
  Date: 26/01/2020
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Don du sang</title>
    <style>
        .navbar{
            background: lightgray;
            text-transform: uppercase;

        }
        .nav-link{
            color: #b21f2d !important;
            font-weight: bold;
        }
        .nav-link:hover{
            letter-spacing: 2px;
            text-align: center;
            background: #b21f2d !important;
            color: #bbbbbb !important;
        }
        .navbar-collapse{
            justify-content: center;
        }
    </style>
</head>
<body>
<div class="navbar navbar-expand-lg navbar-dark mb-3">
    <a href="#" class="navbar-brand font-weight-bold text-Danger text-lg-left float-left"><span class="fa fa-tint fa-2x"></span>&nbsp;Don du Sang</a>
    <button type="button" class="navbar-toggler btn btn-outline-danger" data-toggle="collapse" data-target="#nav">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="nav">
        <ul class="navbar-nav">
            <c:if test="${(empty sessionScope.admin)  && (empty sessionScope.banquesang) && (empty sessionScope.donnateur)}">
                <li class="nav-item">
                    <a href="#" class="nav-link p-2 mr-5 rounded">Home</a>
                </li>
                <li class="nav-item">
                    <a href="#" class="nav-link p-2 mr-5 rounded">Statistics</a>
                </li>
                <li class="nav-item">
                    <a href="#" class="nav-link p-2 mr-5 border border-danger rounded">Join US</a>
                </li>
                <li class="nav-item">
                    <a href="/SignIn" class="nav-link mr-5 p-2 border border-danger rounded">Sign In</a>
                </li>
            </c:if>
            <c:if test="${(not empty sessionScope.admin)  || (not empty sessionScope.banquesang) || (not empty sessionScope.donnateur)}">
                <li class="nav-item">
                    <a href="/LogOut" class="nav-link mr-5 p-2 border border-danger rounded">Log Out</a>
                </li>
            </c:if>
        </ul>
    </div>
</div>
</body>
</html>
