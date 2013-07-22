package org.q31.jcerticles.core.persistence.mongodb.dao.content.impl;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.google.code.morphia.dao.BasicDAO;
import com.google.code.morphia.emul.org.bson.types.ObjectId;
import com.google.code.morphia.query.Query;
import com.mongodb.Mongo;
import org.q31.jcerticles.domain.content.*;
import org.q31.jcerticles.core.persistence.base.dao.content.IContentDAO;

import java.util.ArrayList;
import java.util.List;

public class ContentDAOImpl<T extends Content> extends BasicDAO < T, ObjectId > implements IContentDAO {

    public ContentDAOImpl(Class<T> entityClass, Mongo mongo, Morphia morphia, String dbName) {
        super(entityClass, mongo, morphia, dbName);
    }

    public ContentDAOImpl(Class<T> entityClass, Datastore ds) {
        super(entityClass, ds);
    }

    /**
     * @param technologyId
     * @param subTechnologyId
     * @return
     */
    public Content getRandomQuestion(long technologyId, long subTechnologyId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * @param technologyId
     * @return
     */
    public List < SubTechnology > getAllSubTechnologiesForTechnology(long technologyId) {
        final List < SubTechnology > subTechList = new ArrayList < SubTechnology > ();
        final Query < SubTechnology > contentList = (Query < SubTechnology >) super.createQuery().filter("technologyId = ", technologyId);
        for (SubTechnology subTech : contentList.fetch()) {
            subTechList.add(subTech);
        }
        return subTechList;
    }

    /**
     *
     * @param subTechnologyId
     * @return
     */
    public List < Exam > getAllExamsForSubTechnology(long subTechnologyId) {
        final List < Exam > examList = new ArrayList < Exam > ();
        final Query < Exam > contentList = (Query < Exam >) super.createQuery().filter("subTechnologyId = ", subTechnologyId);
        for (Exam exam : contentList.fetch()) {
            examList.add(exam);
        }
        return examList;
    }

    /**
     *
     * @param technologyId
     * @return
     */
    public List < Exam > getAllExamsForTechnology(long technologyId) {
        final List < Exam > examList = new ArrayList < Exam > ();
        final Query < Exam > contentList = (Query < Exam >) super.createQuery().filter("technologyId = ", technologyId);
        for (Exam exam : contentList.fetch()) {
            examList.add(exam);
        }
        return examList;
    }

    /**
     * Fetch all the Questions for a given technology and sub technology Id
     *
     * @param examId
     * @param technologyId
     * @return
     */
    public List < Question > getAllQuestionsForExamAndTechnology(long examId, long technologyId) {
        final List < Question > questionList = new ArrayList < Question > ();
        final Query < Question > contentList = (Query < Question>) super.createQuery().filter("examId = ", examId).filter("technologyId = ", technologyId);
        for (Question question : contentList.fetch()) {
            questionList.add(question);
        }
        return questionList;
    }

    /**
     * Fetch all the Questions for a given technology and sub technology Id
     *
     * @param examId
     * @return
     */
    public List<Question> getAllQuestionsForExam(long examId) {
        final List < Question > questionList = new ArrayList < Question > ();
        final Query < Question > contentList = (Query < Question>) super.createQuery().filter("examId = ", examId);
        for (Question question : contentList.fetch()) {
            questionList.add(question);
        }
        return questionList;
    }

    /**
     * Fetch all the Answers for a given questionIdgetAllExamsForTechnology
     *
     * @param questionId
     * @return
     */
    public List < Answer > getAllAnswersForQuestionId(final String questionId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * @return
     */
    public Question getQuestionForQuestionId(String questionId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Fetch the passing score for a given examId
     *
     * @param examId
     * @return
     */
    public int getPassScoreForExamId(long examId) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }
}