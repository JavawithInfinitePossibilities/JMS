/**
 * 
 */
package com.jms.activemq.consumer;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

/**
 * @author Siddhant sahu
 *
 */
public class AsynchronousSubscriber implements MessageListener {
	private ConnectionFactory factory;
	private Connection connection;
	private Session session;
	private MessageConsumer consumer;

	public AsynchronousSubscriber(ConnectionFactory factory, String topicName) throws JMSException {
		this.factory = factory;
		this.connection = factory.createConnection();
		this.connection.start();
		this.session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Topic topic = session.createTopic(topicName);
		consumer = session.createConsumer(topic);
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
