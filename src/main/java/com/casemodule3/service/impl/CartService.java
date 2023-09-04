package com.casemodule3.service.impl;

import com.casemodule3.DAO.impl.CartDAO;
import com.casemodule3.model.Cart;
import com.casemodule3.service.IGenerateService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class CartService implements IGenerateService<Cart> {
   private static CartService cartService;
    public static CartService getInstance(){
        if (cartService == null){
            cartService = new CartService();
        }
        return cartService;
    }
    @Override
    public List<Cart> findAll() {
        return CartDAO.getInstance().findAll();
    }

    @Override
    public Cart findOne(HttpServletRequest request) {
        int idCart = Integer.parseInt(request.getParameter("idCart"));
        return CartDAO.getInstance().findOne(idCart);
    }

    @Override
    public void create(HttpServletRequest request) {


    }

    @Override
    public void delete(HttpServletRequest request) {
        int idAccount = Integer.parseInt(request.getParameter("idUser"));
        CartDAO.getInstance().delete(idAccount);
    }

    @Override
    public void update(HttpServletRequest request) {

    }
    public List<Cart> listCartByIdAccount(HttpServletRequest request){
        int idUser = Integer.parseInt(request.getParameter("idUser"));
        request.setAttribute("idUser",idUser);
        List<Cart> carts = new ArrayList<>();
        for (Cart cart:findAll()){
            if (cart.getIdAccount() == idUser){
                carts.add(cart);
            }
        }
        return carts;
    }
}
