package Aerothon.prototype.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import Aerothon.prototype.models.PageSuggestions;

public interface PageSuggestionsRepo extends MongoRepository<PageSuggestions, String> {

	List<PageSuggestions> findAllByPageUrl(String pageUrl);

}
