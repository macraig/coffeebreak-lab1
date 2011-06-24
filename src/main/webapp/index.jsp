<!DOCTYPE HTML>
<html>
<head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="styleNew.css"/>
    <script type="text/javascript" src="jquery/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="HashMap.js"></script>
    <script src="http://maps.google.com/maps/api/js?sensor=false" type="text/javascript"></script>
    <script type="text/javascript" src="gmap3.js"></script>
    <script type="text/javascript" src="map.js"></script>
    <script type="text/javascript" src="InfoMarker.js"></script>

</head>

<body onload="loadMap()">

<div class="section" id="page" style="height:90%"> <!-- Defining the #page section with the section tag -->

    <div class="header"> <!-- Defining the header section of the page with the appropriate tag -->

        <h1>Coffee Break</h1>

        <h3>Social Gatherings Made Easy</h3>

        <div class="nav clear"> <!-- The nav link semantically marks your main site navigation -->
            <ul>
                <li><a href="#article1">Home</a></li>
                <li><a href="/redirect.do?action=MODIFY_USER">Options</a></li>
                <li><a href="logout.jsp">Log Out</a></li>
            </ul>
        </div>

    </div>

    <div class="section"> <!-- A new section with the articles -->

        <!-- Article 1 start -->

        <div class="line"></div>
        <!-- Dividing line -->

        <div class="article" id="article1">
            <!-- The new article tag. The id is supplied so it can be scrolled into view. -->
            <div class="tabArea">

                <h2>

                    <a class="tab" id="tab1" href="/redirect.do?action=ADD_FRIEND" target="tabIframe2"> Friends </a>
                    <a class="tab" id="tab2" href="/redirect.do?action=SHOW_FAVOURITES" target="tabIframe2"> Places </a>
                    <a class="tab" id="tab3" href="/redirect.do?action=SHOW_INVITATIONS" target="tabIframe2">
                        Invites </a>

                </h2>

            </div>

            <%--            <ul id="navigation">
                <li class="one"><a href="#">Details</a></li>
                <li class="two"><a href="#">Schedule</a></li>
                <li class="three selected"><a href="#">Speakers</a></li>
                <li class="shadow"></li>
            </ul>--%>

            <div class="line"></div>


            <iframe name="tabIframe2" src="/redirect.do?action=ADD_FRIEND" id="mainFrame" frameborder="0">
                tu navegador no soporta iframes
            </iframe>

        </div>

        <div class="article" id="article2">
            <!-- The new article tag. The id is supplied so it can be scrolled into view. -->
            <h2><%=request.getRemoteUser().toUpperCase()%>
            </h2>

            <div class="line"></div>

            <div id="example"></div>


        </div>


    </div>
    <div class="footer"> <!-- Marking the footer section -->

        <div class="line"></div>

        <p>Copyright 2011 - CoffeeBreak Team</p> <!-- Change the copyright notice -->

        <a href="#" class="up">Go UP</a>
        <a href="" class="by">CoffeeBreak Team</a>


    </div>

</div>

<%--<script type="text/javascript">
$(document).ready(function(){
	$("ul#navigation li a").click(function() {
		$("ul#navigation li").removeClass("selected");
		$(this).parents().addClass("selected");
		return false;
	});
});
</script>--%>

</body>
</html>