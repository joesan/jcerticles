/*
 * Project: jcerticles
 * Copyright(c) 2011 jcerticles
 * All rights reserved.
 *
 * $Revision $, last modified $Date $ by $Author $
 */
package org.q31.jcerticles.web.common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * The base action class for all the actions that will be defined
 * in the application.
 * Created by IntelliJ IDEA.
 * User: Jothi Shankar Kumar. S
 * Date: Nov 22, 2009
 * Time: 11:24:59 AM
 */
public abstract class BaseAction extends ActionSupport implements ModelDriven < Object >, Preparable,
        ServletRequestAware, ServletResponseAware {

    /* The unique serial version identifier */
	private static final long serialVersionUID = 1L;

	/** The HttpServletRequest reference */
    protected HttpServletRequest httpServletRequest;

    /** The HttpServletResponse reference */
    protected HttpServletResponse httpServletResponse;

    /**
     * <p> Set the Servlet Request </p>
     * @param req   - The HttpServletRequest
     */
	public void setServletRequest(HttpServletRequest req) {
		this.httpServletRequest = req;
	}

    /**
     * <p> Get the Servlet Response </p>
     * @return httpServletResponse
     */
	public HttpServletResponse getServletResponse()	{
		return this.httpServletResponse;
	}

    /**
     *
     * @param res
     */
	public void setServletResponse(HttpServletResponse res)	{
		this.httpServletResponse = res;
	}
}