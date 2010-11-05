package com.compracoletiva.presenters;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compracoletiva.view.main.MainView;
import com.vaadin.ui.Layout;

@Service
public class MainPresenterImpl implements MainPresenter, Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2193522765669900462L;
	
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
