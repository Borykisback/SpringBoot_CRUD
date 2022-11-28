package ru.kiselev.crudApp.SpringBoot_CRUD.dao;


import ru.kiselev.crudApp.SpringBoot_CRUD.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    List<User> listUsers();
    void delete(Long id);
    void update(User user, Long id);
    User show(Long id);
}
