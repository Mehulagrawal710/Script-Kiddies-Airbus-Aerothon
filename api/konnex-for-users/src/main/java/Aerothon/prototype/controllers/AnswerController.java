package Aerothon.prototype.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Aerothon.prototype.dtos.PostAnswerDTO;
import Aerothon.prototype.models.Answers;
import Aerothon.prototype.models.Tokens;
import Aerothon.prototype.models.UserDetails;
import Aerothon.prototype.repositories.AnswersRepo;
import Aerothon.prototype.repositories.TokensRepo;
import Aerothon.prototype.repositories.UserDetailsRepo;

@RestController
@RequestMapping("/answer")
public class AnswerController {

	@Autowired
	AnswersRepo answersRepo;
	@Autowired
	TokensRepo tokensRepo;
	@Autowired
	UserDetailsRepo userDetailsRepo;

	@PostMapping("/all")
	public ResponseEntity<Object> getAnswers(@RequestBody Map<String, String> map) {
		String faqId = map.get("faqId");
		ArrayList<Answers> answers = answersRepo.findAllByFaqId(faqId);
		ArrayList<String> answerResponse = new ArrayList<>();
		for (Answers answer : answers) {
			answerResponse.add(answer.getAnswer());
		}
		return new ResponseEntity<>(answerResponse, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<Answers> postAnswer(@RequestHeader("token") String token,
			@RequestBody PostAnswerDTO postAnswerDTO) {
		Tokens tokenEntry = tokensRepo.findOneByToken(token);
		String userId = tokenEntry.getUserId();
		String faqId = postAnswerDTO.getFaqId();
		String answer = postAnswerDTO.getAnswer();
		Answers newAnswer = new Answers(faqId, userId, answer);
		UserDetails user = userDetailsRepo.findById(userId).orElse(null);
		int score = user.getTotalScore();
		int queAnswered = user.getNoOfQueAnswered() + 1;
		int new_score = score + 10;
		UserDetails new_user = userDetailsRepo.findById(userId).orElse(null);
		new_user.setTotalScore(new_score);
		new_user.setNoOfQueAnswered(queAnswered);
		userDetailsRepo.deleteById(userId);
		userDetailsRepo.save(new_user);
		answersRepo.save(newAnswer);
		return new ResponseEntity<Answers>(newAnswer, HttpStatus.OK);
	}

}
