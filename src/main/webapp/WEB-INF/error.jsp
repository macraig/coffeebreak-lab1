<%@ page import="enums.Error" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title></title>
    <meta http-equiv=refresh content="2; URL=register.html"/>
</head>
<body>

        <%  String html= "error";
            switch (Error.valueOf(request.getParameter("error"))) {

                   case NICKNAME_USED:
                        html="The nickname is already taken"
                   case EMAIL_USED:
                         html="The email address is already in use"

                }



        %>
        <span style="font-size:25px;"> <%= html%> > </span>
</body></span>
</html>