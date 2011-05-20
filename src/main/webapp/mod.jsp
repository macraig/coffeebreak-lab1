<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Modify User: <%= request.getRemoteUser()%>   </title>
<link rel="stylesheet" type="text/css" href="style2.css">
</head>

<body>

<div id="content">
	<h1>NEW USER</h1>
	<form action="register.do" method="post">
		<fieldset>
			<label for="name">Name:</label>
			<input type="text" name="name" id="name" placeholder="Enter your User Name" required />
            <br/>

            <label for="password">Password:</label>
			<input type="password" id="pass" name="pass" placeholder="Enter your Password" required /><br/>

			<label for="email">Email:</label>
			<input type="email" name="mail" id="mail" placeholder="Enter your email address" required /><br/>

			<input type="submit" class="boton" value="Register" />

		</fieldset>
	</form>
</div>

</body>
</html>