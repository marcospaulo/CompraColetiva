package com.compracoletiva.server.validadores;

import com.vaadin.data.Validator;

public class EmailValidator implements Validator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1602832073072454853L;
	
	private String mensagem;

	public EmailValidator(String mensagem) {
		this.mensagem = mensagem;
	}

	@Override
	public boolean isValid(Object value) {

		String email = (String) value;
		String emailComEspacos[] = email.split("\\s");
			
		if (emailComEspacos.length > 1) {
			return false;
		}

		if (email.split("@").length == 2) {
			return true;
		}

		return false;
	}

	@Override
	public void validate(Object value) throws InvalidValueException {
		if (!isValid(value)) {
			throw new InvalidValueException(mensagem);
		}
	}

}
