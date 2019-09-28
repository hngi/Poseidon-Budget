package com.gradimut.poseidonbuget;

public class DashModel {
    private int image;

    private String salary, date, currency, total;

    public DashModel(int image, String salary, String date, String currency, String total) {
        this.image = image;
        this.salary = salary;
        this.date = date;
        this.currency = currency;
        this.total = total;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
