<%@ page import="java.util.List" %>
<%@ page import="model.User" %>
<%@ page import="DAO.UserDAO" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="styleNew.css"/>
    <link rel="stylesheet" type="text/css" href="adminSpecial.css"/>
    

</head>

<body onload="loadMap()">
<% if (!UserDAO.retrieveUserbyNickName(request.getRemoteUser()).isAdmin()){
            request.getRequestDispatcher("index.jsp").forward(request,response);
} %>

<div class="section" id="page" style="height:90%"> <!-- Defining the #page section with the section tag -->

    <div class="header"> <!-- Defining the header section of the page with the appropriate tag -->

        <h1>Coffee Break</h1>

        <h3>Social Gatherings Made Easy</h3>

        <div class="nav clear"> <!-- The nav link semantically marks your main site navigation -->
            <ul>
                <li><a href="#article1">Home</a></li>
                <li><a href="/redirect.do?action=ALL_USERS">All Users</a></li>
                <li><a href="/redirect.do?action=MODIFY_USER">Place Suggestions</a></li>
                <li><a href="/redirect.do?action=MODIFY_USER">Options</a></li>
                <li><a href="logout.jsp">Log Out</a></li>
            </ul>
        </div>

    </div>

    <div class="section"> <!-- A new section with the articles -->

        <!-- Article 1 start -->

        <div class="line"></div>
        <!-- Dividing line -->


        <div class="article" id="article2">
            <!-- The new article tag. The id is supplied so it can be scrolled into view. -->
            <h2>All Users</h2>

            <div class="line"></div>

           <TABLE>
                <TR>
                    <TH>Name</TH>
                    <TH>Admin</TH>
                    <TH>Status</TH>
                    <TH>Action</TH>
                    <TH>Go</TH>
                </TR>
                <% for (int i = 0; i < ((List)request.getAttribute("users")).size() ; i++) { %>
                <TR>
                
                <form id="userForm" action="/user.do" method="post">
                 
                    <TD>
                     
                            <INPUT TYPE="TEXT" readonly="true" value="<%=((List<User>)request.getAttribute("users")).get(i).getNickName()%>">
                  
                    </TD>
                    <TD>
                        <INPUT TYPE="TEXT" readonly="true" value="<%=((List<User>)request.getAttribute("users")).get(i).isAdmin()%>">

                    </TD>
                                        <TD>
                        <INPUT TYPE="TEXT" readonly="true" value="<%=((List<User>)request.getAttribute("users")).get(i).isDeleted()%>">

                    </TD>
                    <TD>
                        <SELECT NAME="rowArray.<%=i%>.combo" SIZE="1">
                            <OPTION VALUE=""></OPTION>
                            <OPTION VALUE="1">Delete</OPTION>
                            <OPTION VALUE="2">Make Admin</OPTION>
                            <OPTION VALUE="3">UnDelete</OPTION>
                        </SELECT>
                    </TD>
                    
                                                            <TD>
                        <INPUT TYPE="SUBMIT" value="Go">

                    </TD>
                 </form>
                </TR>

                <% } %>
            </TABLE>


        </div>


    </div>
    <div class="footer"> <!-- Marking the footer section -->

        <div class="line"></div>

        <p>Copyright 2011 - CoffeeBreak Team</p> <!-- Change the copyright notice -->

        <a href="#" class="up">Go UP</a>
        <a href="" class="by">CoffeeBreak Team</a>


    </div>

</div>

</body>
</html>