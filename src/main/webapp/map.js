/**
 * Created by IntelliJ IDEA.
 * User: Pablo
 * Date: 5/27/11
 * Time: 2:43 PM
 * To change this template use File | Settings | File Templates.
 */

var map = null;
var marker = null;

function loadMap() {

    var mapLayout = document.getElementById("map_canvas");

    var myOptions = {
        zoom: 17,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };

    map = new google.maps.Map(mapLayout, myOptions);

    navigator.geolocation.getCurrentPosition(function(position) {

                if (position.coords.latitude) {

                    map.setCenter(new google.maps.LatLng(position.coords.latitude, position.coords.longitude));

                } else {
                    map.setCenter(-34, -30);

                }
              marker =  new google.maps.Marker({
            position: position,
             });
              marker.setMap(map);
            });


}



function createMarker(posicion, map){

}



$(document).ready(function() {
    loadMap();
})



