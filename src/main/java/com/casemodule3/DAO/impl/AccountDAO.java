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


    private AccountDAO() {
    }

    ;

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
                Account account = new Account(idAccount, username, password);
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
            while (resultSet.next()) {
                int idAccount = resultSet.getInt("idAccount");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                account = new Account(idAccount, username, password);
            }
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
            preparedStatement.setInt(1,account.getIdAccount());

        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(Account account) {

    }
}
