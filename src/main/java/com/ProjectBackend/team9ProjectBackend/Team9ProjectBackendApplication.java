package com.ProjectBackend.team9ProjectBackend;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
//@EntityScan
@Log
public class Team9ProjectBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(Team9ProjectBackendApplication.class, args);
	}

}
