package com.richa.jdbc;

import com.richa.jdbc.model.Student;
import com.richa.jdbc.repository.StudentJdbcRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JdbcApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	final
	StudentJdbcRepository studentJdbcRepository;

	public JdbcApplication(StudentJdbcRepository studentJdbcRepository) {
		this.studentJdbcRepository = studentJdbcRepository;
	}

	public static void main(String[] args) {

		SpringApplication.run(JdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Find By Id -> {}",studentJdbcRepository.findById(10001));
		logger.info("Inserting 10006L-> {}", studentJdbcRepository.insert(new Student(10006L,"Richa", "A1234")));
		logger.info("Updating 10001 -> {}",studentJdbcRepository.update(new Student(10001L,"tyu","wee")));
		logger.info("All Users -> {}", studentJdbcRepository.findAll());
		studentJdbcRepository.delete(10006L);
		logger.info("All Users -> {}", studentJdbcRepository.findAll());

	}
}
