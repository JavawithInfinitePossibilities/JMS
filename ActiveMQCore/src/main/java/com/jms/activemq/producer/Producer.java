/**
 * 
 */
package com.jms.activemq.producer;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * @author Siddhant sahu
 *
 */
public class Producer {
	private ConnectionFactory factory;
	private Connection connection;
	private Session session;
	private MessageProducer producer;

	public Producer(ConnectionFactory factory, String queue) throws JMSException {
		this.factory = factory;
		this.connection = factory.createConnection();
		this.session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue(queue);
		this.producer = session.createProducer(destination);
	}

	public void run(String message) throws JMSException {
		TextMessage textMessage = session.createTextMessage(message);
		producer.send(textMessage);
	}
}
