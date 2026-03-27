import java.util.Scanner;

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
    }
}

