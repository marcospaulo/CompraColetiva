package com.example.compracoletiva;

import com.vaadin.Application;
import com.vaadin.ui.*;

public class CompracoletivaApplication extends Application {
	@Override
	public void init() {
		Window mainWindow = new Window("Compracoletiva Application");
		Label label = new Label("Hello Vaadin user");
		mainWindow.addComponent(label);
		setMainWindow(mainWindow);
	}

}
