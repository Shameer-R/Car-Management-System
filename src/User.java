import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class User {
    public String Name;
    private static final String FileName = "Car-Management.txt";

    static List<Car> garage = new ArrayList<Car>();

    private static void SaveObject(String filename) throws IOException {
        FileOutputStream fileSaver = new FileOutputStream(filename);
        ObjectOutputStream objectSaver = new ObjectOutputStream(fileSaver);
        objectSaver.writeObject(garage);
        objectSaver.flush();
        objectSaver.close();
    }

    private static <T> T LoadObject(String fileName) throws IOException, ClassNotFoundException{
        FileInputStream fileLoader = new FileInputStream("Car-Management.txt");
        ObjectInputStream objectloader = new ObjectInputStream(fileLoader);
        T loadedObject = (T) objectloader.readObject();
        objectloader.close();
        return loadedObject;
    }

    public static void Load() {
        System.out.println("Loading cars");

        List<Car> loadedCar = null;

        try {
            loadedCar = LoadObject(FileName);
        } catch (IOException e) {
            System.err.println("Car was not loaded :(");
        } catch (ClassNotFoundException e) {
            System.err.println("File not found");
        }
        System.out.println("Loaded successfully");
        System.out.println(loadedCar);
    }

    public void AddCar(String carMake, String carModel, String carColor, int carMPG) {
        Car car = new Car();
        car.make = carMake;
        car.model = carModel;
        car.color = carColor;
        car.mpg = carMPG;
        garage.add(car);
    }

    public void RemoveCar() {
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

    public void SearchCars() {
        for (int i = 0; i < garage.size(); i++) {
            Car carIndex = garage.get(i);
            System.out.println(carIndex.make + " - " + carIndex.model + " - " + carIndex.color + " - " + carIndex.mpg);
        }
    }

    public void Exit() {
            try {
              SaveObject(FileName);
            } catch (IOException e) {
                System.err.println(FileName + " was not saved");
            }
            System.out.println(FileName + " saved successfully");
        }
}
