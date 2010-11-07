package com.compracoletiva.main;

import com.compracoletiva.presenters.MainPresenter;
import com.compracoletiva.spring.SpringHelper;
import com.vaadin.Application;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Layout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

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
		mainWindow.setBorder(Window.BORDER_NONE);

		VerticalLayout vLayoutTotal = new VerticalLayout();
		Layout mainView = mainPresenter.getMainView();
		vLayoutTotal.setWidth("100%");
		vLayoutTotal.setHeight("100%");
		vLayoutTotal.addComponent(mainView);
		vLayoutTotal.setComponentAlignment(mainView, Alignment.TOP_CENTER);

		
		mainWindow.addComponent(vLayoutTotal);
		setTheme("green-theme");
		setMainWindow(mainWindow);
	}

}
