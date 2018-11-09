/**
 * 
 */
package br.com.sensorial.evaluation.evaluationqueue.service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Component;

/**
 * @author jsantuci
 *
 */
@Component
public class EvaluationListener implements MessageListener {

	public EvaluationListener() {
		System.out.println("*** EvaluationListener");
	}
	
	@Override
	public void onMessage(Message message) {
		TextMessage textMessage = (TextMessage) message;
		try {
			System.out.println("Received message " + textMessage.getText());
		} catch (JMSException jmsExeption) {
			System.out.println("Error processing message " + jmsExeption);
		}
		
	}

}
