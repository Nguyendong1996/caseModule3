package com.casemodule3.controller.impl;

import com.casemodule3.DAO.impl.AccountDAO;
import com.casemodule3.model.Account;
import com.casemodule3.service.impl.AccountService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/logins")
public class LoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "":
                disPlay(request,response);
                break;
            case "login":
                loginGet(request,response);
                break;
            case "register":
                registerGet(request,response);
                break;



        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "login":
                loginPost(request, response);
                break;
            case "register":
                registerPost(request, response);
                break;

        }
    }
    public void disPlay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rq = request.getRequestDispatcher("index.jsp");
        rq.forward(request,response);
    }

    public void loginPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Account account = AccountService.getInstance().findOne(request);
        if (account == null) {
            RequestDispatcher rq = request.getRequestDispatcher("/login/login.jsp");
            request.setAttribute("mess","Tài khoản hoặc mật khẩu không chính xác!");
            rq.forward(request,response);
        } else {
            response.sendRedirect("index.jsp");
        }

    }
    public void registerPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String re_password = request.getParameter("re_password");
        if (!password.equals(re_password)) {
            request.setAttribute("errorPass","Mật khẩu bạn nhập không giống nhau");
            RequestDispatcher rq = request.getRequestDispatcher("/login/register.jsp");
            rq.forward(request,response);
        }
        else {
            Account account = AccountDAO.getInstance().checkAccountExist(username);
            if (account != null) {
                request.setAttribute("errorUsername","Tài khoản đã tồn tại");
                RequestDispatcher rq = request.getRequestDispatcher("/login/register.jsp");
                rq.forward(request,response);

            } else {
                AccountService.getInstance().create(request);
                response.sendRedirect("index.jsp");

            }
        }

    }
    public void loginGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rq = request.getRequestDispatcher("/login/login.jsp");
        rq.forward(request,response);

    }
    public void registerGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rq = request.getRequestDispatcher("/login/register.jsp");
        rq.forward(request,response);

    }

}
