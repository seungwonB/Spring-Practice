package edu.hallym.w13;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import edu.hallym.w13.StdMapper;
import edu.hallym.w13.Student;

@Component
public class StdDB {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	public void create(Student std) {
		String sql = "INSERT INTO student (id, name, age) values (?, ?, ?)";

		jdbcTemplate.update(sql, std.getId(), std.getName(), std.getAge());
	}

	// 학생 조회 리스트-전체
	public List<Student> select() {
		String sql = "select * from student";
		List<Student> std = jdbcTemplate.query(sql, new StdMapper());
		System.out.println("select 값: " + std);
		return std;
	}

	// 학생 조회 리스트-개별
	public Student select(int seq) {
		String sql = "select * from student where seq=?";
		Student std = jdbcTemplate.queryForObject(sql, new Object[] { seq }, new StdMapper());
		System.out.println("select 값: " + std);
		return std;
	}

	public void update(Student std) {
		String sql = "update student set id=?, name=?, age=? where seq=?";
		jdbcTemplate.update(sql, std.getId(), std.getName(), std.getAge(), std.getSeq());
	}

	public int delete(int seq) {
		String sql = "delete from student where seq=?";
		return jdbcTemplate.update(sql, seq);
	}
}
