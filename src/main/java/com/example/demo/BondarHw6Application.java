package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class BondarHw6Application implements CommandLineRunner{
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(BondarHw6Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//userRepository.save(new User(1L,"Oleksii", "Bondar", 21, "female"));
		//userRepository.update(new User(2L,"Anna", "Dynnyk", 21, "female"));
		//userRepository.deleteId(2L);
		//userRepository.deleteByFirstAndLastName("Anna", "Dynnyk");
		//System.out.println(userRepository.findId(1L));
		//System.out.println(userRepository.findByFirstAndLastName("Anna","Dynnyk"));
		//userRepository.getAllUser().forEach(System.out::println);

	}

}
