/**
 * 
 */
package com.jms.activemq.consumer;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * @author Siddhant sahu
 *
 */
public class Consumer {
	private ConnectionFactory factory;
	private Connection connection;
	private Session session;
	private MessageConsumer consumer;

	public Consumer(ConnectionFactory factory, String queue) throws JMSException {
		this.factory = factory;
		this.connection = factory.createConnection();
		this.connection.start();
		this.session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue(queue);
		this.consumer = session.createConsumer(destination);
	}

	public String getValue() throws JMSException {
		TextMessage message = (TextMessage) this.consumer.receive();
		return message.getText();
	}
}
