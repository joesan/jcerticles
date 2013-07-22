package org.q31.jcerticles.core;

import org.q31.jcerticles.core.business.content.service.IContentService;
import org.q31.jcerticles.core.business.content.service.impl.ContentServiceImpl;
import org.q31.jcerticles.core.business.content.util.ExamObject;

public class ContentServiceTest {

    public static void main(String[] args) {
        new ContentServiceTest().testStartExam();
    }

    public void testStartExam() {
        IContentService contentService = new ContentServiceImpl();

        ExamObject examObject = contentService.startExam(10010L);
        System.out.println(examObject.getAllQuestionIds());

        System.out.println(examObject.getCurrentQuestion().getQuestionText1());
        System.out.println(examObject.getCurrentQuestion().getAnswers());
    }
}