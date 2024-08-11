import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            DocumentChatbot chatbot = new DocumentChatbot("path-to-your-documents-folder");

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Enter your query (or type 'exit' to quit):");
                String query = scanner.nextLine();
                if ("exit".equalsIgnoreCase(query)) {
                    break;
                }
                String response = chatbot.respondToQuery(query);
                System.out.println("Chatbot: " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
