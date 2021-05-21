package Aerothon.prototype.repositories;

import java.util.ArrayList;
import org.springframework.data.mongodb.repository.MongoRepository;

import Aerothon.prototype.models.Faqs;

public interface FaqRepo extends MongoRepository<Faqs, String> {

	ArrayList<Faqs> findAllByPageUrl(String url);

}
