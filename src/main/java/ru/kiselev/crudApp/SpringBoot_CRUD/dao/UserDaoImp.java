package ru.kiselev.crudApp.SpringBoot_CRUD.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kiselev.crudApp.SpringBoot_CRUD.model.User;

import java.util.List;


@Repository
public class UserDaoImp implements UserDao {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional
    public List<User> listUsers() {
        return entityManager.createQuery("select c from User c").getResultList();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        entityManager.createQuery("DELETE FROM User WHERE id = :idInjection")
                .setParameter("idInjection", id)
                .executeUpdate();
    }

    @Override
    @Transactional
    public void update(User user, Long id) {
        user.setId(id);
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public User show(Long id) {
        return listUsers()
                .stream()
                .filter(i -> i.getId().equals(id))
                .findAny()
                .orElse(null);
    }

}
