<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="content">

<div class="item">
<h1>Request for Membership</h1>
<p> Well, what would registering for the Java User Group Chennai bring you? If you really do not bother to receive emails 
on upcoming scheduled meet up, receive interesting articles once in a while... then do register!</p>
<p>Please fill out the registration form below. (* marked fields are required)</p>

<s:form action="/user/register" id="registerUserForm">
<TABLE BORDER=0 cellpadding=4 cellspacing=2 BORDERCOLORLIGHT=BLACK BORDERCOLORDARK=BLACK>
	<TR>		
		<TD><s:textfield name="userDetails.firstName" id="firstName" label="First Name" required="true"/></TD>
	</TR>

	<TR>
		<TD><s:textfield name="userDetails.lastName" id="lastName" label="Last Name"  required="true"/></TD>
	</TR>
	
	<TR>
		<TD><s:textfield name="userDetails.email" id="email" label="Email"  required="true"/></TD>
	</TR>
	
	<TR>
		<TD><s:textfield name="emailConfirm" id="emailConfirm" label="Confirm Email"  required="true"/></TD>
	</TR>
	
	<TR>
		<TD><s:textfield name="userDetails.mobile" id="contactNumber" label="Contact Number" /></TD>
	</TR>	

	<TR>
		<TD><s:select label="Please select your occupation" 
		              headerKey="-1" headerValue="--  Please Select  --"
		              list="{'Student', 'Software Developer', 'Software Architect', 'IT Trainer', 'Other'}" 
		              name="userDetails.occupation" id="occupation"/>
		    <div class="hiddenElem">
				<s:textfield name="otherOccupation" id="otherOccupation" style="display:none"/>
			</div>
		</TD>
	</TR>


<TR><TD>
	
	<div class="jCaptcha">
		<!-- The JCaptcha Control -->
		<jcaptcha:image label="If you are human, then enter the text in the text box below!" width="100"/>
	</div>
</TD></TR>
</TABLE>	
	<div class="submitBtn"><s:submit value="Submit Registration"/></div>
</s:form>

</div>

</div>