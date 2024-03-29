package ru.job4j.ood.ocp.tax;

public class TaxForType {

    private double profit;

    private double tax = 0.15F;
    private double result = 0.0;

    public TaxForType(double profit) {
        this.profit = profit;
    }
    public double calculation(double profit) {
        return profit * tax;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public double getResult() {
        return result;
    }
}
