package br.com.prox.util;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

import org.springframework.stereotype.Component;


@Component
public class FacesMessages implements Serializable {

	private static final long serialVersionUID = 1L;

	private void add(String message, String summary, Severity severity) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage msg = new FacesMessage(severity, summary, message);
		msg.setSeverity(severity);
		
		context.addMessage(null, msg);
		
	}
	
	public void info(String message) {
		add(message, "Informação | ", FacesMessage.SEVERITY_INFO);
	}
	
	public void error(String message) {
		add(message, "Erro | ", FacesMessage.SEVERITY_ERROR);
	}

	public void warn(String message) {
		add(message, "Aviso | ", FacesMessage.SEVERITY_WARN);
	}
}