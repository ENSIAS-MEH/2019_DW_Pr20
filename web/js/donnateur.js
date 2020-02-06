
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

    $.get("Donnateur",{"gs":gs, "ville":ville, "action":"filter"},function(array){
        console.log(array.idDonnateur[0]);
        console.log(array.cin[0]);
        if(!array.idDonnateur[0])
            document.getElementById('warn').innerHTML = '<div class="alert alert-warning" role="alert"> <i class="fas fa-exclamation-circle"></i> <b> Aucun donateur ne correspond à cette catégorie!</b></div>';
        else{
            document.getElementById('warn').innerText ="";
            var table = document.getElementById('dnt');

            for (var i=0; array.idDonnateur[i]!=null; i++) {
                var row = table.insertRow(table.rows.length);

                var idDonn = document.createTextNode(array.idDonnateur[i]);
                var cin = document.createTextNode(array.cin[i]);
                var nom_prenom = document.createTextNode(array.pnomD[i]);
                var gs = document.createTextNode(array.gs[i]);
                var tel = document.createTextNode(array.telD[i]);
                var ville = document.createTextNode(array.ville[i]);

                row.insertCell(0).appendChild(idDonn);
                row.insertCell(1).appendChild(cin);
                row.insertCell(2).appendChild(nom_prenom);
                row.insertCell(3).appendChild(gs);
                row.insertCell(4).appendChild(tel);
                row.insertCell(5).appendChild(ville);

                }
            }
    });
}

window.onload = function() {

    document.querySelector("#donnateur").addEventListener("keyup", chercher);
    document.querySelector("#gs_select").addEventListener("change",data_filter);
    document.querySelector("#ville_select").addEventListener("change",data_filter);

}