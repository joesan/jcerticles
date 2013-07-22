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

		// Other than the selected tab, every other tab will be hidden
		function showHideTabs(selectedTabId) {
			if (selectedTabId == 1) {
				$( "#tabs" ).tabs( "option", "disabled", [2, 3, 4, 5, 6, 7] );
			}
			else if (selectedTabId == 2) {
				$( "#tabs" ).tabs( "option", "disabled", [1, 3, 4, 5, 6, 7] );
			}
			else if (selectedTabId == 3) {
				$( "#tabs" ).tabs( "option", "disabled", [1, 2, 4, 5, 6, 7] );
			}
			else if (selectedTabId == 4) {
				$( "#tabs" ).tabs( "option", "disabled", [1, 3, 2, 5, 6, 7] );
			}
			else if (selectedTabId == 5) {
				$( "#tabs" ).tabs( "option", "disabled", [1, 3, 4, 2, 6, 7] );
			}
			else if (selectedTabId == 6) {
				$( "#tabs" ).tabs( "option", "disabled", [1, 3, 4, 5, 2, 7] );
			}
			else if (selectedTabId == 7) {
				$( "#tabs" ).tabs( "option", "disabled", [1, 3, 4, 5, 6, 2] );
			}
		}
		
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