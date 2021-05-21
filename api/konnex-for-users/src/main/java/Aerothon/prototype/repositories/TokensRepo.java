package Aerothon.prototype.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import Aerothon.prototype.models.Tokens;

public interface TokensRepo extends MongoRepository<Tokens, String>{

	Tokens findOneByToken(String token);
	
}
