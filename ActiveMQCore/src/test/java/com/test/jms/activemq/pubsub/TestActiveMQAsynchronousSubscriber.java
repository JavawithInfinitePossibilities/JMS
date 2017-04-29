/**
 * 
 */
package com.test.jms.activemq.pubsub;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.jms.activemq.consumer.AsynchronousSubscriber;

/**
 * @author Siddhant sahu
 *
 */
public class TestActiveMQAsynchronousSubscriber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		try {
			AsynchronousSubscriber asynchronousSubscriber = new AsynchronousSubscriber(activeMQConnectionFactory,
					"EM_TOPIC.Q");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
