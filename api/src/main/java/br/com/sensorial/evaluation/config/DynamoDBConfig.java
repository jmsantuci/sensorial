/**
 * 
 */
package br.com.sensorial.evaluation.config;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.util.StringUtils;

/**
 * @author jsantuci
 *
 */
@Configuration
@EnableDynamoDBRepositories(basePackages="br.com.sensorial.evaluation")
public class DynamoDBConfig {

	@Value("${amazon.dynamodb.endpoint}")
	private String dBEndpoint;
 
	@Value("${amazon.aws.accesskey}")
	private String accessKey;
 
	@Value("${amazon.aws.secretkey}")
	private String secretKey;
 
	@Bean
	public AmazonDynamoDB amazonDynamoDB() {

		// TODO: remove deprecated method
//		AmazonDynamoDB dynamoDB = 
//				AmazonDynamoDBClientBuilder.standard()
//					.withCredentials(new AWSStaticCredentialsProvider(amazonAWSCredentials()))
//					.withRegion(dBEndpoint)
//					.build(); 

		AmazonDynamoDB dynamoDB = new AmazonDynamoDBClient(amazonAWSCredentials());
		 
		if (!StringUtils.isNullOrEmpty(dBEndpoint)) {
			dynamoDB.setEndpoint(dBEndpoint);
		}

		return dynamoDB;
	}
 
	@Bean
	public AWSCredentials amazonAWSCredentials() {
		return new BasicAWSCredentials(accessKey, secretKey);
	}

}
