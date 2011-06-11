<%@ page import="java.util.List" %>
<%@ page import="model.User" %>
<%@ page import="java.util.Set" %>
<!DOCTYPE HTML>
<html>
<head>
<link rel="stylesheet" type="text/css" href="styleFrame.css"/>

</head>

<body>

<div class="section" id="page"> <!-- Defining the #page section with the section tag -->


    <div class="section"> <!-- A new section with the articles -->

        <!-- Article 1 start -->

        <div class="line"></div>
        <!-- Dividing line -->

        <div class="article" id="article1">
            <!-- The new article tag. The id is supplied so it can be scrolled into view. -->


            <div class="line"></div>
			<!-- <span id="title"> FRIENDS </span>  -->
    <form id="friendForm" action="user.do" method="post">
              
                            
              <span id="searchFriend">
              <input id="email" name="email" type="email" placeholder="Add a CoffeeBreak Friend" required/>
                            <input type="submit" name="submit" id="submit" value="Add Friend"/>
                            <input name="action" value="ADD_FRIEND" hidden="true"/>
              </span>
        </form>

            <%--<TABLE>
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
            </TABLE>--%>

            <% for (int i = 0; i < ((List) request.getAttribute("friends")).size(); i++) { %>

            <div class="contact">
                <p class="name"><%=((List<User>)request.getAttribute("friends")).get(i).getNickName().toUpperCase()%>
                    <img src="img/user-icon.png" alt="User Icon">
                </p>

                <p class="location"> Last Known Location: <span class="adress">1485 Invented Avenue </span></p>


                <div class="buttons">
                  <input type="button" value="Locate"/>
                  <input type="button" value="Send Invite"/>
                </div>
            </div>

            <% } %>


        </div>

    </div>
    <!-- Closing the #page section -->

</div>
</body>
</html>