public enum HierarchicalStructure {

    ECONOMY(45, 4, "Poor"),
    INTERMEDIATE(50, 4, "Medium"),
    STANDARD(55, 5, "Good"),
    VAN(70, 7, "Medium");

    private final double rentalCost;
    private final int maximumPassengers;
    private final String comfortLevel;

    HierarchicalStructure(double rentalCost, int maximumPassengers, String comfortLevel) {
        this.rentalCost = rentalCost;
        this.maximumPassengers = maximumPassengers;
        this.comfortLevel = comfortLevel;
    }

    public double getRentalCost() {
        return rentalCost;
    }

    public int getMaximumPassengers() {
        return maximumPassengers;
    }

    public String getComfortLevel() {
        return comfortLevel;
    }
}
