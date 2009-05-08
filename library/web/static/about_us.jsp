<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="/tags-tiles" %>
<tiles:insert definition="template">
  <tiles:put name="body" type="string">
  <TABLE width="564" border="0" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bgcolor="#FFFFFF">
  <TR><TD width="11">&nbsp;</TD>
    <TD width="11">&nbsp;</TD>
    <TD width="532">&nbsp;</TD>
</TR>
  <TR>
    <TD height="29">&nbsp;</TD>
    <TD>&nbsp;</TD>
    <TD bgcolor="#143E64"><div align="center" class="style14">
      <div align="left"><img src="<%= request.getContextPath() %>/images/other/aboutfounder.jpg" width="550" height="483"></div>
    </div></TD>
  </TR>
  <TR>
    <TD>&nbsp;</TD>
    <TD>&nbsp;</TD>
    <TD bgcolor="#720d3d"><div align="left"><a href="gp08.html"></a><img src="<%= request.getContextPath() %>/images/other/aboutus.jpg" width="550" height="550"></div></TD>
  </TR>
  <TR><TD width="11">&nbsp;</TD>
  <TD width="11">&nbsp;</TD>
  <TD width="532" bordercolor="#FFFFFF" bgcolor="#FFFFFF"><CENTER><div id='pre_content_div' style='display:none;'></div>
      <span class="style4"><a href="http://www.krishnanyc.com/faq.html">For Questions and Answers Please Click Here  </a> </span>
  </CENTER></TD>
</TR>
  </TABLE>
    </tiles:put>
  </tiles:insert>