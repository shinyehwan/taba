package com.example.demo.src.company;

import static com.example.demo.config.BaseResponseStatus.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.config.BaseException;
import com.example.demo.src.user.model.GetUserMyPageRes;
import com.example.demo.utils.JwtService;

@Service
public class CompanyService {
	private final CompanyDao companyDao;
	private final JwtService jwtService;

	@Autowired
	public CompanyService(CompanyDao companyDao, JwtService jwtService) {
		this.companyDao = companyDao;
		this.jwtService = jwtService;
	}

	public List<GetUserMyPageRes> getCompany(int userIdx) throws BaseException {
		try {
			List<GetUserMyPageRes> getUserMyPageRes = companyDao.getCompany(userIdx);
			return getUserMyPageRes;
		} catch (Exception exception) {
			throw new BaseException(DATABASE_ERROR);
		}
	}
}
