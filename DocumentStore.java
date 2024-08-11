import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class DocumentStore {
    private final Map<String, String> documents = new HashMap<>();

    public DocumentStore(String folderPath) throws IOException {
        Files.list(Paths.get(folderPath))
                .filter(Files::isRegularFile)
                .forEach(path -> {
                    try {
                        documents.put(path.getFileName().toString(), new String(Files.readAllBytes(path)));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }

    public String getDocument(String filename) {
        return documents.get(filename);
    }

    public Map<String, String> getAllDocuments() {
        return documents;
    }
}
