 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
  <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
 <%@ taglib uri="/struts-tags" prefix="s" %>
 <%@ taglib uri="http://code.google.com/p/jcaptcha4struts2/taglib/2.0" prefix="jcaptcha" %>
 <html xmlns="http://www.w3.org/1999/xhtml">
 <head>
     <meta http-equiv="content-type" content="text/html; charset=iso-8859-1"/>
     <meta name="description" content="description"/>
     <meta name="keywords" content="keywords"/>
     <meta name="author" content="author"/>
     <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/common/default.css"/>
     <script type="text/javascript" src="<%=request.getContextPath()%>/js/common/jquery.js"></script>
     <script type="text/javascript" src="<%=request.getContextPath()%>/js/common/jquery.validate.js"></script>     
     <script type="text/javascript" src="<%=request.getContextPath()%>/js/user/registerNewUser.js"></script>
     <title>JCerticles - Articles and Mock Exams</title>
 </head>
     <body>
     <div class="main">
         <%@include file="/WEB-INF/pages/common/header.jsp" %>
         <div class="mainContent">
         	 <%@include file="/WEB-INF/pages/common/menu.jsp" %>
         	 <%@include file="/WEB-INF/pages/user/registrationForm.jsp" %>
         </div>
         <div class="footer">
             <%@include file="/WEB-INF/pages/common/footer.jsp" %>
         </div>
     </div>
     </body>
</html>



