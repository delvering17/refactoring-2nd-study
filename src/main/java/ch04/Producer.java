package ch04;

import java.math.BigInteger;

public class Producer {

    private String name;
    private Long cost;
    private Long production;
    private Province province;

    public Producer(Province province, ProducerSaveRequest saveRequest) {
        this.name = saveRequest.name();
        this.cost = saveRequest.cost();
        this.production = saveRequest.production();
        this.province = province;
    }

    public String getName() {
        return name;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = Long.valueOf(cost);
    }

    public Long getProduction() {
        return production;
    }

    public void setProduction(String productionStr) {
        var newProduction = 0L;
        try {
            newProduction = Long.parseLong(productionStr);
        } catch (NumberFormatException ignored) {
        }

        this.province.addProduction(newProduction - this.production);
        this.production = newProduction;
    }
}
