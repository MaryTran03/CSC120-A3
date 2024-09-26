import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

# Testing
public class Conversation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> transcript = new ArrayList<>();  // Stores the transcript of the conversation
        Random random = new Random();

        // Canned responses if no mirroring needed
        String[] cannedResponses = {
                "Mmm-hm.",
                "Interesting.",
                "Tell me more.",
                "I see.",
                "Go on.",
        };

        // Ask for the number of rounds
        System.out.print("How many rounds? ");
        int rounds = Integer.parseInt(scanner.nextLine());

        // Start the conversation
        System.out.println("Hi there! What's on your mind?");
        transcript.add("Hi there! What's on your mind?");

        // Conversation loop
        for (int i = 0; i < rounds; i++) {
            // Get user input
            String userInput = scanner.nextLine();
            transcript.add(userInput);

            // Mirror the response if possible, otherwise use a random canned response
            String[] words = userInput.split(" ");
            StringBuilder mirrored = new StringBuilder();

            // Loop through each word in user input to check for mirrorable words
            for (String word : words) {
                switch (word.toLowerCase()) {  // Convert word to lowercase for consistent mirroring
                    case "i":
                        mirrored.append("you ");
                        break;
                    case "me":
                        mirrored.append("you ");
                        break;
                    case "am":
                        mirrored.append("are ");
                        break;
                    case "you":
                        mirrored.append("I ");
                        break;
                    case "my":
                        mirrored.append("your ");
                        break;
                    case "your":
                        mirrored.append("my ");
                        break;
                    default:
                        mirrored.append(word + " ");  // No mirror match, add word as is
                        break;
                }
            }

            // Convert the mirrored string to a full response and trim extra spaces
            String mirroredResponse = mirrored.toString().trim();
            
            // If the mirrored response is the same as the original input, use a canned response
            String response = mirroredResponse.equals(userInput) ? "" : mirroredResponse + "?";

            // If no mirrored response was generated, pick a random canned response
            if (response.isEmpty()) {
                response = cannedResponses[random.nextInt(cannedResponses.length)];
            }

            // Print and store the response
            System.out.println(response);
            transcript.add(response);
        }

        // Say goodbye
        System.out.println("See ya!");
        transcript.add("See ya!");

        // Print the transcript at the end
        System.out.println("\nTRANSCRIPT:");
        for (String line : transcript) {
            System.out.println(line);
        }

        scanner.close();
    }
}
