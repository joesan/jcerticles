<%@ taglib prefix="s" uri="/struts-tags" %>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/common/jquery/core/jquery-1.5.1.min.js"></script>
<script>
		// Mouseover effect for buttons acting link links
		$(".hyperlinkButton").mouseover(function() {
			$(this).css('cursor','pointer');
			$(this).removeClass().addClass("hyperlinkButtonMouseOver");
			}).mouseout(function() {
			$(this).css('cursor','pointer');
			$(this).removeClass().addClass("hyperlinkButton");
		});
</script>
<div id="main">
    <h1>Mock Exams and Stuff</h1>
        <div id="nextButtonDiv">
            <table BGCOLOR="#E4E4E4" width="99%">
                <tr><td>
                    <s:form action="goToQuestion" namespace="/content" id="goToQuestionForm" cssClass="inlineForm">
                    	Go To Question:&nbsp;<s:select id="goToQuestion" theme="simple" list="#session.examObject.allQuestionIdMap" name = "questionId" label = "Name" headerKey="-1" headerValue=".." onchange="this.form.submit()"/>
                    </s:form>
                </td><td>
                    <s:form action="reviewExam" namespace="/content" id="reviewExamForm" cssClass="inlineForm">
                        <s:submit type="button" cssClass="hyperlinkButton" value="Exam Quick Review"/>
                    </s:form>
                </td><td align="right">
                    <s:form action="evaluateExam" namespace="/content" id="evaluateExamForm" cssClass="inlineForm">
                        <s:submit type="button" cssClass="hyperlinkButton" value="Finish Exam"/>
                    </s:form>
                </td></tr>
            </table><br>
            <table width="99%">
                <tr><td>
                    <s:form action="nextQuestion" namespace="/content" id="nextQuestionForm" cssClass="inlineForm">
                        <div id="questionAndAnswerDisplayDiv">
                            <s:include value="nextExamQuestion.jsp" />
                        </div><br>
                        <s:submit type="button" cssClass="hyperlinkButton" value="Next Question"/>
                    </s:form>
                </td></tr>
            </table>
        </div>
		<div id="goBackDiv">
			You can any time skip or cancel the exam by clicking here...<a href="<%=request.getContextPath()%>/content/exams.action" id="goBack"> Cancel exam and take me back home </a>
		</div>
</div>