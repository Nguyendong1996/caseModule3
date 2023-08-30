package com.casemodule3.model;

public class Species {
    private int idSpecies;
    private String nameSpecies;

    public Species(int idSpecies, String nameSpecies) {
        this.idSpecies = idSpecies;
        this.nameSpecies = nameSpecies;
    }

    public Species(String nameSpecies) {
        this.nameSpecies = nameSpecies;
    }

    public Species() {
    }

    public int getIdSpecies() {
        return idSpecies;
    }

    public void setIdSpecies(int idSpecies) {
        this.idSpecies = idSpecies;
    }

    public String getNameSpecies() {
        return nameSpecies;
    }

    public void setNameSpecies(String nameSpecies) {
        this.nameSpecies = nameSpecies;
    }
}
