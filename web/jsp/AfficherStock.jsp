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

</head>

<body>
<%--
<c:if test="${empty sessionScope.banqueSang}">
    <c:redirect url="/SignIn"></c:redirect>
</c:if>--%>
<header>
    <%@ include file="navbar.jsp"%>
</header>
<br>
<div class="container">
    <h3> Les statistique sur Les Banques du sang</h3>
    <div class="row">
        <div class="col-lg-6">
            <div class="row">
                <div class="col-lg-6 mb-2">
                    <div class="card">
                        <div class="card-body">
                            <div class="media d-flex">
                                <div class="align-self-center">
                                    <img src="/img/A+.png" width="40" height="60">
                                </div>
                                <div class="media-body text-right">
                                    <h3 class="text-stat">${stockList.get(1)}L</h3>
                                    <a data-toggle="modal" href="#modifier1">
                                <span class="shadow text-danger p-2" data-toggle="tooltip" title="Modifier" data-placement="left">
                                    <span class="fa fa-edit" aria-hidden="true"></span>
                                </span>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 mb-2">
                    <div class="card">
                        <div class="card-body">
                            <div class="media d-flex">
                                <div class="align-self-center">
                                    <img src="/img/B+.png" width="40" height="60">
                                </div>
                                <div class="media-body text-right">
                                    <h3 class="text-stat">${stockList.get(2)}L</h3>
                                    <a data-toggle="modal" href="#modifier2">
                                <span class="shadow text-danger p-2" data-toggle="tooltip" title="Modifier" data-placement="left">
                                    <span class="fa fa-edit" aria-hidden="true"></span>
                                </span>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 mb-2">
                    <div class="card">
                        <div class="card-body">
                            <div class="media d-flex">
                                <div class="align-self-center">
                                    <img src="/img/AB+.png" width="40" height="60">
                                </div>
                                <div class="media-body text-right">
                                    <h3 class="text-stat">${stockList.get(4)}L</h3>
                                    <a data-toggle="modal" href="#modifier4">
                                <span class="shadow text-danger p-2" data-toggle="tooltip" title="Modifier" data-placement="left">
                                    <span class="fa fa-edit" aria-hidden="true"></span>
                                </span>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 mb-2">
                    <div class="card">
                        <div class="card-body">
                            <div class="media d-flex">
                                <div class="align-self-center">
                                    <img src="/img/O+.png" width="40" height="60">
                                </div>
                                <div class="media-body text-right">
                                    <h3 class="text-stat">${stockList.get(6)}L</h3>
                                    <a data-toggle="modal" href="#modifier6">
                                <span class="shadow text-danger p-2" data-toggle="tooltip" title="Modifier" data-placement="left">
                                    <span class="fa fa-edit" aria-hidden="true"></span>
                                </span>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 mb-2">
                    <div class="card">
                        <div class="card-body">
                            <div class="media d-flex">
                                <div class="align-self-center">
                                    <img src="/img/A-.png" width="40" height="60">
                                </div>
                                <div class="media-body text-right">
                                    <h3 class="text-stat">${stockList.get(0)}L</h3>
                                    <a data-toggle="modal" href="#modifier0">
                                <span class="shadow text-danger p-2" data-toggle="tooltip" title="Modifier" data-placement="left">
                                    <span class="fa fa-edit" aria-hidden="true"></span>
                                </span>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 mb-2">
                    <div class="card">
                        <div class="card-body">
                            <div class="media d-flex">
                                <div class="align-self-center">
                                    <img src="/img/B-.png" width="40" height="60">
                                </div>
                                <div class="media-body text-right">
                                    <h3 class="text-stat">${stockList.get(3)}L</h3>
                                    <a data-toggle="modal" href="#modifier3">
                                <span class="shadow text-danger p-2" data-toggle="tooltip" title="Modifier" data-placement="left">
                                    <span class="fa fa-edit" aria-hidden="true"></span>
                                </span>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 mb-2">
                    <div class="card">
                        <div class="card-body">
                            <div class="media d-flex">
                                <div class="align-self-center">
                                    <img src="/img/AB-.png" width="40" height="60">
                                </div>
                                <div class="media-body text-right">
                                    <h3 class="text-stat">${stockList.get(5)}L</h3>
                                    <a data-toggle="modal" href="#modifier5">
                                <span class="shadow text-danger p-2" data-toggle="tooltip" title="Modifier" data-placement="left">
                                    <span class="fa fa-edit" aria-hidden="true"></span>
                                </span>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 mb-2">
                    <div class="card">
                        <div class="card-body">
                            <div class="media d-flex">
                                <div class="align-self-center">
                                    <img src="/img/O-.png" width="40" height="60">
                                </div>
                                <div class="media-body text-right">
                                    <h3 class="text-stat">${stockList.get(7)}L</h3>
                                    <a data-toggle="modal" href="#modifier7">
                                <span class="shadow text-danger p-2" data-toggle="tooltip" title="Modifier" data-placement="left">
                                    <span class="fa fa-edit" aria-hidden="true"></span>
                                </span>
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


