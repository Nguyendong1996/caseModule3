package com.casemodule3.service.impl;

import com.casemodule3.DAO.impl.BillDAO;
import com.casemodule3.model.Bill;
import com.casemodule3.service.IGenerateService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class BillService implements IGenerateService<Bill> {
    @Override
    public List<Bill> findAll() {
        return BillDAO.getInstance().findAll();
    }

    @Override
    public Bill findOne(HttpServletRequest request) {
        int idBill = Integer.parseInt(request.getParameter("idBill"));
       return BillDAO.getInstance().findOne(idBill);
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
