package com.compracoletiva.view.main;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.MenuBar.Command;

public class BarraDeMenu extends VerticalLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1829105028238130429L;

	private MenuBar menuBar = new MenuBar();
	private Command ofertaDoDiaAction;
	private Command ofertasAnterioresAction;

	public BarraDeMenu() {
		menuBar.setWidth("100%");
		MenuBar.MenuItem ofertaDoDia = menuBar.addItem(ItensDaBarraDeMenu.OFERTA_DO_DIA.getNome(),
				ofertaDoDiaAction);
		MenuBar.MenuItem ofertasAnteriores = menuBar.addItem(ItensDaBarraDeMenu.OFERTAS_ANTERIORES.getNome(),
				ofertasAnterioresAction);
		
		ofertaDoDia.setStyleName("nomesstyle");
		ofertasAnteriores.setStyleName("nomesstyle");
		
		addComponent(menuBar);
		setComponentAlignment(menuBar, Alignment.MIDDLE_CENTER);
		setWidth("100%");
	}

}
