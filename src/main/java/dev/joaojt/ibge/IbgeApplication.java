package dev.joaojt.ibge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "dev.joaojt.ibge")
public class IbgeApplication {

	public static void main(String[] args) {
		SpringApplication.run(IbgeApplication.class, args);
	}

}