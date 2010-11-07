package com.compracoletiva.view.main;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.http.RequestToken;

import com.compracoletiva.spring.SpringHelper;
import com.vaadin.terminal.ExternalResource;
import com.vaadin.ui.HorizontalLayout;

public class TwitterForm extends HorizontalLayout {

	public static String CONSUMER_KEY = "w3iH5kIXSTo6zGSLXpIpg";
	public static String CONSUMER_SECRET = "CYdFIRelvSuokizI86jS0hpi1IJ13svoDWQ7aCpdY";

	RequestToken requestToken;

	public TwitterForm() {
		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
		try {
			requestToken = twitter.getOAuthRequestToken();
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		String token = requestToken.getToken();
		String tokenSecret = requestToken.getTokenSecret();

//		HttpSession session = request.getSession();
//		session.setAttribute("token", token);
//		session.setAttribute("tokenSecret", tokenSecret);

		String authUrl = requestToken.getAuthorizationURL();

		SpringHelper.getInstance().getApplication().getMainWindow().open(
				new ExternalResource(authUrl));
		
		

	}

}
