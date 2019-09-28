package com.gradimut.poseidonbuget;

public class BudgetModel {
    private String name, cost;

    public BudgetModel(String name, String cost) {
        this.name = name;
        this.cost = cost;
    }


    public String getName() {
        return name;
    }

    public void setName(String currency) {
        this.name = name;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String total) {
        this.cost = cost;
    }
}
