package com.compracoletiva.view.main.componentes;

import java.util.Arrays;

import com.compracoletiva.server.entities.InformacoesContato;
import com.compracoletiva.server.fieldfactorys.InformacoesContatoFieldFactory;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

public class CmpContato {
	
	private Button botaoEnviar;
	
	public CmpContato() {
		InformacoesContato informacoesContato = new InformacoesContato();
		BeanItem<InformacoesContato> beanInformacoesContato = new BeanItem<InformacoesContato>(
				informacoesContato);

		final Form formularioDeEmailForm = new Form() {
			public void commit() {
				super.commit();
			}
		};
		formularioDeEmailForm.setCaption("Contato");
		formularioDeEmailForm.setLayout(new HorizontalLayout());
		formularioDeEmailForm.setWriteThrough(false);
		formularioDeEmailForm.setInvalidCommitted(false);
		formularioDeEmailForm
				.setFormFieldFactory(new InformacoesContatoFieldFactory());
		formularioDeEmailForm.setItemDataSource(beanInformacoesContato);
		formularioDeEmailForm.setVisibleItemProperties(Arrays
				.asList(new String[] { "nome", "email" }));

		botaoEnviar = new Button("Cadastrar");

		VerticalLayout layoutForm = new VerticalLayout();
		layoutForm.addComponent(formularioDeEmailForm);
		layoutForm.addComponent(botaoEnviar);
		layoutForm.setComponentAlignment(formularioDeEmailForm,
				Alignment.MIDDLE_RIGHT);
		layoutForm.setComponentAlignment(botaoEnviar, Alignment.BOTTOM_LEFT);

	}
}
