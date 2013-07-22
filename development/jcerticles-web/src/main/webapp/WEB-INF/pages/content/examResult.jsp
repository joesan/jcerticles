<%@ taglib prefix="s" uri="/struts-tags" %>
<div id="examResultsDiv">

<table border="1px">
	<tr>
		<td>questionId</td>
		<td>Answered</td>
		<td>Correct</td>
		<td>Review</td>
	</tr>
	<s:iterator value="#session.examResult.questionBank" status="stat" var="question">Goes in the iterator...
		<tr>
			<td>
				questionId : <s:property value="#question" />
			</td>
			<td>
				Answered : <s:property value="value" />
			</td>
	</s:iterator>
	<s:iterator value="#session.examObject.allQuestionIds">
			<td>
			
			</td>
			<td>
			
			</td>
		</tr>
	</s:iterator>

</table>


	<table border="1px" width="100%">
		<tr><td width="30%">



		</td><td width="30%" align="right">
			Go To Question:&nbsp;<s:select theme="simple" list = "#session.examObject.allQuestionIds" name = "name" label = "Name" headerKey="" headerValue = ""/>
		</td><td width="25%" align="right">
			Review... hyperlink
		</td><td width="20%" align="right">
			Finsih Exam
		</td></tr>
	</table>


</div>