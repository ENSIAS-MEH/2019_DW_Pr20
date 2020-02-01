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

function data_filter(){

    var gs = document.getElementById("gs_select").value;
    var ville = document.getElementById("ville_select").value;


    console.log(gs);
    console.log(ville);

    $.post('Donnation', {gs:gs, ville:ville, action:"filt"}, function(data){

        console.log(data);
    });
}

window.onload = function(){

    document.querySelector("#donnation").addEventListener("keyup",chercher);
    document.querySelector("#gs_select").addEventListener("change",data_filter);
    document.querySelector("#ville_select").addEventListener("change",data_filter);
}