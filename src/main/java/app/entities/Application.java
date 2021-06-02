package app.entities;

public class Application {
    private String address;
    private String baggageType;
    private double weight;
    private double volume;
    private String dateOfReceival;
    private int userId;

    public Application(String address, String baggageType, double weight,
                       double volume, String dor, int userId) {
        this.address = address;
        this.baggageType = baggageType;
        this.weight = weight;
        this.volume = volume;
        this.dateOfReceival = dor;
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public String getBaggageType() {
        return baggageType;
    }

    public double getWeight() {
        return weight;
    }

    public double getVolume() {
        return volume;
    }

    public String getDateOfReceival() {
        return dateOfReceival;
    }

    public int getUserId() {
        return userId;
    }
}
