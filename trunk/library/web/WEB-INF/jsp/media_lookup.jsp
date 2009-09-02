<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/jsp/include.jsp"%>


<form:form method="get" commandName="mediaLookupFormBean">
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
	<table border="0" cellpadding="5" cellspacing="0" align="center">
	<tr>
		<td> <spring:message code="label.media.search"/></td>
		<td><form:input path="searchString"/></td>
	</tr>
	<tr>
		<td><input type="submit" value="<spring:message code="button.submit"/>"></td> 
		<td><input type="reset"/></td>
	</tr>
	</table>
</form:form>

<table border="0" cellpadding="5" cellspacing="0" align="center" width="40%">
<thead>
<tr align="center">             
	<th><spring:message code="label.media.id"/></th>             
	<th><spring:message code="label.media.title"/></th>	
	<th><spring:message code="label.media.author"/></th>
	<th><spring:message code="label.media.type"/></th>
	<th><spring:message code="label.media.category"/></th>
	<th><spring:message code="label.media.description"/></th>
	<th><spring:message code="label.media.company"/></th>
</tr>
</thead>
<tbody>
<c:forEach var="media" items="${mediaLookupFormBean.mediaList}">
	<tr align="center">
		<td>
			<c:out value="${media.id}"/>
		</td>
		<td>
			<c:out value="${media.title}"/>		
		</td>
		<td>
			<c:out value="${media.author}"/>	
		</td>
		<td>
			<c:out value="${media.mediaType.mediaType}"/>	
		</td>	
		<td>
			<c:out value="${media.category.category}"/>	
		</td>
		<td>
			<c:out value="${media.description}"/>	
		</td>
		<td>
			<c:out value="${media.company}"/>	
		</td>
		<td>
			<a href="<%= request.getContextPath() %>/cart.htm?action=addToCart&mediaId=${media.id}"><spring:message code="label.addtocart"/></a>
		</td>	
	</tr>
</c:forEach>
</tbody>
</table>

