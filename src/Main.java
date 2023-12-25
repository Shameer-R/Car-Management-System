import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        User user = new User();

        User.Load();

        boolean Running = true;

        // Get Users Information

        System.out.println("Hello, what is your name?");
        user.Name = scanner.next();
        System.out.println("Welcome: " + user.Name);


        while (Running) {

            // Give the user options

            System.out.println("\nWhat would you like to do?: ");
            System.out.println("1 - Add a car");
            System.out.println("2 - Remove a car");
            System.out.println("3 - Search for cars");
            System.out.println("0 - Exit Application and Save");

            // Handle user options

            switch (scanner.nextInt()) {
                case 0:
                    user.Exit();
                    System.out.println("\nGoodbye " + user.Name);
                    Running = false;
                    break;
                case 1:

                    System.out.println("Enter the make of the car: ");
                    String carMake = scanner.next();
                    System.out.println("Enter the model of the car: ");
                    String carModel = scanner.next();
                    System.out.println("Enter the color of the car: ");
                    String carColor = scanner.next();
                    System.out.println("Enter the miles per gallon of the car: ");
                    int carMPG = scanner.nextInt();

                    user.AddCar(carMake, carModel, carColor, carMPG);

                    break;
                case 2:
                    user.RemoveCar();
                    break;
                case 3:
                    user.SearchCars();
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }

    }
}