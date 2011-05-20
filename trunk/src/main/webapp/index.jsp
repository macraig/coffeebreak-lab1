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
        <form id="loginForm" action="j_security_check" method="post">
            <table width="100%" border="0">



                <tr>
                    <td colspan="2" rowspan="2"><span class="titulo">SANGRE</span></td>
                    <td width="24%"><input id="j_username" name="j_username" type="text" placeholder="name@mail.com" /></td>
                    <td width="12%"><input type="submit" class="boton" value="SIGN IN" /></td>
                </tr>
                <tr>
                    <td><input id="j_password" name="j_password" type="password" placeholder="*****"/></td>
                    <td> <a href="register.html" class=""><span class="boton">SIGN UP</span></a></td>
                    <td> <a href="mod.jsp" class=""><span class="boton"> MODIFICAR </span></a></td>
                </tr>
            </table>







        </form>


    </div>


</header>

<div id="content">
    <div id="map_canvas"></div>
</div>
</body>
</html>