package app.entities;

public class Direction {
    private String region;
    private String typeOfDelivery;
    private int capacity;
    private int weight;
    private double pricing;
    public Direction(String region, String typeOfDelivery, int capacity, int weight, double pricing) {
        this.region = region;
        this.typeOfDelivery = typeOfDelivery;
        this.capacity = capacity;
        this.weight = weight;
        this.pricing = pricing;
    }

    public String getRegion() {
        return region;
    }

    public String getTypeOfDelivery() {
        return typeOfDelivery;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getWeight() {
        return weight;
    }

    public double getPricing() {
        return pricing;
    }

    @Override
    public String toString() {
        return region + ", " + typeOfDelivery + ", " + capacity + " m^3, "
                + weight + " kg, " + pricing + " hrn";
    }
}
