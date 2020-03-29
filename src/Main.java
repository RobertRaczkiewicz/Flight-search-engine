import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        FlightDatabase database = new FlightDatabase();

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

        Flight cheapestFlight= database.getCheapestFlight();
        System.out.println("Cheapest flight: "+ cheapestFlight.getDetails());

        System.out.println("From which city are you interested in the cheapest flight?");
        String fromCityCheapest= scanner.nextLine();

        Flight cheapestFightFromCity=database.getCheapestFightFromCity(fromCityCheapest);
        System.out.println("Cheapest flight is: "+ cheapestFightFromCity.getDetails());


    }
}
        class Flight{
            String departure;
            String arrival;
            int price;

            public Flight (String departure, String arrival, int price){
            this.departure=departure;
            this.arrival=arrival;
            this.price=price;
            }

            public String getDetails() {
                return "Flight from " + this.departure + " to " + this.arrival+ " costs: " + this.price +"$";
            }
        }

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

                for (int i = 0; i < this.flights.size(); i++) {
                    Flight flight = this.flights.get(i);

                    if (departure.equals(flight.departure) && arrival.equals(flight.arrival)) {
                        System.out.println("Flight exists!!!");
                        return;
                    }
                }
                System.out.println("Flight with given params not exists!");
            }

            public void getFlightsFromCity(String fromCity) {
                System.out.println("Below is a list of flights from the city: " + fromCity);
                boolean isNotFound = true;

                for (int i = 0; i < this.flights.size(); i++) {
                    Flight flight = this.flights.get(i);

                    if (fromCity.equals((flight.departure))) {
                        System.out.println("Departure: " + flight.departure + " Arrival: " + flight.arrival);
                        isNotFound = false;
                    }
                }
                if (isNotFound) {
                    System.out.println("Sorry, there are currently no flights from the selected city!!!");
                }
            }

            public void getFlightsToCity(String toCity) {
                System.out.println("Below is a list of flights to the city: " + toCity);
                boolean isNotFound = true;

                for (int i = 0; i < this.flights.size(); i++) {
                    Flight flight = this.flights.get(i);

                    if (toCity.equals((flight.arrival))) {
                        System.out.println("Departure: " + flight.departure + " Arrival: " + flight.arrival);
                        isNotFound = false;
                    }
                }
                if (isNotFound) {
                    System.out.println("Sorry, there are currently no flights to the selected city!!!");
                }
            }

            public ArrayList<String> getCities() {
                ArrayList<String> cities = new ArrayList<>();
                for (int i = 0; i < this.flights.size(); i++) {
                    Flight flight = this.flights.get(i);
                    if (!cities.contains(flight.departure)) {
                        cities.add(flight.departure);
                    }
                    if (!cities.contains(flight.arrival)) {
                        cities.add(flight.arrival);
                    }
                }
                return cities;
            }

            public Flight getCheapestFlight() {
                Flight cheapestFlight = null;
                for (Flight flight : this.flights) {
                    if (cheapestFlight == null || flight.price < cheapestFlight.price) {
                        cheapestFlight = flight;
                    }
                }
                return cheapestFlight;
            }

            public Flight getCheapestFightFromCity(String fromCity) {
                Flight cheapestFlight = null;
                for (int i = 0; i < this.flights.size(); i++) {
                    Flight flight = this.flights.get(i);
                    if (fromCity.equals(flight.departure)) {
                        if (cheapestFlight == null || flight.price < cheapestFlight.price) {
                        cheapestFlight = flight;
                        }

                    }
                }
                return cheapestFlight;
            }
        }


