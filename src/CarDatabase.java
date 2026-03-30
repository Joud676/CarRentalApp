// least privilege (importing what we need only!)
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarDatabase {
    // least privilege (private and final for constant variables-SR5-)
    private final List<Car> carList = new ArrayList<>();

    public CarDatabase() {
        carList.add(new Car("Honda", "CR-V", Category.SUV, 2026, 30, HierarchicalStructure.STANDARD));
        carList.add(new Car("Honda", "HR-V", Category.CROSSOVER, 2025, 28, HierarchicalStructure.STANDARD));
        carList.add(new Car("Toyota", "Camry", Category.SEDAN, 2026, 51, HierarchicalStructure.INTERMEDIATE));
        carList.add(new Car("Ford", "F150", Category.TRUCK, 2025, 19, HierarchicalStructure.STANDARD));
        carList.add(new Car("Chevrolet", "Corvette", Category.COUPE, 2025, 19, HierarchicalStructure.ECONOMY));
        carList.add(new Car("Hyundai", "Elantra Hybrid", Category.HYBRID, 2025, 54, HierarchicalStructure.INTERMEDIATE));
        carList.add(new Car("Toyota", "Sienna", Category.MINIVAN, 2025, 36, HierarchicalStructure.VAN));
    }

    public List<Car> getAllCars(){
        return Collections.unmodifiableList(carList);
    }
}
