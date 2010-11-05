package com.compracoletiva.view.main;

import java.io.Serializable;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.compracoletiva.server.entities.InformacoesContato;
import com.compracoletiva.server.fieldfactorys.InformacoesContatoFieldFactory;
import com.vaadin.data.util.BeanItem;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

@Service
public class MainViewImpl implements MainView, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7366878783020336329L;

	private VerticalLayout mainVerticalLayout;
	private VerticalLayout topLayout;
	private HorizontalLayout midLayout;
	private HorizontalLayout botLayout;
	private Button botaoEnviar;

	@Override
	public void init() {
		montarTopLayout();
		montarMidLayout();
		montarMainLayout();
	}

	void montarMainLayout() {
		mainVerticalLayout = new VerticalLayout();

		mainVerticalLayout.addComponent(topLayout);
		mainVerticalLayout.addComponent(midLayout);
		// mainVerticalLayout.addComponent(botLayout);

		mainVerticalLayout.setWidth("960");

		mainVerticalLayout.setComponentAlignment(topLayout,
				Alignment.TOP_CENTER);
		mainVerticalLayout.setComponentAlignment(midLayout,
				Alignment.MIDDLE_CENTER);

	}

	void montarTopLayout() {

		HorizontalLayout topPrincipal = new HorizontalLayout();

		Embedded e = new Embedded("", new ThemeResource("img/google_logo.jpg"));
		e.setHeight("100");
		e.setWidth("180");

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

		botaoEnviar = new Button("Cadastrar", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				formularioDeEmailForm.commit();
				topLayout.getWindow().showNotification(
						"Email cadastrado com sucesso!!");
			}
		});

		VerticalLayout layoutForm = new VerticalLayout();
		layoutForm.addComponent(formularioDeEmailForm);
		layoutForm.addComponent(botaoEnviar);
		layoutForm.setComponentAlignment(formularioDeEmailForm,
				Alignment.MIDDLE_RIGHT);
		layoutForm.setComponentAlignment(botaoEnviar, Alignment.BOTTOM_LEFT);

		topPrincipal.addComponent(e);
		topPrincipal.addComponent(layoutForm);

		topPrincipal.setComponentAlignment(e, Alignment.MIDDLE_LEFT);
		topPrincipal.setComponentAlignment(layoutForm, Alignment.MIDDLE_RIGHT);
		topPrincipal.setWidth("100%");

		topLayout = new VerticalLayout();
		topLayout.addComponent(topPrincipal);
		topLayout.addComponent(new BarraDeMenu());
		topLayout.setHeight("150");
		topLayout.setWidth("100%");
	}

	private void montarMidLayout() {
		midLayout = new HorizontalLayout();

		VerticalLayout realMidLayout = new VerticalLayout();

		Label noticia = new Label();
		
		noticia.setValue("PROMOÇÃO DE INAUGURAÇÃO!!! DESCONTO DE 80% NO "
				+ "BEACH PARK... CORRA, SÃO APENAS 200 INGRESSOS");
		noticia.setStyleName("anuncio");

		Embedded e = new Embedded("", new ThemeResource("layouts/teste.html"));
		e.setType(Embedded.TYPE_BROWSER);
		e.setWidth("960");
		e.setHeight("400");

		realMidLayout.addComponent(noticia);
		realMidLayout.addComponent(e);

		realMidLayout.setComponentAlignment(noticia, Alignment.BOTTOM_CENTER);
		realMidLayout.setComponentAlignment(e, Alignment.MIDDLE_CENTER);

		midLayout.addComponent(realMidLayout);
		midLayout.setComponentAlignment(realMidLayout, Alignment.MIDDLE_CENTER);
		midLayout.setWidth("100%");
		midLayout.setHeight("100%");
	}

	@Override
	public Layout getMainLayout() {
		return mainVerticalLayout;
	}

	@Override
	public Layout getBotLayout() {
		return botLayout;
	}

	@Override
	public Layout getMidLayout() {
		return midLayout;
	}

	@Override
	public Layout getTopLayout() {
		return topLayout;
	}

}