<!-- debut modal modifier -->
<div class="modal mt-lg-5" id="modifier0">
    <div class="modal-dialog">
        <div class="modal-content rounded">
            <div class="modal-body">
                <button type="button" class="close" data-dismiss="modal">x</button>
                <form action="Statistiques" method="post">
                    <input type="hidden" name="id" value="1" />
                    <fieldset class="form-group">
                        <label>Entrer la nouvelle quantité.</label>
                        <input type="text" class="form-control" name="quantite" required="required">
                    </fieldset>
                    <div>
                        <button class="btn btn-danger " type="submit">Modifier</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- Fin Modal Supprimer -->
<!-- debut modal modifier -->
<div class="modal mt-lg-5" id="modifier1">
    <div class="modal-dialog">
        <div class="modal-content rounded">
            <div class="modal-body">
                <button type="button" class="close" data-dismiss="modal">x</button>
                <form action="Statistiques" method="post">
                    <input type="hidden" name="id" value="2" />
                    <fieldset class="form-group">
                        <label>Entrer la nouvelle quantité.</label>
                        <input type="text" class="form-control" name="quantite" required="required">
                    </fieldset>

                <div>
                    <button class="btn btn-danger " type="submit">Modifier</button>
                </div></form>
            </div>
        </div>
    </div>
</div>
<!-- Fin Modal Supprimer -->
<!-- debut modal modifier -->
<div class="modal mt-lg-5" id="modifier2">
    <div class="modal-dialog">
        <div class="modal-content rounded">
            <div class="modal-body">
                <button type="button" class="close" data-dismiss="modal">x</button>
                <form action="Statistiques" method="post">
                    <input type="hidden" name="id" value="3" />
                    <fieldset class="form-group">
                        <label>Entrer la nouvelle quantité.</label>
                        <input type="text" class="form-control" name="quantite" required="required">
                    </fieldset>
                <div>
                    <button class="btn btn-danger " type="submit">Modifier</button>
                </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- Fin Modal Supprimer -->
<!-- debut modal modifier -->
<div class="modal mt-lg-5" id="modifier3">
    <div class="modal-dialog">
        <div class="modal-content rounded">
            <div class="modal-body">
                <button type="button" class="close" data-dismiss="modal">x</button>
                <form action="Statistiques" method="post">
                    <input type="hidden" name="id" value="4" />
                    <fieldset class="form-group">
                        <label>Entrer la nouvelle quantité.</label>
                        <input type="text" class="form-control" name="quantite" required="required">
                    </fieldset>

                <div>
                    <button class="btn btn-danger " type="submit">Modifier</button>
                </div></form>
            </div>
        </div>
    </div>
</div>
<!-- Fin Modal Supprimer -->
<!-- debut modal modifier -->
<div class="modal mt-lg-5" id="modifier4">
    <div class="modal-dialog">
        <div class="modal-content rounded">
            <div class="modal-body">
                <button type="button" class="close" data-dismiss="modal">x</button>
                <form action="Statistiques" method="post">
                    <input type="hidden" name="id" value="5" />
                    <fieldset class="form-group">
                        <label>Entrer la nouvelle quantité.</label>
                        <input type="text" class="form-control" name="quantite" required="required">
                    </fieldset>

                <div>
                    <button class="btn btn-danger " type="submit">Modifier</button>
                </div></form>
            </div>
        </div>
    </div>
</div>
<!-- Fin Modal Supprimer -->
<!-- debut modal modifier -->
<div class="modal mt-lg-5" id="modifier5">
    <div class="modal-dialog">
        <div class="modal-content rounded">
            <div class="modal-body">
                <button type="button" class="close" data-dismiss="modal">x</button>
                <form action="Statistiques" method="post">
                    <input type="hidden" name="id" value="6" />
                    <fieldset class="form-group">
                        <label>Entrer la nouvelle quantité.</label>
                        <input type="text" class="form-control" name="quantite" required="required">
                    </fieldset>

                <div>
                    <button class="btn btn-danger " type="submit">Modifier</button>
                </div></form>
            </div>
        </div>
    </div>
