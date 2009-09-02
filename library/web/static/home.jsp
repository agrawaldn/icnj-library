<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="/tags-tiles" %>
<tiles:insert definition="template">
  <tiles:put name="body" type="string">
  <TABLE cellSpacing=0 cellPadding=0 width=561 bgColor=#ffffff border=0>
        <TBODY>
        <TR>
          <TD width=5 height=16>&nbsp;</TD>
          <TD width=5>&nbsp;</TD>
          <TD colSpan=5>&nbsp;</TD></TR>
        <TR>
          <TD width=5 rowSpan=4>&nbsp;</TD>
          <TD width=5 rowSpan=4>&nbsp;</TD>
          <TD colSpan=5 height=121><!-- <IFRAME 
            src="<%= request.getContextPath() %>/static/html/homeshow.html" 
            frameBorder=0 width=550 scrolling=no 
            height=260>
    <div align="center"><a href="<%= request.getContextPath() %>/static/html/homeshow.html">Hmm, you are using a very old browser.
      Click here to go directly to included content.</a></div>
    </IFRAME> --></TD></TR>
        <TR>
          <TD bgColor=#ffffff colSpan=5>&nbsp;</TD></TR>
        <TR>
          <TD bgColor=#000033 colSpan=5 height=24>
            <DIV class=style18 align=center>LATEST NEWS </DIV></TD></TR>
        <TR>
          <TD bgColor=#ffffff colSpan=5>
            <SCRIPT language=JavaScript>Tscroll_init (0)</SCRIPT>
          </TD></TR>
        <TR>
          <TD width=5>&nbsp;</TD>
          <TD width=5>&nbsp;</TD>
          <TD colSpan=5>
            <CENTER></CENTER><!-- WebApp ID: 5000 -->
            <SCRIPT>
/* please note: this script requires url.js */
if (typeof(__path_prefix__) == 'undefined')
    __path_prefix__ = '.';
if (typeof(URL) == 'function') {
    var appLoaderUrl = new URL('http://cgiwsc.enhancedsitebuilder.com:80/cgi-bin/AppLoader/AENDU0IN2CCF/5000//20080121-174618?cc=1205366779888&modified=20080121-174618');
    if (appLoaderUrl.setSession())
        appLoaderUrl.setParameter("foo", Math.random(), true);
  document.write("<SCRIPT src='" + appLoaderUrl.toExternalForm() + "'></"+"SCRIPT>");
}
</SCRIPT>
            <NOSCRIPT></NOSCRIPT></TD></TR>
        <TR>
          <TD>&nbsp;</TD>
          <TD>&nbsp;</TD>
          <TD colSpan=5>&nbsp;</TD></TR>
        <TR>
          <TD>&nbsp;</TD>
          <TD>&nbsp;</TD>
          <TD bgColor=#000000>
            <DIV align=center><IMG height=324 alt=p 
            src="<%= request.getContextPath() %>/images/other/chandan.jpg" 
            width=178 border=0></DIV></TD>
          <TD width=5 bgColor=#ffffff><SPAN class=style20>s</SPAN></TD>
          <TD bgColor=#abe2b5>
            <DIV align=center><A 
            href="/static/temple_project.jsp"><IMG height=324 
            alt=pl 
            src="<%= request.getContextPath() %>/images/other/projectbox.gif" 
            width=178 border=0></A></DIV></TD>
          <TD width=5 bgColor=#ffffff><SPAN class=style20>s</SPAN></TD>
          <TD>
            <DIV align=center><A 
            href="http://www.iskconnj.com/wc/darshangallery"><IMG height=324 
            alt=plk 
            src="<%= request.getContextPath() %>/images/other/darshan.jpg" 
            width=178 border=0></A></DIV></TD></TR>
        <TR>
          <TD>&nbsp;</TD>
          <TD>&nbsp;</TD>
          <TD colSpan=5>&nbsp;</TD></TR>
        <TR>
          <TD>&nbsp;</TD>
          <TD>&nbsp;</TD>
          <TD colSpan=5>
            <DIV class="style26 style19" align=center>Please support us in 
            serving Sri Sri Radha Krishna through your loving 
        donation</DIV></TD></TR>
        <TR>
          <TD>&nbsp;</TD>
          <TD>&nbsp;</TD>
          <TD colSpan=5>&nbsp;</TD></TR>
        <TR>
          <TD>&nbsp;</TD>
          <TD>&nbsp;</TD>
          <TD colSpan=5>
            <DIV align=center></DIV></FONT>
            <DIV></DIV>
            <DIV><FONT face=Arial,Helvetica,sans-serif color=black size=2>
            <DIV>
            <FORM action=https://www.paypal.com/cgi-bin/webscr 
            method=post><INPUT type=hidden value=_xclick name=cmd> <INPUT 
            type=hidden value=harekrishna@iskconnj.com name=business> <INPUT 
            type=hidden value="Iskcon of Central New Jersey" name=item_name> 
            <INPUT type=hidden value=0 name=no_shipping> <INPUT type=hidden 
            value=1 name=no_note> <INPUT type=hidden value=USD 
            name=currency_code> <INPUT type=hidden value=0 name=tax> <INPUT 
            type=hidden value=US name=lc> <INPUT type=hidden 
            value=PP-DonationsBF name=bn> 
            <CENTER><INPUT type=image 
            alt="Make payments&#10;                                    with PayPal - it's fast, free and secure!" 
            src="<%= request.getContextPath() %>/images/other/x-click-but21.gif" 
            border=0 name=submit> <IMG height=1 alt=paypal 
            src="<%= request.getContextPath() %>/images/pixel.gif" 
            width=1 border=0> 
            <CENTER></FORM><!--"''"--></DIV></FONT></DIV></CENTER></CENTER></TD></TR></TBODY></TABLE>
    </tiles:put>
  </tiles:insert>