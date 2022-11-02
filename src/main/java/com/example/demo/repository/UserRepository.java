package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }

    @Transactional
    public void update(User user) {
        entityManager.merge(user);
    }

    public User findId(Long id) {
        return entityManager.find(User.class, id);
    }

    public User findByFirstAndLastName(String firstName, String lastName) {
        Query selectByFirstNameAndLastName = entityManager.createQuery("SELECT user FROM User user WHERE user.firstName =: firstName AND user.lastName =: lastName");
        selectByFirstNameAndLastName.setParameter("firstName", firstName);
        selectByFirstNameAndLastName.setParameter("lastName", lastName);
        return (User) selectByFirstNameAndLastName.getSingleResult();
    }

    @Transactional
    public void deleteByFirstAndLastName(String firstName, String lastName) {
        User user = findByFirstAndLastName(firstName, lastName);
        if (user != null) {
            entityManager.remove(user);
        } else
            System.out.println("specified user not found");
    }

    @Transactional
    public void deleteId(Long id) {
        User user = findId(id);
        if (user != null) {
            entityManager.remove(user);
        } else
            System.out.println("specified user not found");
    }

    public List<User> getAllUser() {
        Query selectAllUser = entityManager.createQuery("SELECT user FROM User user");
        return selectAllUser.getResultList();
    }

}
