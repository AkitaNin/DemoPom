package D4;

import com.github.javafaker.Faker;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DataFaker {
    public void generateUserData(String filePath) {
        Faker faker = new Faker();
        String username = faker.name().username().replaceAll("\\.","");
        String password = faker.internet().password(6, 32);
        String phoneNumber = phoneNumberFakeData(faker);
        //System.out.println("hello "+ username);
        JSONObject userData = new JSONObject();
        userData.put("username", username);
        userData.put("password", password);
        userData.put("phoneNumber", phoneNumber);
        writeDataToJsonFile(filePath, userData);
    }

    //Faker phoneNumber with prefix vn 091,097,093,092,099
    public String phoneNumberFakeData(Faker faker){
        String[] vnPhoneNumPrefixes = {"091", "092","093", "097", "099"};
        String vnPhoneNumPrefix = vnPhoneNumPrefixes[faker.random().nextInt(vnPhoneNumPrefixes.length)];//Chọn ngẫu nhiên 1 đầu số
        // Tạo phần còn lại của số điện thoại với độ dài còn lại giới hạn 10 số
        String remainingNumbers = faker.number().digits(10 - vnPhoneNumPrefix.length());
        return vnPhoneNumPrefix + remainingNumbers;
    }

    //Ghi vào file json
    public void writeDataToJsonFile(String jsonFilePath, JSONObject jsonObject) {
        try (OutputStreamWriter file = new OutputStreamWriter(new FileOutputStream(jsonFilePath), "UTF-8")) {
            file.write(jsonObject.toString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Đọc data từ file json
    public static JSONObject parseJsonFileToJsonObject(String jsonFilePath) throws IOException, ParseException {
        //Read existing JSON file with UTF-8 encoding
        String content = new String(Files.readAllBytes(Paths.get(jsonFilePath)), "UTF-8");
        //Create JSONParser to prepare for parsing string content to JSONObject
        JSONParser jsonParser = new JSONParser();
        //Parse string content to JSONObject
        JSONObject jsonObject = (JSONObject) jsonParser.parse(content);
        return jsonObject;
    }

  public static void main(String[] args) throws IOException, ParseException {
      DataFaker faker = new DataFaker();
      String filePath = "src/test/test-data/datakafer.json";
      faker.generateUserData(filePath);
      JSONObject read = parseJsonFileToJsonObject(filePath);
      String username = (String) read.get("username");
      String password = (String) read.get("password");
      String phoneNumber = (String) read.get("phoneNumber");
      System.out.println(username+" "+password);
      System.out.println("Data fake: " + read);
  }

}






