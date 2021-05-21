package Aerothon.prototype.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import Aerothon.prototype.models.Bug;

public interface BugRepo extends MongoRepository<Bug, String> {

	List<Bug> findAllByPageUrl(String pageUrl);

}
