<%@ taglib uri="http://struts-menu.sf.net/tag-el" prefix="menu" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
    <script type="text/javascript">
    /*<![CDATA[*/
    function IEHoverPseudo() {

        var navItems = document.getElementById("primary-nav").getElementsByTagName("li");

        for (var i=0; i<navItems.length; i++) {
            if(navItems[i].className == "menubar") {
                navItems[i].onmouseover=function() { this.className += " over"; }
                navItems[i].onmouseout=function() { this.className = "menubar"; }
            }
        }

    }
    window.onload = IEHoverPseudo;
    /*]]>*/
    </script>

    <style type="text/css">

        body { font: normal 80% verdana; }

        ul#primary-nav,
        ul#primary-nav ul {
            margin: 0;
            padding: 0;
            width: 150px; /* Width of Menu Items */
            /*border-bottom: 1px solid #ccc;*/
            border-bottom: 1px solid #333;
            /*background: #fff; */
            background: #ECE2D7;
            font-size: 100%;
        }

        ul#primary-nav li {
            position: relative;
            list-style: none;
        }

        ul#primary-nav li a {
            display: block;
            text-decoration: none;
            color: #777;
            padding: 5px;
            /*border: 1px solid #ccc;*/
            border: 1px solid #333;
            border-right: 1px solid #ccc;
            border-bottom: 0;
        }

        /* Fix IE. Hide from IE Mac \*/
        * html ul#primary-nav li { float: left; height: 1%; }
        * html ul#primary-nav li a { height: 1%; }
        /* End */

        ul#primary-nav ul {
            position: absolute;
            display: none;
            left: 149px; /* Set 1px less than menu width */
            top: 0;
        }

        ul#primary-nav li ul li a { padding: 2px 5px; } /* Sub Menu Styles */

        ul#primary-nav li:hover ul ul,
        ul#primary-nav li:hover ul ul ul,
        ul#primary-nav li.over ul ul,
        ul#primary-nav li.over ul ul ul { display: none; } /* Hide sub-menus initially */

        ul#primary-nav li:hover ul,
        ul#primary-nav li li:hover ul,
        ul#primary-nav li li li:hover ul,
        ul#primary-nav li.over ul,
        ul#primary-nav li li.over ul,
        ul#primary-nav li li li.over ul { display: block; } /* The magic */

        ul#primary-nav li.menubar { background: transparent url(images/arrow.gif) right center no-repeat; }

        ul#primary-nav li:hover,
        /*ul#primary-nav li.over { background-color: #f9f9f9; }*/
		ul#primary-nav li.over { background-color: #F7BE81; }
        ul#primary-nav li a:hover { color: #E2144A; }

    </style>

</head>    
<body>
	<menu:useMenuDisplayer name="CSSListMenu" id="primary-nav">
  		<menu:displayMenu name="HomeMenu"/>
  		<menu:displayMenu name="SundayFestivalMenu"/>
  		<menu:displayMenu name="NewsMenu"/>
  		<menu:displayMenu name="TempleProjectMenu"/>
  		<menu:displayMenu name="KrishnaKidsMenu"/>
  		<menu:displayMenu name="ServicesMenu"/>
  		<menu:displayMenu name="LibraryMenu"/>
  		<menu:displayMenu name="JapaConferenceMenu"/>
  		<menu:displayMenu name="NewsLetterMenu"/>
  		<menu:displayMenu name="AboutUsMenu"/>
  		<menu:displayMenu name="DirectionsMenu"/>
  		<menu:displayMenu name="ContactUsMenu"/>
	</menu:useMenuDisplayer>
</body>
</html>	