<%--
  Created by IntelliJ IDEA.
  User: Mohamed Amine
  Date: 26/01/2020
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="../frameworks/bootstap4/dist/css/bootstrap.min.css"/>
    <style>
        .myCard{
            position: absolute;
            left: 43%;
            top: -40px;
            border-radius: 46%;
        }
        .form-group i{
            position: absolute;
        }
        i{
            padding: 10px;
            min-width: 50px;
            text-align: center;
        }
    </style>
</head>
<body>
<%@ include file="navbar.jsp"%>
<br><br><br>
<div class="container ">
    <div class="row justify-content-center">
        <div class="card col-lg-6 m-3 p-0 border-danger h-100">
            <div class="card border-danger shadow text-danger alert-dark p-4 myCard">
                <span class="fa fa-tint fa-2x" aria-hidden="true"></span>
            </div>
            <div class="card-header bg-danger text-white text-center font-weight-bold pt-5" style="font-size: 30px">
                Sign In
            </div>
            <img class="card-img-top border-bottom border-danger h-50" src="../img/log.jpg">
            <div class="card-body">
                <form action="/SignIn" method="post">
                    <div class="form-group p-2">
                        <i class="fa fa-user text-danger"></i>
                        <input type="text" class="form-control text-center" placeholder="Username" required="required" name="username">
                    </div>
                    <div class="form-group p-2">
                        <i class="fa fa-lock text-danger"></i>
                        <input type="password" class="form-control text-center" placeholder="Password" required="required" name="password">
                    </div>
                    <c:if test="${not empty error}">
                        <p class="text-center text-danger font-italic m-1 p-1">${error}</p>
                    </c:if>

                    <div class="form-group">
                        <input type="submit" class="btn btn-outline-dark form-control btn-lg" value="Login">
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div>

    </div>
</div>
</body>
<script src="../frameworks/jquery/jquery.js"></script>
<script src="../frameworks/bootstap4/dist/js/bootstrap.min.js"></script>
</html>
