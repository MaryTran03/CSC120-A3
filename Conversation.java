import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Create a conversation class
 * @param none
 * @return none
 */

// Testing
public class Conversation {

    public static void main(String[] args) {

        // Declaring all the variables
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> transcript = new ArrayList<>();  // Stores the transcript of the conversation
        Random random = new Random(); // To pick the random response later
        String response; // Final response to go to loops

        // Canned responses if no mirroring needed
        String[] cannedResponses = {
                "Mmm-hm.",
                "Interesting.",
                "Haha.",
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
                        mirrored.append("you "); // Add this word to the mirrored sentence
                        break;
                    case "me":
                        mirrored.append("you "); // Add this word to the mirrored sentence
                        break;
                    case "am":
                        mirrored.append("are "); // Add this word to the mirrored sentence
                        break;
                    case "you":
                        mirrored.append("I "); // Add this word to the mirrored sentence
                        break;
                    case "my":
                        mirrored.append("your "); // Add this word to the mirrored sentence
                        break;
                    case "your":
                        mirrored.append("my "); // Add this word to the mirrored sentence
                        break;
                    default:
                        mirrored.append(word + " ");  // No mirror match, add word as is
                        break;
                }
            }

            // Convert the mirrored string to a full response and trim extra spaces
            String mirroredResponse = mirrored.toString().trim();
            
            // If the mirroed is the same as the original input (no change of pronouns), pick a canned response randomly
            if (mirroredResponse.equals(userInput)) {
                response = cannedResponses[random.nextInt(cannedResponses.length)];
            } else {
                response = mirroredResponse + "?";
            }
            
            // Print and store the response
            System.out.println(response);
            transcript.add(response);
        }

        // Say goodbye
        System.out.println("That's the end of the game. See ya!");
        transcript.add("That's the end of the game. See ya!");

        // Print the transcript at the end

        System.out.println("\nTRANSCRIPT:");

        // Print each line in the transcript
        for (String line : transcript) {
            System.out.println(line);
        }
        scanner.close();        
        
    }
}
