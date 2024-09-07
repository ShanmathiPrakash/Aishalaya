package com.example.RealEstateCRM;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.RealEstateCRM.repository")
public class  RealEstateCrmApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(RealEstateCrmApplication.class, args);
	}

}

