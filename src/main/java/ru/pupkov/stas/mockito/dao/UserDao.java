package ru.pupkov.stas.mockito.dao;

import ru.pupkov.stas.mockito.model.User;

public interface UserDao {

    User getUserByUserName(String username) throws Exception;
}
