/**
 * 
 */
package com.test.jms.activemq.pubsub;

import java.util.Scanner;

import javax.jms.JMSException;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import com.jms.activemq.consumer.Subscriber;
import com.jms.activemq.producer.Publisher;

/**
 * @author Siddhant sahu
 *
 */
public class TestActiveMQSynchronousPublisher {

	@Test
	public void testPublisher() {
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		try {
			Publisher publisher = new Publisher(factory, "EM_TOPIC.Q");
			Scanner scanner = new Scanner(System.in);
			String value = null;
			System.out.println("Please send message");
			value = scanner.nextLine();
			publisher.run(value);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		try {
			Subscriber subscriber = new Subscriber(factory, "EM_TOPIC.Q");
			System.out.println(subscriber.getValue());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
