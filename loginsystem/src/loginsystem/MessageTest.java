/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginsystem;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author thikhedzo
 */
public class MessageTest {




    public MessageTest() {
    }

    // Test message length success
    @Test
    public void testMessageLengthSuccess() {

        Message msg = new Message();

        String expected = "Message ready to send.";

        String actual = msg.checkMessageLength(
                "Hi Mike, can you join us for dinner tonight?");

        assertEquals(expected, actual);
    }

    // Test message length failure
    @Test
    public void testMessageLengthFailure() {

        Message msg = new Message();

        String longMessage =
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

        String actual = msg.checkMessageLength(longMessage);

        assertTrue(actual.contains("Message exceeds 250 characters"));
    }

    // Test recipient success
    @Test
    public void testRecipientSuccess() {

        Message msg = new Message();

        boolean actual =
                msg.checkRecipientCell("+27718693002");

        assertTrue(actual);
    }

    // Test recipient failure
    @Test
    public void testRecipientFailure() {

        Message msg = new Message();

        boolean actual =
                msg.checkRecipientCell("08575975889");

        assertFalse(actual);
    }

    // Test message hash
    @Test
    public void testMessageHash() {

        Message msg = new Message();

        String actual =
                msg.createMessageHash(
                        "0012345678",
                        0,
                        "Hi Mike");

        String expected = "00:0:HIMIKE";

        assertEquals(expected, actual);
    }

    // Test total messages
    @Test
    public void testTotalMessages() {

        Message msg = new Message();

        msg.addMessage();
        msg.addMessage();

        int expected = 2;

        int actual = msg.returnTotalMessages();

        assertEquals(expected, actual);
    }
}    

