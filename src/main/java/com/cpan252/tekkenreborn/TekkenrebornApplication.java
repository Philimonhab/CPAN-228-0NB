package com.cpan252.tekkenreborn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cpan252.tekkenreborn.controller.HomeController;

@SpringBootApplication
public class TekkenrebornApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(TekkenrebornApplication.class, args);
		HomeController controller = context.getBean(HomeController.class);
	}
}
