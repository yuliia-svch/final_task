package app.entities;

import app.dao.ApplicationDao;

public class Application {
    private int id;
    private String address;
    private String baggageType;
    private double weight;
    private double volume;
    private String dateOfReceival;
    private int userId;

    public Application(){}
    public Application(String address, String baggageType, double weight,
                       double volume, String dor, int userId) {
        this.address = address;
        this.baggageType = baggageType;
        this.weight = weight;
        this.volume = volume;
        this.dateOfReceival = dor;
        this.userId = userId;
    }

    public int getAppId(){
        return id;
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

    public String getLogin() {
        ApplicationDao appDao = new ApplicationDao();
        return appDao.getUserLoginById(this.userId);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBaggageType(String baggageType) {
        this.baggageType = baggageType;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public void setDate(String dateOfReceival) {
        this.dateOfReceival = dateOfReceival;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
