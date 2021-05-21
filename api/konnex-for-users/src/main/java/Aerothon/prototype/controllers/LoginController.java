package Aerothon.prototype.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Aerothon.prototype.dtos.ResponseMsgDTO;
import Aerothon.prototype.dtos.TokenDTO;
import Aerothon.prototype.dtos.UserLoginDTO;
import Aerothon.prototype.dtos.UserSignupDTO;
import Aerothon.prototype.models.Tokens;
import Aerothon.prototype.models.UserDetails;
import Aerothon.prototype.repositories.TokensRepo;
import Aerothon.prototype.repositories.UserDetailsRepo;

@RestController
public class LoginController {

	@Autowired
	UserDetailsRepo userDetailsRepo;
	@Autowired
	TokensRepo tokensRepo;

	@PostMapping("/signup")
	public ResponseEntity<ResponseMsgDTO> registerUser(@RequestBody UserSignupDTO user) {
		UserDetails newUser = new UserDetails();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(user.getPassword());
		newUser.setEmail(user.getEmail());
		newUser.setTotalScore(0);
		newUser.setNoOfQueAnswered(0);
		userDetailsRepo.save(newUser);
		return new ResponseEntity<>(new ResponseMsgDTO("Signup Successful"), HttpStatus.OK);
	}

	@PostMapping("/signin")
	public ResponseEntity<Object> loginUser(@RequestBody UserLoginDTO user) {
		String username = user.getUsername();
		String password = user.getPassword();
		UserDetails userDetails = userDetailsRepo.findOneByUsername(username);
		if (userDetails == null) {
			return new ResponseEntity<>(new ResponseMsgDTO("username not found"), HttpStatus.NOT_FOUND);
		}
		if (!userDetails.getPassword().equals(password)) {
			return new ResponseEntity<>(new ResponseMsgDTO("wrong password"), HttpStatus.FORBIDDEN);
		}
		String token = UUID.randomUUID().toString();
		tokensRepo.save(new Tokens(userDetails.getUserId(), token));
		return new ResponseEntity<>(new TokenDTO(token), HttpStatus.OK);
	}

}