</div>
<!-- Fin Modal Supprimer -->
<!-- debut modal modifier -->
<div class="modal mt-lg-5" id="modifier6">
    <div class="modal-dialog">
        <div class="modal-content rounded">
            <div class="modal-body">
                <button type="button" class="close" data-dismiss="modal">x</button>
                <form action="Statistiques" method="post">
                    <input type="hidden" name="id" value="7" />
                    <fieldset class="form-group">
                        <label>Entrer la nouvelle quantité.</label>
                        <input type="text" class="form-control" name="quantite" required="required">
                    </fieldset>
                <div>
                    <button class="btn btn-danger " type="submit">Modifier</button>
                </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- Fin Modal Supprimer -->
<!-- debut modal modifier -->
<div class="modal mt-lg-5" id="modifier7">
    <div class="modal-dialog">
        <div class="modal-content rounded">
            <div class="modal-body">
                <button type="button" class="close" data-dismiss="modal">x</button>
                <form action="Statistiques" method="post">
                    <input type="hidden" name="id" value="8" />
                    <fieldset class="form-group">
                        <label>Entrer la nouvelle quantité.</label>
                        <input type="text" class="form-control" name="quantite" required="required">
                    </fieldset>
                <div>
                    <button class="btn btn-danger " type="submit">Modifier</button>
                </div>
                </form>
            </div>
        </div>
    </div>
</div>
</div>
<!-- Fin Modal Supprimer -->
<br>
<!-- Container pour les statistiques en batant
<div class="container">
    <div class="row">
        <div class="col-6">
            <div class="card">
                <div class="card-header text-center" style="font-size: 24px">Les Statistiques</div>
                <div class="card-body">
                    <div id="container1" style="margin: 0 auto"></div>
                </div>
            </div>
        </div>
        <div class="col-6">

        </div>
    </div>
