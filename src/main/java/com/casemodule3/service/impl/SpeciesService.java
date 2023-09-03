package com.casemodule3.service.impl;

import com.casemodule3.DAO.impl.SpeciesDAO;
import com.casemodule3.model.Species;
import com.casemodule3.service.IGenerateService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class SpeciesService implements IGenerateService<Species> {
    private static SpeciesService speciesService;

    public static SpeciesService getInstance() {
        if (speciesService == null) {
            speciesService = new SpeciesService();
        }
        return speciesService;
    }

    @Override
    public List<Species> findAll() {

        return SpeciesDAO.getInstance().findAll();
    }

    @Override
    public Species findOne(HttpServletRequest request) {
        int idSpecies = Integer.parseInt(request.getParameter("idSpecies"));
        return SpeciesDAO.getInstance().findOne(idSpecies);
    }

    @Override
    public void create(HttpServletRequest request) {
        String nameSpecies = request.getParameter("nameSpecies");
        Species species = new Species(nameSpecies);
        SpeciesDAO.getInstance().create(species);
    }

    @Override
    public void delete(HttpServletRequest request) {
        int idSpecies = Integer.parseInt(request.getParameter("idSpecies"));
        SpeciesDAO.getInstance().delete(idSpecies);
    }

    @Override
    public void update(HttpServletRequest request) {
        int idSpecies = Integer.parseInt(request.getParameter("idSpecies"));
        String nameSpecies = request.getParameter("nameSpecies");
        Species species = new Species(idSpecies, nameSpecies);
        SpeciesDAO.getInstance().update(species);
    }
}
