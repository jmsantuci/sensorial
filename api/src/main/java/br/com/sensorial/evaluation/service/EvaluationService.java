/**
 * 
 */
package br.com.sensorial.evaluation.service;

import java.util.List;

import br.com.sensorial.evaluation.model.Evaluation;

/**
 * @author jsantuci
 *
 */
public interface EvaluationService {

	List<Evaluation> getEvaluations();

	void addEvaluation(Evaluation evaluationModel);
}
