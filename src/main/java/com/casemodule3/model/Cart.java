package com.casemodule3.model;

public class Cart {
    int idCart;
    int idBill;
    Pet pet;
    private int quantity;
    private double price;
    private double totalPrice;
    private int idAccount;

    public Cart(int idCart, int idBill, Pet pet, int quantity, double price, double totalPrice,int idAccount) {
        this.idCart = idCart;
        this.idBill = idBill;
        this.pet = pet;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = totalPrice;
        this.idAccount = idAccount;
    }

    public Cart(int idBill, Pet pet, int quantity, double price, double totalPrice,int idAccount) {
        this.idBill = idBill;
        this.pet = pet;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = totalPrice;
        this.idAccount = idAccount;
    }

    public int getIdCart() {
        return idCart;
    }

    public void setIdCart(int idCart) {
        this.idCart = idCart;
    }

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }
}
