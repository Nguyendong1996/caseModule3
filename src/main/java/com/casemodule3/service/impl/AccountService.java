package com.casemodule3.service.impl;

import com.casemodule3.DAO.impl.AccountDAO;
import com.casemodule3.model.Account;
import com.casemodule3.service.IGenerateService;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class AccountService implements IGenerateService<Account> {
    private static AccountService accountService;

    private AccountService(){
        List<Account> accounts = new ArrayList<>();
    };

    public static AccountService getInstance() {
        if (accountService == null) {
            accountService = new AccountService();
        } return accountService;
    }

    @Override
    public List<Account> findAll() {
        return AccountDAO.getInstance().findAll();
    }

    @Override
    public Account findOne(HttpServletRequest request) {
        int idAccount = Integer.parseInt(request.getParameter("idAccount"));
        return AccountDAO.getInstance().findOne(idAccount);
    }

    @Override
    public void create(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Account account = new Account(username,password,false);
        AccountDAO.getInstance().create(account);

    }

    @Override
    public void delete(HttpServletRequest request) {
        int idAccount = Integer.parseInt(request.getParameter("idAccount"));
        AccountDAO.getInstance().delete(idAccount);

    }

    @Override
    public void update(HttpServletRequest request) {
        int idAccount = Integer.parseInt(request.getParameter("idAccount"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Account account = new Account(idAccount,username,password);
        AccountDAO.getInstance().update(account);

    }
    public Account login(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        return AccountDAO.getInstance().login(username,password);
    }

}
