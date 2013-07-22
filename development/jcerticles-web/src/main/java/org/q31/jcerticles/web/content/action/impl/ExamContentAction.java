/*
 * Project: jcerticles
 * Copyright(c) 2011 jcerticles
 * All rights reserved.
 *
 * $Revision $, last modified $Date $ by $Author $
 */
package org.q31.jcerticles.web.content.action.impl;

import java.util.*;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.interceptor.SessionAware;
import org.q31.jcerticles.core.business.content.util.ExamResult;
import org.q31.jcerticles.domain.content.Answer;
import org.q31.jcerticles.domain.content.Exam;
import org.q31.jcerticles.domain.content.Question;
import org.q31.jcerticles.core.business.content.util.ExamObject;
import org.q31.jcerticles.facade.content.IContentFacade;
import org.q31.jcerticles.web.content.action.IExamContentAction;
import org.q31.jcerticles.web.content.model.ExamContentModel;
import org.q31.util.CodeFormatter;

/**
 * TODO... Write javadoc...
 * @author jothi
 * @since 1.6
 */
public class ExamContentAction extends ContentAction implements IExamContentAction, SessionAware {
    
	/* The unique serial version identifier */
	private static final long serialVersionUID = 1L;
	
	/* The session object */
	private Map < String, Object > sessionMap;
	
	/* The model to be instantiated for all ExamContent related actions */
	private ExamContentModel examContentModel;
	
    /* The UserFacade reference */
    @Resource(name = "contentFacade")
    public IContentFacade contentFacade;

    public void setContentFacade(IContentFacade contentFacade) {
        this.contentFacade = contentFacade;
    }

    @Override
	public Object getModel() {
		return examContentModel;
	}

	@Override
	public void prepare() throws Exception {
        if (examContentModel == null) {
        	examContentModel = new ExamContentModel();
        }		
	}
	
