<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
    <title>Logout</title>
    <link href="stylelog.css" rel="stylesheet" type="text/css"/>
    <meta http-equiv=refresh content="2; URL=welcome.html"/>
</head>

<body>
<h1>Logout Succesfull!</h1>
<%

    Cookie[] cookies = request.getCookies();
    for (Cookie cookie : cookies) {
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
    session.invalidate();

%>
You have been logged out of CofeeBreak.<p>

</body>

</html>