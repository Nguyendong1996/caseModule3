package com.casemodule3.model;

import java.time.LocalDate;

public class Bill {
    private int idBill;
    private int idUser;
    private double totalPayment;
    private LocalDate purchaseDate;

    public Bill(int idBill, int idUser, double totalPayment, LocalDate purchaseDate) {
        this.idBill = idBill;
        this.idUser = idUser;
        this.totalPayment = totalPayment;
        this.purchaseDate = purchaseDate;
    }

    public Bill(int idUser, double totalPayment, LocalDate purchaseDate) {
        this.idUser = idUser;
        this.totalPayment = totalPayment;
        this.purchaseDate = purchaseDate;
    }

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
