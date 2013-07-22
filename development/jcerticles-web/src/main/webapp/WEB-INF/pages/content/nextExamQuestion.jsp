<%@ taglib prefix="s" uri="/struts-tags" %>
<head>
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/common/syntaxhighlighter3.0.83/shCore.css"/>
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/common/syntaxhighlighter3.0.83/shThemeDefault.css"/>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/common/syntaxhighlighter3.0.83/shCore.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/common/syntaxhighlighter3.0.83/shBrushJava.js"></script>
</head>
<div id="questionAndAnswerDisplayDiv">
	<div id="questionDiv">
	<s:iterator value="#session.examObject.allQuestionIdMap">
	<s:set var='ques1' value='%{key}'/>
	<s:set var='ques2' value="#session.examObject.currentQuestion.questionId"/>
         <s:if test='%{#ques1.equals(#ques2)}'>
            Q<s:property value="value"/>:&nbsp;
        </s:if>
	</s:iterator>
		<s:property value="#session.examObject.currentQuestion.questionText1"/>
	</div><br>
	<div id="questionCodeDiv">
        <s:if test="%{#session.examObject.currentQuestion.isSourceCode}">
            <pre class="brush: java;">
				<s:iterator value="#session.examObject.currentQuestion.indentedSource">
				    <s:property />
				</s:iterator>
            </pre>
            <script type="text/javascript">
                SyntaxHighlighter.all()
            </script>
        </s:if>
	</div>
	<div id="answerDiv">
		<s:if test="%{#session.examObject.currentQuestion.questionType == 'C'}">
            <s:iterator value="#session.examObject.currentAnswers">
                <s:if test="%{isAnswerSelectedByUser == true}">
                <s:radio cssClass="radio-label" theme="simple" name="yourAnswer" value="answerId" list="#{answerId:answerText}"/></br>
                </s:if>
                <s:else>
                    <s:radio cssClass="radio-label" theme="simple" name="yourAnswer" list="#{answerId:answerText}"/></br>
                </s:else>
            </s:iterator>
		</s:if>
		<s:else>CheckBox manipulation here......</s:else>
	</div><br>
	<s:if test="%{#session.examObject.isEndOfExam}">
	    You have reached the end of the exam. Click Finish exam to evaluate your score!
	</s:if>
</div>