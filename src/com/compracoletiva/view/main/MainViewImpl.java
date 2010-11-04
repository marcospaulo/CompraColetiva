package com.compracoletiva.view.main;

import org.springframework.stereotype.Service;

import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Layout;
import com.vaadin.ui.VerticalLayout;

@Service
public class MainViewImpl implements MainView {

	private VerticalLayout mainVerticalLayout;
	private HorizontalLayout topLayout;
	private HorizontalLayout midLayout;
	private HorizontalLayout botLayout;

	@Override
	public void init() {
		montarTopLayout();
		mainVerticalLayout = new VerticalLayout();
		mainVerticalLayout.addComponent(topLayout);
		mainVerticalLayout.setComponentAlignment(topLayout,
				Alignment.TOP_CENTER);
	}

	void montarTopLayout() {
		Embedded e = new Embedded("YES IMAGE", new ThemeResource(
				"../../img/road.jpg"));
		e.setHeight("300");
		e.setWidth("100%");
		topLayout = new HorizontalLayout();
		topLayout.addComponent(e);
		topLayout.setWidth("100%");
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
