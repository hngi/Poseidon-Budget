package com.gradimut.poseidonbuget.model;

public class BudgetModel {
    private String name, amount;

    public BudgetModel(String name, String amount) {
        this.name = name;
        this.amount = amount;
    }


    public String getName() {
        return name;
    }

    public void setName(String currency) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String total) {
        this.amount = amount;
    }
}
