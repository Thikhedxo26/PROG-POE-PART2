/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginsystem;
import java.util.Random;
/**
 *
 * @author thikhedzo
 */


public class Message {

    int totalMessages = 0;


public String generateMessageID() {

    Random random = new Random();

    long number = 1000000000L + (long)(random.nextDouble() * 9000000000L);

    return String.valueOf(number);
}

public boolean checkMessageID(String messageID) {

    if (messageID.length() <= 10) {
        return true;
    } else {
        return false;
    }
}
    // Check recipient number
    public boolean checkRecipientCell(String number) {

        if (number.startsWith("+27") && number.length() <= 12) {
            return true;
        } else {
            return false;
        }
    }

    // Check message length
    public String checkMessageLength(String message) {

        if (message.length() <= 250) {
            return "Message ready to send.";
        } else {

            int extra = message.length() - 250;

            return "Message exceeds 250 characters by "
                    + extra +
                    ", please reduce the size.";
        }
    }

    // Create message hash
    public String createMessageHash(String messageID,
                                    int messageNumber,
                                    String message) {

        String[] words = message.split(" ");

        String firstWord = words[0];
        String lastWord = words[words.length - 1];

        String hash = messageID.substring(0, 2)
                + ":" +
                messageNumber
                + ":" +
                firstWord
                + lastWord;

        return hash.toUpperCase();
    }
    public void addMessage() {
        
      totalMessages++;  
        
    }
    // Count total messages
    public int returnTotalMessages() {
        return totalMessages;
    }

}