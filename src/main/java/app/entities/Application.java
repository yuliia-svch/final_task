package app.entities;

public class Application {
    private int id;
    private String address;
    private String baggageType;
    private double weight;
    private double volume;
    private String dateOfReceival;
    private int userId;

    public Application(int id, String address, String baggageType, double weight,
                       double volume, String dor, int userId) {
        this.id = id;
        this.address = address;
        this.baggageType = baggageType;
        this.weight = weight;
        this.volume = volume;
        this.dateOfReceival = dor;
        this.userId = userId;
    }
}
