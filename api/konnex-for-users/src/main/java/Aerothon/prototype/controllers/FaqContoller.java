package Aerothon.prototype.controllers;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Aerothon.prototype.models.Faqs;
import Aerothon.prototype.models.Tokens;
import Aerothon.prototype.repositories.FaqRepo;
import Aerothon.prototype.repositories.TokensRepo;
import Aerothon.prototype.services.FaqService;

@RestController
@RequestMapping("/faq")
public class FaqContoller {

	@Autowired
	FaqService faqService;
	@Autowired
	FaqRepo faqRepo;
	@Autowired
	TokensRepo tokensRepo;

	@PostMapping("/create")
	public ResponseEntity<Faqs> addFaq(@RequestHeader("token") String token,
			@RequestBody Map<String, String> reqParam) {
		Tokens tokenEntry = tokensRepo.findOneByToken(token);
		String userId = tokenEntry.getUserId();
		String pageUrl = reqParam.get("pageUrl");
		String question = reqParam.get("question");
		Faqs newQuestion = new Faqs(userId, pageUrl, question);
		newQuestion = faqRepo.save(newQuestion);
		return new ResponseEntity<>(newQuestion, HttpStatus.OK);
	}

	@PostMapping("/all")
	public ResponseEntity<ArrayList<Faqs>> getAllFaqs(@RequestBody Map<String, String> reqParam) {
		String pageUrl = reqParam.get("pageUrl");
		ArrayList<Faqs> allFaqsForThisPage = faqRepo.findAllByPageUrl(pageUrl);
		return new ResponseEntity<>(allFaqsForThisPage, HttpStatus.OK);
	}

//	@GetMapping("/all/match")
//	public List<Faqs> all_faq_with_matching(@RequestBody Map<String, String> url) throws IOException {
//		return faqService.all_question_with_matching_from_elasticsearch(url.get("question"));
//	}

}
