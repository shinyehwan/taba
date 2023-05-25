package com.example.demo.src.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.utils.JwtService;

@RestController
@RequestMapping("/app/users")
public class CompanyController {
	@Autowired
	private CompanyService companyService;
	@Autowired
	private final JwtService jwtService;

	public CompanyController(CompanyService companyService, JwtService jwtService) {
		this.companyService = companyService;
		this.jwtService = jwtService;
	}



	// @ResponseBody
	// @PostMapping("/search")


}
