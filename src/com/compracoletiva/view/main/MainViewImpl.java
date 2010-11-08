package com.compracoletiva.view.main;

import java.awt.Menu;
import java.io.Serializable;

import org.springframework.stereotype.Service;

import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Layout;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.VerticalLayout;

@Service
public class MainViewImpl implements MainView, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7366878783020336329L;

	private VerticalLayout mainVerticalLayout;
	private HorizontalLayout topLayout;
	private HorizontalLayout midLayout;
	private HorizontalLayout botLayout;
	private Button botaoEnviar;
	
	private MenuBar menubar;

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

		mainVerticalLayout.setWidth("980");

		mainVerticalLayout.setComponentAlignment(midLayout,
				Alignment.MIDDLE_CENTER);

	}

	void montarTopLayout() {

//		Label e = new Label();
//		e.setContentMode(e.CONTENT_XHTML);
//		e.setValue("<img style='width: 140; height: 70px;' src='/compracoletiva/VAADIN/themes/green-theme/img/GrandeLanceLogo.png'>");
//		e.setData("<img style='width: 140; height: 70px;'  src='/compracoletiva/VAADIN/themes/green-theme/img/GrandeLanceLogo.png");

		 menubar = new MenuBar();
		
		final MenuBar.MenuItem gl = menubar.addItem("GL", null);
		final MenuBar.MenuItem lanceAnterior = menubar.addItem("Lan�e Anterior", null);
		final MenuBar.MenuItem comoFuncionar = menubar.addItem("Como funciona", null);
		final MenuBar.MenuItem contato = menubar.addItem("Contato", null);
		final MenuBar.MenuItem conta = menubar.addItem("Conta", null);
		final MenuBar.MenuItem buscar = menubar.addItem("Buscar", null);
		menubar.setStyleName("barramenu");
		menubar.setHeight("100%");
		menubar.setWidth("100%");
		
		
	    topLayout = new HorizontalLayout();
		topLayout.addComponent(menubar);
		topLayout.setStyleName("barrademenu");
//		topLayout.setHeight("60");
//		topLayout.setWidth("100%");
		
				
		
		
//		topLayout = new HorizontalLayout();
////		topLayout.addComponent(e);
//		topLayout.addComponent(menu);
//		topLayout.setStyleName("barrademenu");
//		topLayout.setHeight("85");
//		topLayout.setWidth("100%");
	}

	private void montarMidLayout() {
		midLayout = new HorizontalLayout();

		// VerticalLayout realMidLayout = new VerticalLayout();
		//
		// Label noticia = new Label();
		//		
		// noticia.setValue("PROMOÇÃO DE INAUGURAÇÃO!!! DESCONTO DE 80% NO "
		// + "BEACH PARK... CORRA, SÃO APENAS 200 INGRESSOS");
		// noticia.setStyleName("anuncio");
		//
		// Embedded e = new Embedded("", new
		// ThemeResource("layouts/teste.html"));
		// e.setType(Embedded.TYPE_BROWSER);
		// e.setWidth("960");
		// e.setHeight("400");
		//
		// realMidLayout.addComponent(noticia);
		// realMidLayout.addComponent(e);
		//
		// realMidLayout.setComponentAlignment(noticia,
		// Alignment.BOTTOM_CENTER);
		// realMidLayout.setComponentAlignment(e, Alignment.MIDDLE_CENTER);
		//
		// midLayout.addComponent(realMidLayout);
		// midLayout.setComponentAlignment(realMidLayout,
		// Alignment.MIDDLE_CENTER);

		Embedded e = new Embedded("", new ThemeResource("img/grande_lance.png"));
		e.setType(Embedded.TYPE_IMAGE);
		e.setWidth("100%");
		e.setHeight("500");
		midLayout.addComponent(e);
		midLayout.setComponentAlignment(e, Alignment.MIDDLE_CENTER);
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
