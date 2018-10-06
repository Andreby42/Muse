package com.muse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@SpringBootApplication
@ServletComponentScan
public class MuseApplication {

	public static void main(String[] args) {
		SpringApplication.run(MuseApplication.class, args);
	}
}
