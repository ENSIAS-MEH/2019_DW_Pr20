<%--
  Created by IntelliJ IDEA.
  User: Berlin
  Date: 1/30/2020
  Time: 11:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Les Statistiques</title>
    <link rel="stylesheet" href="../frameworks/bootstap4/dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../frameworks/font-awesome/css/fontawesome.min.css">
    <link rel="stylesheet" href="../frameworks/font-awesome/css/regular.min.css">
    <link rel="stylesheet" href="../frameworks/font-awesome/css/solid.min.css">
    <style>
        .card{
            background-color: #f2f2f2;
            border-color: #b21f2d;
        }
    </style>
</head>

<body>
<c:if test="${empty sessionScope.admin}">
    <c:redirect url="/SignIn"></c:redirect>
</c:if>
<header>
    <%@ include file="navbar.jsp"%>
</header>
<br>

    <div class="container">
        <div class="row font-weight-bold text-danger mb-3 border-secondary p-2 m-2 mb-5" style="font-size: 30px;border-left-style: dashed;border-bottom-style: dashed;">
            <span class=""><span class="fas fa-chart-line pt-2"></span></span>&nbsp;&nbsp;Statistiques
        </div>
    <div class="row">
        <div class="col-lg-3 ml-1 col-md-6 mb-3">
            <select name="villes" id="ville_select" class="form-control">
                <option value="all" >-- All --</option>
                <c:forEach var="ville" items="${villes}">
                    <option value="<c:out value="${ville.idVille}"/>"><c:out value="${ville.nomVille}"/></option>
                </c:forEach>
            </select>
        </div>
        <div class="col-lg-3 col-md-6 mb-3">
            <select name="banques" id="banq_select" class="form-control">
                <option value="all ">-- All --</option>
            </select>
        </div>
    </div>
    <div class="row mt-3">
        <div class="col-lg-6">
            <div class="row">
                <div class="col-lg-6 mb-2">
                    <div class="card border rounded border-danger" style="background-color: #f2f2f2">
                        <div class="card-body">
                            <div class="media d-flex">
                                <div class="align-self-center">
                                    <img src="/img/A+.png" width="40" height="60">
                                </div>
                                <div class="media-body text-right">
                                    <h3 class="text-stat" id="cardAplus">L</h3>       <!--Text ghaykon fih Le nombre dyal kol Groupe-->

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 mb-2">
                    <div class="card border rounded border-danger">
                        <div class="card-body">
                            <div class="media d-flex">
                                <div class="align-self-center">
                                    <img src="/img/B+.png" width="40" height="60">
                                </div>
                                <div class="media-body text-right">
                                    <h3 class="text-stat" id="cardBplus">L</h3>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 mb-2">
                    <div class="card border rounded border-danger">
                        <div class="card-body">
                            <div class="media d-flex">
                                <div class="align-self-center">
                                    <img src="/img/AB+.png" width="40" height="60">
                                </div>
                                <div class="media-body text-right">
                                    <h3 class="text-stat" id="cardABplus"></h3>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 mb-2">
                    <div class="card border rounded border-danger">
                        <div class="card-body">
                            <div class="media d-flex">
                                <div class="align-self-center">
                                    <img src="/img/O+.png" width="40" height="60">
                                </div>
                                <div class="media-body text-right">
                                    <h3 class="text-stat" id="cardOplus">L</h3>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 mb-2">
                    <div class="card border rounded border-danger">
                        <div class="card-body">
                            <div class="media d-flex">
                                <div class="align-self-center">
                                    <img src="/img/A-.png" width="40" height="60">
                                </div>
                                <div class="media-body text-right">
                                    <h3 class="text-stat" id="cardAmoin">L</h3>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 mb-2">
                    <div class="card border rounded border-danger">
                        <div class="card-body">
                            <div class="media d-flex">
                                <div class="align-self-center">
                                    <img src="/img/B-.png" width="40" height="60">
                                </div>
                                <div class="media-body text-right">
                                    <h3 class="text-stat" id="cardBmoin">L</h3>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 mb-2">
                    <div class="card border rounded border-danger">
                        <div class="card-body">
                            <div class="media d-flex">
                                <div class="align-self-center">
                                    <img src="/img/AB-.png" width="40" height="60">
                                </div>
                                <div class="media-body text-right">
                                    <h3 class="text-stat" id="cardABmoin">L</h3>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 mb-2">
                    <div class="card border rounded border-danger">
                        <div class="card-body">
                            <div class="media d-flex">
                                <div class="align-self-center">
                                    <img src="/img/O-.png" width="40" height="60">
                                </div>
                                <div class="media-body text-right">
                                    <h3 class="text-stat" id="cardOmoin">L</h3>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-6">
            <div class="card pb-2 border border-danger">
                <div class="card-body">
                    <div id="container2" style="margin: 0 auto"></div>
                </div>
            </div>
        </div>
    </div>

    <br>
    <!-- Script for stat -->
    <script src="../frameworks/js/chart.js"></script>
    <script src="../js/stock.js"></script>
    <script src="../frameworks/js/highcharts.js"></script>
    <script src="../frameworks/js/exporting.js"></script>
    <script src="../frameworks/js/export-data.js"></script>
    <script src="../frameworks/js/series-label.js"></script>
    <script src="../frameworks/js/data.js"></script>
    <script src="../frameworks/js/drilldown.js"></script>
    <script src="../frameworks/jquery/jquery.js"></script>
    <script src="../frameworks/bootstap4/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Statistic Script-->
    <!-- End Script for Stat -->
    </div>
</body>
</html>
