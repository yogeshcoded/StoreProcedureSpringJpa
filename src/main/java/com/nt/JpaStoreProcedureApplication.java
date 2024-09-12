package com.nt;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaStoreProcedureApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaStoreProcedureApplication.class, args);


	}

	@Bean
	public CommandLineRunner runner(OrderService service) {
		return args -> {
			service.fetchOrdersByIds(1,2,3).forEach(System.out::println);
			service.produre(11,12,53).forEach(System.out::println);
		};
	}


}
