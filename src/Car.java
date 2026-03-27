public class Car {
    // least privilege (private and final for constant variables-SR5-)
    private final String make;
    private final String model;
    private final Category category;
    private final int year;
    private final double fuel;
    private final HierarchicalStructure structure;
    // least privilege (and no setters)


    public Car(String make, String model, Category category, int year, double fuel, HierarchicalStructure structure) {
        this.make = make;
        this.model = model;
        this.category = category;
        this.year = year;
        this.fuel = fuel;
        this.structure = structure;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public Category getCategory() {
        return category;
    }

    public int getYear() {
        return year;
    }

    public double getFuel() {
        return fuel;
    }

    public HierarchicalStructure getStructure() {
        return structure;
    }
}
