package ru.job4j.ood.ocp.tax;

public abstract class TaxProfit {

    private Float taxForType(Float profit) {
        return 0F;
    }

    private Float taxForPlase(Float profit) {
        return profit * 0.15F / 100;
    }
    private Float taxForOther(Float profit) {
        return profit * 0.32F / 100;
    }


    public Float getTax(Float profit, String type, String place) {
        if ("организации в сферах образования и здравоохранения".equals(type)) {
            return taxForType(profit);
        } else if ("специальная зона".equals(place)) {
            return taxForPlase(profit);
        } else {
            return taxForOther(profit);
        }
    }
}
