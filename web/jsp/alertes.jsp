<%--
  Created by IntelliJ IDEA.
  User: Mohamed Amine
  Date: 24/01/2020
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Donnation du sang</title>
    <link rel="stylesheet" href="../frameworks/bootstap4/dist/css/bootstrap.min.css"/>
    <style>
        .myCard{
            position: absolute;
            left: 43%;
            top: -20px;
            border-radius: 50%;
        }
        .myCard1{
            position: absolute;
            left: 5%;
            top: -20px;
            border-radius: 50%;
        }
        .myCard2{
            position: absolute;
            left: 80%;
            top: -20px;
            border-radius: 50%;
        }
        .twitter-timeline{
            height: 150px;
        }

    </style>
</head>
<body>
<%@ include file="navbar.jsp"%>
<br>
    <div class="container">
        <div class="row font-weight-bold text-danger mb-3 border-secondary p-2 m-2 mb-5" style="font-size: 30px;border-left-style: dashed;border-bottom-style: dashed;">
            <span class=""><span class="fa fa-bell pt-2"></span></span>&nbsp;&nbsp;Alertes des Besoins
        </div>
        <div class="row">
            <div class="input-group mb-3 col-lg-5">
                <input type="text" id="grp" class="form-control border-danger" placeholder="Chercher une alerte">
                <div class="input-group-prepend">
                    <span class="input-group-text"><span class="fa fa-search text-danger"></span></span>
                </div>
            </div>
            <c:if test="${not empty sessionScope.banquesang}">
                <div class="col-lg-7 float-left mb-3 row justify-content-end">
                    <a class="btn btn-outline-dark font-weight-bold " data-toggle="modal" href="#AjouterAlerte">&nbsp;<span class="fa fa-plus"></span>&nbsp;Ajouter une alerte</a>
                </div>

                <div class="modal mt-lg-5" id="AjouterAlerte">
                    <div class="modal-dialog">
                        <div class="modal-content rounded">
                            <div class="modal-header alert-danger text-center">
                                <h5 class="font-weight-bold modal-title">Informations de l'alerte</h5>
                                <button type="button" class="close" data-dismiss="modal">x</button>
                            </div>
                            <div class="modal-body">
                                <form action="Alertes" method="post">
                                    <div class="form-group">
                                        <label for="desc" class='control-label'>Description de l'alerte</label>
                                        <textarea type="text" rows="5" name="desc" class="form-control" id="desc"></textarea>
                                    </div>
                                    <div class="form-group required">
                                        <label for="GS" class='control-la'>Groupe sangin</label>
                                        <select class="form-control" id="GS" name="groupesangin">
                                            <option value="-1">Choisir un groupe sangin</option>
                                            <c:forEach items="${groupes}" var="group" >
                                                <option value="${group.idGS}"><c:out value="${group.nomGS}"/></option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <button class="btn btn-outline-danger btn-rounded btn-block z-depth-0 my-4" type="submit">
                                        Ajouter l'alerte
                                    </button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>
        </div>
        <hr>
        <c:if test="${empty alertes}">
            <div class="text-center p-3 m-3 alert alert-dark alert-dismissible fade show font-weight-bold text-danger mt-5" role="alert">
                Pas d'alertes de besoin pour l'instant!
                <button type="button" class="btn btn-outline-danger close" data-dismiss="alert" aria-label="Close">
                    <span>&times;</span>
                </button>
            </div>
        </c:if>
        <c:if test="${not empty alertes}">
            <div class=" w-100 mt-5" id="alt">
                <div class="col-lg-5 float-lg-right">
                    <a class="twitter-timeline" href="https://twitter.com/Donation_Sang" data-height="600">Tweets by @Donation_Sang</a>
                </div>
                <div class="col-lg-7">
                    <c:forEach items="${alertes}" var="alerte">
                        <div class="col-md-12 altr">
                            <div class="card border-danger mr-1 ml-1 mb-5 alert-danger">
                                <div class="card border-danger shadow text-danger bg-white p-3 myCard">
                                    <span class="fa fa-tint" aria-hidden="true"></span>
                                </div>
                                <c:if test="${not empty sessionScope.banquesang}">
                                    <a data-toggle="modal" href="#D${alerte.idAlerte}">
                                        <span class="card border-danger shadow text-danger bg-white p-3 myCard1" data-toggle="tooltip" title="Désactiver l'alerte">
                                            <span class="fa fa-power-off" aria-hidden="true"></span>
                                        </span>
                                    </a>
                                    <a data-toggle="modal" href="#S${alerte.idAlerte}">
                                        <span class="card border-danger shadow text-danger bg-white p-3 myCard2" data-toggle="tooltip" title="Supprimer l'alerte">
                                            <span class="far fa-trash-alt" aria-hidden="true"></span>
                                        </span>
                                    </a>
                                </c:if>
                                <br>
                                <div class="p-2">
                                        ${alerte.descriptionAlerte}
                                </div>
                                <div class="card-footer p-2 bg-white">
                                <span class="mr-1 float-left">
                                    <span class="fa fa-tint text-danger"></span>&nbsp;
                                    ${alerte.GS.nomGS}
                                </span>
                                    <span class="float-right">
                                    <span class="fas fa-calendar text-danger"></span>&nbsp;
                                    <fmt:formatDate value="${alerte.dateAlerte}" pattern="dd/MM/yyyy HH:mm"/>
                                </span>
                                </div>
                            </div>
                            <c:if test="${not empty sessionScope.banquesang}">
                                <div class="modal mt-lg-5" id="D${alerte.idAlerte}">
                                    <div class="modal-dialog">
                                        <div class="modal-content rounded">
                                            <div class="modal-body alert-dark">
                                                <p class="font-weight-bold text-center">Voulez vous vraiment désactiver cet alerte ? </p>
                                                <div>
                                                    <button class="btn btn-outline-dark float-left" data-dismiss="modal" type="button">
                                                        Annuler
                                                    </button>
                                                    <a class="btn btn-outline-danger float-right" type="button" href="TraiterAlerte?d=${alerte.idAlerte}">
                                                        Désactiver
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="modal mt-lg-5" id="S${alerte.idAlerte}">
                                    <div class="modal-dialog">
                                        <div class="modal-content rounded">
                                            <div class="modal-body alert-dark">
                                                <p class="font-weight-bold text-center">Voulez vous vraiment supprimer cet alerte ? </p>
                                                <div>
                                                    <button class="btn btn-outline-dark float-left" data-dismiss="modal" type="button">
                                                        Annuler
                                                    </button>
                                                    <a class="btn btn-outline-danger float-right" type="button" href="TraiterAlerte?s=${alerte.idAlerte}">
                                                        Supprimer
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:if>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </c:if>
    </div>
</body>
<script src="../frameworks/jquery/jquery.js"></script>
<script src="../frameworks/bootstap4/dist/js/bootstrap.bundle.min.js"></script>
<script async src="https://platform.twitter.com/widgets.js" charset="utf-8"></script>
<script>
    $(function(){
        $('[data-toggle="tooltip"]').tooltip();
        $('#grp').on("keyup",function(){
            var value=$(this).val().toLowerCase();
            $('#alt .altr').filter(function(){
                $(this).toggle($(this).text().toLowerCase().indexOf(value)>-1);
            });
        });
    });
</script>
</html>
