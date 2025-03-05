package core;

import com.github.javafaker.Faker;

public class TestDataProvider {

    public static String getTestEmail() {
        Faker faker = new Faker();
        return String.format("%s@test.com", faker.name().username());
    }
}
