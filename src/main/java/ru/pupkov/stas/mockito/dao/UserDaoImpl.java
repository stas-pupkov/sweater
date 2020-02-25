package ru.pupkov.stas.mockito.dao;

import ru.pupkov.stas.mockito.model.User;

import java.util.List;

public class UserDaoImpl implements UserDao {

    private List<User> users;


    @Override
    public User getUserByUserName(String username) throws Exception {
        return null;
    }
}
