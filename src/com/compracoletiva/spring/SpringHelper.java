package com.compracoletiva.spring;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.vaadin.Application;
import com.vaadin.terminal.gwt.server.WebApplicationContext;

public class SpringHelper {
	
	private Application application;
	
	private ApplicationContext context;
	
	private static SpringHelper springHelper;

	private SpringHelper(){
	}
	
	public void startApplication(Application application){
		this.application = application;
		ServletContext servletContext = ((WebApplicationContext) application
				.getContext()).getHttpSession().getServletContext();
		context = WebApplicationContextUtils
				.getRequiredWebApplicationContext(servletContext);
	}

	public Object getBean(final String beanRef) {
		return context.getBean(beanRef);
	}
	
	public Application getApplication(){
		return application;
	}
	
	public static SpringHelper getInstance(){
		if(springHelper == null){
			springHelper = new SpringHelper();
		}
		return springHelper;
	}
	
	
	
}
