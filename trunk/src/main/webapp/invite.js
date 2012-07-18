var friendList = new Array();
var deleted = new Array();
var selectbox;
var count = 0;

function addInviteFriend(name) {

    friendList.push(name);


    count = count + 1;


    var table = document.getElementById('dataTable');
//    var friends = document.getElementById('amigos');

    var rowCount = table.rows.length;
    var row = table.insertRow(rowCount);

    var cell1 = row.insertCell(0);
    var element1 = document.createElement("input");
    element1.type = "checkbox";
    cell1.appendChild(element1);

    var cell2 = row.insertCell(1);
    cell2.innerHTML = name;


//           var cell3 = row.insertCell(2);
//           var element2 = document.createElement("input");
//           element2.type = "text";
//           cell3.appendChild(element2);


//       el remove implementado?


    updateText();
    removeOptions();

}

function updateText() {


    formObject = document.forms['inviteForm'];
    formElement = formObject.elements["amigos"];

    var previous = formElement.value;
    var friendText = "";

    for (var i = 0; i < friendList.length; i++) {
        friendText = friendText + "," + friendList[i];
    }

    formElement.value = friendText;


}


function removeOptions() {
    selectbox = document.getElementById('test1');
    var i;
    for (i = selectbox.options.length - 1; i >= 0; i--) {
        if (selectbox.options[i].selected) {
            selectbox.remove(i);
            deleted.push(selectbox.options[i]);
        }
    }
}

function deleteRow() {

    selectbox = document.getElementById('test1');
    try {
        var table = document.getElementById('dataTable');
        var rowCount = table.rows.length;

        for (var i = 0; i < rowCount; i++) {
            var row = table.rows[i];
            var chkbox = row.cells[0].childNodes[0];
            if (null != chkbox && true == chkbox.checked) {
                // agregar la opcion al select

                var deleted = row.cells[1].childNodes[0].data;

                var optn = document.createElement("OPTION");
                optn.text = deleted;
                optn.value = deleted;
                selectbox.options.add(optn);



                var aux = new Array();

                for (var j = 0; j < friendList.length; j++) {
                    if (friendList[j]!=deleted) {
                        alert(friendList[j]);

                        aux.push(friendList[j]);
                   }
                }

                friendList =aux;


                 updateText();




                table.deleteRow(i);


                //row.cells[1].childNodes[0].data

                //alert(row.cells[1].childNodes[0].data);
                rowCount--;
                i--;


            }

        }
    } catch(e) {
        alert(e);
    }
}


function sendData(place, date) {


    $.ajax({
                url: "/user.do?action=ADD_FAVOURITE&place_id=" + id
            });


}







