package helper;

import com.github.javafaker.Faker;

import java.util.Locale;

public class JavaFaker {
        static Faker faker = new Faker();

        public static String fakeFirstName(){
                return faker.name().firstName();
        }
        public static String fakeLastName(){
                return faker.name().lastName();
        }
        public static String fakeEmail(){
                return faker.internet().emailAddress();
        }
        public static String fakePassword(){
                return faker.internet().password();
        }
        public static String fakeLogin(){
                return faker.name().username();
        }

        public static String generateRandomAddress() {
                // Create a Faker object with the US locale to generate US-specific addresses
                Faker faker = new Faker(new Locale("en-US"));

                // Generate a random street address, city, state, and zip code using Faker methods
                String streetNumber = faker.address().buildingNumber();
//                String streetAddress = faker.address().streetAddress();
                String streetName = faker.address().streetName();
                String city = faker.address().city();
                String state = faker.address().stateAbbr();
                String zipCode = faker.address().zipCode();

                // Return the random address as a formatted string
                return streetNumber+" " + streetName + ", " + city + ", " + state + ", " + zipCode;
        }

        public static void fillRandomAddress() {
                // Generate a random US address using Faker
                Faker faker = new Faker(new Locale("en-US"));
                String streetNumber = faker.address().buildingNumber();
                String streetName = faker.address().streetName();
                String city = faker.address().city();
                String state = faker.address().stateAbbr();
                String zipCode = faker.address().zipCode();
                String randomAddress = streetNumber + " " + streetName + ", " + city + ", " + state + " " + zipCode;
                System.out.println(randomAddress);
                // Fill the input field with the random address
        }

        public static void fillRandomAddress2() {

                // Generate a random US address using Faker with the en-US locale
                Faker faker = new Faker(new Locale("en-US"));
                String streetNumber = faker.address().buildingNumber();
                String streetName = faker.address().streetName();
                String city = faker.address().city();
                String state = faker.address().stateAbbr();
                String zipCode = faker.address().zipCode();
                String randomAddress = streetNumber + " " + streetName + ", " + city + ", " + state + " " + zipCode;

                // Verify that the address contains a US state abbreviation
                if (!randomAddress.contains("AL") && !randomAddress.contains("AK") && !randomAddress.contains("AZ") &&
                        !randomAddress.contains("AR") && !randomAddress.contains("CA") && !randomAddress.contains("CO") &&
                        !randomAddress.contains("CT") && !randomAddress.contains("DE") && !randomAddress.contains("FL") &&
                        !randomAddress.contains("GA") && !randomAddress.contains("HI") && !randomAddress.contains("ID") &&
                        !randomAddress.contains("IL") && !randomAddress.contains("IN") && !randomAddress.contains("IA") &&
                        !randomAddress.contains("KS") && !randomAddress.contains("KY") && !randomAddress.contains("LA") &&
                        !randomAddress.contains("ME") && !randomAddress.contains("MD") && !randomAddress.contains("MA") &&
                        !randomAddress.contains("MI") && !randomAddress.contains("MN") && !randomAddress.contains("MS") &&
                        !randomAddress.contains("MO") && !randomAddress.contains("MT") && !randomAddress.contains("NE") &&
                        !randomAddress.contains("NV") && !randomAddress.contains("NH") && !randomAddress.contains("NJ") &&
                        !randomAddress.contains("NM") && !randomAddress.contains("NY") && !randomAddress.contains("NC") &&
                        !randomAddress.contains("ND") && !randomAddress.contains("OH") && !randomAddress.contains("OK") &&
                        !randomAddress.contains("OR") && !randomAddress.contains("PA") && !randomAddress.contains("RI") &&
                        !randomAddress.contains("SC") && !randomAddress.contains("SD") && !randomAddress.contains("TN") &&
                        !randomAddress.contains("TX") && !randomAddress.contains("UT") && !randomAddress.contains("VT") &&
                        !randomAddress.contains("VA") && !randomAddress.contains("WA") && !randomAddress.contains("WV") &&
                        !randomAddress.contains("WI") && !randomAddress.contains("WY")) {
                        throw new RuntimeException("Generated address is not in the USA.");
                }
                System.out.println(randomAddress);

                // Fill the input field with the random address
        }

        public static void main(String[] args) {
             fillRandomAddress2();
        }

}
