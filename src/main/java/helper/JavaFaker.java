package helper;

import com.github.javafaker.Faker;

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

}
