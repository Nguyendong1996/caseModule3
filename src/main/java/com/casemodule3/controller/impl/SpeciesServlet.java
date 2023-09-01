package com.casemodule3.controller.impl;

import com.casemodule3.controller.IGenerateServlet;
import com.casemodule3.model.Species;
import com.casemodule3.service.impl.SpeciesService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SpeciesServlet", value = "/species")
public class SpeciesServlet extends HttpServlet implements IGenerateServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String action = request.getParameter("action");
if (action== null){
    action= "";
}switch (action){
            case "":
                disPlay(request,response);
                break;
            case "create":
                createGet(request,response);
                break;
            case "update":
                updateGet(request,response);
                break;
            case "delete":
                delete(request,response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String action = request.getParameter("action");
if (action == null){
    action = "";
}switch (action){
            case "create":
                createPost(request,response);
                break;
            case "update":
                updatePost(request,response);
                break;
        }
    }

    @Override
    public void disPlay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Species> speciesList = SpeciesService.getInstance().findAll();
        request.setAttribute("species", speciesList);
        RequestDispatcher rd = request.getRequestDispatcher("species/displayAdmin.jsp");
        rd.forward(request, response);
    }

    @Override
    public void createGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("species/create.jsp");
      rd.forward(request,response);
    }

    @Override
    public void createPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SpeciesService.getInstance().create(request);
        response.sendRedirect("/species");
    }

    @Override
    public void updateGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Species species = SpeciesService.getInstance().findOne(request);
        request.setAttribute("species", species);
        RequestDispatcher rd = request.getRequestDispatcher("species/update.jsp");
        rd.forward(request, response);
    }

    @Override
    public void updatePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SpeciesService.getInstance().update(request);
        response.sendRedirect("/species");
    }

    @Override
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SpeciesService.getInstance().delete(request);
        response.sendRedirect("/species");
    }
}