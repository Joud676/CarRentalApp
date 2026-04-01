import java.util.ArrayList;
import java.util.List;

public class CarSelector {

    public List<Car> findBestCars(List<Car> allCars, int passengers, int days, double mileage) {
        List<Car> bestOptions = new ArrayList<>();

        if (allCars == null || allCars.isEmpty() ||
                !InputValidationHandler.isValid(passengers, days, mileage)) {
            return bestOptions;
        }

        List<Car> suitableCars = new ArrayList<>();

        for (Car car : allCars) {
            if (car.getStructure().getMaximumPassengers() >= passengers) {
                suitableCars.add(car);
            }
        }

// DP1: Fail-safe Default ( Return empty result if no suitable cars are found )
        if (suitableCars.isEmpty()) {
            return bestOptions;
        }
        double minTotal = Double.MAX_VALUE;

        // Find the cheapest car, then compare comfort level if needed
        for (Car car : suitableCars) {
            double rental = CostCalculator.calculateRentalCost(car.getStructure().getRentalCost(), days);
            double gas = CostCalculator.calculateGasCost(mileage, car.getFuel());
            double total = CostCalculator.calculateTotal(rental, gas);

            // Ignore invalid calculated values
            if (total <= 0) {
                continue;
            }

            if (total < minTotal) {
                minTotal = total;
                bestOptions.clear();
                bestOptions.add(car);
            } else if (total == minTotal) {
                handleComfortComparison(bestOptions, car);
            }
        }

        return bestOptions;

    }

    // DP3: Least Privilege (Private helper method for comparing comfort levels)
    private void handleComfortComparison(List<Car> currentBest, Car newCar) {
        if (currentBest.isEmpty()) {
            currentBest.add(newCar);
            return;
        }

        int bestComfort = getComfortScore(currentBest.get(0).getStructure().getComfortLevel());
        int newComfort = getComfortScore(newCar.getStructure().getComfortLevel());

        if (newComfort > bestComfort) {
            currentBest.clear();
            currentBest.add(newCar);
        } else if (newComfort == bestComfort) {
            currentBest.add(newCar);
        }
    }

    // Convert comfort level into a numeric score for comparison
    private int getComfortScore(String comfort) {
        if (comfort == null) return 0;

        return switch (comfort) {
            case "Good" -> 3;
            case "Medium" -> 2;
            case "Poor" -> 1;
            default -> 0;
        };
    }
}
