package nintester.com;

import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;

import java.io.IOException;

public class BotTelegram {
    private static final String BOT_TOKEN = "7880739651:AAFvw99jhC7sK7NbdrjSKqaNkwNYAuHz4FU";
    private static final String CHAT_ID = "-4574454692"; // Thay bằng ID group của bạn

    public void sendMessage(String message) throws IOException {
        String url = "https://api.telegram.org/bot" + BOT_TOKEN + "/sendMessage";
        String payload = String.format("{\"chat_id\":\"%s\",\"text\":\"%s\"}", CHAT_ID, message);

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(new StringEntity(payload, ContentType.APPLICATION_JSON));


        CloseableHttpResponse response = client.execute(httpPost);
        //System.out.println("Message Response: " + response.getClass());
        client.close();
    }

    public static void main(String[] args) throws IOException {
        BotTelegram bt = new BotTelegram();
        bt.sendMessage("TAO LÀ CÁ HÚ");
    }
}
