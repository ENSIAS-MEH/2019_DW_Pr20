<%--
  Created by IntelliJ IDEA.
  User: ZOUHAIR
  Date: 30/01/2020
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Planning</title>
    <link rel="stylesheet" href="../frameworks/bootstap4/dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../css/calendar-css.css">
</head>
<body>
    <header>
        <%@ include file="navbar.jsp"%>
    </header>

    <div class="row">
        <div class="container" >
            <div class="row font-weight-bold text-danger mb-3 border-secondary p-2 m-2" style="font-size: 30px;border-left-style: dashed;border-bottom-style: dashed;">
                <span class=""><span class="fa fa-calendar-alt pt-2"></span></span>&nbsp;&nbsp;Planning
            </div>
            <h3><c:out value="${convoi.titreConvoi}"></c:out></h3>
            <hr/>

            <div class="row">
                <div class="input-group mb-3 col-lg-5">
                    <input type="text" id="planning" class="form-control border-danger" placeholder="Chercher">
                    <div class="input-group-prepend">
                        <span class="input-group-text">
                            <span class="fa fa-search text-danger"></span>
                        </span>
                    </div>
                </div>
                <c:if test="${sessionScope.role eq 'banquesang'}">
                    <div class="col-lg-7 float-left mb-3 row justify-content-end">
                        <a class="btn btn-dark font-weight-bold" data-toggle="modal" href="#AjouterPlanning">
                            <span class="fa fa-plus"></span>&nbsp;Ajouter un Plan au calendrier
                        </a>
                    </div>
                </c:if>
            </div>

            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Ville</th>
                    <th scope="col">Date debut</th>
                    <th scope="col">Date Fin</th>
                    <c:if test="${sessionScope.role eq 'banquesang'}">
                        <th scope="col">Option</th>
                    </c:if>
                </tr>
                </thead>

                <tbody id="plan">
                    <c:forEach items="${plannings}" var="planning">
                        <tr>
                            <td scope="row">
                                <c:forEach var="ville" items="${villes}">
                                    <c:if test="${ville.idVille eq planning.idVille}">
                                        <c:out value="${ville.nomVille}"></c:out>
                                    </c:if>
                                </c:forEach>
                            </td>
                            <td scope="row">
                                <fmt:formatDate value="${planning.dateConvoi_debut}" pattern="dd/MM/yyyy HH:mm"/>
                            </td>
                            <td scope="row">
                                <fmt:formatDate value="${planning.dateConvoi_fin}" pattern="dd/MM/yyyy HH:mm"/>
                            </td>
                            <c:if test="${sessionScope.role eq 'banquesang'}">
                                <td>
                                    <a data-toggle="modal" href="#modifier${planning.idConvoi}et${planning.idVille}et${planning.dateConvoi_debut}">
                                        <span class="shadow text-danger p-2" data-toggle="tooltip" title="Modifier Date fin" data-placement="left">
                                            <span class="fa fa-edit" aria-hidden="true"></span>
                                        </span>
                                    </a>
                                    <a data-toggle="modal" href="#supprimer${planning.idConvoi}et${planning.idVille}et${planning.dateConvoi_debut}">
                                        <span class="shadow text-danger p-2" data-toggle="tooltip" title="Supprimer" data-placement="right">
                                            <span class="fa fa-trash-alt" aria-hidden="true"></span>
                                        </span>
                                    </a>
                                </td>
                            </c:if>
                        </tr>

                        <div class="modal mt-lg-4" id="supprimer${planning.idConvoi}et${planning.idVille}et${planning.dateConvoi_debut}">
                            <div class="modal-dialog">
                                <div class="modal-content rouded">
                                    <div class="modal-body alert-dark">
                                        <p class="font-weight-bold text-center">Vous êtes sûr que vous voulez supprimer du calendier</p>
                                        <div>
                                            <button class="btn btn-outline-dark float-left" data-dismiss="modal" type="button">
                                                Annuler
                                            </button>
                                            <a class="btn btn-outline-danger float-right" type="button" href="supprimerPlanning?idConvoi=<c:out value='${planning.idConvoi}' />&idville=<c:out value="${planning.idVille}" />&dd=<c:out value="${planning.dateConvoi_debut}" />" >
                                                Supprimer
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="modal mt-lg-5" id="modifier${planning.idConvoi}et${planning.idVille}et${planning.dateConvoi_debut}">
                            <div class="modal-dialog">
                                <div class="modal-content rounded">
                                    <div class="modal-header alert-danger text-center">
                                        <h5 class="font-weight-bold modal-title">Modifier Un planning</h5>
                                        <button type="button" class="close" data-dismiss="modal">X</button>
                                    </div>

                                    <div class="modal-body">
                                        <form action="ModifierPlanning" method="post">
                                            <fieldset class="form-group">
                                                <input type="hidden" class="form-control" name="idConvoi" value="${planning.idConvoi}" />
                                                <input type="hidden" class="form-control" name="idville" value="${planning.idVille}">
                                                <input type="hidden" class="form-control" name="dd" value="${planning.dateConvoi_debut}">
                                            </fieldset>

                                            <fieldset class="form-group">
                                                <label  class="control-label">Date fin</label>
                                                <input  class="form-control datepicker" name="df" type="date"/>
                                            </fieldset>

                                            <div class="text-center">
                                                <button type="submit" class="btn btn-danger">Modifier</button>
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

    <!-- Start calendar -->
    <div class="p-5 container">
        <hr />
        <h2 class="mb-4">Calendrier des planning</h2>
        <div class="card">
            <div class="card-body p-0">
                <div id="calendar"></div>
            </div>
        </div>
    </div>

    <!-- Ajouter Modal -->
    <div class="modal mt-lg-5" id="AjouterPlanning">
        <div class="modal-dialog">
            <div class="modal-content rounded">
                <div class="modal-header alert-danger text-center">
                    <h5 class="font-weight-bold modal-title">Ajouter Un planning</h5>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                <div class="modal-body">
                    <form action="AjouterPlanning" method="post">
                        <fieldset class="form-group">
                            <input type="hidden" class="form-control" name="idConvoi" value="${convoi.idConvoi}" />
                        </fieldset>
                        <fieldset class="form-group">
                            <label class="custom-control-label">Ville</label>
                            <select class="form-control" id="ville" name="idville">
                                <option value="-1">Choisir une ville</option>
                                <c:forEach items="${villes}" var="ville">
                                    <option value="${ville.idVille}"><c:out value="${ville.nomVille}"></c:out></option>
                                </c:forEach>
                            </select>
                        </fieldset>
                        <fieldset class="form-group">
                           <label for="dd" class="control-label">Date début</label>
                            <input id="dd" class="form-control datepicker" name="dd" type="date" />
                        </fieldset>
                        <fieldset class="form-group">
                            <label for="df" class="control-label">Date fin</label>
                            <input id="df" class="form-control datepicker" name="df" type="date" />
                        </fieldset>
                        <div class="text-center">
                            <button type="submit" class="btn btn-danger">Ajouter</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!-- calendar modal -->
    <div id="modal-view-event" class="modal modal-top fade calendar-modal">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-body">
                    <h4 class="modal-title"><span class="event-icon"></span><span class="event-title"></span></h4>
                    <div class="event-body"></div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
                 </div>
            </div>
        </div>
    </div>


