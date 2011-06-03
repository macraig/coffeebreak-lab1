<%@ page import="java.util.List" %>
<%@ page import="model.User" %>
<%@ page import="java.util.Set" %>
<!DOCTYPE HTML>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="styles.css"/>



</head>

<body>

<div class="section" id="page"> <!-- Defining the #page section with the section tag -->

    <div class="header"> <!-- Defining the header section of the page with the appropriate tag -->

        <h1>Coffee Break</h1>

        <h3>Social Gatherings Made Easy</h3>

        <div class="nav clear"> <!-- The nav link semantically marks your main site navigation -->
            <ul>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="#">Friends</a></li>
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
            <h2>FRIENDS</h2>

            <div class="line"></div>

            <form id="friendForm" action="user.do" method="post">
                        <p>Search Friend:
                            <input id="email" name="email" type="email" placeholder="Insert Friends Email" required/>
                            <input type="submit" name="submit" id="submit" value="Search"/>
                            <input name="action" value="ADD_FRIEND" hidden="true"/>
                        </p>
                    </form>

            <TABLE>
                <TR>
                    <TH>Select</TH>
                    <TH>Name</TH>
                    <TH>Options</TH>
                </TR>
                <% for (int i = 0; i < ((List)request.getAttribute("friends")).size() ; i++) { %>
                <TR>
                    <TD>
                        <CENTER>
                            <INPUT TYPE="CHECKBOX" NAME="rowArray.<%=i%>.selected">
                        </CENTER>
                    </TD>
                    <TD>
                        <INPUT TYPE="TEXT" readonly="true" value="<%=((List<User>)request.getAttribute("friends")).get(i).getNickName()%>">

                    </TD>
                    <TD>
                        <SELECT NAME="rowArray.<%=i%>.combo" SIZE="1">
                            <OPTION VALUE=""></OPTION>
                            <OPTION VALUE="1">Invite</OPTION>
                            <OPTION VALUE="2">Send Message</OPTION>
                            <OPTION VALUE="3">Opcion para drogadictos</OPTION>
                        </SELECT>
                    </TD>
                </TR>
                <% } %>
            </TABLE>


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