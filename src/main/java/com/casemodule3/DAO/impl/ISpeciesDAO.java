package com.casemodule3.DAO.impl;

import com.casemodule3.DAO.IGenerateDAO;
import com.casemodule3.connection.MyConnection;
import com.casemodule3.model.Species;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ISpeciesDAO implements IGenerateDAO<Species> {
    private static ISpeciesDAO iSpeciesDAO;
    private final String SELECT_SPECIES="select * from species;";
    private final String CREATE_SPECIES = "insert into species(nameSpecies) value(?);";
    private final String UPDATE_SPECIES = "update species set nameSpecies = ? where idSpecies = ? ;";
    public static ISpeciesDAO getInstance(){
        if (iSpeciesDAO== null){
            iSpeciesDAO = new ISpeciesDAO();
        }
        return iSpeciesDAO;
    }
    @Override
    public List<Species> findAll() {
        List<Species> species = new ArrayList<>();
        try {
            PreparedStatement  ps = MyConnection.getInstance().getConnection().prepareStatement(SELECT_SPECIES);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                int idSpecies = resultSet.getInt("idSpecies");
                String nameSpecies = resultSet.getString("nameSpecies");
                Species species1 = new Species(idSpecies,nameSpecies);
                species.add(species1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
            PreparedStatement ps = MyConnection.getInstance().getConnection().prepareStatement(CREATE_SPECIES);
            ps.setString(1,species.getNameSpecies());
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
    public void update(Species species) {


    }
}
