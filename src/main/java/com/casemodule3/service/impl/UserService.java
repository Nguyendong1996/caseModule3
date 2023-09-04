package com.casemodule3.service.impl;

import com.casemodule3.DAO.impl.UserDAO;
import com.casemodule3.model.Account;
import com.casemodule3.model.User;
import com.casemodule3.service.IGenerateService;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
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
        Account account = AccountService.getInstance().findOne(request);
String fullName = request.getParameter("fullName");
        LocalDate dob = LocalDate.parse(request.getParameter("dob"));
        String sex = request.getParameter("sex");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        User user = new User(account,fullName,dob,sex,phone,email,address);
        UserDAO.getInstance().create(user);

    }

    @Override
    public void delete(HttpServletRequest request) {

    }

    @Override
    public void update(HttpServletRequest request) {

    }
}
