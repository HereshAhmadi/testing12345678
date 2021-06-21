package com.deerpointgroup.deerpointliquorstore;

import org.springframework.boot.web.servlet.ServletComponentScan;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@ServletComponentScan
@SpringBootApplication
public class DeerpointliquorstoreApplication {
    
	public static void main(String[] args) {
		SpringApplication.run(DeerpointliquorstoreApplication.class, args);
	}

}
