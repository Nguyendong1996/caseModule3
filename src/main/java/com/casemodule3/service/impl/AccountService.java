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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        return AccountDAO.getInstance().login(username,password);
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

    }

    @Override
    public void update(HttpServletRequest request) {

    }
//    public Account register(HttpServletRequest request) {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        String re_password = request.getParameter("re_password");
//        if (!password.equals(re_password)) {
//            request.setAttribute("errorPass","Mật khẩu bạn nhập không giống nhau");
//            RequestDispatcher rq = request.getRequestDispatcher("/login/register.jsp");
//        }
//        else {
//            Account account = AccountDAO.getInstance().checkAccountExist(username);
//            if (account == null) {
//                request.setAttribute("errorUsername","Tài khoản đã tồn tại");
//                RequestDispatcher rq = request.getRequestDispatcher("/login/register.jsp");
//
//            } else {
//
//            }
//        }

//    }

}
