<%@ taglib prefix="s" uri="/struts-tags" %>
<link type="text/css" href="<%=request.getContextPath()%>/css/common/jquery/jquery-ui-1.8.14.custom_ui_widget.css" rel="Stylesheet" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/common/jquery/core/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/common/jquery/ui/jquery-ui-1.8.14.custom.min_ui_widget.js"></script>

<script type="text/javascript">
		$(document).ready(function() {
		    $(function() {
				$( "#tabs" ).tabs();
		    });
		    // Mouseover effect for buttons acting link links
		    $(".hyperlinkButton").mouseover(function() {
				$(this).css('cursor','pointer');
		    	$(this).removeClass().addClass("hyperlinkButtonMouseOver");
		    	}).mouseout(function() {
					$(this).css('cursor','pointer');
		    		$(this).removeClass().addClass("hyperlinkButton");
		    	});
			});

		$(document).ready(function() {
			$( "#tabs" ).tabs({
				ajaxOptions: {
					error: function( xhr, status, index, anchor ) {
						$( anchor.hash ).html(
							"Couldn't load this tab. We'll try to fix this as soon as possible. " +
							"If this wouldn't be a demo." );
					}
				}
			});
		});

</script>

<div id="main">
	<h1>Mock Exams and Stuff</h1>
	<p>Please click on the tabs below to learn more!</p>
	<div id="mockExamTabs" style="margin: 5px 10px;">
			<div id="tabs">
				<ul>
				  <li><a href="#tabs-1">Read Me First</a></li>
				  <li>
					   <s:url id="loadExamURL" action="allExamsForTechnology" namespace="/content">
						<s:param name="technologyId" value="10" />
					   </s:url>
					   <s:a href="%{loadExamURL}">Core Java</s:a>
				  </li>
                  <li><a href="#tabs-3">JSP & Servlets</a></li>
                  <li><a href="#tabs-4">JSF</a></li>
				  <li><a href="#tabs-5">EJB</a></li>
				  <li><a href="#tabs-6">JPA</a></li>
				  <li><a href="#tabs-7">Spring</a></li>
				  <li><a href="#tabs-8">Struts</a></li>
				  <li><a href="#tabs-9">Other Frameworks</a></li>
				</ul>
			    <div id="tabs-1">
				  <p style="color:black">

				    Click on any of the tabs above to view the available exams for the respective topic.<br>
				    <br>
				  	<b>Please read the instructions below before you proceed to attempt any of the exams.</b><br>

      			  	Each exam mentions the number of questions that it has.<br>
				  	There is no time limit to finish an exam. The reason is I still have to develop that
				  	piece of functionality.<br>
				  	You can review the questions at any point of time during the exam by clicking the review button.<br>
				  	You also have the possibility to jump to a question by its question number.<br>
				  	I still have to develop the logic for displaying drag and drop type questions. So no drag and drop questions at the moment.
				  	Use the finish exam button to grade the results of the exam once you are through attempting
				  	all the questions.<br>
				  </p>
				  <p style="color:red">I wish you then "Hasta Siempre"</p>
			    </div>
			</div>
	    </div>
</div>