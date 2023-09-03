package com.casemodule3.service.impl;

import com.casemodule3.DAO.impl.CartDAO;
import com.casemodule3.model.Cart;
import com.casemodule3.service.IGenerateService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CartService implements IGenerateService<Cart> {
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

    }

    @Override
    public void update(HttpServletRequest request) {

    }
}
