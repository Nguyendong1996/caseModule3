package com.casemodule3.service.impl;

import com.casemodule3.DAO.impl.AccountDAO;
import com.casemodule3.model.Account;
import com.casemodule3.service.IGenerateService;

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
