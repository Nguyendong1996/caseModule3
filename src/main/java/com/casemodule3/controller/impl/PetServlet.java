package com.casemodule3.controller.impl;

import com.casemodule3.DAO.impl.CartDAO;
import com.casemodule3.DAO.impl.PetDAO;
import com.casemodule3.controller.IGenerateServlet;
import com.casemodule3.model.Bill;
import com.casemodule3.model.Cart;
import com.casemodule3.model.Pet;
import com.casemodule3.model.Species;
import com.casemodule3.service.IGenerateService;
import com.casemodule3.service.impl.CartService;
import com.casemodule3.service.impl.PetService;
import com.casemodule3.service.impl.SpeciesService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
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
                display(request, response);
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
            case "displayAdmin":
                displayAdmin(request,response);
                break;
            case "detail":
                detail(request,response);
                break;
            case "sortByPriceAS":
                sortByPriceAS(request,response);
                break;
            case "sortByPriceDESC":
                sortByPriceDESC(request,response);
                break;
            case "displayBySpecies":
                displayBySpecies(request,response);
                break;
            case "searchByPrice":
                searchByPrice(request,response);
                break;
            case "cart":
                cart(request,response);
                break;
            case "back":
                backHome(request,response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "create":
                createPost(request, response);
                break;
            case "update":
                updatePost(request, response);
                break;
            case "searchByName":
                searchByName(request,response);
                break;
            case "searchByPrice":
                searchByName(request,response);
                break;

        }
    }


    @Override
    public void display(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Pet> pets = PetService.getInstance().findAll();
        request.setAttribute("pets", pets);
        List<Species> speciesList = SpeciesService.getInstance().findAll();
        request.setAttribute("speciesList", speciesList);
        RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
        rd.forward(request, response);
    }

    @Override
    public void createGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Species> speciesList = SpeciesService.getInstance().findAll();
        request.setAttribute("speciesList", speciesList);
        RequestDispatcher rd = request.getRequestDispatcher("pet/create.jsp");
        rd.forward(request, response);
    }

    @Override
    public void createPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PetService.getInstance().create(request);
        request.setAttribute("create", "Bạn vừa thêm 1 sản phẩm thành công");
        displayAdmin(request,response);

    }

    @Override
    public void updateGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Pet pet = PetService.getInstance().findOne(request);
        List<Species> speciesList = SpeciesService.getInstance().findAll();
        request.setAttribute("pet", pet);
        request.setAttribute("speciesList", speciesList);
        RequestDispatcher rd = request.getRequestDispatcher("pet/update.jsp");
        rd.forward(request, response);
    }

    @Override
    public void updatePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PetService.getInstance().update(request);
        request.setAttribute("update", "Bạn vừa cập nhật 1 sản phẩm thành công");
        displayAdmin(request,response);
    }

    @Override
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PetService.getInstance().delete(request);
        displayAdmin(request,response);

    }
    public void displayAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Pet> pets = PetService.getInstance().findAll();
        request.setAttribute("pets", pets);
        List<Species> speciesList = SpeciesService.getInstance().findAll();
        request.setAttribute("speciesList", speciesList);
        RequestDispatcher rd = request.getRequestDispatcher("pet/displayAdmin.jsp");
        rd.forward(request, response);
    }
    public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Pet pet = PetService.getInstance().findOne(request);
        request.setAttribute("pet", pet);
        RequestDispatcher rq = request.getRequestDispatcher("/pet/detail.jsp");
        rq.forward(request, response);
    }
    public void searchByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Pet> pets = PetService.getInstance().searchByName(request);
        request.setAttribute("pets", pets);
        List<Species> speciesList = SpeciesService.getInstance().findAll();
        request.setAttribute("speciesList", speciesList);
        RequestDispatcher rq = request.getRequestDispatcher("home.jsp");
        rq.forward(request, response);
    }

    public void searchByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Pet> pets = PetService.getInstance().searchByPrice(request);
        request.setAttribute("pets", pets);
        List<Species> speciesList = SpeciesService.getInstance().findAll();
        request.setAttribute("speciesList", speciesList);
        RequestDispatcher rq = request.getRequestDispatcher("home.jsp");
        rq.forward(request, response);
    }

    public void sortByPriceAS(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Pet> pets = PetService.getInstance().sortByPriceAS(request);
        request.setAttribute("pets", pets);
        List<Species> speciesList = SpeciesService.getInstance().findAll();
        request.setAttribute("speciesList", speciesList);
        RequestDispatcher rq = request.getRequestDispatcher("home.jsp");
        rq.forward(request, response);
    }
    public void sortByPriceDESC(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Pet> pets = PetService.getInstance().sortByPriceDESC(request);
        request.setAttribute("pets", pets);
        List<Species> speciesList = SpeciesService.getInstance().findAll();
        request.setAttribute("speciesList", speciesList);
        RequestDispatcher rq = request.getRequestDispatcher("home.jsp");
        rq.forward(request, response);
    }
    public void displayBySpecies(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Pet> pets = PetService.getInstance().getPetsBySpecies(request);
        request.setAttribute("pets", pets);
        List<Species> speciesList = SpeciesService.getInstance().findAll();
        request.setAttribute("speciesList", speciesList);
        RequestDispatcher rq = request.getRequestDispatcher("home.jsp");
        rq.forward(request, response);
    }
    public void cart(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        int idPet = Integer.parseInt(request.getParameter("idPet"));
        int idUser = Integer.parseInt(request.getParameter("idUser"));
        Pet pet = PetDAO.getInstance().findOne(idPet);
        List<Cart> carts = CartService.getInstance().findAll();
        int quantity = 0;
        double totalPrice;
        double price = pet.getPrice();
        int idBill =0;
        int idCart = 0 ;

        boolean flag = false;
        for (Cart cart:carts){
            if (cart.getPet().getIdPet()== idPet&& idUser == cart.getIdAccount()){
                flag = true;
                quantity = cart.getQuantity() +1;
                idCart = cart.getIdCart();
            }
        }
        if (flag){
            totalPrice = quantity*pet.getPrice();
            Cart cart = new Cart(idCart,idBill,pet,quantity,price,totalPrice,idUser);
CartDAO.getInstance().update(cart);
        }
        else {
            quantity = quantity +1;
            totalPrice = quantity*pet.getPrice();
            Cart cart = new Cart(idBill,pet,quantity,price,totalPrice,idUser);
            CartDAO.getInstance().create(cart);
        }
response.sendRedirect("/pets");
    }
    public void backHome(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.sendRedirect("/pets");


    }

}