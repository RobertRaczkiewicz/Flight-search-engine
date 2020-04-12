import java.util.Scanner;
import java.util.List;

import model.DataBaseFlights;
import airlines.AirLines;

class CreateDatabase {
    int option;
    Scanner scanner = new Scanner(System.in);

    public void createDatabase() {
        do {
            System.out.println("Do you want work with flight database?");
            System.out.println("1 - YES");
            System.out.println("2 - NO");
            option = scanner.nextInt();

            if (option == 2) {
                System.out.println("Thank you!");
                break;
            }
            else if (option == 1) {
                CreateDatabase menu= new CreateDatabase();
                menuCreateDatabase();
            }
            else if (option != 1 && option != 2) {
                System.out.println("Incorrect number of option. Please, try again!");
            }
        } while (option != 2);

    }
    public void menuCreateDatabase(){
        System.out.println("Please, choose what do you want to do:");
        System.out.println("1 - Display list of flights");
        System.out.println("2 - Add a new flight");
        System.out.println("3 - Remove an existing flight");
        Scanner scanner = new Scanner(System.in);
        int a=scanner.nextInt();
        if (a==1){
            listOfFlights();
        }
        else if (a==2){
            addFlight();
        }
        else if (a==3){
            deleteFlight();
        }
    }
    public void listOfFlights(){
        AirLines b = new AirLines();
        List<DataBaseFlights> flights = b.selectFlights();

        System.out.println("List of flights in the database:");
        for (DataBaseFlights k : flights)
            System.out.println(k);
    }
    public void addFlight(){
        System.out.println("Please input from which city want you add flight:");
        scanner.nextLine();
        String addCityDeparture = scanner.nextLine();
        System.out.println("Please input to which city want you add flight:");
        String addCityArrival = scanner.nextLine();
        AirLines b=new AirLines();
        List<DataBaseFlights> flights=b.selectFlights();

        for (int i=0; i< flights.size(); i++){
            DataBaseFlights flight= flights.get(i);

            if (addCityDeparture.equals(flight.getDeparture()) && addCityArrival.equals(flight.getArrival())) {
                System.out.println("Flight exists!!!");
                System.out.println("Flight number:" + flight);
                return;
            }
            else {
                System.out.println("Please input the price of the flight from: " +addCityDeparture+ " to: " + addCityArrival);
                int cost=scanner.nextInt();
                b.insertDataBaseFlights(addCityDeparture,addCityArrival,cost);
                System.out.println("A new flight has been added!");
                return;
            }
        }
    }
    public void deleteFlight(){
        AirLines b=new AirLines();
        List<DataBaseFlights> flights=b.selectFlights();
        System.out.println("Please select the city from which you are interested in the departure of the plane:");
        scanner.nextLine();
        String fromCity=scanner.nextLine();

        FlightDatabase database = new FlightDatabase();
        System.out.println("Which ID flight want you delete?");
        int id=scanner.nextInt();
        b.deleteDataBaseFlights(id);
    }
}



