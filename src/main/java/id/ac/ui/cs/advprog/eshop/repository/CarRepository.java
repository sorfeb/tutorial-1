package id.ac.ui.cs.advprog.eshop.repository;
import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Repository
public class CarRepository implements TemplateRepository<Car> {
    static int id = 0;

    private List<Car> carData = new ArrayList<>();

    public Car create(Car car) {
        if (car.getProductId() == null) {
            UUID uuid = UUID.randomUUID();
            car.setProductId(uuid.toString());
        }
        carData.add(car);
        return car;
    }

    public Iterator<Car> findAll() {
        return carData.iterator();
    }

    public Car findById(String carId) {
        for (Car car : carData) {
            if (car.getProductId().equals(carId)) {
                return car;
            }
        }
        return null;
    }

    public Car update(Car updatedCar) {
        for (Car car : carData) {
            if (car.getProductId().equals(updatedCar.getProductId())) {
                //Update the existing car with the new information
                car.setProductName(
                        updatedCar.getProductName()
                );
                car.setColor(
                        updatedCar.getColor()
                );
                car.setProductQuantity(
                        updatedCar.getProductQuantity()
                );
                return updatedCar;
            }
        }
        return null; //Handle the case where the car is not found
    }

    public Car deleteById(String carId) {
        for (Car car : carData) {
            if (car.getProductId().equals(carId)) {
                carData.remove(car);
                return car;
            }
        }
        throw new ArrayIndexOutOfBoundsException("Car not found");
    }
}

