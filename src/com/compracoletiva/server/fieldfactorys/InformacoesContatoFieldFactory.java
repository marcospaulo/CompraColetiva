package com.compracoletiva.server.fieldfactorys;

import com.compracoletiva.server.validadores.EmailValidator;
import com.vaadin.data.Item;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.ui.Component;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.TextField;

public class InformacoesContatoFieldFactory extends DefaultFieldFactory {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6882011539487229979L;

	private static final String COMMON_FIELD_WIDTH = "12em";

	@Override
	public Field createField(Item item, Object propertyId, Component uiContext) {

		Field f = super.createField(item, propertyId, uiContext);
		if ("nome".equals(propertyId)) {
			TextField tf = (TextField) f;
			tf.setRequired(true);
			tf.setRequiredError("Por favor, insira o seu nome.");
			tf.setWidth(COMMON_FIELD_WIDTH);
			tf.addValidator(new StringLengthValidator(
					"Ops! Seu nome deve ter entre 2 a 20 caracteres..", 2,
					20, false));
		} else if ("email".equals(propertyId)) {
			TextField tf = (TextField) f;
			tf.setRequired(true);
			tf
					.setRequiredError("Seu e-mail Ž muito importante para n—s, n‹o deixe de coloc‡-lo");
			tf.setWidth(COMMON_FIELD_WIDTH);
			tf
					.addValidator(new EmailValidator(
							"Xii!! Algo est‡ errado, por favor, verifique seu e-mail novamente"));

		}

		return f;
	}
}
