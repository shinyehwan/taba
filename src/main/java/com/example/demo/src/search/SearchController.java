package com.example.demo.src.search;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.BaseResponse;
import com.example.demo.utils.JwtService;

@RestController
@RequestMapping("/search")
public class SearchController {
	final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private final SearchService searchService;
	@Autowired
	private final JwtService jwtService;

	public SearchController(SearchService searchService, JwtService jwtService) {
		this.searchService = searchService;
		this.jwtService = jwtService;
	}

	// @ResponseBody
	// @PostMapping("")
	// public BaseResponse<>

}
