package com.example.demo.src.company;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.company.model.GetCompanyRes;
import com.example.demo.src.user.model.GetUserRes;
import com.example.demo.utils.JwtService;

@RestController
@RequestMapping("/app/company")
public class CompanyController {
	@Autowired
	private CompanyService companyService;
	@Autowired
	private final JwtService jwtService;

	public CompanyController(CompanyService companyService, JwtService jwtService) {
		this.companyService = companyService;
		this.jwtService = jwtService;
	}

	@ResponseBody
	@GetMapping("/{companyIdx}")
	public BaseResponse<List<GetCompanyRes>> getCompanyInfo(
		@PathVariable("companyIdx") Integer companyIdx) {
		try {
			List<GetCompanyRes> getCompanyRes = companyService.getCompany(companyIdx);
			return new BaseResponse<>(getCompanyRes);
		} catch (BaseException exception) {
			return new BaseResponse<>((exception.getStatus()));
		}


	}

}
