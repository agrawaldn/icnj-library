<%@ page import="org.springframework.security.ui.webapp.AuthenticationProcessingFilter" %>
<%@ page import="org.springframework.security.ui.AbstractProcessingFilter" %>
<%@ page import="org.springframework.security.AuthenticationException" %>

<html>
<head><title>Logon</title></head>
<body> 
<center>
<form action="j_spring_security_check">
		<table width="25%" border="1">
			<tr>
				<td align="center" bgcolor="lightblue">Log on</td>
			</tr>
			<tr>
				<td>
					<table border="0" width="100%">
						<tr>
							<td width="33%" align="right"><label for="j_username">Username: </label> </td>
							<td width="66%" align="left">
								<input type="text" name="j_username" id="j_username" <c:if test="${not empty param.login_error}">value='<%= session.getAttribute(AuthenticationProcessingFilter.SPRING_SECURITY_LAST_USERNAME_KEY) %>'</c:if>/> 
							</td>
							
						</tr>
						
						<tr>
							<td width="33%" align="right">Password: </td>
							<td width="66%" align="left">
								<input type="password" name="j_password" id="j_password"/>
							</td>
						</tr>
						<tr>
							<td width="33%" align="right"><input type='checkbox' name='_spring_security_remember_me'/></td>
							<td width="66%" align="left">Remember me on this computer.	</td>
						</tr>
						<tr>
							<td align="center" colspan="2">
								<input type="submit" alignment="center" value="Login">
							</td>
						</tr>
					</table>
					
				</td>
			</tr>
		</table>
</form>
</center>
</body>
</html>