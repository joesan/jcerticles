/*
 * Project: jcerticles
 * Copyright(c) 2011 jcerticles
 * All rights reserved.
 *
 * $Revision $, last modified $Date $ by $Author $
 */
package org.q31.jcerticles.web.content.action.impl;

import javax.annotation.Resource;

import org.q31.jcerticles.facade.content.IContentFacade;
import org.q31.jcerticles.web.common.action.BaseAction;
import org.q31.jcerticles.web.content.model.ContentModel;

/**
 * All content related actions are concentrated here
 * @author Jothi Shankar Kumar. S
 * @since 1.6
 * Date: Nov 22, 2009
 * Time: 11:25:17 AM
 */
public abstract class ContentAction extends BaseAction {
	
	/* The unique serial version identifier */
	private static final long serialVersionUID = 1L;
	
	/* The model to be instantiated for all Content related actions */
	private ContentModel contentModel;
	
    /* The UserFacade reference */
    @Resource(name = "contentFacade")
    protected IContentFacade contentFacade;	

	@Override
	public Object getModel() {
		return contentModel;
	}

	@Override
	public void prepare() throws Exception {
        if (contentModel == null) {
            contentModel = new ContentModel();
        }		
	}
	
	@Override
	public String execute() {
		return SUCCESS;
	}
}