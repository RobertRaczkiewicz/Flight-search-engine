import java.util.ArrayList;
import java.util.List;

import airlines.AirLines;
import model.DataBaseFlights;

class FlightDatabase {
    ArrayList<Flight> flights = new ArrayList<Flight>();
    private java.lang.Object Object;

    public FlightDatabase() {

        this.flights.add(new Flight("Warsaw", "Berlin", 100));
        this.flights.add(new Flight("Warsaw", "Madrid", 150));
        this.flights.add(new Flight("Warsaw", "London", 200));
        this.flights.add(new Flight("Warsaw", "Roma", 250));
        this.flights.add(new Flight("Berlin", "London", 80));
        this.flights.add(new Flight("Berlin", "Roma", 120));
        this.flights.add(new Flight("Berlin", "Paris", 50));
        this.flights.add(new Flight("Paris", "Athens", 120));
        this.flights.add(new Flight("Paris", "Amsterdam", 40));
        this.flights.add(new Flight("Amsterdam", "Lisbon", 200));
        this.flights.add(new Flight("Lisbon", "London", 180));
    }

    public void checkIfFlightExists(String departure, String arrival) {
        System.out.println("Departure is: " + departure + " and arrival is: " + arrival);
        AirLines b = new AirLines();
        List<DataBaseFlights> flights = b.selectFlights();
        for (int i = 0; i < flights.size(); i++) {
            DataBaseFlights flight = flights.get(i);

            if (departure.equals(flight.getDeparture()) && arrival.equals(flight.getArrival())) {
                System.out.println("Flight exists!!!");
                System.out.println("Flight number:"+flight);
                return;
            }
        }
        System.out.println("Flight with given params not exists!");
    }

    public void getFlightsFromCity(String fromCity) {
        AirLines b = new AirLines();
        List<DataBaseFlights> flights = b.selectFlights();
        System.out.println("Below is a list of flights from the city: " + fromCity);
        boolean isNotFound = true;

        for (int i = 0; i < flights.size(); i++) {
            DataBaseFlights flight = flights.get(i);

            if (fromCity.equals((flight.getDeparture()))) {
                System.out.println("Flight number: " + flight);
                isNotFound = false;
            }
        }
        if (isNotFound) {
            System.out.println("Sorry, there are currently no flights from the selected city!!!");
        }
    }

    public void getFlightsToCity(String toCity) {
        AirLines b = new AirLines();
        List<DataBaseFlights> flights = b.selectFlights();
        System.out.println("Below is a list of flights to the city: " + toCity);
        boolean isNotFound = true;

        for (int i = 0; i < flights.size(); i++) {
            DataBaseFlights flight = flights.get(i);

            if (toCity.equals((flight.getArrival()))) {
                System.out.println("Flight number: " + flight);
                isNotFound = false;
            }
        }
        if (isNotFound) {
            System.out.println("Sorry, there are currently no flights to the selected city!!!");
        }
    }

    public ArrayList<String> getCities() {
        AirLines b = new AirLines();
        List<DataBaseFlights> flights = b.selectFlights();
        ArrayList<String> cities = new ArrayList<>();
        for (int i = 0; i < flights.size(); i++) {
            DataBaseFlights flight = flights.get(i);
            if (!cities.contains(flight.getDeparture())) {
                cities.add(flight.getDeparture());
            }
            if (!cities.contains(flight.getArrival())) {
                cities.add(flight.getArrival());
            }
        }
        return cities;
    }

    public DataBaseFlights getCheapestFlight() {
        AirLines b = new AirLines();
        List<DataBaseFlights> flights = b.selectFlights();
        DataBaseFlights cheapestFlight = null;
        for (int i = 0; i < flights.size(); i++) {
            DataBaseFlights flight = flights.get(i);
            if (cheapestFlight == null || flight.getPrice() < cheapestFlight.price) {
                cheapestFlight = flight;
            }
        }
        return cheapestFlight;
    }

    public DataBaseFlights getCheapestFightFromCity(String fromCity) {
        AirLines b = new AirLines();
        List<DataBaseFlights> flights = b.selectFlights();
        DataBaseFlights cheapestFlight = null;
        for (int i = 0; i < flights.size(); i++) {
            DataBaseFlights flight = flights.get(i);
            if (fromCity.equals(flight.getDeparture())) {
                if (cheapestFlight == null || flight.getPrice() < cheapestFlight.price) {
                    cheapestFlight = flight;
                }
            }
        }
        return cheapestFlight;
    }
//    public ArrayList<Flight> getFlights (String start, String end){
//        ArrayList<Flight> starting = getFlightsFromCity(start);
//        ArrayList<Flight> ending= getFlightsToCity(end);
//        ArrayList<Flight> result = new ArrayList<Flight>();
//        for (Flight first : starting){
//            for (Flight second : ending){
//                if (first.arrival.equals(second.departure)){
//                    result.add(new Journey(first, second));
//                }
//            }
//        }
//        return result;
//    }
}
