package com.casemodule3.model;

public class Pet {
    private int idPet;
    private String namePet;
    private double price;
    private Species species;
    private String color;
    private String male;
    private String vaccination;
    private String deworming;
    private String health;
    private int quantity;
    private String status;
    private String source;
    private String image;

    public Pet(int idPet, String namePet, double price, Species species, String color, String male, String vaccination, String deworming, String health, int quantity, String status, String source, String image) {
        this.idPet = idPet;
        this.namePet = namePet;
        this.price = price;
        this.species = species;
        this.color = color;
        this.male = male;
        this.vaccination = vaccination;
        this.deworming = deworming;
        this.health = health;
        this.quantity = quantity;
        this.status = status;
        this.source = source;
        this.image = image;
    }

    public Pet(String namePet, double price, Species species, String color, String male, String vaccination, String deworming, String health, int quantity, String status, String source, String image) {
        this.namePet = namePet;
        this.price = price;
        this.species = species;
        this.color = color;
        this.male = male;
        this.vaccination = vaccination;
        this.deworming = deworming;
        this.health = health;
        this.quantity = quantity;
        this.status = status;
        this.source = source;
        this.image = image;
    }

    public Pet() {
    }

    public int getIdPet() {
        return idPet;
    }

    public void setIdPet(int idPet) {
        this.idPet = idPet;
    }

    public String getNamePet() {
        return namePet;
    }

    public void setNamePet(String namePet) {
        this.namePet = namePet;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMale() {
        return male;
    }

    public void setMale(String male) {
        this.male = male;
    }

    public String getVaccination() {
        return vaccination;
    }

    public void setVaccination(String vaccination) {
        this.vaccination = vaccination;
    }

    public String getDeworming() {
        return deworming;
    }

    public void setDeworming(String deworming) {
        this.deworming = deworming;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
