package be.vdab.pizzaluigi.web;

import java.io.Serializable;

import javax.validation.constraints.Email;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope

public class DefaultIdentificatie implements Serializable, Identificatie{
	private static final long serialVersionUID = 1L;
	
	@Email
	private String EmailAdres;

	@Override
	public String getEmailAdres() {
	return EmailAdres;
	}

	@Override
	public void setEmailAdres(String adres) {
		this.EmailAdres = adres;
		
	}
	
	

}
