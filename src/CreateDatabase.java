import java.util.Scanner;

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
            else if (option != 1 && option != 2) {
                System.out.println("Incorrect number of option. Please, try again!");
            }
        } while (option != 2);

    }
}



