package Aerothon.prototype.repositories;

import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;

import Aerothon.prototype.models.Answers;

public interface AnswersRepo extends MongoRepository<Answers, String> {

	ArrayList<Answers> findAllByFaqId(String faqId);

}
