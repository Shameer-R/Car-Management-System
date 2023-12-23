import java.util.ArrayList;
import java.util.List;

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

        for (int i = 0; i < garage.size(); i++) {
            Car carIndex = garage.get(i);
            System.out.println(carIndex.make + " - " + carIndex.model + " - " + carIndex.color + " - " + carIndex.mpg);
        }
    }

    public void Remove() {
        System.out.println("Remove cars");
    }
}
