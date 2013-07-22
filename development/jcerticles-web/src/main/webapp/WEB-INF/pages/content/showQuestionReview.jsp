<%@ taglib prefix="s" uri="/struts-tags" %>
<link type="text/css" href="<%=request.getContextPath()%>/css/common/jquery/jquery-ui-1.8.14.custom_ui_dialog.css" rel="Stylesheet" />	
<script type="text/javascript" src="<%=request.getContextPath()%>/js/common/jquery/core/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/common/jquery/ui/jquery-ui-1.8.14.custom.min_ui_dialog.js"></script>
<script>
	$(function() {
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
</script>


<div id="dialog-message" title="Download complete">
	<p>
		<span class="ui-icon ui-icon-circle-check" style="float:left; margin:0 7px 50px 0;"></span>
		Your files have downloaded successfully into the My Downloads folder.
	</p>
	<p>
		Currently using <b>36% of your storage space</b>.
	</p>
</div>

   <div id="terms" style="display:none;">
       Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
   </div>
   <a id="showTerms" href="#">Show Terms &amp; Conditions</a>      
   <script type="text/javascript">
       $(document).ready(function(){
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