<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 06/02/2020
  Time: 01:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Donateur</title>
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
        <div class="row font-weight-bold text-danger mb-3 border-secondary p-2 m-2 mb-5" style="font-size: 30px;border-left-style: dashed;border-bottom-style: dashed;">
            <span class=""><span class="fas fa-users-cog pt-2"></span></span>&nbsp;&nbsp;Donateurs
        </div>
        <div class="row" >
            <div class="input-group mb-3 col-lg-4" >
                <input type="text" id="donnateur" class="form-control border-danger" placeholder="Chercher un donnateur">


                <!-- Debut -- variables de sessions pour des besoins de js -->

                <!-- Fin -- variables de sessions pour des besoins de js -->
                <div class="input-group-prepend">
                    <span class="input-group-text"><span class="fa fa-search text-danger"></span></span>
                </div>
            </div>

            <div class="col-lg-3 mb-3" id="gs_div_container" >
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
            </div>

            <div class="col-lg-2 mb-3" id="ville_div_container" >
                    <div id="ville_div">
                        Ville: <select name="villes" id="ville_select" class="form-control">
                        <option value="all">-- All --</option>
                        <c:forEach var="ville" items="${villes}">
                            <option value="<c:out value="${ville.nomVille}"/>"><c:out value="${ville.nomVille}"/></option>
                        </c:forEach>
                    </select>
                    </div>
            </div>

                <div class="col-lg-3 float-left mb-3 row justify-content-end" >
                    <a class="btn btn-dark font-weight-bold text-white" data-toggle="modal" data-target="#AjouterDonnation">&nbsp;<span class="fa fa-plus"></span>&nbsp;Ajouter une Donateur</a>
                </div>

        </div>

        <br>
        <table class="table table-bordered" id="dntr_table">
            <thead class="alert-danger">
            <tr>
                <th >N° donateur</th>
                <th >CIN</th>
                <th >Nom & Prenom</th>
                <th >Groupe sanguin</th>
                <th >Téléphone</th>
                <th >Ville</th>
                <!--<c:if test="${sessionScope.role eq 'banquesang'}"><th class="align-content-center">Actions</th></c:if>-->
            </tr>
            </thead>

            <tbody id = "dnt" style="background-color: #f2f2f2">

            <c:forEach var="donnateur" items="${donnateurs}">
                <tr>
                    <td><c:out value="${donnateur.idDonnateur}" /></td>
                    <td><c:out value="${donnateur.cin}" /></td>
                    <td data-toggle="tooltip" data-placement="right" title="Nombre de donations: ">
                        <c:out value="${donnateur.nomD}"/> <c:out value="${donnateur.prenomD}"/>
                    </td>
                    <td>
                        <c:forEach var="gs" items="${gsList}">
                            <c:if test="${gs.idGS eq donnateur.idGS}">
                                <c:out value="${gs.nomGS}"/>
                            </c:if>
                        </c:forEach>
                    </td>
                    <td><c:out value="${donnateur.teleD}" /></td>
                    <td>
                        <c:forEach var="ville" items="${villes}">
                            <c:if test="${donnateur.idVille eq ville.idVille}">
                                <c:out value="${ville.nomVille}"/>
                            </c:if>
                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
        <div id="warn" ></div>
    </div>
</div>

</body>

<!-- Début Modal - Ajouter Donnateur -->
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


                    <button id="aj_btn" class="btn btn-danger align-content-md-center" >
                        Valider
                    </button>

                </form>
            </div>
        </div>
    </div>
</div>
<!-- Fin Modal - Ajouter Donnateur -->

<script src="../frameworks/jquery/jquery.js"></script>
<script src="../frameworks/bootstap4/dist/js/bootstrap.bundle.min.js"></script>
<script>

</script>

<script src="../js/donnateur.js" type="text/javascript"></script>

</html>
