package Aerothon.prototype.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Aerothon.prototype.models.PageSuggestions;
import Aerothon.prototype.repositories.PageSuggestionsRepo;

@RestController
@RequestMapping("/suggestion")
public class PageSuggestionsController {

	@Autowired
	PageSuggestionsRepo pageSuggestionsRepo;

	@PostMapping("/add")
	public PageSuggestions add_page_desc(@RequestBody Map<String, String> map) {
		System.out.println("here");
		String pageUrl = map.get("pageUrl");
		String suggestion = map.get("suggestion");
		System.out.println(pageUrl);
		System.out.println(suggestion);
		PageSuggestions sug = new PageSuggestions(pageUrl, suggestion);
		return pageSuggestionsRepo.save(sug);

	}

	@PostMapping("/all")
	public List<PageSuggestions> get_all_with_same_url(@RequestBody Map<String, String> urlMap) {
		String url = urlMap.get("pageUrl");
		return pageSuggestionsRepo.findAllByPageUrl(url);
	}

}
