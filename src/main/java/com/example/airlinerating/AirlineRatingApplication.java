package com.example.airlinerating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class AirlineRatingApplication {
    private static Environment environment;

    @Autowired
    public AirlineRatingApplication(Environment environment) {
        AirlineRatingApplication.environment = environment;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AirlineRatingApplication.class, args);
        AirlineRatingApplication da = new AirlineRatingApplication(environment);
        da.contextLoads();
    }

    public void contextLoads() throws Exception {
        System.out.println("DemoApplication 실행");
        System.out.println("profile 값 :: " + environment.getProperty("spring.profiles.active"));
        System.out.println("profile 값 environment :: " + environment);
        String username = environment.getProperty("spring.test.username");
        System.out.println("USERNAME :: " + username);
    }

}
