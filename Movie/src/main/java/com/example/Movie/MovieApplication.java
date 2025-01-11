package com.example.Movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
//Fisrt Comment from Githup online
@SpringBootApplication
public class MovieApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext=SpringApplication.run(MovieApplication.class, args);

	}

}
