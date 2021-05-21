package Aerothon.prototype.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Aerothon.prototype.models.Faqs;
import Aerothon.prototype.repositories.FaqElasticRepo;
import Aerothon.prototype.repositories.FaqRepo;

@Service
public class FaqService {

	@Autowired
	FaqRepo mongo_repository;

	@Autowired
	FaqElasticRepo elastic_repo;

	public Faqs add_faq_to_mongo(Faqs question) {
		Faqs saved_to_mongo = mongo_repository.save(question);
		elastic_repo.save(saved_to_mongo);
		return saved_to_mongo;

	}

	public List<Faqs> all_faqs_from_mongo(String pageUrl) {
		return mongo_repository.findAllByPageUrl(pageUrl);
	}

	public List<Faqs> all_question_with_matching_from_elasticsearch(String question) throws IOException {
		return elastic_repo.find_all_question_with_matching_from_elasticsearch(question);
	}

}
