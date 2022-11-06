package org.example.models;

public class NumberOfUserCards {
    private int CountSalaryCard;
    private int CountActiveCard;

    public int getCountActiveCard() {
        return CountActiveCard;
    }

    public int getCountSalaryCard() {
        return CountSalaryCard;
    }

    public void setCountSalaryCard(int countSalaryCard) {
        this.CountSalaryCard = countSalaryCard;
    }

    public void setCountActiveCard(int countActiveCard) {
        this.CountActiveCard = countActiveCard;
    }
}
