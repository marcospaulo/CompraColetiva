package com.compracoletiva.main;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.compracoletiva.presenters.MainPresenter;
import com.compracoletiva.spring.SpringHelper;
import com.vaadin.Application;
import com.vaadin.ui.Window;

@Service
@Configurable(preConstruction=true)
public class CompraColetivaApp extends Application {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2186351548832266712L;

	private MainPresenter mainPresenter;

	@Override
	public void init() {
		Window mainWindow = new Window("Compracoletiva Application");
		SpringHelper helper = SpringHelper.getInstance();
		helper.startApplication(this);
		mainPresenter = (MainPresenter) helper.getBean("myBean");
		mainWindow.addComponent(mainPresenter.getMainView());
		setMainWindow(mainWindow);
	}

}
