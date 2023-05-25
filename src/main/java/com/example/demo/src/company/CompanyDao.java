package com.example.demo.src.company;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.src.user.model.GetUserMyPageRes;

@Repository
public class CompanyDao {
	private JdbcTemplate jdbcTemplate;
	@Autowired //readme 참고
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public List<GetUserMyPageRes> getCompany(int userIdx) {
		String getCompanyQuery = "select companyName, page, days, UserCompany.createdAt, UserCompany.updatedAt\n"
			+ "from User, UserCompany, Company\n"
			+ "where User.userIdx = UserCompany.userIdx and\n"
			+ "      UserCompany.companyIdx = Company.companyIdx and\n"
			+ "      User.userIdx = ?"; // 해당 userIdx를 만족하는 유저를 조회하는 쿼리문
		int getCompanyParams = userIdx;
		return this.jdbcTemplate.query(getCompanyQuery,
			(rs, rowNum) -> new GetUserMyPageRes(
				rs.getString("companyName"),
				rs.getInt("page"),
				rs.getInt("days"),
				rs.getString("created_at"),
				rs.getString("updated_at")
			),// RowMapper(위의 링크 참조): 원하는 결과값 형태로 받기
			getCompanyParams); // 한 개의 회원정보를 얻기 위한 jdbcTemplate 함수(Query, 객체 매핑 정보, Params)의 결과 반환
	}

}
