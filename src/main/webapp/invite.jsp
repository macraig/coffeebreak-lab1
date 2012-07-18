<%@ page import="model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="DAO.PlaceDAO" %>
<!DOCTYPE html>

<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <title>Coffee Break</title>

    <%--<link rel="stylesheet" type="text/css" href="styles.css"/>--%>
    <link rel="stylesheet" type="text/css" href="inviteStyle.css"/>
    <script src="jquery-1.4.4.min.js" type="text/javascript"></script>
    <script src="jquery.hyjack.select.js" type="text/javascript"></script>
    <script src="invite.js" type="text/javascript"></script>
    <link href="hyjack.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="include/jquery-1.5.1.min.js"></script>
    <script type="text/javascript" src="include/jquery.ui.core.min.js"></script>
    <script type="text/javascript" src="include/jquery.ui.widget.min.js"></script>
    <script type="text/javascript" src="include/jquery.ui.tabs.min.js"></script>
    <script type="text/javascript" src="jquery.ui.timepicker.js?v=0.2.3"></script>
    <link rel="stylesheet" href="timepicker.css" type="text/css" />
        <link rel="stylesheet" href="include/jquery-ui-1.8.14.custom.css" type="text/css" />



    <!--[if IE]>

    <style type="text/css">
        .clear {
            zoom: 1;
            display: block;
        }
    </style>


    <![endif]-->


    <script type="text/javascript">

//        $(function () {
//            var wait = 3000;
//            $('.old').fadeTo('fast', .4);
//
//            // Hyjack Onload with all defaults
//            $('.hyjack').hyjack_select();
//            $('#rs_select').hyjack_select({ restrictSearch: true });
//            $('#filter_select').hyjack_select({ filter: 'like' });
//        });

    </script>


</head>

<body>

<div class="line"></div>
<!-- Dividing line -->

<div class="article" id="article1">
    <!-- The new article tag. The id is supplied so it can be scrolled into view. -->
    <h2>New Invitation</h2>

    <div class="line"></div>
    <div class="articleBody clear">


        <form action="/user.do?action=CREATE_INVITE" method="post" id="inviteForm">

            <label for="name">Place:</label>
            <input type="text" name="place" id="place"
                   value="<%=PlaceDAO.retrievePlacesbyId(Long.parseLong(request.getParameter("id"))).getName()%>"
                   disabled="true" required/>
            <br/>

            <label for="password">Time:</label>
            <input type="text" id="timepicker" name="timepicker" required/><br/>
             <script type="text/javascript">
            $(document).ready(function() {
                $('#timepicker').timepicker();
            });
        </script>
            <label for="select">Friends:</label>
            <select id="test1" class="hyjack">
                <% for (int i = 0; i < ((List) request.getAttribute("friends")).size(); i++) { %>
                <option value=<%=((User) (((List) request.getAttribute("friends")).get(i))).getNickName()%>><%=((User) (((List) request.getAttribute("friends")).get(i))).getNickName()%>
                </option>
                <% } %>
            </select>
            <input type="button" value="Add" onclick="addInviteFriend($('#test1').val())">
            <input type="text" hidden="true" id="amigos" name="amigos">
            <input type="text" hidden="true" id="placeId" name="placeId" value="<%=request.getParameter("id")%>">

            <TABLE id="dataTable" width="350px" border="1">
                <TR>
                    <TD><INPUT type="text" value="" disabled="true" name="chk"/></TD>
                    <TD><INPUT type="text" value="Name" disabled="true" name="chk"/></TD>

                </TR>
            </TABLE>

            <INPUT type="button" value="Delete Row" onclick="deleteRow()" />


            <div id="nameList"></div>
            <input name="action" id="action" value="CREATE_INVITE" hidden="true"/>

            <input type="submit" class="boton" onclick="sendData(name.value,datetime.value)" value="CREATE"/>


        </form>


    </div>


</div>


</body>
</html>