<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<form:form method="post" commandName="media" action="/library/addMedia.htm">
		<spring:hasBindErrors name="media">
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
	<table border="0" cellpadding="5" cellspacing="0" align="center">
	<tr>
		<td> Title*:</td><td><form:input path="title"/></td>
		<td> Author*:</td><td><form:input path="author"/></td>
	</tr>
	<tr>
		<td> Media Type*:</td><td>
			<form:select path="mediaType.mediaType">
			<form:option value="book"></form:option>
			<form:option value="dvd"></form:option>
			<form:option value="cd"></form:option>
			</form:select>
		</td>
		<td> Media Category*:</td><td>
			<form:select path="category.category">
			<form:option value="movie"></form:option>
			<form:option value="bhajan"></form:option>
			<form:option value="education"></form:option>
			<form:option value="biography"></form:option>
			<form:option value="dham"></form:option>
			</form:select>
		</td>		
	</tr>
	<tr>
		<td> Volume Number*:</td><td><form:input path="volumeNumber"/></td>
		<td> Total Volumes*:</td><td><form:input path="totalVolume"/></td>
	</tr>
	<tr>
		<td> Publisher*:</td><td><form:input path="company"/></td>
		<td> Description:</td><td><form:input path="description"/></td>
	</tr>
	<tr>
		<td> Total Copies:</td><td><form:input path="copies"/></td>
		<td> Location:</td><td><form:input path="location"/></td>
	</tr>
	<tr>
		<td><input type="submit" value="<spring:message code="button.submit"/>"></td> 
		<td><input type="reset"/></td>
	</tr>
	</table>
</form:form>