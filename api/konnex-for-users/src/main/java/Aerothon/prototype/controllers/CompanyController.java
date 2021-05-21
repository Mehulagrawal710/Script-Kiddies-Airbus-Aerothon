package Aerothon.prototype.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Aerothon.prototype.dtos.ResponseMsgDTO;
import Aerothon.prototype.dtos.TokenDTO;
import Aerothon.prototype.dtos.UserLoginDTO;
import Aerothon.prototype.models.Company;
import Aerothon.prototype.models.Tokens;
import Aerothon.prototype.repositories.CompanyRepo;
import Aerothon.prototype.repositories.TokensRepo;

@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	CompanyRepo companyRepo;
	@Autowired
	TokensRepo tokensRepo;

	@PostMapping("/signup")
	public ResponseEntity<ResponseMsgDTO> registerCompany(@RequestBody UserLoginDTO user) {
		String pageUrl = user.getUsername();
		String password = user.getPassword();
		System.out.println(pageUrl);
		System.out.println(password);
		Company company = new Company(pageUrl, password);
		companyRepo.save(company);
		return new ResponseEntity<>(new ResponseMsgDTO("Signup Successful"), HttpStatus.OK);
	}

	@PostMapping("/signin")
	public ResponseEntity<Object> loginCompany(@RequestBody UserLoginDTO user) {
		String page_url = user.getUsername();
		String password = user.getPassword();

		Company company = companyRepo.findByPageUrl(page_url);
		if (company == null) {
			return new ResponseEntity<>(new ResponseMsgDTO("username not found"), HttpStatus.NOT_FOUND);
		}
		if (!company.getPassword().equals(password)) {
			return new ResponseEntity<>(new ResponseMsgDTO("wrong password"), HttpStatus.FORBIDDEN);
		}
		String token = UUID.randomUUID().toString();
		tokensRepo.save(new Tokens(company.getCompanyId(), token));
		return new ResponseEntity<>(new TokenDTO(token), HttpStatus.OK);
	}

}
