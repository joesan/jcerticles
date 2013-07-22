package org.q31.jcerticles.mail.impl;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.q31.jcerticles.common.domain.user.UserDetails;
import org.q31.jcerticles.common.exception.Q31RuntimeException;
import org.q31.jcerticles.mail.IEmailSender;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;

public class EmailSenderImpl implements IEmailSender {
	
	private JavaMailSender mailSender;
	private VelocityEngine velocityEngine;
	
	private String senderEmail;

	public void setMailSender(JavaMailSender mailSender) {
	   this.mailSender = mailSender;
	}

	public void setVelocityEngine(VelocityEngine velocityEngine) {
	   this.velocityEngine = velocityEngine;
	}
	
	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}

	@Override
	public void sendEmail(final UserDetails userDetails) {
		Map<Object, Object> hTemplateVariables = new HashMap<Object, Object>();
		hTemplateVariables.put("firstName", userDetails.getFirstName());
		hTemplateVariables.put("lastName", userDetails.getLastName());
		this.sendEmail(userDetails.getEmail(), "Hi Maha... From JUGChennai", hTemplateVariables);		
	}
	
    /**
     * Sends e-mail using Velocity template for the body and 
     * the properties passed in as Velocity variables.
     * 
     * @param   msg                 The e-mail message to be sent, except for the body.
     * @param   hTemplateVariables  Variables to use when processing the template. 
     */
	private void sendEmail(final String to, final String subject, final Map<Object, Object> hTemplateVariables) {
		final String senderEmail = this.senderEmail;
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
               MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
               message.setTo(to);
               message.setFrom(senderEmail);
               message.setSubject(subject);

               String body = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/config/common/emailBody.vm", hTemplateVariables);

               message.setText(body, true);
            }
         };
         try {
        	 mailSender.send(preparator);        	 
         }
         catch (MailException ex) {
        	 throw new Q31RuntimeException("", ex);        	 
         }
         
		
	}

}
