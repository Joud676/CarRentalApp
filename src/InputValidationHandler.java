public class InputValidationHandler {

    // SR1 (INPUT VALIDATION)
    // SR2 (SECURE ERROR HANDLING)
    // FIRST LAYER IN DEFENSE IN DEPTH (INPUT VALIDATION)
    // Psychological Acceptability (CLEAR ERROR MESSAGES)
    // Minimize Trust Surface (ALL USERS' INPUTS MUST BE CHECKED)

    public static int validateDays(int days) throws IllegalArgumentException {
        if (days < 0) {
            throw new IllegalArgumentException("Sorry, rental days cannot be a negative number.\n");
        }

        if (days == 0) {
            throw new IllegalArgumentException("Sorry, rental days cannot be zero. It must be at least 1.\n");
        }

        if (days > 365) {
            throw new IllegalArgumentException("Sorry, a car cannot be rented for more than 365 days.\n");
        }
        return days;
    }

    public static int validatePassengers(int passengers) throws IllegalArgumentException{
        if (passengers < 0) {
            throw new IllegalArgumentException("Sorry, the number of passengers cannot be negative.\n");
        }

        if (passengers == 0) {
            throw new IllegalArgumentException("Sorry, the number of passengers cannot be zero. It must be at least 1.\n");
        }

        if (passengers > 7) {
            throw new IllegalArgumentException("Sorry, the maximum capacity of our cars is 7 passengers.\n");
        }
        return passengers;
    }

    public static double validateMileage(double mileage) throws IllegalArgumentException{
        if (mileage < 0) {
            throw new IllegalArgumentException("Sorry, the mileage cannot be a negative number.\n");
        }

        if (mileage == 0) {
            throw new IllegalArgumentException("Sorry, the mileage cannot be zero. It must be greater than 0.\n");
        }

        if (mileage > 50000) {
            throw new IllegalArgumentException("Sorry, the entered mileage exceeds the allowable operational limit.\n");
        }
        return mileage;
    }

    // Usability (Accept user input even if he enters an Arabic number)

    public static String normalizeArabicNumbers(String input) {

        return input.replace("٠", "0")
                .replace("١", "1")
                .replace("٢", "2")
                .replace("٣", "3")
                .replace("٤", "4")
                .replace("٥", "5")
                .replace("٦", "6")
                .replace("٧", "7")
                .replace("٨", "8")
                .replace("٩", "9");
    }

}
