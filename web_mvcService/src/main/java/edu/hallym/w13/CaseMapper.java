package edu.hallym.w13;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CaseMapper implements RowMapper<Case>{
	
	@Override
	public Case mapRow(ResultSet rs, int rowNum) throws SQLException{
		Case std = new Case();
		std.setSeq(rs.getInt("seq"));
		std.setCase_day(rs.getString("case_day"));
		std.setCase_court(rs.getString("case_court"));
		std.setCase_name(rs.getString("case_name"));
		std.setCase_order(rs.getString("case_order"));
		std.setCase_main(rs.getString("case_main"));
		
		return std;
	}
}
