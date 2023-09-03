package com.casemodule3.DAO.impl;

import com.casemodule3.DAO.IGenerateDAO;
import com.casemodule3.connection.MyConnection;
import com.casemodule3.model.Cart;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDAO implements IGenerateDAO<Cart> {
    private static CartDAO cartDAO;
    private final String SELECT_CART="select * from cart;";
    private final String CREATE_CART = "insert into cart(idBill,idPet,quantity,price,totalPrice) value(?,?,?,?,?);";
    private final String DELETE_CART = "delete from cart where idCart = ? ;";
    private final String UPDATE_CART = "update cart set quantity = ?, price = ? ,totalPrice = ? where idCart = ? ;";
    public static CartDAO getInstance(){
        if (cartDAO == null){
            cartDAO = new CartDAO();
        }
        return cartDAO;
    }
    @Override
    public List<Cart> findAll() {
        List<Cart> carts = new ArrayList<>();
        try {
            PreparedStatement ps = MyConnection.getInstance().getConnection().prepareStatement(SELECT_CART);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                int idCart = resultSet.getInt("idCart");
                int idBill = resultSet.getInt("idBill");
                int idPet = resultSet.getInt("idPet");
                int quantity = resultSet.getInt("quantity");
                double price = resultSet.getDouble("price");
                double totalPrice = resultSet.getDouble("totalPrice");
                Cart cart = new Cart(idCart,idBill,idPet,quantity,price,totalPrice);
                carts.add(cart);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return carts;
    }

    @Override
    public Cart findOne(int id) {
        List<Cart> carts = findAll();
        for (Cart cart : carts){
            if (cart.getIdCart() == id){
                return cart;
            }
        }
        return null;
    }

    @Override
    public void create(Cart cart) {
try {
    PreparedStatement ps = MyConnection.getInstance().getConnection().prepareStatement(CREATE_CART);
    ps.setInt(1,cart.getIdBill());
    ps.setInt(2,cart.getIdPet());
    ps.setInt(3,cart.getQuantity());
    ps.setDouble(4,cart.getPrice());
    ps.setDouble(5,cart.getTotalPrice());
    ps.executeUpdate();
    ps.close();
} catch (SQLException e) {
    throw new RuntimeException(e);
}
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(Cart cart) {

    }
}
