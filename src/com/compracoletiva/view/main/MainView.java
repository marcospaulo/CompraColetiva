package com.compracoletiva.view.main;

import com.vaadin.ui.Layout;

public interface MainView {
	
	void init();
	
	Layout getMainLayout();
	Layout getTopLayout();
	Layout getMidLayout();
	Layout getBotLayout();

}
