package Aerothon.prototype.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Aerothon.prototype.models.Bug;
import Aerothon.prototype.repositories.BugRepo;

@RestController
@RequestMapping("/bug")
public class BugController {

	@Autowired
	BugRepo bugRepo;

	@PostMapping("/add")
	public Bug add_bug(@RequestBody Bug bug) {
		return bugRepo.save(bug);
	}

	@PostMapping("/all")
	public List<Bug> get_all(@RequestBody Map<String, String> urlMap) {
		String pageUrl = urlMap.get("pageUrl");
		return bugRepo.findAllByPageUrl(pageUrl);
	}

}
