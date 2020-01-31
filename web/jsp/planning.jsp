<%--
  Created by IntelliJ IDEA.
  User: ZOUHAIR
  Date: 30/01/2020
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Planning</title>
    <link rel="stylesheet" href="frameworks/bootstap4/dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="frameworks/font-awesome/css/fontawesome.min.css">
    <link rel="stylesheet" href="frameworks/font-awesome/css/regular.min.css">
    <link rel="stylesheet" href="frameworks/font-awesome/css/solid.min.css">
    <link rel="stylesheet" href="/css/calendar-css.css">
</head>
<body>
    <header>
        <%@ include file="navbar.jsp"%>
    </header>
    <div class="row">
        <div class="container" >
            <h3>Planning du Convois : <c:out value="${convoi.titreConvoi}"></c:out></h3>
            <hr />
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Ville</th>
                    <th scope="col">Date debut</th>
                    <th scope="col">Date Fin</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach items="${plannings}" var="planning">
                        <tr>
                            <th scope="row">
                                <c:forEach var="ville" items="${villes}">
                                    <c:if test="${ville.idVille eq planning.idVille}">
                                        <c:out value="${ville.nomVille}"></c:out>
                                    </c:if>
                                </c:forEach>
                            </th>

                            <th scope="row">
                                <c:out value="${planning.dateConvoi_debut}"></c:out>
                            </th>

                            <th scope="row">
                                <c:out value="${planning.dateConvoi_fin}"></c:out>
                            </th>
                        </tr>
                    </c:forEach>
                </tbody> 
            </table>
        </div>


    </div>

    <hr />
    <!-- Start calendar -->
    <div class="p-5">
        <h2 class="mb-4">Full Calendar</h2>
        <div class="card">
            <div class="card-body p-0">
                <div id="calendar"></div>
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
<script src="frameworks/jquery/jquery.js"></script>
<script src="frameworks/bootstap4/dist/js/bootstrap.bundle.min.js"></script>


<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
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
                        icon : "medkit",
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
</html>
