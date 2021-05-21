package Aerothon.prototype.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import Aerothon.prototype.models.UserDetails;

public interface UserDetailsRepo extends MongoRepository<UserDetails, String>{

	UserDetails findOneByUsername(String username);

}
