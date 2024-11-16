package nintester.com;

import com.github.javafaker.Faker;
import com.google.gson.JsonObject;

public class Datafaker_Generate {
    private static final Faker faker = new Faker();

    public static void generateUserData(String filePath) {
        String username = faker.name().username();
        String password = faker.internet().password(6, 32);
        String phoneNumber = faker.phoneNumber().phoneNumber();

        JsonObject userData = new JsonObject();
        userData.addProperty("username", username);
        userData.addProperty("password", password);
        userData.addProperty("phonenumber", phoneNumber);
    }
}
