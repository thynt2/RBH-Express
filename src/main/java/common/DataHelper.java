package common;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataHelper {
    private Locale locate = new Locale("en");
    private Faker faker = new Faker(locate);

    public static DataHelper getData() {
        return new DataHelper();
    }

    public String getFirstName() {
        return faker.name().firstName();
    }

    public String getLastName() {
        return faker.name().lastName();
    }

    public String getEmail() {
        return faker.internet().emailAddress();
    }

    public String getPhoneNumber() {
        return faker.phoneNumber().phoneNumber();
    }

    public String getPassword() {
        return faker.internet().password();
    }
}
