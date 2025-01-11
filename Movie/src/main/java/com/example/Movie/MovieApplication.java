package com.example.Movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MovieApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext=SpringApplication.run(MovieApplication.class, args);

	}

}
