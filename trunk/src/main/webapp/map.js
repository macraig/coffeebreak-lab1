/**
 * Created by IntelliJ IDEA.
 * User: Pablo
 * Date: 5/27/11
 * Time: 2:43 PM
 * To change this template use File | Settings | File Templates.
 */

var map = null;
var marker = null;
var pos = null;
function loadMap() {

    var mapLayout = document.getElementById("map_canvas");

    var myOptions = {
        zoom: 17,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };

    map = new google.maps.Map(mapLayout, myOptions);

    navigator.geolocation.getCurrentPosition(function(position) {

        if (position.coords.latitude) {
           pos=position;
            map.setCenter(new google.maps.LatLng(position.coords.latitude, position.coords.longitude));



        } else {
            map.setCenter(-34, -30);

        }
        marker = new google.maps.Marker({
            position: new google.maps.LatLng(pos.coords.latitude, pos.coords.longitude),
        animation: google.maps.Animation.DROP
        });
        marker.setMap(map);
    });


}

var contentString = '<div id="content">'+
    '<div id="siteNotice">'+
    '</div>'+
    '<h1 id="windowName"> Name</h1>'+
    '<div id="bodyContent">'+
    '<p><b>Uluru</b>, also referred to as <b>Ayers Rock</b>, is a large ' +
    'sandstone rock formation in the southern part of the '+
    'Northern Territory, central Australia. It lies 335 km (208 mi) '+
    'south west of the nearest large town, Alice Springs; 450 km '+
    '(280 mi) by road. Kata Tjuta and Uluru are the two major '+
    'features of the Uluru - Kata Tjuta National Park. Uluru is '+
    'sacred to the Pitjantjatjara and Yankunytjatjara, the '+
    'Aboriginal people of the area. It has many springs, waterholes, '+
    'rock caves and ancient paintings. Uluru is listed as a World '+
    'Heritage Site.</p>'+
    '<p>Attribution: Uluru, <a href="http://en.wikipedia.org/w/index.php?title=Uluru&oldid=297882194">'+
    'http://en.wikipedia.org/w/index.php?title=Uluru</a> (last visited June 22, 2009).</p>'+
    '</div>'+
    '</div>';

var infowindow = new google.maps.InfoWindow({
    content: contentString
});

google.maps.event.addListener(marker, 'click', function() {
  infowindow.open(map,marker);
});

$(document).ready(function() {
    alert(3);
    loadMap();
    alert(2);
})



