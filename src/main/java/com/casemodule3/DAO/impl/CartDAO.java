package com.casemodule3.DAO.impl;

import com.casemodule3.DAO.IGenerateDAO;
import com.casemodule3.connection.MyConnection;
import com.casemodule3.model.Cart;
import com.casemodule3.model.Pet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDAO implements IGenerateDAO<Cart> {
    private static CartDAO cartDAO;
    private final String SELECT_CART="select * from cart;";
    private final String CREATE_CART = "insert into cart(idPet,quantity,price,totalPrice,idAccount) value(?,?,?,?,?);";
    private final String DELETE_CART = "delete from cart where idAccount = ? ;";
    private final String DELETE_CART1 = "delete from cart where idCart = ? ;";

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
            Connection connection = MyConnection.getInstance().getConnection();
            PreparedStatement ps =connection.prepareStatement(SELECT_CART);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                int idCart = resultSet.getInt("idCart");
                int idBill = resultSet.getInt("idBill");
                int idPet = resultSet.getInt("idPet");
                Pet pet = PetDAO.getInstance().findOne(idPet);
                int quantity = resultSet.getInt("quantity");
                double price = resultSet.getDouble("price");
                double totalPrice = resultSet.getDouble("totalPrice");
                int idAccount = resultSet.getInt("idAccount");
                Cart cart = new Cart(idCart,idBill,pet,quantity,price,totalPrice,idAccount);
                carts.add(cart);
            }
            connection.close();
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
    Connection connection = MyConnection.getInstance().getConnection();
    PreparedStatement ps = connection.prepareStatement(CREATE_CART);
//    ps.setInt(1,cart.getIdBill());
    ps.setInt(1,cart.getPet().getIdPet());
    ps.setInt(2,cart.getQuantity());
    ps.setDouble(3,cart.getPrice());
    ps.setDouble(4,cart.getTotalPrice());
    ps.setInt(5,cart.getIdAccount());
    ps.executeUpdate();
    connection.close();
} catch (SQLException e) {
    throw new RuntimeException(e);
}
    }

    @Override
    public void delete(int id) {
        try {
            Connection connection = MyConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(DELETE_CART);
            ps.setInt(1, id);
            ps.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
        public void deleteCart(int id) {
            try {
                Connection connection = MyConnection.getInstance().getConnection();
                PreparedStatement ps = connection.prepareStatement(DELETE_CART1);
                ps.setInt(1,id);
                ps.executeUpdate();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }

    @Override
    public void update(Cart cart) {try {
Connection connection =MyConnection.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement(UPDATE_CART);
        ps.setInt(1,cart.getQuantity());
        ps.setDouble(2,cart.getPrice());
        ps.setDouble(3,cart.getTotalPrice());
        ps.setInt(4,cart.getIdCart());
        ps.executeUpdate();
        connection.close();
    }catch (SQLException e){e.printStackTrace();
    }
}
}
