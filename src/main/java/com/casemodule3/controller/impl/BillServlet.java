package com.casemodule3.controller.impl;

import com.casemodule3.DAO.impl.CartDAO;
import com.casemodule3.DAO.impl.PetDAO;
import com.casemodule3.DAO.impl.UserDAO;
import com.casemodule3.controller.IGenerateServlet;
import com.casemodule3.model.Bill;
import com.casemodule3.model.Cart;
import com.casemodule3.model.Pet;
import com.casemodule3.model.User;
import com.casemodule3.service.impl.BillService;
import com.casemodule3.service.impl.CartService;
import com.casemodule3.service.impl.PetService;
import com.casemodule3.service.impl.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BillServlet", value = "/bills")
public class BillServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "":
                display(request, response);
                break;
            case "bill":
                bill(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
//        if (action == null) {
//            action = "";
//        }
        switch (action) {
            case "createUser":
                createUserPost(request, response);
                break;
        }
    }

    public void display(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        List<Cart> carts = CartService.getInstance().listCartByIdAccount(request);
        request.setAttribute("carts", carts);
        RequestDispatcher rs = request.getRequestDispatcher("bill.jsp");
        rs.forward(request, response);

    }


    public void bill(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idAccount = Integer.parseInt(request.getParameter("idUser"));
        User user = UserDAO.getInstance().checkIdAccount(idAccount);
        if (user == null) {
            request.setAttribute("idAccount", idAccount);
            RequestDispatcher rd = request.getRequestDispatcher("user.jsp");
            rd.forward(request, response);
        } else {
            BillService.getInstance().create(request);
            List<Cart> carts = CartService.getInstance().listCartByIdAccount(request);
            List<Pet> pets = PetService.getInstance().findAll();

            for (Cart cart : carts) {
                for (Pet pet : pets) {
                    if (cart.getPet().getIdPet() == pet.getIdPet()) {
                        int quantity = pet.getQuantity() - cart.getQuantity();
                        Pet pet1 = new Pet(pet.getIdPet(), pet.getNamePet(), pet.getPrice(), pet.getSpecies(), pet.getColor(), pet.getMale(), pet.getVaccination(), pet.getDeWorming(), pet.getHealth(), quantity, pet.getStatus(), pet.getSource(), pet.getImage());
                        PetDAO.getInstance().update(pet1);
                    }
                }
            }
            CartService.getInstance().delete(request);
            RequestDispatcher rd = request.getRequestDispatcher("/hoa_don.jsp");
            rd.forward(request, response);
        }
    }


    public void createUserPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService.getInstance().create(request);
        RequestDispatcher rd = request.getRequestDispatcher("/pets");
        rd.forward(request, response);
//        response.sendRedirect("/pets");
    }


    public void updateGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    public void updatePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}