package com.casemodule3.controller.impl;

import com.casemodule3.controller.IGenerateServlet;
import com.casemodule3.model.Pet;
import com.casemodule3.service.impl.PetService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeServlet", value = "/homes")
public class HomeServlet extends HttpServlet  {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String action = request.getParameter("action");
if (action == null){
    action ="";
}switch (action){
            case "":
                disPlay(request,response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void disPlay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        List<Pet> pets = PetService.getInstance().findAll();
        request.setAttribute("pets", pets);
        RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
        rd.forward(request, response);
    }

    public void createGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void createPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    public void updateGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    public void updatePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}