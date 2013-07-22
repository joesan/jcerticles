<%@ taglib prefix="s" uri="/struts-tags" %>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/common/Orange.css"/>
<link type="text/css" href="<%=request.getContextPath()%>/css/common/jquery/jquery-ui-1.8.14.custom_ui_widget.css" rel="Stylesheet" />	
<script type="text/javascript" src="<%=request.getContextPath()%>/js/common/jquery/core/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/common/jquery/ui/jquery-ui-1.8.14.custom.min_ui_widget.js"></script>

<script>
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

	// Other than the selected tab, every other tab will be hidden
	function showHideTabs(selectedTabId) {
		if (selectedTabId == 1) {
			$( "#tabs" ).tabs( "option", "disabled", [0, 2, 3, 4, 5, 6, 7] );
		}
		else if (selectedTabId == 2) {
			$( "#tabs" ).tabs( "option", "disabled", [0, 1, 3, 4, 5, 6, 7] );
		}
		else if (selectedTabId == 3) {
			$( "#tabs" ).tabs( "option", "disabled", [0, 1, 2, 4, 5, 6, 7] );
		}
		else if (selectedTabId == 4) {
			$( "#tabs" ).tabs( "option", "disabled", [0, 1, 3, 2, 5, 6, 7] );
		}
		else if (selectedTabId == 5) {
			$( "#tabs" ).tabs( "option", "disabled", [0, 1, 3, 4, 2, 6, 7] );
		}
		else if (selectedTabId == 6) {
			$( "#tabs" ).tabs( "option", "disabled", [0, 1, 3, 4, 5, 2, 7] );
		}
		else if (selectedTabId == 7) {
			$( "#tabs" ).tabs( "option", "disabled", [0, 1, 3, 4, 5, 6, 2] );
		}
	}
	
	// Ajax submit functions
	$(document).ready(function() {
		// set the tabs
        $("#tabs").tabs();
	    // Capture the form's submit event
        $('.inlineForm').live('submit', function() {
	    	var $tabs = $('#tabs').tabs();
	    	var selected = $tabs.tabs('option', 'selected');
		showHideTabs(selected);
	    	$('#hiddenTabId').val(selected);
	    	$.ajax({ // create an AJAX call...
	       		traditional: true,
				data: $(this).serialize(), // get the form data
				type: $(this).attr('method'), // GET or POST
				url: $(this).attr('action'), // the file to call
				success: function(response) { // on success..
					$('.ui-tabs-panel:visible').html(response); // update the DIV			
				}
	    	});
       	    return false; // cancel original event to prevent form submitting
	    });
	});
