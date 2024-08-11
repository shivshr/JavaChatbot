import java.io.IOException;
import java.util.Map;

public class DocumentChatbot {
    private final DocumentStore documentStore;
    private final GPTClient gptClient;

    public DocumentChatbot(String documentFolderPath) throws IOException {
        this.documentStore = new DocumentStore(documentFolderPath);
        this.gptClient = new GPTClient();
    }

    public String respondToQuery(String query) throws IOException {
        // 1. Find the most relevant document
        String relevantDocument = findRelevantDocument(query);

        // 2. Construct a prompt for the GPT model
        String prompt = "Document: " + relevantDocument + "\nUser Query: " + query + "\nAI:";
        
        // 3. Get the AI-generated response
        return gptClient.generateResponse(prompt);
    }

    private String findRelevantDocument(String query) {
        // Simple keyword-based matching (you can improve this with more advanced techniques)
        Map<String, String> allDocuments = documentStore.getAllDocuments();
        return allDocuments.values().stream()
                .filter(doc -> doc.contains(query))
                .findFirst()
                .orElse("No relevant document found.");
    }
}
