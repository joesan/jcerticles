<%@ taglib prefix="s" uri="/struts-tags" %>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/common/jquery-1.5.1.min.js"></script>
<link type="text/css" href="<%=request.getContextPath()%>/css/common/jquery/jquery-ui-1.8.14.custom_ui_dialog.css" rel="Stylesheet" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/common/jquery/ui/jquery-ui-1.8.14.custom.min_ui_dialog.js"></script>

<div id="terms" title="Review Question"  style="display:none;">
    Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
</div>      
<script type="text/javascript">
    $(document).ready(function() {
        $('#showTerms').click(function() {
    		// a workaround for a flaw in the demo system (http://dev.jqueryui.com/ticket/4375), ignore!
    		$( "#dialog:ui-dialog" ).dialog( "destroy" );
    	
    		$( "#terms" ).dialog({
    			modal: true,
    			buttons: {
    				Ok: function() {
    					$( this ).dialog( "close" );
    				}
    			}
    		});  
        });
    });
</script>

<div id="examResultsDiv">

<table border="1px">
	<tr>
		<td>questionId</td>
		<td>Answered</td>
		<td>Correct</td>
		<td>Review</td>
	</tr>
	<s:iterator value="#session.examObject.questionBank" status="stat" var="question">Goes in the iterator...
		<tr>
			<td>
				questionId : <s:property value="#question.key.questionText" />
			</td>
			<td>
				<s:if test = "%{#question.key.isAnswered == true}" >Y</s:if>
				<s:else>N</s:else>				
			</td><td>
				<s:if test = "%{#question.key.isAnswerCorrect == true}" >Y</s:if>
				<s:else>N</s:else>	
			</td><td>
				<a id="showTerms" href="#">Show Terms &amp; Conditions</a> 
			</td>
		</tr>
	</s:iterator>

</table>

</div>