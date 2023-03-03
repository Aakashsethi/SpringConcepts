package com.NoshVersion01;

import com.NoshVersion01.controller.CalculatorController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication
public class NoshVersion01Application {

	public static void main(String[] args) {
		SpringApplication.run(NoshVersion01Application.class, args);
		System.out.println("hello from App");
		/*CalculatorController cc = new CalculatorController();*/
	}

}
