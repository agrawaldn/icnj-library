<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/jsp/include.jsp"%>


<br>
<br>
<form name="form1" method=post>
<spring:hasBindErrors name="user">
	<font color="red">
	<p>There were ${errors.errorCount} error(s) in total:</p>
	<ul>
		<c:forEach var="errMsgObj" items="${errors.allErrors}">
			<li><spring:message code="${errMsgObj.code}"
				text="${errMsgObj.defaultMessage}" /></li>
		</c:forEach>
	</ul>
	</font>
</spring:hasBindErrors>
<p>
<table style="WIDTH: 387px; HEIGHT: 236px" cellspacing="0" cellPadding=3
	width=387 align=center border=0 bgColor=#bcc6ed>

	<tr>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong>Account
		Number:</strong></td>
		<td>
		<p align="center"><input name="accountNumber"></p>
		</td>
	</tr>
	<tr>
		<td colspan="2">
		<p align="center"><input type="submit" value="View Account"
			name="submit"><input type="reset" value="Reset" name="reset"></p>
		</td>
	</tr>
</table>
</P>
<p align="left">&nbsp;
</form>