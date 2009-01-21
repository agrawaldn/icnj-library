<%@ page session="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="str" uri="http://jakarta.apache.org/taglibs/string-1.1" %>
<%@ taglib prefix="spring" uri="/spring" %>

<STYLE type=text/css media=all>BODY {
	FONT: 0.8em arial, helvetica, sans-serif
}
#header UL {
	PADDING-RIGHT: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; MARGIN: 0px; PADDING-TOP: 0px; LIST-STYLE-TYPE: none
}
#header LI {
	BORDER-RIGHT: #bbb 1px solid; BORDER-TOP: #bbb 1px solid; FLOAT: left; MARGIN: 0px; BORDER-LEFT: #bbb 1px solid; BORDER-BOTTOM: #bbb 0px solid
}
#header A {
	PADDING-RIGHT: 1em; DISPLAY: block; PADDING-LEFT: 1em; BACKGROUND: #eee; PADDING-BOTTOM: 0.24em; WIDTH: 8em; COLOR: #00c; PADDING-TOP: 0.24em; TEXT-ALIGN: center; TEXT-DECORATION: none
}
#header A:hover {
	BACKGROUND: #ddf
}
#header #selected {
	BORDER-LEFT-COLOR: black; BORDER-BOTTOM-COLOR: black; BORDER-TOP-COLOR: black; BORDER-RIGHT-COLOR: black
}
#header #selected A {
	FONT-WEIGHT: bold; BACKGROUND: white; COLOR: black; POSITION: relative; TOP: 1px
}
#content {
	CLEAR: both; BORDER-RIGHT: black 1px solid; PADDING-RIGHT: 1em; BORDER-TOP: black 1px solid; PADDING-LEFT: 1em; PADDING-BOTTOM: 0px; BORDER-LEFT: black 1px solid; PADDING-TOP: 0px; BORDER-BOTTOM: black 1px solid
}

</STYLE>


