package com.gradimut.poseidonbuget.model;

public class ItemModel {
    private int id;
    private String itemName, priority, budgetAllocate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getBudgetAllocate() {
        return budgetAllocate;
    }

    public void setBudgetAllocate(String budgetAllocate) {
        this.budgetAllocate = budgetAllocate;
    }
}