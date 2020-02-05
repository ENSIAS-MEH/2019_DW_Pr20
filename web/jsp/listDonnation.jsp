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
</head>

<body>

<header>
    <%@ include file="navbar.jsp"%>
</header>
<br>

<div class="row">

    <div class="container">
        <h3 class="text-center">La Liste des Donations</h3>
        <hr>
        <div class="row">
            <div class="input-group mb-3 col-lg-4" >
                <input type="text" id="donnation" class="form-control border-danger" placeholder="Chercher par nom du donnateur">


                <input type="hidden" value='${sessionScope.role}' id="role">

                <c:if test="${sessionScope.role eq 'admin'}">
                    <input type="hidden" value='${sessionScope.admin}' id="session">
                </c:if>
                <c:if test="${sessionScope.role eq 'banquesang'}">
                    <input type="hidden" value='${sessionScope.banquesang.getIdBS()}' id="session">
                </c:if>
                <c:if test="${sessionScope.role eq 'donnateur'}">
                    <input type="hidden" value='${sessionScope.donnateur.getIdDonnateur()}' id="session">
                </c:if>

                <div class="input-group-prepend">
                    <span class="input-group-text"><span class="fa fa-search text-danger"></span></span>
                </div>
            </div>
            <div class="col-lg-3 mb-3" id="gs_div_container">
                <div id="gs_div">
                    Groupe sanguin:
                    <select name="GrpSng" id="gs_select">
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

            </div>

            <div class="col-lg-2 mb-3" id="ville_div_container">
                <div id="ville_div">
                    Ville:
                    <select name="villes" id="ville_select">
                        <option value="all">-- All --</option>
                        <c:forEach var="ville" items="${villes}">
                            <option value="<c:out value="${ville.nomVille}"/>"><c:out value="${ville.nomVille}"/></option>
                        </c:forEach>
                    </select>
                </div>

            </div>

            <div class="col-lg-3 float-left mb-3 row justify-content-end" >
                <a class="btn btn-outline-dark font-weight-bold " data-toggle="modal" data-target="#AjouterDonnation">&nbsp;<span class="fa fa-plus"></span>&nbsp;Ajouter une Donnation</a>
            </div>
        </div>

        <br>
        <table class="table table-bordered" id="dnt_table">
            <thead>
            <tr>
                <th onclick='sortTable(1)'>N° donateur</th>
                <th onclick='sortTable(2)'>Nom & Prenom</th>
                <th onclick='sortTable(3)'>Groupe sanguin</th>
                <th onclick='sortTable(4)'>Date de donation</th>
                <th onclick='sortTable(5)'>Banque sanguin</th>
                <th onclick='sortTable(6)'>Téléphone</th>
                <th onclick='sortTable(7)'>Ville</th>
                <th class="align-content-center">Actions</th>
            </tr>
            </thead>

            <tbody id = "dnt">

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
                            <td><c:out value="${banque.nomBS}" /></td>
                            <td><c:out value="${banque.teleBS}" /></td>

                            <c:forEach var="ville" items="${villes}">
                                <c:if test="${banque.idVille eq ville.idVille}">
                                    <td><c:out value="${ville.nomVille}"/></td>
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </c:forEach>

                    <td >
                        <a data-toggle="modal" href="#ModifierDonnation">
                                <span class="shadow text-danger p-2" data-toggle="tooltip" title="Modifier" data-placement="left">
                                    <span class="fa fa-pen" aria-hidden="true"></span>
                                </span>
                        </a>
                        <a data-toggle="modal" href="#sup_modal">
                                <span class="shadow text-danger p-2 " data-toggle="tooltip" title="Supprimer" data-placement="right">
                                    <span class="fa fa-trash" aria-hidden="true"></span>
                                </span>
                        </a>
                    </td>
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
                        <input type="text" class="form-control" name="idD_aj" id="idD_aj" required>
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Nom & Prénom</label>
                        <input type="text" class="form-control" name="nomD_aj" id="nomD_aj" required>
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Groupe Sanguin</label><br>
                        <select name="GrpSng" name="gs_aj" id="gs_aj">
                            <option value="">-- Choisissez un groupe sanguin --</option>
                            <option value="A-">A-</option>
                            <option value="A+">A+</option>
                            <option value="B+">B+</option>
                            <option value="B-">B-</option>
                            <option value="AB+">AB+</option>
                            <option value="AB-">AB-</option>
                            <option value="O+">O+</option>
                            <option value="O-">O-</option>
                        </select>
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Date de donation</label>
                        <input type="datetime-local" class="form-control" name="dateD_aj" id="dateD_aj" required>
                    </fieldset>


                    <button id="aj_btn" class="btn btn-danger align-content-md-center" style="float: right;">
                        Valider
                    </button>

                </form>
            </div>
        </div>
    </div>
</div>
<!-- Fin Modal - Ajouter Donnation -->

<!-- Début Modal - Modifier Donnation -->
<div class="modal mt-lg-5" id="ModifierDonnation">
    <div class="modal-dialog">
        <div class="modal-content rounded">
            <div class="modal-header alert-danger text-center">
                <h5 class="font-weight-bold modal-title">Modifier une Donation</h5>
                <button type="button" class="close" data-dismiss="modal">x</button>
            </div>
            <div class="modal-body">
                <form>
                    <caption>
                        <h5>

                        </h5>
                    </caption>

                    <input type="hidden" name="idDonnateur" value="-1" />

                    <fieldset class="form-group">
                        <label>Numéro du donateur</label>
                        <input type="text" class="form-control" name="idD_md" id="idD_md">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Nom & Prénom</label>
                        <input type="text" class="form-control" name="nomD_md" id="nomD_md">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Groupe Sanguin</label><br>
                        <select name="GrpSng" name="gs_md" id="gs_md">
                            <option value="">-- Choisissez un groupe sanguin --</option>
                            <option value="A-">A-</option>
                            <option value="A+">A+</option>
                            <option value="B+">B+</option>
                            <option value="B-">B-</option>
                            <option value="AB+">AB+</option>
                            <option value="AB-">AB-</option>
                            <option value="O+">O+</option>
                            <option value="O-">O-</option>
                        </select>
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Date de donation</label>
                        <input type="datetime-local" class="form-control" name="dateD_md" id="dateD_md">
                    </fieldset>


                    <button id="md_btn" class="btn btn-danger align-content-md-center" style="float: right;">
                        Valider
                    </button>

                </form>
            </div>
        </div>
    </div>
</div>
<!-- Fin Modal - Modifier Donnation -->

<!-- Début Modal - Supprimer Donnation -->
<div class="modal mt-lg-5" id="sup_modal">
    <div class="modal-dialog">
        <div class="modal-content rounded">
            <div class="modal-body alert-dark">
                <p class="font-weight-bold text-center">Voulez vous vraiment supprimer cette Banque du sang ? </p>
                <div>
                    <button class="btn btn-outline-dark float-left" data-dismiss="modal" type="button">
                        Annuler
                    </button>
                    <a class="btn btn-outline-danger float-right" type="button" id="supp_dnt">
                        Supprimer
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="../frameworks/jquery/jquery.js"></script>
<script src="../frameworks/bootstap4/dist/js/bootstrap.bundle.min.js"></script>
<script>

</script>

<script src="../js/donnation.js" type="text/javascript"></script>

</html>