	@Override
	public String execute() {
		return SUCCESS;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String getExamQuestion() {
		return SUCCESS;		
	}
	
	/**
	 * {@inheritDoc}
	 */	
	public String getAllExamsForTechnology() {

		List < Exam > allExamsForTechnology = contentFacade.getAllExamsForTechnology(examContentModel.getTechnologyId());
		
		for (Exam exam : allExamsForTechnology) {
		}
		
		examContentModel.setAllExamsForTechnology(allExamsForTechnology);
		
		return SUCCESS;		
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String getAllQuestionsForExam() {

		final String examId = examContentModel.getExamId();
        System.out.println("The ExamId is " + examId);
		
		//List < Question > questionsList = contentFacade.getAllQuestionsForExam(technologyId, subTechnologyId);
		//System.out.println("The questions list is " + questionsList);
		/* Set the obtained questionList in session */
		// TODO... Prepare the ExamObject and stuff it in the session
		this.getSession().put("examObject", contentFacade.startExam(Long.valueOf(examId)));
		System.out.println("In getAllQuestionsForExam......Printing the session that was just created...");
		ExamObject exam = (ExamObject) this.getSession().get("examObject");
		System.out.println("Printing the question text..." + exam.getCurrentQuestion().getQuestionText1());
		return SUCCESS;		
	}

    /**
     * Prepare the ExamObject for layout in the UI
     * (1) Set the currentQuestion, currentAnswers
     * (2) If the currentQuestion contains SourceCode for display, format it
     * (3) Prepare the questionId's for GUI navigation
     * (4) Prepare the unansweredQuestionId Map
     * @param examObj
     * @return
     */
    private ExamObject prepareExamObjectForUI(ExamObject examObj) {
        List < Question > allQuestions = examObj.getQuestionBank();

        /* Prepare the allQuestionIds for GUI navigation */
        SortedMap < String, Long > allQuestionIds = new TreeMap < String, Long > ();

        /* Set all the questions as unanswered */
        SortedMap < String, Long > unansweredQuestionMap = new TreeMap < String, Long > ();

        long count = 0L;
        for (Question question : allQuestions) {
            count = count + 1;
            allQuestionIds.put(question.getQuestionId(), count);
            unansweredQuestionMap.put(question.getQuestionId(), count);

            // Set the currentQuestionIdForNavigation to 1 as this is the first Question
            if (count == 1) {
                examObj.setCurrentQuestionIdForNavigation(count);
            }

            // If Question contains sourceCode, format it
            if (question.getIsSourceCode()) {
                CodeFormatter formatter = new CodeFormatter(question.getQuestionSourceCode());
                question.setIndentedSource(formatter.getFormattedCodeList());
            }
        }

        examObj.setUnAnsweredQuestionIdMap(unansweredQuestionMap);
        examObj.setAllQuestionIdMap(allQuestionIds);

        /* Set the first Question and its Answer as the currentQuestion and currentAnswer */
        examObj.setCurrentQuestion(allQuestions.get(0));
        examObj.setCurrentAnswers(allQuestions.get(0).getAnswers());

        return examObj;
    }
	
	/**
	 * {@inheritDoc}
	 */
	public String startExam() {
		
		final String examId = examContentModel.getExamId();

        if (StringUtils.isBlank(examId)) {
            return INPUT;
        }
		
		/* Get an ExamObject */
		ExamObject examObj = contentFacade.startExam(Long.valueOf(examId));

        /* Prepare the ExamObject for layout in the UI */
        examObj = this.prepareExamObjectForUI(examObj);

		/* Set the obtained examObject in session */
		// TODO... How to check if this is a new session. Here we always need a new session object.
		this.getSession().put("examObject", examObj);

		return SUCCESS;		
	}

	/**
	 * {@inheritDoc}
	 */
	public String getNextQuestion() {
		// Check the session if there is a examObject in session scope...
		if (this.getSession().get("examObject") != null) {
			ExamObject exam = (ExamObject) this.getSession().get("examObject");
            exam = prepareNextQuestion(exam, null);
            if (exam.getIsEndOfExam()) {
                // call evaluate exam automatically or??? What to do?

            }
			this.getSession().put("examObject", exam);
		}
		else {
			System.out.println("In the else block ******************** Starting a new session...");			
			this.getSession().put("examObject", null);
		}
		
		return SUCCESS;
	}

    /**
     * {@inheritDoc}
     */
    public String getQuestionForQuestionId() {
        // TODO... Prepare the ExamObject and stuff it in the session
        // Check the session if there is a examObject in session scope...
        if (this.getSession().get("examObject") != null) {
            ExamObject exam = (ExamObject) this.getSession().get("examObject");
            exam = prepareNextQuestion(exam, (String) httpServletRequest.getParameter("questionId"));
            this.getSession().put("examObject", exam);
        }
        else {
            System.out.println("In the else block getQuestionForQuestionId ******************** Starting a new session...");
            this.getSession().put("examObject", null);
        }

        return SUCCESS;
    }

    /**
     * {@inheritDoc}
     */
    public String evaluateExam() {
        /* Get the values for the technologyId, sub-technologyId, */
        long subTechnologyId = examContentModel.getSubTechnologyId();

        //List < Question > questionsList = contentFacade.getAllQuestionsForExam(technologyId, subTechnologyId);
        //System.out.println("The questions list is " + questionsList);
        /* Set the obtained questionList in session */
        // TODO... Prepare the ExamObject and stuff it in the session
        // Check the session if there is a examObject in session scope...
        if (this.getSession().get("examObject") != null) {
            ExamObject exam = (ExamObject) this.getSession().get("examObject");
            // Call the service and evaluate the exam and get the ExamResults
        }

        return SUCCESS;
    }

    /**
     * The following actions are performed:
     * (1) Get the currentQuestion that was answered by the user, get its current answers
     * (2) Write the currentQuestion and the answer answered by the user to << TODO >>
     * (3) Fetch the nextQuestion and its answers and set them in the ExamObject accordingly
     * @param examObject
     * @return
     */
    private ExamObject prepareNextQuestion(final ExamObject examObject, final String nextQuestionId) {
        List < Question > questionBank = examObject.getQuestionBank();
        SortedMap < String, Long > unAnsweredQuestionIdMap = examObject.getUnAnsweredQuestionIdMap();
        SortedMap < String, Long > allQuestionIdMap = examObject.getAllQuestionIdMap();

        /* If the unAnsweredQuestionIdMap is empty, signal the end of exam (TODO... Do this only when the currentQuestionIdForNavigation == last Question */
        if (unAnsweredQuestionIdMap.size() == 0) {
            examObject.setEndOfExam(true);
        }

        // Get the currentQuestion and currentAnswer from the examObject
        Question currQuestion = examObject.getCurrentQuestion();
        List < Answer > currAnswers = examObject.getCurrentAnswers();

        // Check what type of Question it is (Radio button or CheckBox)
        if (currQuestion.getQuestionType() == 'C') { // R stands for Radio buttons and C stands for Check box
            String yourAnswer = httpServletRequest.getParameter("yourAnswer");

            // TODO... How do we track unansweredQuestions?? to be shown in the UI as a popup
            // Following rules apply for modifying the unansweredQuestionIdMap
            // If check box, user can change the values and send them unanswered even for an answered checkbox
            // but for radio buttons, no need to worry.
            // Do the following for radio buttons:
            // (1) if yourAnswer is not null, then it means that the user has selected an option, this means that the user has answered the question
            // (2) Iterate and set the answer as answered by the user and update the List
            // (3) Update the unAnsweredQuestionIdMap (optionally set the flag against the currQuestion)
            if (StringUtils.isNotBlank(yourAnswer)) {
                // Iterate the currAnswers List and set the "yourAnswer" answered by the user in it
                int i = 0;
                // First reset the Answer#isAnswerSelectedByUser
                for (Answer answer : currAnswers) {
                    if (answer.getIsAnswerSelectedByUser()) {
                        Answer newAns = answer;
                        currAnswers.remove(i);
                        newAns.setIsAnswerSelectedByUser(false);
                        currAnswers.add(i, newAns);
                        break;
                    }
                    i++;
                }
                i = 0; //reset the counter
                for (Answer answer : currAnswers) {
                    if (StringUtils.equals(String.valueOf(answer.getAnswerId()), yourAnswer)) {
                        System.out.println("Yur Answer is " + yourAnswer);
                        // Remove the Answer from its index position
                        Answer newAns = answer;
                        currAnswers.remove(i);
                        newAns.setIsAnswerSelectedByUser(true);
                        currAnswers.add(i, newAns);
                        break;
                    }
                    // Reset the already set Answer

                    i++;
                }
                // Update the unansweredQuestionIdMap by removing the currentQuestionId key from it
                unAnsweredQuestionIdMap.remove(currQuestion.getQuestionId());
                // Additionally set the flag in currQuestion as Answered
                currQuestion.setAnswered(true);
                System.out.println("Current Answers is " + currAnswers);
                currQuestion.setAnswers(currAnswers);

                // Iterate the questionBank in the ExamObject and get the currentQuestion from it
                int k = 0;
                for (Question ques : questionBank) {
                    if (StringUtils.equals(currQuestion.getQuestionId(), ques.getQuestionId())) {
                        // Update the questionBank with the currentQuestion
                        questionBank.remove(k);
                        questionBank.add(k, currQuestion);
                        examObject.setQuestionBank(questionBank);
                        break;
                    }
                    k++;
                }
            }
        }

        if (StringUtils.isNotBlank(nextQuestionId)) {
            // Iterate and get the Question for the nextQuestionId
            for (Question ques : examObject.getQuestionBank()) {
                if (ques.getQuestionId().equals(nextQuestionId)) {
                    examObject.setCurrentQuestion(ques);
                    examObject.setCurrentAnswers(ques.getAnswers());
                    break;
                }
            }
            // Update the currentQuestionId in the examObject#currQuestionIdForNavigation field
            examObject.setCurrentQuestionIdForNavigation(allQuestionIdMap.get(examObject.getCurrentQuestion().getQuestionId()));
            if (examObject.getCurrentQuestionIdForNavigation() == questionBank.size()) {
                examObject.setEndOfExam(true);
            }
            else {
                examObject.setEndOfExam(false);
            }
        }
        else {
            // Get the currentQuestionIdForNavigation
            long currentQuestionIdForNavigation = examObject.getCurrentQuestionIdForNavigation();

            // Check if this is the last question for the exam
            if (currentQuestionIdForNavigation == questionBank.size()) {
                examObject.setEndOfExam(true);
            }
            else {
                examObject.setEndOfExam(false);
                // Get the nextQuestion
                String nextQuestion = null;
                for (Map.Entry < String, Long > entry : allQuestionIdMap.entrySet()) {
                    Long quesMappedId = entry.getValue();
                    if (quesMappedId.longValue() == currentQuestionIdForNavigation + 1) {
                       nextQuestion = entry.getKey();
                        break;
                    }
                }
                // Iterate the questionBank and fetch the Question for the questionId
                for (Question ques : questionBank) {
                    if (StringUtils.equals(nextQuestion, ques.getQuestionId())) {
                        examObject.setCurrentQuestion(ques);
                        examObject.setCurrentAnswers(ques.getAnswers());
                        examObject.setCurrentQuestionIdForNavigation(currentQuestionIdForNavigation + 1);
                    }
                }
            }
        }

        return examObject;
    }
	
	/**
	 * Called when the user finishes the exam
	 * @return
	 */
	public String finishAndEvaluateExam() {
		
		// TODO... Destroy the session object, and of course the examObject attribute in session
		ExamObject examObject = (ExamObject) this.getSession().get("examObject");
        List < Question > questionBank = examObject.getQuestionBank();
        int passScore = examObject.getPassScore();
		/* Call the service to evaluate the exam */
        boolean isUserPassedTheExam = this.isUserPass(passScore, questionBank);

        ExamResult examResult = new ExamResult();
        examResult.setPassScore(passScore);
        examResult.setQuestionBank(questionBank);
        examResult.setPass(isUserPassedTheExam);

        // Remove the ExamObject from session
        this.getSession().remove("examObject");
        this.getSession().put("examResult", examResult);
		
		return SUCCESS;		
	}

    private boolean isUserPass(int passScore, List < Question > questionBank) {

        int correctAnswerCount = 0;
        for (Question ques : questionBank) {
            List < Answer > answerList = ques.getAnswers();
            for (Answer answer : answerList) {
                if (answer.getCorrectAnswer() == answer.getIsAnswerSelectedByUser()) {
                    correctAnswerCount = correctAnswerCount + 1;
                }
            }
        }

        return correctAnswerCount >= passScore;
    }

    /**
     * Called when the user finishes the exam
     * @return
     */
    public String reviewExam() {

        ExamObject examObject = (ExamObject) this.getSession().get("examObject");
        /* Call the service to evaluate the exam */

        return SUCCESS;
    }

	public void setSession(Map < String, Object > sessionMap) {
		this.sessionMap = sessionMap;		
	}
	
	/**
	 * Get the current session
	 * @return
	 */
	private Map < String, Object > getSession() {
		return this.sessionMap;
	}
}