</script>


  <div id="tabs-3">
 <p style="color:black">					
	Please select the topic of your interest from the list below. Each exam consists of not more than 10 questions
	and there is no time limit to finish an exam. Each question has an explanation 
	to the correct answer. <br>
	If you find any discrepancies to any of the questions or its answers,
	please feel free to write me an <a href="mailto:contact@jcerticles.com">email</a>. <br>
       <table width="100%">
  <tr><td width="50%">
    <s:form theme="simple" id="formOne" action="startExam" namespace="/content" cssClass="inlineForm">
	<s:hidden id="technologyId" name="technologyId" value="1" />
	<s:hidden id="subTechnologyId" name="subTechnologyId" value="2" />
	Declarations, initialization, and scoping (Test-1) - 
        <s:submit theme="simple" type="button" cssClass="hyperlinkButton" value="Start Exam"/>						
    </s:form>
    <p style="color:black">
	Tests your knowledge on the following so and so called stupid stuff.. What a waste stuff to be
	tested delivered at client location. What a beauty and what a pity...
    </p>
  </td><td width="50%">
    <s:form theme="simple" id="formTwo" action="startExam" namespace="/content" cssClass="inlineForm">
	<s:hidden id="technologyId" name="technologyId" value="" />
	<s:hidden id="subTechnologyId" name="subTechnologyId" value="" />
	Declarations, initialization, and scoping (Test-2) - 
	<s:submit theme="simple" type="button" cssClass="hyperlinkButton" value="Start Exam"/>						
    </s:form>
    <p style="color:black">
	Tests your knowledge on the following so and so called stupid stuff.. What a waste stuff to be
	tested delivered at client location. What a beauty and what a pity...
    </p>
  </td></tr>
  <tr><td width="50%">
    <s:form theme="simple" id="formThree" action="startExam" namespace="/content" cssClass="inlineForm">
	<s:hidden id="technologyId" name="technologyId" value="" />
	<s:hidden id="subTechnologyId" name="subTechnologyId" value="" />
	Declarations, initialization, and scoping (Test-3) - 
	<s:submit theme="simple" type="button" cssClass="hyperlinkButton" value="Start Exam"/>						
    </s:form>
    <p style="color:black">
	Tests your knowledge on the following so and so called stupid stuff.. What a waste stuff to be
	tested delivered at client location. What a beauty and what a pity...
    </p>
  </td><td width="50%"> 
    <s:form theme="simple" id="formFour" action="startExam" namespace="/content" cssClass="inlineForm">
	<s:hidden id="technologyId" name="technologyId" value="" />
	<s:hidden id="subTechnologyId" name="subTechnologyId" value="" />
	Object-oriented concepts (Test-1) - 
	<s:submit theme="simple" type="button" cssClass="hyperlinkButton" value="Start Exam"/>						
    </s:form>
    <p style="color:black">
	Tests your knowledge on the following so and so called stupid stuff.. What a waste stuff to be
	tested delivered at client location. What a beauty and what a pity...
    </p>
  </td></tr>
  <tr><td width="50%">
    <s:form theme="simple" id="formFive" action="startExam" namespace="/content" cssClass="inlineForm">
	<s:hidden id="technologyId" name="technologyId" value="" />
	<s:hidden id="subTechnologyId" name="subTechnologyId" value="" />
	Object-oriented concepts (Test-2) - 
	<s:submit theme="simple" type="button" cssClass="hyperlinkButton" value="Start Exam"/>						
    </s:form>
    <p style="color:black">
	Tests your knowledge on the following so and so called stupid stuff.. What a waste stuff to be
	tested delivered at client location. What a beauty and what a pity...
    </p>
  </td><td width="50%">
    <s:form theme="simple" id="formSix" action="startExam" namespace="/content" cssClass="inlineForm">
	<s:hidden id="technologyId" name="technologyId" value="" />
	<s:hidden id="subTechnologyId" name="subTechnologyId" value="" />
	Object-oriented concepts (Test-3) - 
	<s:submit theme="simple" type="button" cssClass="hyperlinkButton" value="Start Exam"/>						
    </s:form>
    <p style="color:black">
	Tests your knowledge on the following so and so called stupid stuff.. What a waste stuff to be
	tested delivered at client location. What a beauty and what a pity...
    </p>
 </td></tr>
 <tr><td width="50%">
    <s:form id="formSeven" action="startExam" namespace="/content" cssClass="inlineForm">
	<s:hidden id="technologyId" name="technologyId" value="" />
	<s:hidden id="subTechnologyId" name="subTechnologyId" value="" />
	Collections and Generics (Test-1) - 
	<s:submit theme="simple" type="button" cssClass="hyperlinkButton" value="Start Exam"/>						
    </s:form>
    <p style="color:black">
	Tests your knowledge on the following so and so called stupid stuff.. What a waste stuff to be
	tested delivered at client location. What a beauty and what a pity...
    </p>
 </td><td width="50%">
    <s:form theme="simple" id="formEight" action="startExam" namespace="/content" cssClass="inlineForm">
	<s:hidden id="technologyId" name="technologyId" value="" />
	<s:hidden id="subTechnologyId" name="subTechnologyId" value="" />
	Collections and Generics (Test-2) - 
	<s:submit theme="simple" type="button" cssClass="hyperlinkButton" value="Start Exam"/>						
    </s:form>
    <p style="color:black">
	Tests your knowledge on the following so and so called stupid stuff.. What a waste stuff to be
	tested delivered at client location. What a beauty and what a pity...
    </p>
  </td></tr>
  <tr><td width="50%">
    <s:form theme="simple" id="formNine" action="startExam" namespace="/content" cssClass="inlineForm">
		<s:hidden id="technologyId" name="technologyId" value="" />
		<s:hidden id="subTechnologyId" name="subTechnologyId" value="" />
		Declarations, initialization, and scoping (Test-1) - 
		<s:submit theme="simple" type="button" cssClass="hyperlinkButton" value="Start Exam"/>						
    </s:form>
    <p style="color:black">
	Tests your knowledge on the following so and so called stupid stuff.. What a waste stuff to be
	tested delivered at client location. What a beauty and what a pity...
    </p>
  </td><td width="50%">
    <s:form theme="simple" id="formTen" action="startExam" namespace="/content" cssClass="inlineForm">
		<s:hidden id="technologyId" name="technologyId" value="" />
		<s:hidden id="subTechnologyId" name="subTechnologyId" value="" />
		Declarations, initialization, and scoping (Test-1) - 
        <s:submit theme="simple" type="button" cssClass="hyperlinkButton" value="Start Exam"/>						
    </s:form>
    <p style="color:black">
	Tests your knowledge on the following so and so called stupid stuff.. What a waste stuff to be
	tested delivered at client location. What a beauty and what a pity...
    </p>
  </td></tr>
</table>
 </p>
  </div>
