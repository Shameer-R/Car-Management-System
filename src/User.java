import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    public String Name;

    List<Car> garage = new ArrayList<Car>();

    public void Add(String carMake, String carModel, String carColor, int carMPG) {
        Car car = new Car();
        car.make = carMake;
        car.model = carModel;
        car.color = carColor;
        car.mpg = carMPG;
        garage.add(car);
    }

    public void Remove() {
       if (!garage.isEmpty()) {
           System.out.println("Enter the index of the car you want to remove: ");
           for (int i = 0; i < garage.size(); i++) {
               Car carIndex = garage.get(i);
               System.out.println(i + ": " + carIndex.make + " - " + carIndex.model + " - " + carIndex.color + " - " + carIndex.mpg);
           }

           Scanner scanner = new Scanner(System.in);

           int removeIndex = scanner.nextInt();

           if (removeIndex >= 0 && removeIndex <= garage.size()) {
               Car carIndex = garage.get(removeIndex);
               System.out.println("The " + carIndex.color + " " + carIndex.make + " " + carIndex.model + " has been removed.");
               garage.remove(carIndex);
           } else {
               System.out.println("There is no car with that index.");
           }

       } else {
           System.out.println("There are no cars to remove.");
       }
    }
}
