window.onload = function() {

    document.querySelector("#ville_select").addEventListener("change", data_filter);
    document.querySelector("#banq_select").addEventListener("change", data_filter);

    $.get("DonnationStats", {"ville": "all", "banq": "all", "action": "filter"}, function (data) {
        var tab = JSON.parse(data);

        document.getElementById("cardAmoin").innerHTML = tab[0] + "L";
        document.getElementById("cardAplus").innerHTML = tab[1] + "L";
        document.getElementById("cardBplus").innerHTML = tab[2] + "L";
        document.getElementById("cardBmoin").innerHTML = tab[3] + "L";
        document.getElementById("cardABplus").innerHTML = tab[4] + "L";
        document.getElementById("cardABmoin").innerHTML = tab[5] + "L";
        document.getElementById("cardOplus").innerHTML = tab[6] + "L";
        document.getElementById("cardOmoin").innerHTML = tab[7] + "L";

        var cont = document.getElementById("container2");

        Highcharts.chart(cont, {
            chart: {
                type: 'pie'
            },
            title: {
                text: 'Les Statiqtiques Actuels du Stock'
            },
            subtitle: {
                text: 'Tous les banque'
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
                            "name": "A-",
                            "y": tab[0],
                            "drilldown": "A-"
                        },
                        {
                            "name": "A+",
                            "y": tab[1],
                            "drilldown": "A+"
                        },
                        {
                            "name": "B+",
                            "y": tab[2],
                            "drilldown": "B+"
                        },
                        {
                            "name": "B-",
                            "y": tab[3],
                            "drilldown": "B-"
                        },
                        {
                            "name": "AB+",
                            "y": tab[4],
                            "drilldown": "AB+"
                        },
                        {
                            "name": "AB-",
                            "y": tab[5],
                            "drilldown": "AB-"
                        },
                        {
                            "name": "O+",
                            "y": tab[6],
                            "drilldown": "O+"
                        },
                        {
                            "name": "O-",
                            "y": tab[7],
                            "drilldown": "O-"
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
    })

}