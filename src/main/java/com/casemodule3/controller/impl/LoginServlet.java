package com.casemodule3.controller.impl;

import com.casemodule3.DAO.impl.AccountDAO;
import com.casemodule3.model.Account;
import com.casemodule3.model.Pet;
import com.casemodule3.service.impl.AccountService;
import com.casemodule3.service.impl.PetService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/logins")
public class LoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
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
        RequestDispatcher rq = request.getRequestDispatcher("home.jsp");
        rq.forward(request,response);
    }

    public void loginPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Account account = AccountService.getInstance().findOne(request);
        if (account == null) {
            RequestDispatcher rq = request.getRequestDispatcher("login.jsp");
            request.setAttribute("mess","Tài khoản hoặc mật khẩu không chính xác!");
            rq.forward(request,response);
        } else {
            List<Pet> pets = PetService.getInstance().findAll();
            request.setAttribute("pets",pets);
            HttpSession session = request.getSession();
            session.setAttribute("account", account);
//            RequestDispatcher rq = request.getRequestDispatcher("/pet/displayAdmin.jsp");
//            rq.forward(request,response);
            RequestDispatcher rq = request.getRequestDispatcher("home.jsp");
            rq.forward(request,response);
        }

    }
    public void registerPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String re_password = request.getParameter("re_password");
        if (!password.equals(re_password)) {
            request.setAttribute("errorPass","Mật khẩu bạn nhập không giống nhau");
            RequestDispatcher rq = request.getRequestDispatcher("register.jsp");
            rq.forward(request,response);
        }
        else {
            Account account = AccountDAO.getInstance().checkAccountExist(username);
            if (account != null) {
                request.setAttribute("errorUsername","Tài khoản đã tồn tại");
                RequestDispatcher rq = request.getRequestDispatcher("register.jsp");
                rq.forward(request,response);

            } else {
                AccountService.getInstance().create(request);
                request.setAttribute("success","Bạn đã đăng ký tài khoản thành công!");
                RequestDispatcher rq = request.getRequestDispatcher("login.jsp");
                rq.forward(request,response);

            }
        }

    }
    public void loginGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rq = request.getRequestDispatcher("login.jsp");
        rq.forward(request,response);

    }
    public void registerGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rq = request.getRequestDispatcher("register.jsp");
        rq.forward(request,response);

    }

}
