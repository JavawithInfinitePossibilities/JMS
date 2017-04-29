/**
 * 
 */
package com.test.jms.activemq.senderreceiver;

import javax.jms.JMSException;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import com.jms.activemq.consumer.AsynchronousConsumer;

/**
 * @author Siddhant sahu
 *
 */
public class TestActiveMQAsynchronous {

	public static void main(String[] args) {
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		try {
			AsynchronousConsumer consumer = new AsynchronousConsumer(activeMQConnectionFactory, "EM_MESSAGE.Q");
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
