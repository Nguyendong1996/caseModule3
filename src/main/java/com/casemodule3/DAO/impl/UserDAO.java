package com.casemodule3.DAO.impl;

import com.casemodule3.DAO.IGenerateDAO;
import com.casemodule3.connection.MyConnection;
import com.casemodule3.model.Account;
import com.casemodule3.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IGenerateDAO<User> {
    private final String SELECT_ALL = "select * from user;";
    private final String SELECT_BY_ID = "select * from user where idUser = ?;";
    private final String INSERT_INTO = "insert into user(idAccount, fullName, dob, sex, phone, email, address ) values (?,?,?,?,?,?,?);";
    private final String UPDATE_BY_ID = "update user set idAccount = ?, fullName = ?, dob = ?, sex = ?, phone = ?, email = ?, address = ? where idUser = ?";
    private final String DELETE_BY_ID = "delete from user where idUser = ?";
    private static UserDAO userDAO;

    private UserDAO() {
    }
    ;

    public static UserDAO getInstance() {
        if (userDAO == null) {
            userDAO = new UserDAO();
        }
        return userDAO;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        Connection connection = MyConnection.getInstance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idAccount = resultSet.getInt("idAccount");
                Account account = AccountDAO.getInstance().findOne(idAccount);
                String fullName = resultSet.getString("fullName");
                LocalDate dob = LocalDate.parse(resultSet.getString("dob"));
                String sex = resultSet.getString("sex");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                User user = new User(account, fullName, dob, sex, phone, email, address);
                users.add(user);
            }
            connection.close();

        } catch (SQLException e) {
            e.getStackTrace();
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                int idUser = resultSet.getInt("idUser");
                int idAccount = resultSet.getInt("idAccount");
                Account account = AccountDAO.getInstance().findOne(idAccount);
                String fullName = resultSet.getString("fullName");
                LocalDate dob = resultSet.getObject("dob", LocalDate.class);
                String sex = resultSet.getString("sex");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                User user = new User(account, fullName, dob, sex, phone, email, address);
                users.add(user);
            }
            connection.close();

        } catch (SQLException e) {
            e.getStackTrace();
        }
        return users;
    }

    @Override
    public User findOne(int id) {
        User user = null;
        Connection connection = MyConnection.getInstance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            ResultSet resultSet = preparedStatement.getResultSet();
            preparedStatement.setInt(1, id);
            while (resultSet.next()) {
                int idAccount = resultSet.getInt("idAccount");
                Account account = AccountDAO.getInstance().findOne(idAccount);
                String fullName = resultSet.getString("fullName");
                LocalDate dob = resultSet.getObject("dob", LocalDate.class);
                String sex = resultSet.getString("sex");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                user = new User(account, fullName, dob, sex, phone, email, address);
            }
            connection.close();

        } catch (SQLException e) {
            e.getStackTrace();
        }
        return user;
    }

    @Override
    public void create(User user) {
        Connection connection = MyConnection.getInstance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setInt(1, user.getAccount().getIdAccount());
            preparedStatement.setString(2, user.getFullName());
            preparedStatement.setString(3, user.getDob().toString());
            preparedStatement.setString(4, user.getSex());
            preparedStatement.setString(5, user.getPhone());
            preparedStatement.setString(6, user.getEmail());
            preparedStatement.setString(7, user.getAddress());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.getStackTrace();
        }

    }

    @Override
    public void delete(int id) {
        Connection connection = MyConnection.getInstance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    @Override
    public void update(User user) {
        Connection connection = MyConnection.getInstance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
            preparedStatement.setInt(1, user.getAccount().getIdAccount());
            preparedStatement.setString(2, user.getFullName());
            preparedStatement.setString(3, user.getDob().toString());
            preparedStatement.setString(4, user.getSex());
            preparedStatement.setString(5, user.getPhone());
            preparedStatement.setString(6, user.getEmail());
            preparedStatement.setString(7, user.getAddress());
            preparedStatement.setInt(8,user.getIdUser());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.getStackTrace();
        }

    }
    public User checkIdAccount(int id){
        List<User> users = findAll();
        for (User user:users){
            if (user.getAccount().getIdAccount()==id){
                return user;
            }
        }
        return null;
    }
}
