/**
 * 
 */
package com.test.jms.activemq.senderreceiver;

import java.util.Scanner;

import javax.jms.JMSException;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.jms.activemq.consumer.Consumer;
import com.jms.activemq.producer.Producer;

/**
 * @author Siddhant sahu
 *
 */
public class TestActiveMQSynchronous {

	private Producer producer;
	private Consumer consumer;

	@Before
	public void init() throws JMSException {
		System.out.println("This is init method...");
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		producer = new Producer(activeMQConnectionFactory, "EM_MESSAGE.Q");
		consumer = new Consumer(activeMQConnectionFactory, "EM_MESSAGE.Q");
	}

	@Test
	public void testProducer() {
		Scanner scanner = new Scanner(System.in);
		String value = null;
		System.out.println("Please enter the message...");
		value = scanner.nextLine();
		try {
			producer.run(value);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	@Ignore
	public void testConsumer() {
		try {
			String message = consumer.getValue();
			System.out.println(message);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
