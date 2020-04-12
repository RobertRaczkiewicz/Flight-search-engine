import airlines.AirLines;
import model.DataBaseFlights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        FlightDatabase database = new FlightDatabase();
        AirLines b = new AirLines();
        List<DataBaseFlights> flights = b.selectFlights();

        b.closeConnection();

        CreateDatabase option= new CreateDatabase();
        option.createDatabase();

        System.out.println("Please select the city from which you are interested in the departure of the plane:");
        String fromCity=scanner.nextLine();
        database.getFlightsFromCity(fromCity);

        System.out.println("Please select the city you want to fly to:");
        String toCity=scanner.nextLine();
        database.getFlightsToCity(toCity);

        System.out.println("Please select the city of departure:");
        String departure=scanner.nextLine();
        System.out.println("Please select the city of arrival:");
        String arrival=scanner.nextLine();

        database.checkIfFlightExists(departure, arrival);

        ArrayList<String> cities=database.getCities();
        System.out.println(cities);

        DataBaseFlights cheapestFlight = database.getCheapestFlight();
        System.out.println("Cheapest flight: "+ cheapestFlight);

        System.out.println("From which city are you interested in the cheapest flight?");
        String fromCityCheapest= scanner.nextLine();

        DataBaseFlights cheapestFightFromCity=database.getCheapestFightFromCity(fromCityCheapest);
        System.out.println("Cheapest flight is: "+ cheapestFightFromCity);

        System.out.println("Please select from which city you want to take off?");
        String start=scanner.nextLine();
        System.out.println("Please select in which city you want to land");
        String end=scanner.nextLine();

//        ArrayList<Journey> journeys = database.getFlights(start, end);
//        System.out.println(journeys);
    }
}





