<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="content">
		<div class="item">
			<h1>JUG Chennai Moderators</h1>
			<div class="moderatorListDiv">
				<table BORDER=0 align="center">
					<tr>
						<td>						
							<p> This group is at present moderated by the following folks:</p>
							
							<a href="javascript:void(0);" id="jothi">Jothi Shankar Kumar. S</a><br><br>
							<a href="javascript:void(0);" id="xxxxx">Mr. XXXXX</a>							
						</td>
					
						<td>
							<div class="loginDiv"><a href="javascript:void(0);" id="logIn">Moderator Log In</a> 
							</div>
						</td>
					</tr>
					
				</table>
				<div id="loginDivPopUp" style="display:none;">
					<table BORDER=0>
						<tr><td>Enter your username: </td><td><s:textfield name="userName" id="userName" maxlength="40" theme="simple"/></td></tr>
						<tr><td>Enter your password: </td><td><s:textfield name="password" id="password" maxlength="40" theme="simple"/></td></tr>
						<tr><td><td></td><td><s:submit id="submitLogin" value="Log In" /></td></tr>
					</table>
				</div>
			</div>
		</div>
		<div id="moderatorJothi" style="display:none;">
	    	<div class="item">
				<h1>Jothi Shankar Kumar</h1>
				<p> Profile:</p> Interested in Java / J2EE development projects<br>			
			</div>
		</div>
		
		<div id="moderatorXXXXX" style="display:none;">
	    	<div class="item">
				<h1>XXXXX</h1>
				<p> Profile:</p> Interested in SAP related projects<br>		
			</div>
		</div>

</div>





