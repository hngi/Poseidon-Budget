package com.gradimut.poseidonbuget.model;

public class BudgetModel {
    private String name, amount, date;


    public BudgetModel(String name, String amount, String date) {
        this.name = name;
        this.amount = amount;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String currency) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String total) {
        this.amount = amount;
    }
}
