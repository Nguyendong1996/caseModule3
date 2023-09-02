package com.casemodule3.DAO.impl;

import com.casemodule3.DAO.IGenerateDAO;
import com.casemodule3.connection.MyConnection;
import com.casemodule3.model.Pet;
import com.casemodule3.model.Species;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PetDAO implements IGenerateDAO<Pet> {
    private static PetDAO petDAO;
    private final String SELECT_PET = "select * from pet;";
    private final String CREATE_PET = "insert into pet(namePet,price,idSpecies,color,male,vaccination,deWorming,health,quantity,status,source,image) value (?,?,?,?,?,?,?,?,?,?,?,?);";
    private final String DELETE_PET = "delete from pet where idPet = ?;";
    private final String UPDATE_PET = "update pet set namePet = ?, price = ?,idSpecies = ?,color = ?,male= ?,vaccination= ?,deWorming= ?,health= ?,quantity = ?,status = ?,source = ?,image= ? where idPet = ? ;";
    private final String SELECT_BY_ID_SPECIES = "select * from product where idSpecies = ?;";
    private final String SELECT_PET_BY_NAME = "select * from pet where namePet like ?;";
    private final String SELECT_PET_BY_PRICE = "select * from pet where price >= ? and price <= ?;";
    private final String SORT_PET_BY_PRICE_AS = "select * from pet order by price;";
    private final String SORT_PET_BY_PRICE_DESC = "select * from pet order by price desc;";
    public static PetDAO getInstance() {
        if (petDAO == null) {
            petDAO = new PetDAO();
        }
        return petDAO;
    }

    @Override
    public List<Pet> findAll() {
        List<Pet> pets = new ArrayList<>();
        try {
            Connection connection = MyConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(SELECT_PET);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
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
                Pet pet = new Pet(idPet, namePet, price, species, color, male, vaccination, deWorming, health, quantity, status, source, image);
                pets.add(pet);
            }
            connection.close();
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return pets;
    }

    @Override
    public Pet findOne(int id) {
        List<Pet> pets = findAll();
        for (Pet pet : pets) {
            if (pet.getIdPet() == id) {
                return pet;
            }
        }
        return null;
    }

    @Override
    public void create(Pet pet) {
        Connection connection = MyConnection.getInstance().getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(CREATE_PET);
            ps.setString(1, pet.getNamePet());
            ps.setDouble(2, pet.getPrice());
            ps.setInt(3, pet.getSpecies().getIdSpecies());
            ps.setString(4, pet.getColor());
            ps.setString(5, pet.getMale());
            ps.setString(6, pet.getVaccination());
            ps.setString(7, pet.getDeWorming());
            ps.setString(8, pet.getHealth());
            ps.setInt(9, pet.getQuantity());
            ps.setString(10, pet.getStatus());
            ps.setString(11, pet.getSource());
            ps.setString(12, pet.getImage());
            ps.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.getStackTrace();
        }

    }

    @Override
    public void delete(int id) {
        Connection connection = MyConnection.getInstance().getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(DELETE_PET);
            ps.setInt(1, id);
            ps.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    @Override
    public void update(Pet pet) {
        Connection connection = MyConnection.getInstance().getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE_PET);
            ps.setString(1, pet.getNamePet());
            ps.setDouble(2, pet.getPrice());
            ps.setInt(3, pet.getSpecies().getIdSpecies());
            ps.setString(4, pet.getColor());
            ps.setString(5, pet.getMale());
            ps.setString(6, pet.getVaccination());
            ps.setString(7, pet.getDeWorming());
            ps.setString(8, pet.getHealth());
            ps.setInt(9, pet.getQuantity());
            ps.setString(10, pet.getStatus());
            ps.setString(11, pet.getSource());
            ps.setString(12, pet.getImage());
            ps.setInt(13, pet.getIdPet());
            ps.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.getStackTrace();
        }

    }
    public List<Pet> searchByName(String search) {
        Connection connection = MyConnection.getInstance().getConnection();
        List<Pet> pets = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PET_BY_NAME);
            preparedStatement.setString(1, '%' + search + '%');
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
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
                Pet pet = new Pet(idPet, namePet, price, species, color, male, vaccination, deWorming, health, quantity, status, source, image);
                pets.add(pet);
            }
            connection.close();
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return pets;
    }
    public List<Pet> searchByPrice(double minPrice, double maxPrice) {
        Connection connection = MyConnection.getInstance().getConnection();
        List<Pet> pets = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PET_BY_PRICE);
            preparedStatement.setDouble(1, minPrice);
            preparedStatement.setDouble(2, maxPrice);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
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
                Pet pet = new Pet(idPet, namePet, price, species, color, male, vaccination, deWorming, health, quantity, status, source, image);
                pets.add(pet);
            }
            connection.close();
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return pets;
    }
    public List<Pet> sortByPriceAS() {
        Connection connection = MyConnection.getInstance().getConnection();
        List<Pet> pets = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SORT_PET_BY_PRICE_AS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
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
                Pet pet = new Pet(idPet, namePet, price, species, color, male, vaccination, deWorming, health, quantity, status, source, image);
                pets.add(pet);
            }
            connection.close();
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return pets;
    }
    public List<Pet> sortByPriceDESC() {
        Connection connection = MyConnection.getInstance().getConnection();
        List<Pet> pets = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SORT_PET_BY_PRICE_DESC);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
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
                Pet pet = new Pet(idPet, namePet, price, species, color, male, vaccination, deWorming, health, quantity, status, source, image);
                pets.add(pet);
            }
            connection.close();
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return pets;
    }
    public List<Pet> getPetsBySpecies(int id) {
        Connection connection = MyConnection.getInstance().getConnection();
        List<Pet> pets = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID_SPECIES);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
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
                Pet pet = new Pet(idPet, namePet, price, species, color, male, vaccination, deWorming, health, quantity, status, source, image);
                pets.add(pet);
            }
            connection.close();
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return pets;
    }

}
