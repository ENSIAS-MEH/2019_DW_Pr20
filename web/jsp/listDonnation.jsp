<%--
  Created by IntelliJ IDEA.
  User: Mossati-Oussama
  Date: 24/01/2020
  Time: 02:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Donation</title>
    <link rel="stylesheet" href="../frameworks/bootstap4/dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../frameworks/font-awesome/css/fontawesome.min.css">
    <link rel="stylesheet" href="../frameworks/font-awesome/css/regular.min.css">
    <link rel="stylesheet" href="../frameworks/font-awesome/css/solid.min.css">
    <link rel="stylesheet" type="text/css" href="../css/donnation.css">
    <style>
        .card{
            background-color: #f2f2f2;
            border-color: #b21f2d;
        }
    </style>
</head>

<body>

<header>
    <%@ include file="navbar.jsp"%>
</header>
<br>

<div class="row">

    <div class="container">

        <div class="row font-weight-bold text-danger mb-3 border-secondary p-2 m-2 mb-5" style="font-size: 30px;border-left-style: dashed;border-bottom-style: dashed;">
            <span class=""><span class="fas fa-syringe pt-2"></span></span>&nbsp;&nbsp;<h3 class="text-center" id="titre_stats"></h3>
        </div>

        <hr>
        <div class="row">
            <div class="col-lg-12">
                <div class="row">
                    <div class="col-lg mb-2">
                        <div class="card">
                            <div class="card-body">
                                <div class="media d-flex">
                                    <div class="align-self-center">
                                        <img src="/img/A+.png" width="40" height="60">
                                    </div>
                                    <div class="media-body text-right">
                                        <h3 class="text-stat" id="cardAplus" ></h3>       <!--Text ghaykon fih Le nombre dyal kol Groupe-->
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg mb-2">
                        <div class="card">
                            <div class="card-body">
                                <div class="media d-flex">
                                    <div class="align-self-center">
                                        <img src="/img/B+.png" width="40" height="60">
                                    </div>
                                    <div class="media-body text-right">
                                        <h3 class="text-stat" id="cardBplus"></h3>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg mb-2">
                        <div class="card">
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
                    <div class="col-lg mb-2">
                        <div class="card">
                            <div class="card-body">
                                <div class="media d-flex">
                                    <div class="align-self-center">
                                        <img src="/img/O+.png" width="40" height="60">
                                    </div>
                                    <div class="media-body text-right">
                                        <h3 class="text-stat" id="cardOplus"></h3>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg mb-2">
                        <div class="card">
                            <div class="card-body">
                                <div class="media d-flex">
                                    <div class="align-self-center">
                                        <img src="/img/A-.png" width="40" height="60">
                                    </div>
                                    <div class="media-body text-right">
                                        <h3 class="text-stat" id="cardAmoin"></h3>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg mb-2">
                        <div class="card">
                            <div class="card-body">
                                <div class="media d-flex">
                                    <div class="align-self-center">
                                        <img src="/img/B-.png" width="40" height="60">
                                    </div>
                                    <div class="media-body text-right">
                                        <h3 class="text-stat" id="cardBmoin"></h3>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg mb-2">
                        <div class="card">
                            <div class="card-body">
                                <div class="media d-flex">
                                    <div class="align-self-center">
                                        <img src="/img/AB-.png" width="40" height="60">
                                    </div>
                                    <div class="media-body text-right">
                                        <h3 class="text-stat" id="cardABmoin"></h3>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg mb-2">
                        <div class="card">
                            <div class="card-body">
                                <div class="media d-flex">
                                    <div class="align-self-center">
                                        <img src="/img/O-.png" width="40" height="60">
                                    </div>
                                    <div class="media-body text-right">
                                        <h3 class="text-stat" id="cardOmoin"></h3>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <br>
        <div class="row font-weight-bold text-danger mb-3 border-secondary p-2 m-2" style="font-size: 30px;border-left-style: dashed;border-bottom-style: dashed;">
            <span class=""><span class="fas fa-syringe pt-2"></span></span>&nbsp;&nbsp;<h3 class="text-center">La Liste des Donations</h3>
        </div>

        <br><br>
        <div class="row" >

            <div class="input-group mb-3 col-lg-4" >
                <input type="text" id="donnation" class="form-control border-danger" placeholder="Chercher par nom du donnateur">


                <input type="hidden" value='${sessionScope.role}' id="role">

                <c:if test="${sessionScope.role eq 'admin'}">
                    <input type="hidden" value='${sessionScope.admin}' id="session">
                </c:if>

                <c:if test="${sessionScope.role eq 'banquesang'}">
                    <input type="hidden" value='${sessionScope.banquesang.getIdBS()}' id="session">
                    <c:forEach var="ville" items="${villes}">
                        <c:if test="${sessionScope.banquesang.getIdVille() eq ville.idVille}" >
                            <input type="hidden" value="${ville.nomVille}" id="session_ville">
                        </c:if>
                    </c:forEach>
                </c:if>

                <c:if test="${sessionScope.role eq 'donnateur'}">
                    <input type="hidden" value='${sessionScope.donnateur.getIdDonnateur()}' id="session">
                    <c:forEach var="donat" items="${donnateurs}">
                        <c:if test="${sessionScope.donnateur.getIdDonnateur() eq donat.idDonnateur}" >
                            <c:forEach var="donat" items="${donnateurs}">
                                <c:if test="${sessionScope.donnateur.getIdDonnateur() eq donat.idDonnateur}" >
                                    <input type="hidden" value="${donat.idGS}" id="session_gs">
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </c:forEach>
                </c:if>

                <div class="input-group-prepend">
                    <span class="input-group-text"><span class="fa fa-search text-danger"></span></span>
                </div>
            </div>

                    <div class="col-lg-3 mb-3" id="gs_div_container" >
                        <c:if test="${sessionScope.role ne 'donnateur'}">
                        <div id="gs_div" >
                            Groupe sanguin: <select name="GrpSng" id="gs_select" class="form-control">
                                <option value="all">-- All --</option>
                                <option value="A-">A-</option>
                                <option value="A+">A+</option>
                                <option value="B+">B+</option>
                                <option value="B-">B-</option>
                                <option value="AB+">AB+</option>
                                <option value="AB-">AB-</option>
                                <option value="O+">O+</option>
                                <option value="O-">O-</option>
                            </select>
                        </div>
                        </c:if>
                    </div>

                <div class="col-lg-2 mb-3" id="ville_div_container" >
                    <c:if test="${sessionScope.role ne 'banquesang'}">
                    <div id="ville_div">
                        Ville: <select name="villes" id="ville_select" class="form-control">
                            <option value="all">-- All --</option>
                            <c:forEach var="ville" items="${villes}">
                                <option value="<c:out value="${ville.nomVille}"/>"><c:out value="${ville.nomVille}"/></option>
                            </c:forEach>
                        </select>
                    </div>
                    </c:if>
                </div>

            <c:if test="${sessionScope.role ne 'donnateur'}">
                <div class="col-lg-3 float-left mb-3 row justify-content-end" >
                    <a class="btn btn-dark text-white font-weight-bold " data-toggle="modal" data-target="#AjouterDonnation">&nbsp;<span class="fa fa-plus"></span>&nbsp;Ajouter une Donnation</a>
                </div>
            </c:if>

        </div>

        <br>
        <table class="table table-bordered" id="dnt_table">
            <thead class="alert-danger">
            <tr>
                <th onclick='sortTable(1)'>N° donateur</th>
                <th onclick='sortTable(2)'>Nom & Prenom</th>
                <th onclick='sortTable(3)'>Groupe sanguin</th>
                <th onclick='sortTable(4)'>Date de donation</th>
                <th onclick='sortTable(5)'>Banque sanguin</th>
                <th onclick='sortTable(6)'>Téléphone</th>
                <th onclick='sortTable(7)'>Ville</th>
                <!--<c:if test="${sessionScope.role eq 'banquesang'}"><th class="align-content-center">Actions</th></c:if>-->
            </tr>
            </thead>

            <tbody id = "dnt" style="background-color: #f2f2f2">

            <c:forEach var="donnation" items="${donnationList}">
                <tr>
                    <td><c:out value="${donnation.idDonnateur}" /></td>

                    <c:forEach var="donnateur" items="${donnateurs}">
                        <c:if test="${donnateur.idDonnateur eq donnation.idDonnateur}">
                            <td data-toggle="tooltip" data-placement="right" title="Email:<br>Tel:<br>Adresse:">
                                <c:out value="${donnateur.nomD}"/> <c:out value="${donnateur.prenomD}"/>
                            </td>
                            <td>
                                <c:forEach var="gs" items="${gsList}">
                                    <c:if test="${gs.idGS eq donnateur.idGS}">
                                        <c:out value="${gs.nomGS}"/>
                                    </c:if>
                                </c:forEach>
                            </td>
                        </c:if>
                    </c:forEach>

                    <td><fmt:formatDate value="${donnation.dateDonnation}" pattern="dd/MM/yyyy HH:mm"/></td>

                    <c:forEach var="banque" items="${banqueSangList}">
                        <c:if test="${banque.idBS eq donnation.idBS}">
                            <td>
                                <input type="hidden" value="${banque.idBS}" />
                                <c:out value="${banque.nomBS}" />
                            </td>
                            <td><c:out value="${banque.teleBS}" /></td>

                            <c:forEach var="ville" items="${villes}">
                                <c:if test="${banque.idVille eq ville.idVille}">
                                    <td><c:out value="${ville.nomVille}"/></td>
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </c:forEach>
                </tr>
            </c:forEach>

            </tbody>
        </table>
        <div id="warn" ></div>
    </div>
