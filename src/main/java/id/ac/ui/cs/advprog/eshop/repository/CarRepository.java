package id.ac.ui.cs.advprog.eshop.repository;
import id.ac.ui.cs.advprog.eshop.model.Car;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
public class CarRepository {
    static int id = 0;

    private List<Car> carData = new ArrayList<>();

    public Car createCar(Car car) {
        if (car.getCarId() == null) {
            UUID uuid = UUID.randomUUID();
            car.setCarId(uuid.toString());
        }
        carData.add(car);
        return car;
    }
    public Iterator<Car> findAll() {
        return carData.iterator();
    }

    public Car findById(String carId) {
        for (Car car : carData) {
            if (car.getCarId().equals(carId)) {
                return car;
            }
        }
        return null;
    }

    public Car update(String id, Car updatedCar) {
        for (int i = 0; i < carData.size(); i++) {
            Car car = carData.get(i);
            if (car.getCarId().equals(id)) {
                //Update the existing car with the new information
                car.setCarName(updatedCar.getCarName());
                car.setCarColor(updatedCar.getCarColor());
                car.setCarQuantity(updatedCar.getCarQuantity());
                return updatedCar;
            }
        }
        return null; //Handle the case where the car is not found
    }
    public void delete(String carId) { carData.removeIf(car -> car.getCarId().equals(carId));}
}
