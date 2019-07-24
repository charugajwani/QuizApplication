<html>
	<body>
		<script>
			function submitForm(){
				var form = document.getElementById('loginForm');
				form.submit();
			}
		</script>
		<form id="loginForm" action="/doLogin" method="post">
			UserName: <input type="text" name="username">
			Password: <input type="text" name="password">
			<input type="button" value="submit" onclick="submitForm()"/>
		</form>
	</body>
</html>