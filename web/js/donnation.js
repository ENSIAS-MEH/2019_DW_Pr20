function sortTable(n) {
    var rows, i, x, y, shouldSwitch, switchcount = 0;
    var table = document.getElementById("dnt_table");
    var switching = true;
    var dir = "asc";

    while (switching) {
        switching = false;
        rows = table.getElementsByTagName("tr");

        for (i = 1; i < (rows.length - 1); i++) {
            shouldSwitch = false;

            x = rows[i].getElementsByTagName("td")[n];
            y = rows[i + 1].getElementsByTagName("td")[n];

            if (dir == "asc") {
                if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                    shouldSwitch= true;
                    break;
                }
            }
            else if (dir == "desc") {
                if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
                    shouldSwitch= true;
                    break;
                }
            }
        }
        if (shouldSwitch) {
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;
            switchcount ++;
        }
        else {
            if (switchcount == 0 && dir == "asc") {
                dir = "desc";
                switching = true;
            }
        }
    }
}

function chercher(){

    var value = $(this).val().toLowerCase();

    $('#dnt tr').filter(function(){
        $(this).toggle($(this).text().toLowerCase().indexOf(value)>-1);
    });
}

function data_filter() {

    var gs = document.getElementById("gs_select").value;
    var ville = document.getElementById("ville_select").value;

    document.getElementById('dnt').innerText ="";

    $.get("Donnation",{"gs":gs, "ville":ville, "action":"filter"},function(array){

        if(!array.idDonnateur[0])
            document.getElementById('warn').innerHTML = '<div class="alert alert-warning" role="alert"> <i class="fas fa-exclamation-circle"></i> <b> Aucune donation ne correspond à cette catégorie!</b></div>';
        else{
            document.getElementById('warn').innerText ="";
            for (var i=0; array.idDonnateur[i]!=null; i++) {

                var table = document.getElementById('dnt');
                var row = table.insertRow(table.rows.length);

                var idDonn = document.createTextNode(array.idDonnateur[i]);
                var nom_prenom = document.createTextNode(array.pnomD[i]);
                var gs = document.createTextNode(array.gs[i]);
                var dateDonn = document.createTextNode(array.dateDonnation[i]);
                var nom_bnq = document.createTextNode(array.nomB[i]);
                var tel_bnq = document.createTextNode(array.telB[i]);
                var ville_bnq = document.createTextNode(array.villeB[i]);
                row.insertCell(0).appendChild(idDonn);
                row.insertCell(1).appendChild(nom_prenom);
                row.insertCell(2).appendChild(gs);
                row.insertCell(3).appendChild(dateDonn);
                row.insertCell(4).appendChild(nom_bnq);
                row.insertCell(5).appendChild(tel_bnq);
                row.insertCell(6).appendChild(ville_bnq);
                row.insertCell(7).innerHTML = "<a data-toggle=\"modal\" href=\"#AjouterBanque\">\n" +
                    "                                   <span class=\"shadow text-danger p-2\" data-toggle=\"tooltip\" title=\"Modifier\" data-placement=\"left\">\n" +
                    "                                    <span class=\"fa fa-pen\" aria-hidden=\"true\"></span>\n" +
                    "                                   </span>\n" +
                    "                               </a>\n" +
                    "                               <a data-toggle=\"modal\" href=\"#sup${banque.idBS}\">\n" +
                    "                                   <span class=\"shadow text-danger p-2 \" data-toggle=\"tooltip\" title=\"Supprimer\" data-placement=\"right\">\n" +
                    "                                    <span class=\"fa fa-trash\" aria-hidden=\"true\"></span>\n" +
                    "                                   </span>\n" +
                    "                               </a>";
            }
        }
    });
}

function ajouter_donation(){


    //document.getElementById("idD_aj").value  ;
   // document.getElementById("aj_btn").value = ;
   // document.getElementById("aj_btn").value = ;
}

function modifier_donnation(){

}

window.onload = function(){

    document.querySelector("#aj_btn").addEventListener("click",ajouter_donation);
    document.querySelector("#md_btn").addEventListener("click",modifier_donnation);

    document.querySelector("#donnation").addEventListener("keyup",chercher);
    document.querySelector("#gs_select").addEventListener("change",data_filter);
    document.querySelector("#ville_select").addEventListener("change",data_filter);

    document.getElementById("aj_btn").disabled = true;

    $.get("Donnation",{"get_session" : "get_session"},function(data) {
        console.log(data);
    });
}