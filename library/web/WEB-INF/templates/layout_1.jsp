<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="/tags-tiles" %> 

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ISKCON Of Central New Jersey</title>
<link rel=stylesheet type="text/css" href="styles/style.css">
</head>
<body background="<%= request.getContextPath() %>/images/background.jpg" bottommargin="0" leftmargin="0" 
					marginheight="0" marginwidth="0" rightmargin="0" topmargin="0">

<center>
<table width="765" height="100%" cellpadding="0" cellspacing="0" 
					border="0" background="<%= request.getContextPath() %>/images/mainbackground.jpg">
<tr valign="top">
	<td>
	<tiles:insert name="header"/>
	<table width="764" cellpadding="0" cellspacing="0" border="0">
		<tr valign="top">
			<td width="150">
				<tiles:insert name="left-nav"/>
			</td>
			<td width="10">&nbsp;</td>
			<td width="744">
				<tiles:insert name="body"/>
				<tiles:insert name="footer"/>
			</td>
			<td width="10">&nbsp;</td>
		</tr>
	</table>
	</td>
</tr>
</table>
</center>
</body>
</html>