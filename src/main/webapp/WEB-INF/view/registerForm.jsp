<html>
	<head>
		<title>Register</title>
	</head>
	<body>
		<form action="/registerUser" method="post">
			<input type="text" name="firstName"/>
			<input type="text" name="middleName"/>
			<input type="text" name="lastName"/>
			<input type="text" name="email"/>
			<input type="text" name="mobileNumber"/>
			<input type="text" name="password"/>
			<select name="gender">
				<option value="male">Male</option>
				<option value="female">Female</option>
			</select>
			<input type="submit" value="Submit" />
		</form>
	</body>
</html>