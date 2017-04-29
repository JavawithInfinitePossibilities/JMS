/**
 * 
 */
package com.jms.activemq.consumer;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

/**
 * @author Siddhant sahu
 *
 */
public class Subscriber {
	private ConnectionFactory factory;
	private Connection connection;
	private Session session;
	private MessageConsumer consumer;

	public Subscriber(ConnectionFactory factory, String topicName) throws JMSException {
		super();
		this.factory = factory;
		this.connection = factory.createConnection();
		this.connection.start();
		this.session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Topic topic = session.createTopic(topicName);
		consumer = session.createConsumer(topic);
	}

	public String getValue() throws JMSException {
		TextMessage textMessage = (TextMessage) consumer.receive();
		return textMessage.getText();
	}
}
