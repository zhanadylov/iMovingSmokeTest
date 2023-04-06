package helper;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

public class JavaFaker {
        static Faker faker = new Faker(new Locale("en-US"));
        public static Random random = new Random();


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


        private static final String[] STREET_NAMES = {"Main St.", "Oak St.", "Maple Ave.", "Elm St.", "Cedar Rd.",
                                "Park Ave.", "Hill St.", "Pine Rd.", "Broadway", "Washington Blvd.",
                                "Church St.", "Chestnut St.", "Grand Ave.", "First St.", "Spring St.",
                                "Lakeview Dr.", "Sunset Blvd.", "Highland Ave.", "River Rd.", "Linden St.",
                                "Market St.", "Adams St.", "Jefferson Ave.", "Madison St.", "Monroe Rd.",
                                "Willow St.", "Franklin Ave.", "Holly Rd.", "Birch St.", "Magnolia Blvd."
        };

        private static final String[] CITY_NAMES = {"New York", "Los Angeles", "Chicago", "Houston", "Philadelphia", "Las Vegas", "San Jose",
                "Miami", "Dallas", "Seattle", "Boston", "San Francisco", "Austin", "Washington", "Atlanta",
                "Denver", "Phoenix", "San Diego", "Detroit", "Portland", "Minneapolis", "Baltimore", "Tampa",
                "Charlotte", "Nashville", "Kansas City", "Oakland", "Raleigh", "Cleveland", "New Orleans"
        };

        private static final String[] STATE_CODES = {"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};

        public static String generateAddress() {
                int streetNumber = random.nextInt(1000) + 1; // Random street number between 1 and 1000
                String streetName = STREET_NAMES[random.nextInt(STREET_NAMES.length)]; // Random street name
                String city = CITY_NAMES[random.nextInt(CITY_NAMES.length)]; // Random city name
                String stateCode = STATE_CODES[random.nextInt(STATE_CODES.length)]; // Random state code
                int zipCode = random.nextInt(90000) + 10000; // Random zip code between 10000 and 99999

                return String.format("%d %s, %s, %s %d", streetNumber, streetName, city, stateCode, zipCode);
        }

}
