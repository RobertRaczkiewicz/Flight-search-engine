package model;

public class DataBaseFlights {
    public int price;
    private int id;
    private String departure;
    private String arrival;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public DataBaseFlights() {
    }

    public DataBaseFlights(int id, String departure, String arrival, int price) {
        this.id = id;
        this.departure = departure;
        this.arrival = arrival;
        this.price = price;
    }

    @Override
    public String toString() {
        return "[" + id + "] - " + departure + " - " + arrival + " - " + price;

    }
}