</body>
<script src="../frameworks/jquery/jquery.js"></script>
<script src="../frameworks/bootstap4/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.9.0/fullcalendar.min.js"></script>

<script>
    jQuery(document).ready(function(){
        jQuery('.datetimepicker').datepicker({
            timepicker: true,
            language: 'en',
            range: true,
            multipleDates: true,
            multipleDatesSeparator: " - "
        });
        jQuery("#add-event").submit(function(){
            alert("Submitted");
            var values = {};
            $.each($('#add-event').serializeArray(), function(i, field) {
                values[field.name] = field.value;
            });
            console.log(
                values
            );
        });
    });

    (function () {
        'use strict';
        // ------------------------------------------------------- //
        // Calendar
        // ------------------------------------------------------ //
        jQuery(function() {
            // page is ready
            jQuery('#calendar').fullCalendar({
                themeSystem: 'bootstrap4',
                // emphasizes business hours
                businessHours: false,
                defaultView: 'month',
                // event dragging & resizing
                editable: true,
                // header
                header: {
                    left: 'title',
                    center: 'month,agendaWeek,agendaDay',
                    right: 'today prev,next'
                },
                events: [
                    <c:forEach items="${plannings}" var="planning" >
                    {
                        title: <c:forEach var="ville" items="${villes}">
                                    <c:if test="${ville.idVille eq planning.idVille}">
                                        '<c:out value="${ville.nomVille}"></c:out>',
                                    </c:if>
                                </c:forEach>
                        description: '<c:out value="${convoi.description}"></c:out>',
                        start: '<c:out value="${planning.dateConvoi_debut}"></c:out>',
                        end: '<c:out value="${planning.dateConvoi_fin}"></c:out>',
                        className: 'fc-bg-blue',
                        icon : "map-marker-alt",
                        allDay: false
                    },
                    </c:forEach>
                ],
                eventRender: function(event, element) {
                    if(event.icon){
                        element.find(".fc-title").prepend("<i class='fa fa-"+event.icon+"'></i>");
                    }
                },
                dayClick: function() {
                    jQuery('#modal-view-event-add').modal();
                },
                eventClick: function(event, jsEvent, view) {
                    jQuery('.event-icon').html("<i class='fa fa-"+event.icon+"'></i>");
                    jQuery('.event-title').html(event.title);
                    jQuery('.event-body').html(event.description);
                    jQuery('.eventUrl').attr('href',event.url);
                    jQuery('#modal-view-event').modal();
                },
            })
        });

    })(jQuery);
</script>

<script>

    $(function(){
        $('[data-toggle="tooltip"]').tooltip();
        $('#planning').on("keyup",function(){
            var value=$(this).val().toLowerCase();
            $('#plan tr').filter(function(){
                $(this).toggle($(this).text().toLowerCase().indexOf(value)>-1);
            });
        });
    });

</script>
</html>
