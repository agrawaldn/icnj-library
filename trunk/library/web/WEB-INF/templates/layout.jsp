 
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="/tags-tiles" %> 


<html>
<head><title>ISKCON CNJ Library</title></head>

<body>
<table cellspacing="0" cellpadding="0" border="0">
<tr>
<td colspan="2">
<tiles:insert name="header"/>
</td>
</tr>
<tr>
<td width="25%">
<tiles:insert name="left-nav"/>
</td>
<td width="75%">
<tiles:insert name="body"/>
</td>
</tr>
<tr>
<td colspan="2">
<tiles:insert name="footer"/>
</td>
</tr>

</table>
</body>


</html>

