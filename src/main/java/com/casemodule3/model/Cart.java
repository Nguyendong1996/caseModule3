package com.casemodule3.model;

public class Cart {
    int idCart;
    int idBill;
    int idPet;
    private int quantity;
    private double price;
    private double totalPrice;

    public Cart(int idCart, int idBill, int idPet, int quantity, double price, double totalPrice) {
        this.idCart = idCart;
        this.idBill = idBill;
        this.idPet = idPet;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = totalPrice;
    }

    public Cart(int idBill, int idPet, int quantity, double price, double totalPrice) {
        this.idBill = idBill;
        this.idPet = idPet;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = totalPrice;
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

    public int getIdPet() {
        return idPet;
    }

    public void setIdPet(int idPet) {
        this.idPet = idPet;
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
}
