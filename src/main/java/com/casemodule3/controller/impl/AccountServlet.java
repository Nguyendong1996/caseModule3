package com.casemodule3.controller.impl;


import com.casemodule3.model.Account;
import com.casemodule3.model.Pet;
import com.casemodule3.model.Species;
import com.casemodule3.service.impl.AccountService;
import com.casemodule3.service.impl.PetService;
import com.casemodule3.service.impl.SpeciesService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AccountServlet", value = "/accounts")
public class AccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "display":
                display(request,response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "update":
                updateGet(request,response);
                break;
            case "detail":
                detail(request,response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "update":
                updatePost(request, response);
                break;

        }
    }


    public void display(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        List<Account> accounts = AccountService.getInstance().findAll();
        request.setAttribute("accounts", accounts);
        RequestDispatcher rd = request.getRequestDispatcher("account/display.jsp");
        rd.forward(request, response);
    }

    public void updateGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Account account = AccountService.getInstance().findOne(request);
        request.setAttribute("account", account);
        RequestDispatcher rd = request.getRequestDispatcher("account/update.jsp");
        rd.forward(request, response);
    }


    public void updatePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AccountService.getInstance().update(request);
        request.setAttribute("update", "Bạn vừa cập nhật thành công");
        detail(request,response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AccountService.getInstance().delete(request);
        display(request,response);
    }
    public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Account account = AccountService.getInstance().findOne(request);
        request.setAttribute("account", account);
        RequestDispatcher rq = request.getRequestDispatcher("/account/detail.jsp");
        rq.forward(request, response);
    }
}
