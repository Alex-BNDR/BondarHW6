package com.example.demo.menu;

import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Scanner;

@Repository
public class MenuImplements implements Menu {
    @Autowired
    UserRepository userRepository;
    private  String[] items = {"""
          1. Create and save user
          
          2. Update user
          
          3. Find user by id
          
          4. Find user by name
          
          5. Delete user by id
          
          6. Delete user by name
          
          7. Get info about all users
          
          0. Exit
          
          """};

    @Override
    public void showMenu() {
        showItems(items);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int m = scanner.nextInt();

            switch (m) {
                case 1:
                    userRepository.saveUser();
                    showMenu();
                case 2:
                    userRepository.updateUser();
                    showMenu();
                case 3:
                    userRepository.findUserById();
                    showMenu();
                case 4:
                    userRepository.findUserByFirstAndLastName();
                    showMenu();
                case 5:
                    userRepository.deleteId();
                    showMenu();
                case 6:
                    userRepository.deleteByFirstAndLastName();
                    showMenu();
                case 7:
                    userRepository.getAllUsers().forEach(System.out::println);
                    showMenu();
                case 0:
                    exit();
                    break;
            }
        }
    }

    @Override
    public void exit() {
        System.exit(0);
    }
}
