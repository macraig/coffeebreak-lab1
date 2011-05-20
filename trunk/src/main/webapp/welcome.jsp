<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <link rel="stylesheet" type="text/css" href="style3.css">

    <script type="text/javascript"
            src="http://maps.google.com/maps/api/js?sensor=false">
    </script>
    <script type="text/javascript">
        var map = null;

        function loadMap(){

            var mapLayout = document.getElementById("map_canvas");

            var myOptions = {
                zoom: 17,
                mapTypeId: google.maps.MapTypeId.ROADMAP
            };

            map = new google.maps.Map (mapLayout, myOptions)

            navigator.geolocation.getCurrentPosition(function(position){

                if (position.coords.latitude){

                    map.setCenter(new google.maps.LatLng(position.coords.latitude, position.coords.longitude));
                } else {
                    map.setCenter(-34,-30);

                }

            });

        }

    </script>

</head>
<body onload="loadMap()">
<header>
    <div id="user-bar">

        <table width="100%" border="0">

            Welcome <%=request.getRemoteUser()%> to Cofee Break
            <a href="logout.jsp"> <font color="#FFFFCC"> Logout</font> </a>

        </table>









    </div>





</header>

<div id="content">
    <div id="map_canvas"></div>
</div>
</body>
</html>