package com.application.videoapplication;

import com.application.videoapplication.user.User;
import com.application.videoapplication.userservice.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VideoApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserService userService) {
		return args ->{
			userService.register(User.builder()
					.username("shubhh123")
					.email("shubh@123.com")
					.password("shubhh123")
					.build()
			);

			userService.register(User.builder()
					.username("Rohit789")
					.email("rohit@123.com")
					.password("rohit123")
					.build()
			);

			userService.register(User.builder()
					.username("Arjun123")
					.email("arjun@email.com")
					.password("arjun123")
					.build()
			);
		};
	}
}
