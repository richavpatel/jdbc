package com.richa.jdbctemplate.repository;

import com.richa.jdbctemplate.model.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentJdbcRepository {
    final
    JdbcTemplate jdbcTemplate;

    public StudentJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    class StudentRowMapper implements RowMapper<Student> {

        @Override
        public Student mapRow(ResultSet resultSet, int i) throws SQLException {
            Student student = new Student();
            student.setId(resultSet.getLong("id"));
            student.setName(resultSet.getString("name"));
            student.setPassportNumber(resultSet.getString("passport_number"));
            return student;
        }

    }

    public List<Student> findAll() {
        return jdbcTemplate.query("Select * from student", new StudentRowMapper());
    }

    public Student findById(long id) {
        return jdbcTemplate.queryForObject("select * from student where id = ?", new Object[]
                {id}, new BeanPropertyRowMapper<Student>(Student.class));
    }

    public int insert(Student student) {
        return jdbcTemplate.update("insert into student (id ,name, passport_number)" + "values(?,?,?)",
                new Object[]{student.getId(), student.getName(), student.getPassportNumber()});
    }

    public int update(Student student) {
        return jdbcTemplate.update("update student " + " set name = ? ,passport_number = ? " + " where id = ?",
                new Object[]{student.getName(), student.getPassportNumber(), student.getId()});
    }

    public int delete(long id) {
        return jdbcTemplate.update("delete from student where id = ?",
                new Object[]{id});
    }

}
