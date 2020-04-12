package com.in.salamtrend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@EnableSwagger2
@ComponentScan
public class SalamTrendBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalamTrendBackendApplication.class, args);
	}

}
