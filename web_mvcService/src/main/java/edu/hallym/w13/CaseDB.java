package edu.hallym.w13;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class CaseDB {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	// 케이스 조회 리스트-전체
	public List<Case> select() {
		String sql = "select * from case_legal";
		List<Case> std = jdbcTemplate.query(sql, new CaseMapper());
		return std;
	}

	public List<Case> select1() {
		String sql = "select * from case_legal where case_day >= 20210101";
		List<Case> std = jdbcTemplate.query(sql, new CaseMapper());
		return std;
	}
	
	public List<Case> select2() {
		String sql = "select * from case_legal where case_day >= 20200101 and case_day < 20210101";
		List<Case> std = jdbcTemplate.query(sql, new CaseMapper());
		return std;
	}

	public List<Case> select3() {
		String sql = "select * from case_legal where case_day >= 20190001 and case_day < 20200101";
		List<Case> std = jdbcTemplate.query(sql, new CaseMapper());
		return std;
	}

	// 개별 조회
	public Case select(int seq) {
		String sql = "select * from case_legal where seq=?";
		Case ce = jdbcTemplate.queryForObject(sql, new Object[] { seq }, new CaseMapper());
		return ce;
	}

	public int delete(int seq) {
		String sql = "delete from case_legal where seq=?";
		return jdbcTemplate.update(sql, seq);
	}
}
