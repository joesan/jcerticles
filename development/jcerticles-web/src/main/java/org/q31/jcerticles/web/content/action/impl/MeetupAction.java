package org.q31.jcerticles.web.content.action.impl;


import org.q31.jcerticles.web.common.action.BaseAction;
import org.q31.jcerticles.web.content.action.IMeetupAction;

/**
 * 
 * @author jothi
 *
 */
public class MeetupAction extends BaseAction implements IMeetupAction {

	/* The unique serial version identifier */
	private static final long serialVersionUID = 1L;

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub		
	}
	
	public String execute() {
		return SUCCESS;
	}
	
	public String getArchiveMeetUpList() {
		return SUCCESS;
	}
}
