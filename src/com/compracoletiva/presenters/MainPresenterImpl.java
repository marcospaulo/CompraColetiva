package com.compracoletiva.presenters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compracoletiva.view.main.MainView;
import com.vaadin.ui.Layout;

@Service
public class MainPresenterImpl implements MainPresenter {

	private MainView mainView;

	@Autowired
	public MainPresenterImpl(MainView mainView) {
		this.mainView = mainView;
	}

	@Override
	public void trocarPagina() {

	}

	@Override
	public Layout getMainView() {
		mainView.init();
		return mainView.getMainLayout();
	}

}
