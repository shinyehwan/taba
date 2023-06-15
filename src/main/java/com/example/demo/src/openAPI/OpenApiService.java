package com.example.demo.src.openAPI;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenApiService {

	public String callOpenApi() {
		RestTemplate restTemplate = new RestTemplate();
		String apiUrl = "https://apis.data.go.kr/1160100/service/GetStockSecuritiesInfoService?serviceKey=YOUR_API_KEY&likeItmsNm=YOUR_QUERY";
		ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
		return response.getBody();
	}
}