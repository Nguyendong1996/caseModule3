package com.casemodule3.service.impl;

import com.casemodule3.DAO.impl.AccountDAO;
import com.casemodule3.DAO.impl.BillDAO;
import com.casemodule3.DAO.impl.UserDAO;
import com.casemodule3.model.Account;
import com.casemodule3.model.Bill;
import com.casemodule3.model.Cart;
import com.casemodule3.model.User;
import com.casemodule3.service.IGenerateService;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;

public class BillService implements IGenerateService<Bill> {
    private static BillService billService;
    public static BillService getInstance(){
        if (billService == null){
            billService = new BillService();
        }
        return billService;
    }
    @Override
    public List<Bill> findAll() {
        return BillDAO.getInstance().findAll();
    }

    @Override
    public Bill findOne(HttpServletRequest request) {
        int idUser = Integer.parseInt(request.getParameter("idUser"));
       return BillDAO.getInstance().findOne(idUser);
    }

    @Override
    public void create(HttpServletRequest request) {
int idAccount = Integer.parseInt(request.getParameter("idUser"));
        User user = UserDAO.getInstance().checkIdAccount(idAccount);
        int idUser = user.getIdUser();

double totalPayment = 0;
List<Cart> carts = CartService.getInstance().listCartByIdAccount(request);
for (Cart cart: carts){
    totalPayment += cart.getTotalPrice();
}
        LocalDate purchaseDate = LocalDate.now();
Bill bill = new Bill(idUser,totalPayment,purchaseDate);
request.setAttribute("bill",bill);
BillDAO.getInstance().create(bill);

    }

    @Override
    public void delete(HttpServletRequest request) {

    }

    @Override
    public void update(HttpServletRequest request) {

    }
}
