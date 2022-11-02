package com.example.demo;

import com.example.demo.menu.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@AutoConfiguration
public class BondarHw6Application implements CommandLineRunner{
	@Autowired
	public Menu menu;

	public static void main(String[] args) {
		SpringApplication.run(BondarHw6Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		menu.showMenu();
	}

}
