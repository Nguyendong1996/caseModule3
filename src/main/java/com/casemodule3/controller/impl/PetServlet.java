package com.casemodule3.controller.impl;

import com.casemodule3.controller.IGenerateServlet;
import com.casemodule3.model.Pet;
import com.casemodule3.model.Species;
import com.casemodule3.service.IGenerateService;
import com.casemodule3.service.impl.PetService;
import com.casemodule3.service.impl.SpeciesService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PetServlet", value = "/pets")
public class PetServlet extends HttpServlet implements IGenerateServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "":
                disPlay(request, response);
                break;
            case "create":
                createGet(request, response);
                break;
            case "update":
                updateGet(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createPost(request, response);
                break;
            case "update":
                updatePost(request, response);
                break;
        }
    }


    @Override
    public void disPlay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Pet> pets = PetService.getInstance().findAll();
        request.setAttribute("pets", pets);
        RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
        rd.forward(request, response);
    }

    @Override
    public void createGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Species> species = SpeciesService.getInstance().findAll();
//        request.setAttribute("species", species);
        RequestDispatcher rd = request.getRequestDispatcher("pet/create.jsp");
        rd.forward(request, response);
//        response.sendRedirect("pet/create.jsp");
    }

    @Override
    public void createPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PetService.getInstance().create(request);
        RequestDispatcher rd = request.getRequestDispatcher("/pets");
        rd.forward(request, response);

    }

    @Override
    public void updateGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Pet pet = PetService.getInstance().findOne(request);
        List<Species> species = SpeciesService.getInstance().findAll();
        request.setAttribute("pet", pet);
        request.setAttribute("species", species);
        RequestDispatcher rd = request.getRequestDispatcher("pet/update.jsp");
        rd.forward(request, response);
    }

    @Override
    public void updatePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PetService.getInstance().update(request);
        response.sendRedirect("/pets");
    }

    @Override
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PetService.getInstance().delete(request);
        response.sendRedirect("/pets");
    }
}