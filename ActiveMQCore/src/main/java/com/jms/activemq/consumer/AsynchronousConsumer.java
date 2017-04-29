/**
 * 
 */
package com.jms.activemq.consumer;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * @author Siddhant sahu
 *
 */
public class AsynchronousConsumer implements MessageListener {
	private ConnectionFactory factory;
	private Connection connection;
	private Session session;
	private MessageConsumer consumer;

	public AsynchronousConsumer(ConnectionFactory factory, String queue) throws JMSException {
		this.factory = factory;
		this.connection = factory.createConnection();
		this.connection.start();
		this.session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue(queue);
		this.consumer = session.createConsumer(destination);
		consumer.setMessageListener(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.jms.MessageListener#onMessage(javax.jms.Message)
	 */
	public void onMessage(Message message) {
		if (message instanceof TextMessage) {
			TextMessage textMessage = (TextMessage) message;
			try {
				System.out.println(textMessage.getText());
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

}
