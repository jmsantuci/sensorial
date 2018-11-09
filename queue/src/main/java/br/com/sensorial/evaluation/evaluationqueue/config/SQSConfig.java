/**
 * 
 */
package br.com.sensorial.evaluation.evaluationqueue.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQSClient;

/**
 * @author jsantuci
 *
 */
@Configuration
public class SQSConfig {

	 @Value("${queue.endpoint}")
	 private String endpoint;

	 @Value("${queue.name}")
	 private String queueName;

	 @Bean
	 public AmazonSQSClient createSQSClient() {
		 // TODO: remove deprecated classes and methods
		 AmazonSQSClient amazonSQSClient = new AmazonSQSClient(new BasicAWSCredentials("",""));
		 amazonSQSClient.setEndpoint(endpoint);
		 amazonSQSClient.createQueue(queueName);
		 return amazonSQSClient;
	 }
	 
}
