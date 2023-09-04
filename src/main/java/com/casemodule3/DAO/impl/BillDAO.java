package com.casemodule3.DAO.impl;

import com.casemodule3.DAO.IGenerateDAO;
import com.casemodule3.connection.MyConnection;
import com.casemodule3.model.Bill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BillDAO implements IGenerateDAO<Bill> {
    private static BillDAO billDAO;
    private final String SELECT_BILL="select * from bill ;";
    private final String CREATE_BILL = "insert into bill(idUser,totalPayment,purchaseDate) value(?,?,?);";
    private final String DELETE_SPECIES = "delete from species where idSpecies = ? ;";
    private final String UPDATE_SPECIES = "update bill set  = ? where idSpecies = ? ;";
    public static BillDAO getInstance(){
        if (billDAO == null){
            billDAO = new BillDAO();
        }
        return billDAO;
    }
    @Override
    public List<Bill> findAll() {
        List<Bill> bills = new ArrayList<>();
        try {
            Connection myConnection = MyConnection.getInstance().getConnection();
            PreparedStatement ps = myConnection.prepareStatement(SELECT_BILL);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                int idBill = resultSet.getInt("idBill");
                int idUser = resultSet.getInt("idUser");
                double totalPayment = resultSet.getDouble("totalPayment");
                LocalDate purchaseDate = LocalDate.parse(resultSet.getString("purchaseDate"));
                Bill bill = new Bill(idBill,idUser,totalPayment,purchaseDate);
                bills.add(bill);
            }
            myConnection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bills;
    }

    @Override
    public Bill findOne(int id) {
        List<Bill> bills = findAll();
        for (Bill bill:bills){
            if (bill.getIdUser() == id){
                return  bill;
            }
        }
        return null;
    }

    @Override
    public void create(Bill bill) {
        try {
            Connection connection = MyConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(CREATE_BILL);
            ps.setInt(1,bill.getIdUser());
            ps.setDouble(2,bill.getTotalPayment());
            ps.setString(3,bill.getPurchaseDate().toString());
            ps.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(Bill bill) {

    }
}
