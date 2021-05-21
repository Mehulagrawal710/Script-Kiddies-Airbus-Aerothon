package Aerothon.prototype.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import Aerothon.prototype.models.Company;

public interface CompanyRepo extends MongoRepository<Company, String> {

	Company findByPageUrl(String pageUrl);

}
