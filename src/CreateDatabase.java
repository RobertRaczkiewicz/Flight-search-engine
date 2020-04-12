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

    }
}



