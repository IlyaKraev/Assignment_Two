package org.pcedu.assignmenttwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class AssignmentTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentTwoApplication.class, args);
	}

}
