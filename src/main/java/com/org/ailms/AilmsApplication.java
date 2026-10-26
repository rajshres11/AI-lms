package com.org.ailms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class AilmsApplication {

	public static void main(String[] args) {
		// System.out.println("start" +" " +new BCryptPasswordEncoder().encode("Shresth123"));
		// System.out.println("end");
		SpringApplication.run(AilmsApplication.class, args);
	}

}
