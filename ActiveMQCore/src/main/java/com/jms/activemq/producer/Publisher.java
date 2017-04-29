/**
 * 
 */
package com.jms.activemq.producer;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

/**
 * @author Siddhant sahu
 *
 */
public class Publisher {
	private ConnectionFactory factory;
	private Connection connection;
	private Session session;
	private MessageProducer producer;

	public Publisher(ConnectionFactory factory, String topicName) throws JMSException {
		this.factory = factory;
		this.connection = factory.createConnection();
		this.session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Topic topic = session.createTopic(topicName);
		producer = session.createProducer(topic);
	}

	public void run(String message) throws JMSException {
		TextMessage textMessage = session.createTextMessage(message);
		producer.send(textMessage);
	}
}
