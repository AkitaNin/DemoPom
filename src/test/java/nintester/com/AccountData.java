package nintester.com;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class AccountData {
    private static final String FILE_PATH = "src/test/test-data/accountdata.json";
    public static List<Account> getAccounts() {
        List<Account> accounts = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(FILE_PATH)) {
            JSONObject obj = (JSONObject) jsonParser.parse(reader);
            JSONArray accountList = (JSONArray) obj.get("accounts");

            for (Object o : accountList) {
                JSONObject accountJson = (JSONObject) o;
                String username = (String) accountJson.get("username");
                String password = (String) accountJson.get("password");

                accounts.add(new Account(username, password));
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return accounts;
    }
            public static class Account {
            private String username;
            private String password;

            public Account(String username, String password) {
                this.username = username;
                this.password = password;
            }

            public String getUsername() {
                return username;
            }

            public String getPassword() {
                return password;
            }
    }
}
