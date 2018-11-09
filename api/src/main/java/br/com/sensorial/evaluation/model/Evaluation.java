/**
 * 
 */
package br.com.sensorial.evaluation.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.Data;

/**
 * @author jsantuci
 *
 */
@Data
@DynamoDBTable(tableName = "Evaluation")
public class Evaluation {

	@DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
	private String id;
	
	private long userId;
	
	private int session;
	
	private int level;
	
	private boolean block;
	
	private int attempt;
	
	/**
	 * Non-Arg Constructor.
	 */
	public Evaluation() {
	}

}