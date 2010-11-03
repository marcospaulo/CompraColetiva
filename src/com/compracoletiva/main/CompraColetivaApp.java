package com.compracoletiva.main;

import com.vaadin.Application;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

public class CompraColetivaApp extends Application {

	@Override
	public void init() {
		Window mainWindow = new Window("Compracoletiva Application");
		Label label = new Label("Hello Vaadin user");
		mainWindow.addComponent(label);

		setMainWindow(mainWindow);
	}

}
