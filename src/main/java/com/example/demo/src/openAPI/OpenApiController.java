package com.example.demo.src.openAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OpenApiController {

	@Autowired
	private OpenApiService openApiService;

	// @CrossOrigin(origins = "https://localhost:3000")
	@GetMapping("/openapi")
	public String getOpenApiData() {
		return openApiService.callOpenApi();
	}
}