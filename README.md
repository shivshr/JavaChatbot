# Java Document-Based Chatbot

This project is a Java-based chatbot that leverages OpenAI's GPT model to respond to user queries by searching and processing documents stored in a local directory. It combines document search with generative AI to provide relevant and context-aware responses.

## Project Structure

- **DocumentStore.java**: Handles loading and managing documents from a specified directory.
- **GPTClient.java**: Integrates with the OpenAI GPT API to generate responses based on user queries and document content.
- **DocumentChatbot.java**: The core logic that ties document retrieval with GPT-based response generation.
- **Main.java**: The entry point for the chatbot, providing a command-line interface for user interaction.
- **pom.xml**: Maven configuration file, including dependencies for JSON processing and HTTP client.

## Setup Instructions

1. **Clone the Repository**: Download or clone the repository to your local machine.
2. **API Key**: Replace the placeholder API key in `GPTClient.java` with your actual OpenAI API key.
3. **Documents Folder**: Update the path to your documents folder in `Main.java`.
4. **Build the Project**: Use Maven to build the project by running `mvn clean install`.
5. **Run the Chatbot**: Execute the `Main` class to start interacting with the chatbot.

## Dependencies

- Jackson (for JSON processing)
- Apache HttpClient (for making API requests)

## About the Developer

This project was developed by **Shiv Sharma**, a BTech graduate from ITM University, Gwalior (Class of 2023).
