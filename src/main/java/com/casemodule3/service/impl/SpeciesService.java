package com.casemodule3.service.impl;

import com.casemodule3.model.Species;
import com.casemodule3.service.IGenerateService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class SpeciesService implements IGenerateService<Species> {

    @Override
    public List<Species> findAll() {
        return null;
    }

    @Override
    public Species findOne(HttpServletRequest request) {
        return null;
    }

    @Override
    public void create(HttpServletRequest request) {

    }

    @Override
    public void delete(HttpServletRequest request) {

    }

    @Override
    public void update(HttpServletRequest request) {

    }
}
