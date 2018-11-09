/**
 * 
 */
package br.com.sensorial.evaluation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.sensorial.evaluation.model.Evaluation;
import br.com.sensorial.evaluation.repository.EvaluationRepository;

/**
 * @author jsantuci
 *
 */
@Component
public class EvaluationServiceImpl implements EvaluationService {

	@Autowired
	private EvaluationRepository evaluationRepository;
	
	@Override
	public List<Evaluation> getEvaluations() {
		List<Evaluation> evaluations = new ArrayList<Evaluation>();
		Iterable<Evaluation> evaluationIterable = evaluationRepository.findAll();
		evaluationIterable.forEach(evaluations::add);
		return evaluations;
	}

	@Override
	public void addEvaluation(Evaluation evaluationModel) {
		evaluationRepository.save(evaluationModel);
	}

}
