package com.casemodule3.DAO.impl;

import com.casemodule3.DAO.IGenerateDAO;
import com.casemodule3.model.User;

import java.util.List;

public class UserDAO implements IGenerateDAO<User> {

    private static UserDAO userDAO;
    private UserDAO() {}

    public static UserDAO getInstance() {
        if (userDAO == null) {
            userDAO = new UserDAO();
        } return userDAO;
    }
    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findOne(int id) {
        return null;
    }

    @Override
    public void create(User user) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(User user) {

    }
}
