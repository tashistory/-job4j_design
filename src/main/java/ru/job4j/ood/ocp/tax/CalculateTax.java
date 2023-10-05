package ru.job4j.ood.ocp.tax;

import java.security.InvalidParameterException;

public class CalculateTax {
   public void calculate(Tax type) {
       if (type == null) {
           throw new InvalidParameterException();
       }
       if (type instanceof TaxForType forType) {
           forType.setResult(forType.calculation(1233455.6F));
       } else if (type instanceof TaxForPlase forPlace) {
           forPlace.setResult(forPlace.calculation(354656.66F));
       }
   }
}
