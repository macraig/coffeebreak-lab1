<%@ page import="model.User" %>
<%@ page import="servlets.ActionName" %>
<!DOCTYPE html>

<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <title>Coffee Break</title>

    <link rel="stylesheet" type="text/css" href="styles.css"/>
    <link rel="stylesheet" type="text/css" href="stylesReg.css"/>

    <!--[if IE]>

    <style type="text/css">
        .clear {
            zoom: 1;
            display: block;
        }
    </style>


    <![endif]-->

    <style type="text/css">
        #page #articles #article1 .articleBody.clear {
            text-align: center;
        }

        #page #articles #article1 .articleBody.clear span {
            font-style: italic;
        }

        #page #articles #article1 .articleBody.clear form p {
            text-align: left;
        }

        #page #articles #article1 .articleBody.clear form p {
            text-align: left;
        }
    </style>


</head>

<body>

<div class="section" id="page"> <!-- Defining the #page section with the section tag -->

    <div class="header"> <!-- Defining the header section of the page with the appropriate tag -->

        <h1>Coffee Break</h1>

        <h3>Social Gatherings Made Easy</h3>

        <div class="nav clear"> <!-- The nav link semantically marks your main site navigation -->
            <ul>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="#">Options</a></li>
                <li><a href="logout.jsp">Log Out</a></li>
            </ul>
        </div>

    </div>

    <div class="section" id="articles"> <!-- A new section with the articles -->

        <!-- Article 1 start -->

        <div class="line"></div>
        <!-- Dividing line -->

        <div class="article" id="article1">
            <!-- The new article tag. The id is supplied so it can be scrolled into view. -->
            <h2>GENERAL SETTINGS</h2>

            <div class="line"></div>
            <div class="articleBody clear">


                <form action="user.do" method="post">
                <input value="MODIFY_USER" hidden="true" />

                    <label for="name">Name:</label>
                    <input type="text" name="name" id="name" required value="<%=request.getRemoteUser()%>"
                           disabled="true"/>

                    <label for="email">Email:</label>
                    <input type="email" name="mail" id="mail"
                           value="<%= ((User)request.getAttribute("user")).getEmail()%>" required/><br/>

                    <label for="password">Password:</label>
                    <input type="password" id="pass" name="pass" placeholder="Enter your Password" required/><br/>

                    <input name="action" id="action" value="MODIFY_USER" hidden="true"/>

                    <input type="submit" class="boton" value="Done"/>


                </form>


            </div>


        </div>

        <div class="article" id="article2">
            <!-- The new article tag. The id is supplied so it can be scrolled into view. -->
            <h2>PASSWORD SETTINGS</h2>

            <div class="line"></div>
            <div class="articleBody clear">


                <form action="mod.do" method="post">

                    <label for="name">New Password:</label>
                    <input type="password" name="name" placeholder="Enter NEW Password" required />

                    <label for="email">Confirm:</label>
                    <input type="password" name="mail" placeholder="Confirm NEW Password" required/><br/>

                    <label for="password">Password:</label>
                    <input type="password" name="pass" placeholder="Enter your Password" required/><br/>

                    <input name="action" value="MODIFY_PASS" hidden="true"/>

                    <input type="submit" class="boton" value="Done"/>


                </form>


            </div>


        </div>

        <div class="footer"> <!-- Marking the footer section -->

            <div class="line"></div>

            <p>Copyright 2011 - CoffeeBreak Team</p> <!-- Change the copyright notice -->

            <a href="#" class="up">Go UP</a>
            <a href="" class="by">Chelen Productions</a>


        </div>

    </div>

</div>
</body>

</html>