</div>
-->
<!-- Script for stat -->
<script src="../frameworks/js/chart.js"></script>
<script src="../frameworks/js/highcharts.js"></script>
<script src="../frameworks/js/exporting.js"></script>
<script src="../frameworks/js/export-data.js"></script>
<script src="../frameworks/js/series-label.js"></script>
<script src="../frameworks/js/modules/data.js"></script>
<script src="../frameworks/js/drilldown.js"></script>
<script src="../frameworks/jquery/jquery.js"></script>
<script src="../frameworks/bootstap4/dist/js/bootstrap.bundle.min.js"></script>
<script>


    // Start the chart
    Highcharts.chart('container1', {
        chart: {
            type: 'column'
        },
        title: {
            text: 'Les Statiqtiques Actuels du Stock'
        },
        subtitle: {
            text: '${currentBanque.nomBS}' /*Nom du Banque*/
        },
        xAxis: {
            type: 'category'
        },
        yAxis: {
            title: {
                text: 'Quantité Totale (L)'
            }

        },
        legend: {
            enabled: false
        },
        plotOptions: {
            series: {
                borderWidth: 0,
                dataLabels: {
                    enabled: true,
                    format: '{point.y:.1f}L'
                }
            }
        },

        tooltip: {
            headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
            pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}</b> L<br/>'
        },

        "series": [
            {
                "name": "Browsers",
                "colorByPoint": true,
                "data": [
                    {
                        "name": "${groupList.get(0).nomGS}",
                        "y": ${stockList.get(0)},
                        "drilldown": "${groupList.get(0).nomGS}"
                    },
                    {
                        "name": "${groupList.get(1).nomGS}",
                        "y": ${stockList.get(1)},
                        "drilldown": "${groupList.get(1).nomGS}"
                    },
                    {
                        "name": "${groupList.get(2).nomGS}",
                        "y": ${stockList.get(2)},
                        "drilldown": "${groupList.get(2).nomGS}"
                    },
                    {
                        "name": "${groupList.get(3).nomGS}",
                        "y": ${stockList.get(3)},
                        "drilldown": "${groupList.get(3).nomGS}"
                    },
                    {
                        "name": "${groupList.get(4).nomGS}",
                        "y": ${stockList.get(4)},
                        "drilldown": "${groupList.get(4).nomGS}"
                    },
                    {
                        "name": "${groupList.get(5).nomGS}",
                        "y": ${stockList.get(5)},
                        "drilldown": "${groupList.get(5).nomGS}"
                    },
                    {
                        "name": "${groupList.get(6).nomGS}",
                        "y": ${stockList.get(6)},
                        "drilldown": "${groupList.get(6).nomGS}"
                    },
                    {
                        "name": "${groupList.get(7).nomGS}",
                        "y": ${stockList.get(7)},
                        "drilldown": "${groupList.get(7).nomGS}"
                    }
                ]
            }
        ],
        "drilldown": {
            "series": [
                {
                    "name": "Chrome",
                    "id": "Chrome",
                    "data": [
                        [
                            "v65.0",
                            0.1
                        ],
                        [
                            "v64.0",
                            1.3
                        ],
                        [
                            "v63.0",
                            53.02
                        ],
                        [
                            "v62.0",
                            1.4
                        ],
                        [
                            "v61.0",
                            0.88
                        ],
                        [
                            "v60.0",
                            0.56
                        ],
                        [
                            "v59.0",
                            0.45
                        ],
                        [
                            "v58.0",
                            0.49
                        ],
                        [
                            "v57.0",
                            0.32
                        ],
                        [
                            "v56.0",
                            0.29
                        ],
                        [
                            "v55.0",
                            0.79
                        ],
                        [
                            "v54.0",
                            0.18
                        ],
                        [
                            "v51.0",
                            0.13
                        ],
                        [
                            "v49.0",
                            2.16
                        ],
                        [
                            "v48.0",
                            0.13
                        ],
                        [
                            "v47.0",
                            0.11
                        ],
                        [
                            "v43.0",
                            0.17
                        ],
                        [
                            "v29.0",
                            0.26
                        ]
                    ]
                },
                {
                    "name": "Firefox",
                    "id": "Firefox",
                    "data": [
                        [
                            "v58.0",
                            1.02
                        ],
                        [
                            "v57.0",
                            7.36
                        ],
                        [
                            "v56.0",
                            0.35
                        ],
                        [
                            "v55.0",
                            0.11
                        ],
                        [
                            "v54.0",
                            0.1
                        ],
                        [
                            "v52.0",
                            0.95
                        ],
                        [
                            "v51.0",
                            0.15
                        ],
                        [
                            "v50.0",
                            0.1
                        ],
                        [
                            "v48.0",
                            0.31
                        ],
                        [
                            "v47.0",
                            0.12
                        ]
                    ]
                },
                {
                    "name": "Internet Explorer",
                    "id": "Internet Explorer",
                    "data": [
                        [
                            "v11.0",
                            6.2
                        ],
                        [
                            "v10.0",
                            0.29
                        ],
                        [
                            "v9.0",
                            0.27
                        ],
                        [
                            "v8.0",
                            0.47
                        ]
                    ]
                },
                {
                    "name": "Safari",
                    "id": "Safari",
                    "data": [
                        [
                            "v11.0",
                            3.39
                        ],
                        [
                            "v10.1",
                            0.96
                        ],
                        [
                            "v10.0",
                            0.36
                        ],
                        [
                            "v9.1",
                            0.54
                        ],
                        [
                            "v9.0",
                            0.13
                        ],
                        [
                            "v5.1",
                            0.2
                        ]
                    ]
                },
                {
                    "name": "Edge",
                    "id": "Edge",
                    "data": [
                        [
                            "v16",
                            2.6
                        ],
                        [
                            "v15",
                            0.92
                        ],
                        [
                            "v14",
                            0.4
                        ],
                        [
                            "v13",
                            0.1
                        ]
                    ]
                },
                {
                    "name": "Opera",
                    "id": "Opera",
                    "data": [
                        [
                            "v50.0",
                            0.96
                        ],
                        [
                            "v49.0",
                            0.82
                        ],
                        [
                            "v12.1",
                            0.14
                        ]
                    ]
                }
            ]
        }
    });

</script>
<!-- End Script for Stat -->

