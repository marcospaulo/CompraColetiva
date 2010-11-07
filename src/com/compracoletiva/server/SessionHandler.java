package com.compracoletiva.server;

import javax.servlet.http.HttpServletRequest;

import com.vaadin.Application;
import com.vaadin.service.ApplicationContext.TransactionListener;

/**
 * A utility class for handling user sessions
 * 
 * @author Kim
 * 
 */
public class SessionHandler implements TransactionListener {

	private static final long serialVersionUID = 4142938996955537395L;

	private final Application application;
	
	private static HttpServletRequest request;


	// Store the user object of the currently inlogged user
	private static ThreadLocal<SessionHandler> instance = new ThreadLocal<SessionHandler>();

	/**
	 * Constructor
	 * 
	 * @param application
	 *            Current application instance
	 */
	public SessionHandler(Application application) {
		this.application = application;
		instance.set(this);
	}

	/**
	 * {@inheritDoc}
	 */
	public void transactionEnd(Application application, Object transactionData) {
		// Clear the currentApplication field
		request = (HttpServletRequest) transactionData;
		if (this.application == application) {
			instance.set(null);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void transactionStart(Application application, Object transactionData) {
		// Check if the application instance we got as parameter is actually
		// this application instance. If it is, then we should define the thread
		// local variable for this request.
		if (this.application == application) {
			// Set the current user
			instance.set(this);
		}
	}

	/**
	 * Initializes the {@link SessionHandler} for the given {@link Application}
	 * 
	 * @param application
	 */
	public static void initialize(Application application) {
		if (application == null) {
			throw new IllegalArgumentException("Application may not be null");
		}
		SessionHandler handler = new SessionHandler(application);
		application.getContext().addTransactionListener(handler);
	}

	public static HttpServletRequest getServletRequest() {
		return request;
	}


}
