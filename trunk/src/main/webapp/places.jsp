<%@ page import="java.util.List" %>
<%@ page import="model.User" %>
<%@ page import="java.util.Set" %>
<%@ page import="model.Place" %>
<!DOCTYPE HTML>
<html>
<head>
    <!-- <link rel="stylesheet" type="text/css" href="styles.css"/>       -->


</head>

<body>

<div class="section" id="page"> <!-- Defining the #page section with the section tag -->


    <div class="section"> <!-- A new section with the articles -->

        <!-- Article 1 start -->

        <div class="line"></div>
        <!-- Dividing line -->

        <div class="article" id="article1">
            <!-- The new article tag. The id is supplied so it can be scrolled into view. -->
            <h2>PLACES</h2>

            <div class="line"></div>

            <p> To add a place select it from the map and clock on "Add to Favourites"</p>

            <TABLE>
                <TR>
                    <TH>Select</TH>
                    <TH>Name</TH>
                    <TH>Address</TH>
                    <TH>Options</TH>
                </TR>
                <% for (int i = 0; i < ((List) request.getAttribute("places")).size(); i++) { %>
                <TR>
                    <TD>
                        <CENTER>
                            <INPUT TYPE="CHECKBOX" NAME="rowArray.<%=i%>.selected">
                        </CENTER>
                    </TD>
                    <TD>
                        <INPUT TYPE="TEXT" readonly="true"
                               value="<%=((List<Place>)request.getAttribute("places")).get(i).getName()%>">

                    </TD>
                    <TD>
                        <INPUT TYPE="TEXT" readonly="true"
                               value="<%=((List<Place>)request.getAttribute("places")).get(i).getAddress()%>">

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

    </div>
    <!-- Closing the #page section -->

</div>

</body>
</html>