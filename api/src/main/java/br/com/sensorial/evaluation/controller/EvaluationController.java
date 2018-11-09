/**
 * 
 */
package br.com.sensorial.evaluation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.sensorial.evaluation.model.Evaluation;
import br.com.sensorial.evaluation.service.EvaluationService;

/**
 * @author jsantuci
 *
 */
@RestController
@RequestMapping("/api/evaluation")
public class EvaluationController {

	@Autowired
	private EvaluationService evaluationService;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	@ResponseStatus(value = HttpStatus.OK)
	public List<Evaluation> getAll() {
		return evaluationService.getEvaluations();
	}
	
	@RequestMapping(value = "/evaluations", method = RequestMethod.PUT, produces = "application/json")
	@ResponseStatus(value = HttpStatus.OK)
	public void addEvaluation(@RequestBody Evaluation evaluation) {
		evaluationService.addEvaluation(evaluation);
	}
	
}
