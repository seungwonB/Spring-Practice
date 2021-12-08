package edu.hallym.w13;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StdMapper implements RowMapper<Student>{
	
	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException{
		
		Student std = new Student();
		std.setSeq(rs.getInt("seq"));
		std.setId(rs.getString("id"));
		std.setName(rs.getString("name"));
		std.setAge(rs.getInt("age"));
		
		return std;
	}
}
