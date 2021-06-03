package app.entities;

public class Receipt {
    private int id;
    private double price;
    private int appId;

    public Receipt(double price, int appId){
        this.price = price;
        this.appId = appId;
    }

    public int getRecId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public int getAppId() {
        return appId;
    }

    public void setRecId(int id) {
        this.id = id;
    }
}
