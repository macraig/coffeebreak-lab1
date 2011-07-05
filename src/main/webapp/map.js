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
var markersMap = new HashMap();
var lastInfoWindow = null;

var contentString = '<div id="content">' +
        '<div id="siteNotice">' +
        '</div>' +
        '<h1 id="windowName"> You Are Here</h1>';

var infowindow = new google.maps.InfoWindow({
            content: contentString
        });

function createContent(name, address, id) {
    var contentString = '<div id="infoWindow">' +

            '<h1 id="windowName">' + name + '  </h1>' +
            '<div id="bodyContent">' +
            'Address : ' + address +
//            '<p> <a href=\"/user.do?action=ADD_FAVOURITE&place_id='+id+'\"> ' + 'Add to Favourites</p>' +
            '<p> <a HREF="javascript:void(0)" onclick="add_favourite(' + id + ')">Add</p>' +
            '<p> <a HREF="javascript:void(0)" onclick="create_invite(' + id + ')">Create Invite</p>' +
            '</div>';
    return contentString;
}

function getPlaces() {
    var json = getJson("http://" + window.location.host + "/place.do?action=PLACE_MARKERS");
    for (var i = 0; i < json.length; i += 5) {

        var marker = new google.maps.Marker({
                    position: new google.maps.LatLng(json[i + 2], json[i + 3]),
                    icon: '/img/coffee.png',
                    animation: google.maps.Animation.DROP

                });
        marker.setMap(map);
        addInfoWindow(marker, createContent(json[i], json[i + 1], json[i + 4]));
        // var infoMarker = new InfoMarker().startupInfoMarker(marker, infowindow);

        // markersMap.put(infoMarker.marker.getPosition(), infoMarker);

        /*google.maps.event.addListener(infoMarker.marker, 'click', function() {
         var infoMarkerSelected = markersMap.get(infoMarker.marker.getPosition());
         infoMarkerSelected.infoWindow.open(map, infoMarker.marker);
         });*/
    }
}

function getFriends() {
    var json = getJson("http://" + window.location.host + "/user.do?action=PLACE_FRIENDS");
    for (var i = 0; i < json.length; i += 3) {

        var marker = new google.maps.Marker({
                    position: new google.maps.LatLng(json[i + 1], json[i + 2]),
                    icon: '/img/friend.png',
                    title: json[i],
                    animation: google.maps.Animation.DROP

                });
        marker.setMap(map);


    }
}

function add_favourite(id) {
    $.ajax({
                url: "/user.do?action=ADD_FAVOURITE&place_id=" + id
            });


}



function addInfoWindow(marker, content) {
    var infoWindow = new google.maps.InfoWindow({
                content: content
            });

    google.maps.event.addListener(marker, 'click', function () {
        if (lastInfoWindow) {
            lastInfoWindow.close()
        }
        infoWindow.open(map, marker);
        lastInfoWindow = infoWindow;
    });
}

/*function locateFriend(){
 var json = getJson("http://"+window.location.host+"/user.do?action=LOCATE_FRIEND");
 map.setCenter(json[0],json[1]);
 }   */

function getJson(url) {
    XMLHttpRequestObject = new XMLHttpRequest();

    XMLHttpRequestObject.open("POST", url, false);

    XMLHttpRequestObject.send(null);

    var JSONtext = (XMLHttpRequestObject.responseText);
    var JSONObject = eval('(' + JSONtext + ')');
    return JSONObject;
}

function loadMap() {

    var mapLayout = document.getElementById("example");

    var myOptions = {
        zoom: 17,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };

    map = new google.maps.Map(mapLayout, myOptions);

    navigator.geolocation.getCurrentPosition(function(position) {

        if (position.coords.latitude) {
            pos = position;
            map.setCenter(new google.maps.LatLng(position.coords.latitude, position.coords.longitude));
            $.ajax({
                        url: "/user.do?action=UPDATE_LOCATION&latitude=" + pos.coords.latitude + "&longitude=" + pos.coords.longitude
                    });

        } else {
            map.setCenter(-34, -30);

        }
        marker = new google.maps.Marker({
                    position: new google.maps.LatLng(pos.coords.latitude, pos.coords.longitude),
                    icon: '/img/me.png',
                    animation: google.maps.Animation.DROP,
                    draggable: true
                });

        marker.setMap(map);

        google.maps.event.addListener(marker, 'click', function() {
            infowindow.open(map, marker);
        });


    });


    getPlaces();
    getFriends();
}


