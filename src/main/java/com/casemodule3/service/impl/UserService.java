package com.casemodule3.service.impl;

import com.casemodule3.model.User;
import com.casemodule3.service.IGenerateService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class UserService implements IGenerateService<User> {
    private static UserService userService;

    private UserService() {};
    public static UserService getInstance() {
        if(userService == null) {
            userService = new UserService();
        } return userService;
    }
    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findOne(HttpServletRequest request) {
        return null;
    }

    @Override
    public void create(HttpServletRequest request) {

    }

    @Override
    public void delete(HttpServletRequest request) {

    }

    @Override
    public void update(HttpServletRequest request) {

    }
}
