<%--
  Created by IntelliJ IDEA.
  User: ZOUHAIR
  Date: 29/01/2020
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>List Convois</title>
    <link rel="stylesheet" href="frameworks/bootstap4/dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="frameworks/font-awesome/css/fontawesome.min.css">
    <link rel="stylesheet" href="frameworks/font-awesome/css/regular.min.css">
    <link rel="stylesheet" href="frameworks/font-awesome/css/solid.min.css">
</head>
<body>
    <header>
        <%@ include file="navbar.jsp"%>
    </header>

    <div class="row">
        <div class="container" style="margin-top: 30px;">
            <h3 class="text-center">La List des Convoi</h3>
            <hr />
            <div class="row">
                <div class="input-group mb-3 col-lg-5">
                    <input type="text" id="convoi" class="form-control border-danger" placeholder="Chercher un Convoi">
                    <div class="input-group-prepend">
                        <span class="input-group-text">
                            <span class="fa fa-search text-danger"></span>
                        </span>
                    </div>
                </div>
                <div class="col-lg-7 float-left mb-3 row justify-content-end">
                    <a class="btn btn-outline-dark font-weight-bold" data-toggle="modal" href="#AjouterConvoi">
                        <span class="fa fa-plus"></span>&nbsp;Ajouter un Convoi
                    </a>
                </div>
            </div>

            <table class="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Titre</th>
                    <th scope="col">Description</th>
                    <th scope="col">Banque du Sang</th>
                    <th scope="col">Option</th>

                </tr>
                </thead>
                <tbody id="conv">
                    <c:forEach items="${convois}" var="convoi">
                        <tr>
                            <th scope="row">
                                <c:out value="${convoi.idConvoi}"></c:out>
                            </th>

                            <td>
                                <c:out value="${convoi.titreConvoi}"></c:out>
                            </td>

                            <td>
                                <c:out value="${convoi.description}"></c:out>
                            </td>

                            <td>
                                <c:forEach var="banque" items="${banques}">
                                    <c:if test="${banque.idBS eq convoi.idBS }">
                                        <c:out value="${banque.nomBS}"></c:out>
                                    </c:if>
                                </c:forEach>
                            </td>

                            <td>
                                <a data-toggle="modal" href="#modifier${convoi.idConvoi}">
                                    <span class="shadow text-danger p-2" data-toggle="tooltip" title="Modifier" data-placement="left">
                                        <span class="fa fa-edit" aria-hidden="true"></span>
                                    </span>
                                </a>

                                <a data-toggle="modal" href="#supprimer${convoi.idConvoi}">
                                    <span class="shadow text-danger p-2" data-toggle="tooltip" title="Supprimer" data-placement="right">
                                        <span class="fa fa-trash-alt" aria-hidden="true"></span>
                                    </span>
                                </a>

                                <a data-toggle="modal" href="#Planning${convoi.idConvoi}" >
                                    <span class="shadow text-danger p-2" data-toggle="tooltip" title="Planning" data-placement="right">
                                        <span class="fa fa-calendar-alt" aria-hidden="true"></span>
                                    </span>
                                </a>

                            </td>

                        </tr>

                        <div class="modal mt-lg-4" id="supprimer${convoi.idConvoi}">
                            <div class="modal-dialog">
                                <div class="modal-content rouded">
                                    <div class="modal-body alert-dark">
                                        <p class="font-weight-bold text-center">Vous êtes sûr que vous voullez supprimer le convoi <c:out value="${convoi.titreConvoi}"></c:out></p>
                                        <div>
                                            <button class="btn btn-outline-dark float-left" data-dismiss="modal" type="button">
                                                Annuler
                                            </button>
                                            <a class="btn btn-outline-danger float-right" type="button" href="supprimerConvoi?id=<c:out value='${convoi.idConvoi}' />" >
                                                Supprimer
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="modal mt-lg-4" id="Planning${convoi.idConvoi}">
                            <div class="modal-dialog">
                                <div class="modal-content rounded">
                                    <div class="modal-body alert-dark">
                                        <p class="font-weight-bold text-center">Acceder au Planning du Convoi : <c:out value="${convoi.titreConvoi}"></c:out></p>
                                        <div class="text-center">
                                            <a class="btn btn-outline-info" type="button" href="Planning?idConvoi=<c:out value='${convoi.idConvoi}' />">
                                                Planning
                                            </a>
                                          </div>
                                    </div>
                                </div>
                            </div>
                        </div>


                    <div class="modal mt-lg-4" id="modifier${convoi.idConvoi}">
                        <div class="modal-dialog">
                            <div class="modal-content rouded">
                                <div class="modal-header alert-danger text-center">
                                    <h5 class="font-weight-bold modal-title">Formulaire de Modification</h5>
                                    <button type="button" class="close" data-dismiss="modal">X</button>
                                </div>
                                <div class="modal-body">
                                    <form action="/ModifierConvoi?id=${convoi.idConvoi}" method="post">
                                        <fieldset class="form-group">
                                            <label>Titre Convoi</label>
                                            <input type="text"  class="form-control" name="titreConvoi" value="${convoi.titreConvoi}" required="required">
                                        </fieldset>
                                        <fieldset class="form-group">
                                            <label>Description</label>
                                            <textarea class="form-control" rows="5"  name="description">${convoi.description}</textarea>
                                        </fieldset>
                                        <div class="text-center">
                                            <button type="submit" class="btn btn-success">Modifier</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>

                    </c:forEach>
                </tbody>

            </table>
        </div>

    </div>

    <!--Modal Ajouter Convoi-->
    <div class="modal mt-lg-5" id="AjouterConvoi">
        <div class="modal-dialog">
            <div class="modal-content rounded">
                <div class="modal-header alert-danger text-center">
                    <h5 class="font-weight-bold modal-title">Ajouter Un convoi</h5>
                    <button type="button" class="close" data-dismiss="modal">X</button>
                </div>

                <div class="modal-body">
                    <form action="/AjouterConvoi" method="post">
                        <caption>
                            <h2 class="align-content-md-center">Nouveau Convoi</h2>
                        </caption>

                        <fieldset class="form-group">
                            <label>Titre Convoi</label>
                            <input type="text"  class="form-control" name="titreConvoi" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Description</label>
                            <textarea class="form-control" rows="5"  name="description"></textarea>
                        </fieldset>
                        <div class="text-center">
                            <button type="submit" class="btn btn-success">Ajouter</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>


</body>
<script src="frameworks/jquery/jquery.js"></script>
<script src="frameworks/bootstap4/dist/js/bootstrap.bundle.min.js"></script>
<script>
    $(function(){
        $('[data-toggle="tooltip"]').tooltip();
        $('#convoi').on("keyup",function(){
            var value=$(this).val().toLowerCase();
            $('#conv tr').filter(function(){
                $(this).toggle($(this).text().toLowerCase().indexOf(value)>-1);
            });
        });
    });
</script>
</html>
