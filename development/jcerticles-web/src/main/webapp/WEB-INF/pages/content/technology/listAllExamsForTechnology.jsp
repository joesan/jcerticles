<%@ taglib prefix="s" uri="/struts-tags" %>
<div id="allExamsForTechnologyDiv">
	<table width="100%">
		<s:iterator value="allExamsForTechnology" status="examCount" var="exam">
	    <s:if test="#examCount.odd == true">
			<tr>
				<td><s:property value="#exam.examDescription"/></td>
				<td>
					<s:form theme="simple" action="startExam" namespace="/content" cssClass="inlineForm">
			    		<s:hidden id="examId" name="examId" value="%{examId}" />
			    		<s:submit theme="simple" type="button" cssClass="hyperlinkButton" value="Start Exam"/>
					</s:form>
				</td>
    	</s:if>
    	<s:else>
				<td><s:property value="#exam.examDescription"/></td>
				<td>
					<s:form theme="simple" action="startExam" namespace="/content" cssClass="inlineForm">
			    		<s:hidden id="examId" name="examId" value="%{examId}" />
			    		<s:submit theme="simple" type="button" cssClass="hyperlinkButton" value="Start Exam"/>
					</s:form>
				</td>
			</tr>
    	</s:else>
		</s:iterator>
	</table>
</div>