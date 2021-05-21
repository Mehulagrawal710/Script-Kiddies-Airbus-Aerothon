package Aerothon.prototype.controllers;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import Aerothon.prototype.dtos.PostAnswerDTO;
import Aerothon.prototype.models.Answers;
import Aerothon.prototype.models.Tokens;
import Aerothon.prototype.repositories.AnswersRepo;
import Aerothon.prototype.repositories.TokensRepo;

@RestController
public class AnswerController {

	@Autowired
	AnswersRepo answersRepo;
	@Autowired
	TokensRepo tokensRepo;

	@GetMapping("/answer")
	public ResponseEntity<Object> getAnswers(@RequestBody Map<String, String> map) {
		String faqId = map.get("faqId");
		ArrayList<Answers> answers = answersRepo.findAllByFaqId(faqId);
		ArrayList<String> answerResponse = new ArrayList<>();
		for (Answers answer : answers) {
			answerResponse.add(answer.getAnswer());
		}
		return new ResponseEntity<>(answerResponse, HttpStatus.OK);
	}

	@PostMapping("/answer")
	public ResponseEntity<Answers> postAnswer(@RequestHeader("token") String token,
			@RequestBody PostAnswerDTO postAnswerDTO) {
		Tokens tokenEntry = tokensRepo.findOneByToken(token);
		String userId = tokenEntry.getUserId();
		String faqId = postAnswerDTO.getFaqId();
		String answer = postAnswerDTO.getAnswer();
		Answers newAnswer = new Answers(faqId, userId, answer);
		answersRepo.save(newAnswer);
		return new ResponseEntity<Answers>(newAnswer, HttpStatus.OK);
	}

}
