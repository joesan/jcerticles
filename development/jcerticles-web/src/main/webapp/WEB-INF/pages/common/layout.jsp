 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
 <html xmlns="http://www.w3.org/1999/xhtml">
 <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%> 
 <head>
     <meta http-equiv="content-type" content="text/html; charset=iso-8859-1"/>
     <meta name="description" content="description"/>
     <meta name="keywords" content="keywords"/>
     <meta name="author" content="author"/>
     <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/common/Orange.css"/>
     <link rel="icon" href="<%=request.getContextPath()%>/favicon.ico" type="image/x-icon" />
     <title>JCerticles</title>
 </head>
     <body>
     <div id="wrap">
         <tiles:insertAttribute name="header" />
         <tiles:insertAttribute name="menu" />
         <div id="content-wrap">             
             <tiles:insertAttribute name="body" />
         </div>
         <div id="footer">
             <tiles:insertAttribute name="footer" />
         </div>
     </div>
     </body>
</html>
