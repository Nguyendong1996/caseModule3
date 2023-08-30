package com.casemodule3.model;

import java.time.LocalDate;

public class User {
    private int idUser;
    private Account account;
    private String fullName;
    private LocalDate dob;
    private String sex;
    private String phone;
    private String email;
    private String Address;

    public User() {
    }

    public User(Account account, String fullName, LocalDate dob, String sex, String phone, String email, String address) {
        this.account = account;
        this.fullName = fullName;
        this.dob = dob;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        Address = address;
    }

    public User(int idUser, Account account, String fullName, LocalDate dob, String sex, String phone, String email, String address) {
        this.idUser = idUser;
        this.account = account;
        this.fullName = fullName;
        this.dob = dob;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        Address = address;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
