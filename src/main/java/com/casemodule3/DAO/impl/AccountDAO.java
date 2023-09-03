package com.casemodule3.DAO.impl;

import com.casemodule3.DAO.IGenerateDAO;
import com.casemodule3.connection.MyConnection;
import com.casemodule3.model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO implements IGenerateDAO<Account> {
    private static AccountDAO accountDAO;
    private final String SELECT_ALL = "select * from account;";
    private final String SELECT_BY_ID = "select * from account where idAccount = ?;";
    private final String INSERT_INTO = "insert into account(username, password) values (?,?);";
    private final String UPDATE_BY_ID = "update account set username = ?, password = ? where idAccount = ?";
    private final String DELETE_BY_ID = "delete from account where idAccount = ?";
    private final String LOGIN = "select * from account where username = ? and password = ?;";
    private final String CHECK_ACCOUNT = "select * from account where username = ?;";


    private AccountDAO() {
    };

    public static AccountDAO getInstance() {
        if (accountDAO == null) {
            accountDAO = new AccountDAO();
        }
        return accountDAO;
    }

    @Override
    public List<Account> findAll() {
        List<Account> accounts = new ArrayList<>();
        Connection connection = MyConnection.getInstance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idAccount = resultSet.getInt("idAccount");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                boolean isAdmin = resultSet.getBoolean("isAdmin");
                Account account = new Account(idAccount, username, password,isAdmin);
                accounts.add(account);
            }
            connection.close();
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return accounts;
    }

    @Override
    public Account findOne(int id) {
        Account account = null;
        Connection connection = MyConnection.getInstance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            preparedStatement.setInt(1,id);
            while (resultSet.next()) {
                int idAccount = resultSet.getInt("idAccount");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                boolean isAdmin = resultSet.getBoolean("isAdmin");
                account = new Account(idAccount,username,password,isAdmin);
            }
            connection.close();
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return account;
    }

    @Override
    public void create(Account account) {
        Connection connection = MyConnection.getInstance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setString(1,account.getUsername());
            preparedStatement.setString(2,account.getPassword());
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
    public void update(Account account) {
        Connection connection = MyConnection.getInstance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
            preparedStatement.setString(1,account.getUsername());
            preparedStatement.setString(2,account.getPassword());
            preparedStatement.setInt(3,account.getIdAccount());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    public Account login(String username, String password) {
        Account account = null;
        Connection connection = MyConnection.getInstance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(LOGIN);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idAccount = resultSet.getInt("idAccount");
                String usernameDB = resultSet.getString("username");
                String passwordDB = resultSet.getString("password");
                boolean isAdmin = resultSet.getBoolean("isAdmin");
                account = new Account(idAccount,usernameDB,passwordDB,isAdmin);
            }
            connection.close();
        } catch (SQLException e) {
            e.getStackTrace();
        } return account;
    }
    public Account checkAccountExist(String username) {
        Account account = null;
        Connection connection = MyConnection.getInstance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CHECK_ACCOUNT);
            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idAccount = resultSet.getInt("idAccount");
                String usernameDB = resultSet.getString("username");
                String password = resultSet.getString("password");
                boolean isAdmin = resultSet.getBoolean("isAdmin");
                account = new Account(idAccount,usernameDB,password,isAdmin);
            }
            connection.close();
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return account;
    }
}
