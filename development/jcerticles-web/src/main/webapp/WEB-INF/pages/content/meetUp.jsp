<%@ taglib prefix="s" uri="/struts-tags" %>
<link type="text/css" href="<%=request.getContextPath()%>/css/common/jquery-ui-1.8.14.custom.css" rel="Stylesheet" />	
<script type="text/javascript" src="<%=request.getContextPath()%>/js/common/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/common/jquery-ui-1.8.14.custom.min.js"></script>

<div class="content">		
    	<div class="item">
		<h1>Mock Exams and Stuff</h1>
		<p>Please click on the tabs below to learn more!</p>
	</div>
	<div class="item">
		<script>
		    $(document).ready(function() {
			  $( "#tabs" ).tabs({
				event: "mouseover"
		    });

		   $('a.tab-loader').click(function(){alert(this); 
		         $(this).parent(".ui-tabs-panel p").load(this.href);  
		         return false;  
		   });
		  });
		</script>
		<div id="mockExamTabs">
			<div id="tabs" style="height:420px;" >
				<ul>
				  <li><a href="#tabs-1">Read Me</a></li>
				  <li><a href="#tabs-2">Core Java</a></li>
				  <li><a href="ajax/content2.html">JSP and Servlets</a></li>
				  <li><a href="ajax/content2.html">JSF</a></li>
				  <li><a href="ajax/content3-slow.php">EJB</a></li>
				  <li><a href="ajax/content4-broken.php">JPA</a></li>
				  <li><a href="ajax/content4-broken.php">Spring</a></li>
				  <li><a href="ajax/content4-broken.php">Other Frameworks</a></li>
				</ul>
			    <div id="tabs-1">
				  <p style="color:black">XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXxxx
					This page has a lot to offer. But it is in the very beggining of its inception... Just browse through the tabs and you will find
					ample resources to articles and certifications.
					This page has a lot to offer. But it is in the very beggining of its inception... Just browse through the tabs and you will find
					ample resources to articles and certifications.
					This page has a lot to offer. But it is in the very beggining of its inception... Just browse through the tabs and you will find
					ample resources to articles and certifications.
					This page has a lot to offer. But it is in the very beggining of its inception... Just browse through the tabs and you will find
					ample resources to articles and certifications.
					This page has a lot to offer. But it is in the very beggining of its inception... Just browse through the tabs and you will find
					ample resources to articles and certifications.
					This page has a lot to offer. But it is in the very beggining of its inception... Just browse through the tabs and you will find
					ample resources to articles and certifications.
					This page has a lot to offer. But it is in the very beggining of its inception... Just browse through the tabs and you will find
					ample resources to articles and certifications.
					This page has a lot to offer. But it is in the very beggining of its inception... Just browse through the tabs and you will find
					ample resources to articles and certifications.
					This page has a lot to offer. But it is in the very beggining of its inception... Just browse through the tabs and you will find
					ample resources to articles and certifications.
					This page has a lot to offer. But it is in the very beggining of its inception... Just browse through the tabs and you will find
					ample resources to articles and certifications.
					This page has a lot to offer. But it is in the very beggining of its inception... Just browse through the tabs and you will find
					ample resources to articles and certifications.
					This page has a lot to offer. But it is in the very beggining of its inception... Just browse through the tabs and you will find
					ample resources to articles and certifications.
					This page has a lot to offer. But it is in the very beggining of its inception... Just browse through the tabs and you will find
					ample resources to articles and certifications...
					Why on earth would you do something like this?
					This is not really interesting... Go and watch some movies that are newly released...					
				  </p>
			    </div>
			    <div id="tabs-2">
				  <p style="color:black">
					This page has a lot to offer. But it is in the very beggining of its inception... Just browse through the tabs and you will find
					ample resources to articles and certifications.</br></br>
					
					The following sample exams are available. (This will be iterated and shown here)</br></br>

					<a class="tab-loader" href="<s:url action='startExam' namespace="/content"/>">Java Test 1</a> : Focus on Collections and Generics</br></br>
					<a href="<s:url action='startExam' namespace="/content"/>">Java Test 2</a> : Focus on Constructor and Object creation</br></br>
					<a href="<%=request.getContextPath()%>/pages/content/test3.html">Java Test 3</a> : Focus on Constructor and Object creation</br></br>
					<a href="<%=request.getContextPath()%>/pages/content/test4.html">Java Test 4</a> : Focus on Constructor and Object creation</br></br>
					<a href="<%=request.getContextPath()%>/pages/content/test5.html">Java Test 5</a> : Focus on Loops	
				  </p>
			    </div>
		    </div>
	    </div>
    </div>
</div>