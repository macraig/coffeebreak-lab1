<!DOCTYPE HTML>
<html>
<head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="styles.css"/>
    <link rel="stylesheet" type="text/css" href="welcomeStyle.css"/>
    <link rel="stylesheet" type="text/css" href="newStyle.css"/>




</head>

<body onLoad="loadMap()">

<div class="section" id="page"> <!-- Defining the #page section with the section tag -->

    <div class="header"> <!-- Defining the header section of the page with the appropriate tag -->

        <h1>Coffee Break</h1>

        <h3>Social Gatherings Made Easy</h3>

        <div class="nav clear"> <!-- The nav link semantically marks your main site navigation -->
            <ul>
                <li><a href="#article1">Home</a></li>
                <li><a href="/redirect.do?action=ADD_FRIEND">Friends</a></li>
                <li><a href="/redirect.do?action=MODIFY_USER">Options</a></li>
                <li><a href="logout.jsp">Log Out</a></li>
            </ul>
        </div>

    </div>

    <div class="section"> <!-- A new section with the articles -->

        <!-- Article 1 start -->

        <div class="line"></div>
        <!-- Dividing line -->


        <div class="article" id="opt">
            <!-- The new article tag. The id is supplied so it can be scrolled into view. -->
            <h2><%=request.getRemoteUser().toUpperCase()%>
            </h2>

            <div class="line"></div>
			
            
            <p> AAAAAAAAAAAAAAAAAAAAAAAA<br>
AAAAAAAAAAAAAAAAA<br>
AAAAAAAAAAAAAAAAAAAAAAAAAAAAA<br>
AAAAAAAAAAAAAAAAAAAAAAAAA<br>
A<br>
A<br>
A<br>
</p>

        </div>

        <div class="article" id="article1">
            <h2><%=request.getRemoteUser().toUpperCase()%>
            </h2>

            <div class="line"></div>

            <div id="map_canvas"></div>


        </div>


        <div class="footer"> <!-- Marking the footer section -->

            <div class="line"></div>

            <p>Copyright 2011 - CoffeeBreak Team</p> <!-- Change the copyright notice -->

            <a href="#" class="up">Go UP</a>
            <a href="" class="by">CoffeeBreak Team</a>


        </div>

    </div>
    <!-- Closing the #page section -->

</div>

</body>
</html>