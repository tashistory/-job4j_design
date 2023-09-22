package ru.job4j.ood.srp.farepayment;

public interface Payment {

    void payment(TypePay type, float amount);
    void printCheck();
}