</div>

</body>

<!-- Début Modal - Ajouter Donnation -->
<div class="modal mt-lg-5" id="AjouterDonnation">
    <div class="modal-dialog">
        <div class="modal-content rounded">
            <div class="modal-header alert-danger text-center">
                <h5 class="font-weight-bold modal-title">Ajouter une nouvelle Donation</h5>
                <button type="button" class="close" data-dismiss="modal">x</button>
            </div>
            <div class="modal-body">
                <form>
                    <caption>
                        <h5>

                        </h5>
                    </caption>

                    <fieldset class="form-group">
                        <label>Numéro du donateur</label>
                        <input type="text" class="form-control" id="idD_aj">
                    </fieldset>
                    <div id="warn_dnt" ></div>

                    <fieldset class="form-group">
                        <label>Nom & Prénom</label>
                        <input type="text" class="form-control" id="nomD_aj" disabled>
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Groupe Sanguin</label><br>
                        <input type="text" class="form-control" id="gs_aj" disabled>
                    </fieldset>


                    <button id="aj_btn" class="btn btn-danger align-content-md-center" >
                        Valider
                    </button>

                </form>
            </div>
        </div>
    </div>
</div>
<!-- Fin Modal - Ajouter Donnation -->

<script src="../frameworks/jquery/jquery.js"></script>
<script src="../frameworks/bootstap4/dist/js/bootstrap.bundle.min.js"></script>
<script>

</script>

<script src="../js/donnation.js" type="text/javascript"></script>

</html>
