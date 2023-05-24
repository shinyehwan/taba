package com.example.demo.src.company;

import static com.example.demo.config.BaseResponseStatus.*;

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

	@ResponseBody
	@GetMapping("/{userIdx}/{companyIdx}")
	public BaseResponse<List<GetCompanyRes>> getCompanyInfo(
		@PathVariable("userIdx") Integer userIdx,
		@PathVariable("companyIdx") Integer companyIdx) {
		try {
			//jwt에서 idx 추출.
			int userIdxByJwt = jwtService.getUserIdx();
			//userIdx와 접근한 유저가 같은지 확인
			if( userIdx != userIdxByJwt){
				return new BaseResponse<>(INVALID_USER_JWT);
			}
			List<GetCompanyRes> getCompanyRes = companyService.getCompany(companyIdx);
			return new BaseResponse<>(getCompanyRes);
		} catch (BaseException exception) {
			return new BaseResponse<>((exception.getStatus()));
		}


	}

}
