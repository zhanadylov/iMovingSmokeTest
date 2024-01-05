package org.example.ui.methods;

import java.util.Random;

public class GenerateRandomAddress {
    private static final String[] STREET_NAMES = {
            "Wilshire Boulevard", "Main Street", "Oak Avenue", "Elm Street", "Cedar Lane",
            "Broadway", "Maple Drive", "Pine Street", "Washington Avenue", "Lakeview Drive",
            "Sunset Boulevard", "Highland Avenue", "River Road", "Hillcrest Drive", "Park Avenue",
            "Ocean Avenue", "Central Avenue", "Market Street", "Victory Lane", "Ridge Road"
    };

    private static final String[] CITIES = {
            "Los Angeles", "New York", "Chicago", "San Francisco", "Miami",
            "Houston", "Seattle", "Boston", "Atlanta", "Dallas",
            "Denver", "Phoenix", "Portland", "Las Vegas", "Philadelphia",
            "San Diego", "Minneapolis", "Detroit", "Orlando", "Austin"
    };

    private static final String[] STATES = {
            "CA", "NY", "IL", "FL", "TX",
            "CO", "AZ", "MA", "GA", "WA",
            "NC", "NV", "OR", "PA", "SD",
            "MN", "MI", "FL", "TX", "OH"
    };

    public static String generateRandomAddress() {
        Random random = new Random();

        // Generate a random street number between 1 and 9999
        int streetNumber = random.nextInt(9999) + 1;

        // Randomly select a street name
        String streetName = STREET_NAMES[random.nextInt(STREET_NAMES.length)];

        // Randomly select a city
        String city = CITIES[random.nextInt(CITIES.length)];

        // Randomly select a state
        String state = STATES[random.nextInt(STATES.length)];

        // Generate a random 5-digit zip code
        int zipCode = random.nextInt(90000) + 10000;

        // Format the address
        String address = streetNumber + " " + streetName + ", " + city + ", " + state + ", " + zipCode;
        return address;
    }

    public static String generateAddressInSameState(String existingAddress) {
        Random random = new Random();
        String[] addressParts = existingAddress.split(", ");

        if (addressParts.length != 3) {
            throw new IllegalArgumentException("Invalid address format. Address should be in the format 'Street, City, State, ZipCode'");
        }

        String state = addressParts[2].substring(0,2);
        System.out.println("State"+state);
        // Check if the provided state is valid (exists in the STATES array)
        boolean validState = false;
        for (String validStateCode : STATES) {
            if (state.equals(validStateCode)) {
                validState = true;
                break;
            }
        }

        if (!validState) {
            throw new IllegalArgumentException("Invalid state code in the provided address.");
        }

        // Generate a random street number between 1 and 9999
        int streetNumber = random.nextInt(9999) + 1;

        // Randomly select a street name
        String streetName = STREET_NAMES[random.nextInt(STREET_NAMES.length)];

        // Randomly select a city
        String city = CITIES[random.nextInt(CITIES.length)];

        // Generate a random 5-digit zip code
        int zipCode = random.nextInt(90000) + 10000;

        // Format the new address in the same state
        String newAddress = streetNumber + " " + streetName + ", " + city + ", " + state + " " + zipCode;
        return newAddress;
    }

    public static void main(String[] args) {
        String existingAddress = "1385 Lakeview Drive, Leesburg, FL 34788";
        String newAddressInSameState = generateAddressInSameState(existingAddress);
        System.out.println("Existing Address: " + existingAddress);
        System.out.println("New Address in the Same State: " + newAddressInSameState);
    }
}
