import java.util.List;

import model.DataBaseFlights;
import airlines.AirLines;

public class CreateDatabase {
    public static void main(String[] args) {

        AirLines b = new AirLines();

        b.insertDataBaseFlights("Warsaw", "Berlin", 500);
        b.insertDataBaseFlights("Berlin", "London", 300);
        b.insertDataBaseFlights("Madrid", "Paris", 700);
        b.insertDataBaseFlights("Warsaw", "Madrid", 150);
        b.insertDataBaseFlights("Warsaw", "London", 200);
        b.insertDataBaseFlights("Warsaw", "Roma", 250);
        b.insertDataBaseFlights("Berlin", "London", 80);
        b.insertDataBaseFlights("Berlin", "Roma", 120);
        b.insertDataBaseFlights("Berlin", "Paris", 50);
        b.insertDataBaseFlights("Paris", "Athens", 120);
        b.insertDataBaseFlights("Paris", "Amsterdam", 40);
        b.insertDataBaseFlights("Amsterdam", "Lisbon", 200);
        b.insertDataBaseFlights("Lisbon", "London", 180);

        List<DataBaseFlights> flights = b.selectFlights();


        System.out.println("List of flights in the database:");
        for (DataBaseFlights k : flights)
            System.out.println(k);

        b.closeConnection();
    }

}

