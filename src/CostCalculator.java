public class CostCalculator {
    // SR5: Protect Constant Variables
    private static final double GAS_PRICE_PER_LITER = 2.25;

    // DP3: Least Privilege ( Static method is used because no object state is needed )
    public static double calculateRentalCost(double dailyRate, int days) {

        // DP1: Fail-safe Default ( Return 0 if the number of rental days is invalid )
        if (days <= 0) return 0.0;
        return dailyRate * days;

    }

    // DP3: Least Privilege
    public static double calculateGasCost(double mileage, double fuelEfficiency) {

        // SR4: Operational Limits ( Prevent invalid input values and division by zero )
        if (fuelEfficiency <= 0 || mileage <= 0) return 0.0;

        // Required formula: (mileage ÷ fuelEfficiency) × gas price
        return (mileage / fuelEfficiency) * GAS_PRICE_PER_LITER;
    }

    // DP3: Least Privilege
    public static double calculateTotal(double rentalCost, double gasCost) {

        // DP1: Fail-safe Default ( Return 0 if any cost value is invalid )
        if (rentalCost < 0 || gasCost < 0) return 0.0;

        return rentalCost + gasCost;

    }
}
