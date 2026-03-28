import java.util.Scanner;
import java.util.List;


public class CarRentalApplication {


    public void start() {
        displayWelcomeMessage();
        collectAndValidateInputs();
    }

    // usability (good look design)
    private void displayWelcomeMessage() {
        System.out.println("                ***************");
        System.out.println("           ****               ****");
        System.out.println("        ***                       ***");
        System.out.println("      ***                           ***");
        System.out.println("  *****************************************");
        System.out.println(" *******************************************");
        System.out.println(" ***********                 ***********");
        System.out.println("    ******                     ******");
        System.out.println("     ****                       ****");
        System.out.println();
        System.out.println("************************************************");
        System.out.println("***   Welcome to the Car Rental Application! ***");
        System.out.println("************************************************\n");
    }

    private void collectAndValidateInputs() {
        Scanner scanner = new Scanner(System.in);
        int days = 0;
        int passengers = 0;
        double mileage = 0.0;

        boolean isValid = false; // Fail-safe Default

        while (!isValid) {
            try {
                System.out.print("Please enter the number of rental days: ");
                String daysInput = scanner.next();
                daysInput = InputValidationHandler.normalizeArabicNumbers(daysInput);
                days = Integer.parseInt(daysInput);
                days = InputValidationHandler.validateDays(days);
                isValid = true;
            } catch (NumberFormatException e) {
                // Fail Secure (prevent the long java error) -SR2- & Psychological Acceptability
                System.out.println("Error: Please enter valid numbers only, without letters or symbols.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Sorry, an unexpected error occurred. Please try again.");
            }
        }

        isValid = false; // Fail-safe Default
        while (!isValid) {
            try {
                System.out.print("Please enter the number of passengers: ");
                String passengersInput = scanner.next();
                passengersInput = InputValidationHandler.normalizeArabicNumbers(passengersInput);
                passengers = Integer.parseInt(passengersInput);
                passengers = InputValidationHandler.validatePassengers(passengers);
                isValid = true;
            } catch (NumberFormatException e) {
                // Fail Secure (prevent the long java error) -SR2- & Psychological Acceptability
                System.out.println("Error: Please enter valid numbers only, without letters or symbols.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Sorry, an unexpected error occurred. Please try again.");
            }
        }

        isValid = false; // Fail-safe Default
        while (!isValid) {
            try {
                System.out.print("Please enter the expected mileage: ");
                String mileageInput = scanner.next();
                mileageInput = InputValidationHandler.normalizeArabicNumbers(mileageInput);
                mileage = Double.parseDouble(mileageInput);
                mileage = InputValidationHandler.validateMileage(mileage);
                isValid = true;
            } catch (NumberFormatException e) {
                // Fail Secure (prevent the long java error) -SR2- & Psychological Acceptability
                System.out.println("Error: Please enter valid numbers only, without letters or symbols.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Sorry, an unexpected error occurred. Please try again.");
            }
        }
        System.out.println("\n[🔍] Searching our database for the best matches...");

        try {
            // 1. Create the database and selector objects
            CarDatabase db = new CarDatabase();
            CarSelector selector = new CarSelector();

            // 2. Search for the best matching cars using validated inputs
            List<Car> bestCars = selector.findBestCars(db.getAllCars(), passengers, days, mileage);

            // 3. Display results clearly for better usability and user acceptance
            if (bestCars.isEmpty()) {
                System.out.println("\n[!] Sorry, no cars found matching your requirements.");
            } else {
                System.out.println("\n==========================================");
                System.out.println("   SUCCESS! WE FOUND THE BEST OPTION(S):  ");

                System.out.println("==========================================");

                for (Car car : bestCars) {
                    // Use CostCalculator to display a detailed cost breakdown
                    double rental = CostCalculator.calculateRentalCost(car.getStructure().getRentalCost(), days);
                    double gas = CostCalculator.calculateGasCost(mileage, car.getFuel());
                    double total = CostCalculator.calculateTotal(rental, gas);

                    System.out.println("Vehicle: " + car.getMake() + " " + car.getModel() + " (" + car.getYear() + ")");
                    System.out.println("Comfort Level: " + car.getStructure().getComfortLevel());
                    System.out.println("------------------------------------------");
                    // DP7: Usability - Ensures clear and consistent number formatting for better readability.
                    System.out.printf(java.util.Locale.US, "> Rental Cost: $%.2f\n", rental);
                    System.out.printf(java.util.Locale.US, "> Gas Cost:    $%.2f\n", gas);
                    System.out.printf(java.util.Locale.US, "> TOTAL COST:  $%.2f\n", total);
                    System.out.println("==========================================\n");
                }
            }

        } catch (Exception e) {
            // SR2: Secure Error Handling (Show a generic message without exposing internal system details)
            System.out.println("\n[!] An unexpected error occurred while retrieving the car data.");
            System.out.println("[!] Please try again later or contact support.");
        }

    }
}

