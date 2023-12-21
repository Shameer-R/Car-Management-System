import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        User user = new User();

        // Get Users Information

        System.out.println("Hello, what is your name?");
        user.Name = scanner.next();
        System.out.println("Welcome: " + user.Name);

        // Give the user options

        System.out.println("\nWhat would you like to do?: ");
        System.out.println("1 - Add a car");
        System.out.println("2 - Remove a car");
        System.out.println("3 - Search for cars");

        // Handle user options

        switch (scanner.nextInt()) {
            case 1:
                user.Add();
                break;
            case 2:
                user.Remove();
                break;
            case 3:
                System.out.println("This has not been implemented yet.");
                break;
             default:
                System.out.println("ERROR");
        }
    }
}