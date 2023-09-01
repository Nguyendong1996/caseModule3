package com.casemodule3.DAO.impl;

import com.casemodule3.DAO.IGenerateDAO;
import com.casemodule3.connection.MyConnection;
import com.casemodule3.model.Species;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpeciesDAO implements IGenerateDAO<Species> {
    private static SpeciesDAO speciesDAO;
    private final String SELECT_SPECIES="select * from species;";
    private final String CREATE_SPECIES = "insert into species(nameSpecies) value(?);";
    private final String DELETE_SPECIES = "delete from species where idSpecies = ? ;";
    private final String UPDATE_SPECIES = "update species set nameSpecies = ? where idSpecies = ? ;";
    public static SpeciesDAO getInstance(){
        if (speciesDAO == null){
            speciesDAO = new SpeciesDAO();
        }
        return speciesDAO;
    }
    @Override
    public List<Species> findAll() {
        List<Species> species = new ArrayList<>();
        try {
            Connection connection = MyConnection.getInstance().getConnection();
            PreparedStatement  ps = connection.prepareStatement(SELECT_SPECIES);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                int idSpecies = resultSet.getInt("idSpecies");
                String nameSpecies = resultSet.getString("nameSpecies");
                Species species1 = new Species(idSpecies,nameSpecies);
                species.add(species1);
            }
            connection.close();
        } catch (SQLException e) {
           e.getStackTrace();
        }
        return species;
    }

    @Override
    public Species findOne(int id) {
        List<Species> species = findAll();
        for (Species species1: species){
            if (species1.getIdSpecies()==id){
                return species1;
            }
        }
        return null;
    }

    @Override
    public void create(Species species) {
        try {
            Connection connection = MyConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(CREATE_SPECIES);
            ps.setString(1,species.getNameSpecies());
            ps.executeUpdate();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.getStackTrace();
        }

    }

    @Override
    public void delete(int id) {
try {
    Connection connection = MyConnection.getInstance().getConnection();
    PreparedStatement ps = connection.prepareStatement(DELETE_SPECIES);
    ps.setInt(1,id);
    ps.executeUpdate();
    connection.close();
} catch (SQLException e) {
    e.getStackTrace();
}
    }

    @Override
    public void update(Species species) {
        try {
            Connection connection = MyConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(UPDATE_SPECIES);
            ps.setString(1,species.getNameSpecies());
            ps.setInt(2,species.getIdSpecies());
            ps.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
