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

    var role = document.getElementById("role").value;
    var session = document.getElementById("session").value;

    if(role == "admin"){
        var gs = document.getElementById("gs_select").value;
        var ville = document.getElementById("ville_select").value;
    }
    else if(role == "banquesang"){
        var gs = document.getElementById("gs_select").value;
        var ville = document.getElementById("session_ville").value;
    }
    else if(role == "donnateur"){
        var gs = document.getElementById("session_gs").value;
        var ville = document.getElementById("ville_select").value;;
    }

    document.getElementById('dnt').innerText ="";

    $.get("Donnation",{"gs":gs, "ville":ville, "action":"filter"},function(array){

        if(!array.idDonnateur[0])
            document.getElementById('warn').innerHTML = '<div class="alert alert-warning" role="alert"> <i class="fas fa-exclamation-circle"></i> <b> Aucune donation ne correspond à cette catégorie!</b></div>';
        else{
            document.getElementById('warn').innerText ="";
            var table = document.getElementById('dnt');

            for (var i=0; array.idDonnateur[i]!=null; i++) {
                if(role == "admin" || (role =="banquesang" && session==array.idBS[i]) || (role =="donnateur" && session==array.idDonnateur[i])){
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

                }
            }
        }
    });
}

function ajouter_donation(){


    var idD = document.getElementById("idD_aj").value  ;
    var idBS = document.getElementById("session").value;

    //console.log("idBS: "+idBS +"-- idDonnateur: "+idD+ "-- DateD: "+dateD);

    $.post("Donnation",{"idD":idD, "idBS":idBS, "action":"ajouter"},function(array){
        console.log(array);
    });
}

function load_target(e){

    console.log(e.parentNode.parentNode.parentNode.parentNode.children[0].innerHTML);
    console.log(e.parentNode.parentNode.parentNode.parentNode.children[3].innerHTML);

    var idD = e.parentNode.parentNode.parentNode.parentNode.children[0].innerHTML;
    var dateD = e.parentNode.parentNode.parentNode.parentNode.children[3].innerHTML;

    document.getElementById("target_supp_idD").value = idD;
    document.getElementById("target_supp_date").value = dateD;

}


window.onload = function(){

    document.querySelector("#donnation").addEventListener("keyup",chercher);
    var role = document.getElementById("role").value;

    if(role == "donnateur"){
        document.querySelector("#ville_select").addEventListener("change",data_filter);
        var gs = document.getElementById("session_gs").value;
        if(gs == 1)
            document.getElementById("session_gs").value = "A-";
        else if(gs == 2)
            document.getElementById("session_gs").value = "A+";
        else if(gs == 3)
            document.getElementById("session_gs").value = "B+";
        else if(gs == 4)
            document.getElementById("session_gs").value = "B-";
        else if(gs == 5)
            document.getElementById("session_gs").value = "AB+";
        else if(gs == 6)
            document.getElementById("session_gs").value = "AB-";
        else if(gs == 7)
            document.getElementById("session_gs").value = "O+";
        else if(gs == 8)
            document.getElementById("session_gs").value = "O-";
    }
    if(role == "admin"){
        document.querySelector("#gs_select").addEventListener("change",data_filter);
        document.querySelector("#ville_select").addEventListener("change",data_filter);
    }
    if(role == "banquesang"){
        document.querySelector("#gs_select").addEventListener("change",data_filter);
        document.querySelector("#aj_btn").addEventListener("click",ajouter_donation);
    }
    document.getElementById('dateD_aj').value = new Date();
}
