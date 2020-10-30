package edu.miu.cs.cs544.eafinalproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
//@EnableWebSecurity
public class EaFinalProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(EaFinalProjectApplication.class, args);
	}

}