<script>
    // Create the chart
    Highcharts.chart('container2', {
        chart: {
            type: 'pie'
        },
        title: {
            text: 'Les Statiqtiques Actuels du Stock'
        },
        subtitle: {
            text: '${currentBanque.nomBS}' /*Nom du Banque*/
        },
        xAxis: {
            type: 'category'
        },
        yAxis: {
            title: {
                text: 'Quantité Totale (L)'
            }

        },
        legend: {
            enabled: false
        },
        plotOptions: {
            series: {
                borderWidth: 0,
                dataLabels: {
                    enabled: true,
                    format: '{point.y:.1f}L'
                }
            }
        },

        tooltip: {
            headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
            pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}</b> L<br/>'
        },

        "series": [
            {
                "name": "Browsers",
                "colorByPoint": true,
                "data": [
                    {
                        "name": "${groupList.get(0).nomGS}",
                        "y": ${stockList.get(0)},
                        "drilldown": "${groupList.get(0).nomGS}"
                    },
                    {
                        "name": "${groupList.get(1).nomGS}",
                        "y": ${stockList.get(1)},
                        "drilldown": "${groupList.get(1).nomGS}"
                    },
                    {
                        "name": "${groupList.get(2).nomGS}",
                        "y": ${stockList.get(2)},
                        "drilldown": "${groupList.get(2).nomGS}"
                    },
                    {
                        "name": "${groupList.get(3).nomGS}",
                        "y": ${stockList.get(3)},
                        "drilldown": "${groupList.get(3).nomGS}"
                    },
                    {
                        "name": "${groupList.get(4).nomGS}",
                        "y": ${stockList.get(4)},
                        "drilldown": "${groupList.get(4).nomGS}"
                    },
                    {
                        "name": "${groupList.get(5).nomGS}",
                        "y": ${stockList.get(5)},
                        "drilldown": "${groupList.get(5).nomGS}"
                    },
                    {
                        "name": "${groupList.get(6).nomGS}",
                        "y": ${stockList.get(6)},
                        "drilldown": "${groupList.get(6).nomGS}"
                    },
                    {
                        "name": "${groupList.get(7).nomGS}",
                        "y": ${stockList.get(7)},
                        "drilldown": "${groupList.get(7).nomGS}"
                    }
                ]
            }
        ],
        "drilldown": {
            "series": [
                {
                    "name": "Chrome",
                    "id": "Chrome",
                    "data": [
                        [
                            "v65.0",
                            0.1
                        ],
                        [
                            "v64.0",
                            1.3
                        ],
                        [
                            "v63.0",
                            53.02
                        ],
                        [
                            "v62.0",
                            1.4
                        ],
                        [
                            "v61.0",
                            0.88
                        ],
                        [
                            "v60.0",
                            0.56
                        ],
                        [
                            "v59.0",
                            0.45
                        ],
                        [
                            "v58.0",
                            0.49
                        ],
                        [
                            "v57.0",
                            0.32
                        ],
                        [
                            "v56.0",
                            0.29
                        ],
                        [
                            "v55.0",
                            0.79
                        ],
                        [
                            "v54.0",
                            0.18
                        ],
                        [
                            "v51.0",
                            0.13
                        ],
                        [
                            "v49.0",
                            2.16
                        ],
                        [
                            "v48.0",
                            0.13
                        ],
                        [
                            "v47.0",
                            0.11
                        ],
                        [
                            "v43.0",
                            0.17
                        ],
                        [
                            "v29.0",
                            0.26
                        ]
                    ]
                },
                {
                    "name": "Firefox",
                    "id": "Firefox",
                    "data": [
                        [
                            "v58.0",
                            1.02
                        ],
                        [
                            "v57.0",
                            7.36
                        ],
                        [
                            "v56.0",
                            0.35
                        ],
                        [
                            "v55.0",
                            0.11
                        ],
                        [
                            "v54.0",
                            0.1
                        ],
                        [
                            "v52.0",
                            0.95
                        ],
                        [
                            "v51.0",
                            0.15
                        ],
                        [
                            "v50.0",
                            0.1
                        ],
                        [
                            "v48.0",
                            0.31
                        ],
                        [
                            "v47.0",
                            0.12
                        ]
                    ]
                },
                {
                    "name": "Internet Explorer",
                    "id": "Internet Explorer",
                    "data": [
                        [
                            "v11.0",
                            6.2
                        ],
                        [
                            "v10.0",
                            0.29
                        ],
                        [
                            "v9.0",
                            0.27
                        ],
                        [
                            "v8.0",
                            0.47
                        ]
                    ]
                },
                {
                    "name": "Safari",
                    "id": "Safari",
                    "data": [
                        [
                            "v11.0",
                            3.39
                        ],
                        [
                            "v10.1",
                            0.96
                        ],
                        [
                            "v10.0",
                            0.36
                        ],
                        [
                            "v9.1",
                            0.54
                        ],
                        [
                            "v9.0",
                            0.13
                        ],
                        [
                            "v5.1",
                            0.2
                        ]
                    ]
                },
                {
                    "name": "Edge",
                    "id": "Edge",
                    "data": [
                        [
                            "v16",
                            2.6
                        ],
                        [
                            "v15",
                            0.92
                        ],
                        [
                            "v14",
                            0.4
                        ],
                        [
                            "v13",
                            0.1
                        ]
                    ]
                },
                {
                    "name": "Opera",
                    "id": "Opera",
                    "data": [
                        [
                            "v50.0",
                            0.96
                        ],
                        [
                            "v49.0",
                            0.82
                        ],
                        [
                            "v12.1",
                            0.14
                        ]
                    ]
                }
            ]
        }
    });

</script>
<!-- End Script for Stat -->

</body>
</html>
