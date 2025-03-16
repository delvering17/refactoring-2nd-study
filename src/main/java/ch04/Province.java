package ch04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Province {

    private final String name;
    private final List<Producer> producers;
    private Long totalProduction;
    private Long demand;
    private Long price;

    public Province(String name, Long demand, Long price, List<ProducerSaveRequest> producers) {
        this.name = name;
        this.demand = demand;
        this.price = price;
        this.totalProduction = 0L;
        this.producers = new ArrayList<>();
        producers.forEach(d -> addProducer(new Producer(this, d)));
    }

    public Long shortfall() {
        return this.demand - this.totalProduction;
    }

    public Long profit() {
        return demandValue() - demandCost();
    }

    private Long demandValue() {
        return satisfiedDemand() * this.price;
    }

    private Long satisfiedDemand() {
        return Math.min(this.demand, this.totalProduction);
    }

    private Long demandCost() {
        Long remainingDemand = Long.valueOf(this.demand);
        var result = 0L;
        this.producers.sort(Comparator.comparing(Producer::getCost));
        for (Producer p : producers) {
            var contribution = Math.min(remainingDemand, p.getProduction());
            remainingDemand -= contribution;
            result += contribution * p.getCost();
        }

        return result;
    }

    public void addProduction(Long production) {
        this.totalProduction += production;
    }

    private void addProducer(Producer arg) {
        this.producers.add(arg);
        this.totalProduction += arg.getProduction();
    }

    public String getName() {
        return name;
    }

    public List<Producer> getProducers() {
        return producers;
    }

    public Long getTotalProduction() {
        return totalProduction;
    }

    public void setTotalProduction(String totalProduction) {
        this.totalProduction = Long.valueOf(totalProduction);
    }

    public Long getDemand() {
        return demand;
    }

    public void setDemand(String demand) {
        this.demand = Long.valueOf(demand);
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = Long.parseLong(price);
    }

}
