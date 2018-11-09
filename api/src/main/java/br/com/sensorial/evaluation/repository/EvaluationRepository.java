/**
 * 
 */
package br.com.sensorial.evaluation.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import br.com.sensorial.evaluation.model.Evaluation;

/**
 * @author jsantuci
 *
 */
@EnableScan
public interface EvaluationRepository extends CrudRepository<Evaluation, String> {
}
