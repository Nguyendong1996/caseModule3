package com.casemodule3.service.impl;

import com.casemodule3.DAO.impl.PetDAO;
import com.casemodule3.DAO.impl.SpeciesDAO;
import com.casemodule3.model.Pet;
import com.casemodule3.model.Species;
import com.casemodule3.service.IGenerateService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class PetService implements IGenerateService<Pet> {
    private static PetService petService;

    public static PetService getInstance() {
        if (petService == null) {
            petService = new PetService();
        }
        return petService;
    }

    @Override
    public List<Pet> findAll() {
        return PetDAO.getInstance().findAll();
    }

    @Override
    public Pet findOne(HttpServletRequest request) {
        int idPet = Integer.parseInt(request.getParameter("idPet"));
        return PetDAO.getInstance().findOne(idPet);
    }

    @Override
    public void create(HttpServletRequest request) {
        String namePet = request.getParameter("namePet");
        double price = Double.parseDouble(request.getParameter("price"));
        int idSpecies = Integer.parseInt(request.getParameter("idSpecies"));
        Species species = SpeciesDAO.getInstance().findOne(idSpecies);
        String color = request.getParameter("color");
        String male = request.getParameter("male");
        String vaccination = request.getParameter("vaccination");
        String deWorming = request.getParameter("deWorming");
        String health = request.getParameter("health");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String status = request.getParameter("status");
        String source = request.getParameter("source");
        String image = request.getParameter("image");
        Pet pet = new Pet(namePet, price, species, color, male, vaccination, deWorming, health, quantity, status, source, image);
        PetDAO.getInstance().create(pet);
    }

    @Override
    public void delete(HttpServletRequest request) {
        int idPet = Integer.parseInt(request.getParameter("idPet"));
        PetDAO.getInstance().delete(idPet);
    }

    @Override
    public void update(HttpServletRequest request) {
        int idPet = Integer.parseInt(request.getParameter("idPet"));
        String namePet = request.getParameter("namePet");
        double price = Double.parseDouble(request.getParameter("price"));
        int idSpecies = Integer.parseInt(request.getParameter("idSpecies"));
        Species species = SpeciesDAO.getInstance().findOne(idSpecies);
        String color = request.getParameter("color");
        String male = request.getParameter("male");
        String vaccination = request.getParameter("vaccination");
        String deWorming = request.getParameter("deWorming");
        String health = request.getParameter("health");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String status = request.getParameter("status");
        String source = request.getParameter("source");
        String image = request.getParameter("image");
        Pet pet = new Pet(idPet, namePet, price, species, color, male, vaccination, deWorming, health, quantity, status, source, image);
        PetDAO.getInstance().update(pet);

    }
    public List<Pet> searchByName(HttpServletRequest request) {
        String search = request.getParameter("search");
        request.setAttribute("search",search);
        return PetDAO.getInstance().searchByName(search);
    }
    public List<Pet> searchByPrice(HttpServletRequest request) {
        double minPrice = Double.parseDouble(request.getParameter("minPrice"));
        double maxPrice = Double.parseDouble(request.getParameter("maxPrice"));
        request.setAttribute("minPrice",minPrice);
        request.setAttribute("maxPrice",maxPrice);
        return PetDAO.getInstance().searchByPrice(minPrice,maxPrice);
    }
    public List<Pet> sortByPriceAS(HttpServletRequest request) {
        return PetDAO.getInstance().sortByPriceAS();
    }
    public List<Pet> sortByPriceDESC(HttpServletRequest request) {
        return PetDAO.getInstance().sortByPriceDESC();
    }

    public List<Pet> getPetsBySpecies(HttpServletRequest request) {
        int idSpecies = Integer.parseInt(request.getParameter("idSpecies"));
        return PetDAO.getInstance().getPetsBySpecies(idSpecies);
    }

}
