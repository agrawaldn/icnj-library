<%@ include file="/WEB-INF/jsp/include.jsp" %>

<html>
<head><title>Logon</title></head>
<body>

<center>

	<form method="post">
		<spring:hasBindErrors name="user">
         <font color="red">
         <p>There were ${errors.errorCount} error(s) in total:</p>
         <ul>
            <c:forEach var="errMsgObj" items="${errors.allErrors}">
               <li>
                  <spring:message code="${errMsgObj.code}" text="${errMsgObj.defaultMessage}"/>
               </li>
            </c:forEach>
         </ul>
         </font>
      	</spring:hasBindErrors>
		
		<table width="25%" border="1">
			<tr>
				<td align="center" bgcolor="lightblue">Log on</td>
			</tr>
			<tr>
				<td>
					<table border="0" width="100%">
						<tr>
							<td width="33%" align="right">Username: </td>
							<td width="66%" align="left">
								<input type="text" name="userName"/> 
							</td>
							
						</tr>
						
						<tr>
							<td width="33%" align="right">Password: </td>
							<td width="66%" align="left">
								<input type="password" name="password" />
							</td>
						</tr>
						<tr>
							<td align="center" colspan="2">
								<input type="submit" alignment="center" value="Logon">
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