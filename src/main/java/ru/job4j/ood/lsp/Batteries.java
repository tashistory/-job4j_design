package ru.job4j.ood.lsp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Batteries extends Food {

    public Batteries(String name,  Date expiryDate, Date createDate, double price) {
        super(name,  expiryDate, createDate, price);
    }

   /*  public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Batteries batteries = new Batteries("fgfg", 1, sdf.parse("06/24/2024"), sdf.parse("06/24/2023"), 23.33);
        batteries.getProcent();
        System.out.println(batteries.toString());
        System.out.println(batteries.getExpiryDate().getTime() - batteries.getCreateDate().getTime());
        System.out.println(new java.util.Date().getTime() - batteries.getCreateDate().getTime());
        System.out.println((new java.util.Date().getTime() - batteries.getCreateDate().getTime()) * 100 / (batteries.getExpiryDate().getTime() - batteries.getCreateDate().getTime()));
        System.out.println(batteries.getShelfLifePercentage());
        batteries.setDiscount(20);
        System.out.println(batteries.getPrice());
    } */
}
