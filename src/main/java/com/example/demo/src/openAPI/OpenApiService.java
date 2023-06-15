package com.example.demo.src.openAPI;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenApiService {

	public String callOpenApi() {
		RestTemplate restTemplate = new RestTemplate();
		String apiUrl = "https://apis.data.go.kr/1160100/service/GetStockSecuritiesInfoService?serviceKey=5KYbFYzPwjxdKTV1XgxGsTU%2FIG9joJTc8CnTRZyC2mj3c6HrwmglFZpgGQqV0qHnGIBYsO2Or%2BQZAJe0YVvMRA%3D%3D&likeItmsNm=삼성전자";
		ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
		return response.getBody();
	}
}