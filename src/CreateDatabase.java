import java.util.List;

import model.DataBaseFlights;
import airlines.AirLines;

public class CreateDatabase {
    public static void main(String[] args) {

        AirLines b = new AirLines();

        b.insertDataBaseFlights("Warsaw", "Berlin", 500);
        b.insertDataBaseFlights("Berlin", "London", 300);
        b.insertDataBaseFlights("Madrid", "Paris", 700);


        List<DataBaseFlights> flights = b.selectFlights();


        System.out.println("List of flights in the database:");
        for (DataBaseFlights k : flights)
            System.out.println(k);

        b.closeConnection();
    }
}
