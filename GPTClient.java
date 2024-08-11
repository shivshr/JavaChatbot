import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.HttpResponseException;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.StringEntity;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GPTClient {
    private static final String API_URL = "https://api.openai.com/v1/completions";
    private static final String API_KEY = "your-api-key-here";

    public String generateResponse(String prompt) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost request = new HttpPost(API_URL);
        request.addHeader("Content-Type", "application/json");
        request.addHeader("Authorization", "Bearer " + API_KEY);

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("model", "text-davinci-003");
        requestBody.put("prompt", prompt);
        requestBody.put("max_tokens", 150);

        ObjectMapper objectMapper = new ObjectMapper();
        StringEntity entity = new StringEntity(objectMapper.writeValueAsString(requestBody));
        request.setEntity(entity);

        try (CloseableHttpResponse response = client.execute(request)) {
            if (response.getCode() != 200) {
                throw new HttpResponseException(response.getCode(), "Request to GPT API failed");
            }
            JsonNode jsonResponse = objectMapper.readTree(response.getEntity().getContent());
            return jsonResponse.get("choices").get(0).get("text").asText().trim();
        }
    }
}
