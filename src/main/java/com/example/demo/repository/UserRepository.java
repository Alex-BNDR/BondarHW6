package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Scanner;

@Repository
public class UserRepository {
    Scanner scanner = new Scanner(System.in);

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public User findId(Long id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    public void saveUser() {

        System.out.println("Enter user first name: ");
        String inputFirstName = scanner.next();

        System.out.println("Enter user last name: ");
        String inputLastName = scanner.next();

        System.out.println("Enter user age: ");
        int inputAge = scanner.nextInt();

        System.out.println("Enter user gender: ");
        String inputGender = scanner.next();

        entityManager.persist(new User(inputFirstName, inputLastName, inputAge, inputGender));

        System.out.println("Inputted user is added to table.");
    }

    @Transactional
    public void updateUser() {
        System.out.println("Enter user id what you want to update".toUpperCase());
        Long inputId = scanner.nextLong();
        User user = findId(inputId);
        if (user == null) {
            System.out.println("User not found");
            System.exit(0);
        } else {

            System.out.println("Enter user first name: ");
            String inputFirstName = scanner.next();

            System.out.println("Enter user last name: ");
            String inputLastName = scanner.next();

            System.out.println("Enter user age: ");
            int inputAge = scanner.nextInt();

            System.out.println("Enter user gender: ");
            String inputGender = scanner.next();

            entityManager.merge(new User(inputId, inputFirstName, inputLastName, inputAge, inputGender));

            System.out.println("User updated.");
        }
    }

    @Transactional
    public void findUserById() {
        System.out.println("User id: ");
        Long inputUserId = scanner.nextLong();
        User user = findId(inputUserId);
        if (user == null) {
            System.out.println("User not found");
        } else {
            System.out.println(user);
        }
    }

    @Transactional
    private User findByFirstAndLastName(String inputFirstName, String inputLastName) {
        Query selectByFirstNameAndLastName = entityManager.createQuery("SELECT user FROM User user WHERE user.firstName =: firstName AND user.lastName =: lastName");
        selectByFirstNameAndLastName.setParameter("firstName", inputFirstName);
        selectByFirstNameAndLastName.setParameter("lastName", inputLastName);
        return (User) selectByFirstNameAndLastName.getSingleResult();

    }

    @Transactional
    public void findUserByFirstAndLastName() {
        System.out.println("Enter user first name: ");
        String inputFirstName = scanner.next();

        System.out.println("Enter user last name: ");
        String inputLastName = scanner.next();

        Query selectByFirstNameAndLastName = entityManager.createQuery("SELECT user FROM User user WHERE user.firstName =: firstName AND user.lastName =: lastName");
        selectByFirstNameAndLastName.setParameter("firstName", inputFirstName);
        selectByFirstNameAndLastName.setParameter("lastName", inputLastName);

        User user = findByFirstAndLastName(inputFirstName, inputLastName);

        System.out.println(user);;
    }

    @Transactional
    public void deleteByFirstAndLastName() {

        System.out.println("Enter user first name: ");
        String inputFirstName = scanner.next();

        System.out.println("Enter user last name: ");
        String inputLastName = scanner.next();

        User user = findByFirstAndLastName(inputFirstName, inputLastName);

        if (user != null) {
            entityManager.remove(user);
        } else
            System.out.println("specified user not found");
    }

    @Transactional
    public void deleteId() {
        System.out.println("User id :");
        Long inputUserId = scanner.nextLong();
        User user = findId(inputUserId);
        if (user == null) {
            System.out.println("User not found");
        } else {
            entityManager.remove(user);
            System.out.println("User deleted");
        }
    }

    @Transactional
    public List<User> getAllUsers() {
        Query selectAllUser = entityManager.createQuery("SELECT user FROM User user");
        return selectAllUser.getResultList();
    }

}
