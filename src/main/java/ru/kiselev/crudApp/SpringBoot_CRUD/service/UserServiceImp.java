package ru.kiselev.crudApp.SpringBoot_CRUD.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kiselev.crudApp.SpringBoot_CRUD.dao.UserDao;
import ru.kiselev.crudApp.SpringBoot_CRUD.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService{

    private final UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
      return userDao.listUsers();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Override
    @Transactional
    public void update(User user, Long id) {
        userDao.update(user, id);
    }

    @Override
    @Transactional
    public User show(Long id) {
        return userDao.show(id);
    }

}
