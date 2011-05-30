/**
 * Created by IntelliJ IDEA.
 * User: Pablo
 * Date: 5/27/11
 * Time: 2:43 PM
 * To change this template use File | Settings | File Templates.
 */

var map = null;

function loadMap() {

    var mapLayout = document.getElementById("map_canvas");

    var myOptions = {
        zoom: 17,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };

    map = new google.maps.Map(mapLayout, myOptions);



}


navigator.geolocation.getCurrentPosition(function(position) {
          initialLocation = new google.maps.LatLng(position.coords.latitude,position.coords.longitude);
          contentString = "Location found using W3C standard";
          map.setCenter(initialLocation);
          var marker = new google.maps.Marker({
            position: initialLocation,
            title:"Hola Mili !" ,
              animation: google.maps.Animation.DROP,
            map: map
          });
        }, function() {
          alert('AAAAAAAAAAAA');
        });

$(document).ready(function() {
    loadMap();
})



