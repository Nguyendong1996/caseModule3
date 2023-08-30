package com.casemodule3.DAO.impl;

import com.casemodule3.DAO.IGenerateDAO;
import com.casemodule3.connection.MyConnection;
import com.casemodule3.model.Pet;
import com.casemodule3.model.Species;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PetDAO implements IGenerateDAO<Pet> {
   private static PetDAO petDAO;
   private final String SELECT_PET = "select * from pet;";
   private final String CREATE_PET ="insert into pet(namePet,price,ipSpecies,color,male,vaccination,deWorming,health,quantity,status,source,image) value (?,?,?,?,?,?,?,?,?,?,?,?);";
   private final String DELETE_PET ="delete from pet where idPet = ?;";
   private final String UPDATE_PET ="update pet set namePet = ?, price = ?,ipSpecies = ?,color = ?,male= ?,vaccination= ?,deWorming= ?,health= ?,quantity = ?,status = ?,source = ?,image= ? where idPet = ? ;";

    private static PetDAO getInstance(){
        if (petDAO == null){
            petDAO = new PetDAO();
        }
        return petDAO;
    }
    @Override
    public List<Pet> findAll() {
        List<Pet> pets = new ArrayList<>();
        try {
            PreparedStatement ps = MyConnection.getInstance().getConnection().prepareStatement(SELECT_PET);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                int idPet = resultSet.getInt("idPet");
                String namePet = resultSet.getString("namePet");
                double price = resultSet.getDouble("price");
                int idSpecies = resultSet.getInt("idSpecies");
                Species species = SpeciesDAO.getInstance().findOne(idSpecies);
                String color = resultSet.getString("color");
                String male = resultSet.getString("male");
                String vaccination = resultSet.getString("vaccination");
                String deWorming = resultSet.getString("deWorming");
                String health = resultSet.getString("health");
                int quantity = resultSet.getInt("quantity");
                String status = resultSet.getString("status");
                String source = resultSet.getString("source");
                String image = resultSet.getString("image");
                Pet pet = new Pet(idPet,namePet,price,species,color,male,vaccination,deWorming,health,quantity,status,source,image);
                pets.add(pet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pets;
    }

    @Override
    public Pet findOne(int id) {
        List<Pet> pets = findAll();
        for (Pet pet:pets){
            if (pet.getIdPet()==id){
                return  pet;
            }
        }
        return null;
    }

    @Override
    public void create(Pet pet) {
        try {
            PreparedStatement ps = MyConnection.getInstance().getConnection().prepareStatement(CREATE_PET);
            ps.setString(1,pet.getNamePet());
            ps.setDouble(2,pet.getPrice());
            ps.setInt(3,pet.getSpecies().getIdSpecies());
            ps.setString(4,pet.getColor());
            ps.setString(5,pet.getMale());
            ps.setString(6,pet.getVaccination());
            ps.setString(7,pet.getDeWorming());
            ps.setString(8,pet.getHealth());
            ps.setInt(9,pet.getQuantity());
            ps.setString(10,pet.getStatus());
            ps.setString(11,pet.getSource());
            ps.setString(12,pet.getImage());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(int id) {
try {
    PreparedStatement ps = MyConnection.getInstance().getConnection().prepareStatement(DELETE_PET);
    ps.setInt(1,id);
    ps.executeUpdate();
    ps.close();
} catch (SQLException e) {
    e.printStackTrace();
}
    }

    @Override
    public void update(Pet pet) {
        try {
            PreparedStatement ps = MyConnection.getInstance().getConnection().prepareStatement(UPDATE_PET);
            ps.setString(1,pet.getNamePet());
            ps.setDouble(2,pet.getPrice());
            ps.setInt(3,pet.getSpecies().getIdSpecies());
            ps.setString(4,pet.getColor());
            ps.setString(5,pet.getMale());
            ps.setString(6,pet.getVaccination());
            ps.setString(7,pet.getDeWorming());
            ps.setString(8,pet.getHealth());
            ps.setInt(9,pet.getQuantity());
            ps.setString(10,pet.getStatus());
            ps.setString(11,pet.getSource());
            ps.setString(12,pet.getImage());
            ps.setInt(13,pet.getIdPet());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
