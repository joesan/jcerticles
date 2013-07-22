<%@ taglib prefix="s" uri="/struts-tags" %>

<div id="main">
    <h1>Review Exam</h1>
    	<s:if test="%{session.examObject.unansweredQuestionIdMap.size != 0}">
    		Seems like you still have a couple questions unanswered. Refer the table below to find out which ones are they.
    	</s:if>
        <div id="reviewExamDiv"><table border="1"><tr><td>QuestionId</td><td>Answered / UnAnswered</td>
            <s:iterator value="#session.examObject.allQuestionIds" status="stat">
                <s:if test="%{isAnswerSelectedByUser == true}">
                	<s:if test="#stat.even == true">
                    	<tr style="background: #CCCCCC">
                        	<td><s:property value="#stat.count"/></td>
                        	<td>Answered</td>
                    	</tr>
                    </s:if>
                	<s:else>
                    	<tr>
                        	<td><s:property value="#stat.count"/></td>
                        	<td>Answered</td>
                    	</tr>
                    </s:else>
                </s:if>
                <s:else>
                	<s:if test="#stat.even == true">
                    	<tr style="background: #CCCCCC">
                        	<td><s:property value="#stat.count"/></td>
                        	<td>UnAnswered</td>
                    	</tr>
                    </s:if>
                	<s:else>
                    	<tr>
                        	<td><s:property value="#stat.count"/></td>
                        	<td>UnAnswered</td>
                    	</tr>
                    </s:else>
                </s:else>
            </s:iterator>
            <br>
            <tr><s:submit type="button" cssClass="hyperlinkButton" value="Go Back and Answer UnAnswered Questions" onclick="history.go(-1);"/></tr>
            </table>
        </div>
		<div id="goBackDiv">
			You can any time skip or cancel the exam by clicking here...<a href="<%=request.getContextPath()%>/content/exams.action" id="goBack"> Cancel exam and take me back home </a>
		</div>
</div>