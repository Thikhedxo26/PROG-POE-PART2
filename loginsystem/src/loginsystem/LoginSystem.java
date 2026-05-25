/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package loginsystem;

/**
 *
 * @author thikhedzo
 */


import java.util.Scanner;

public class LoginSystem {

    String username;
    String password;
    String cellPhone;
    String firstName;
    String lastName;

    public boolean checkUserName(String username) {
        if (username.contains("_") && username.length() <= 5) {
            return true;
        } else {
            return false;
        }
    }


    public boolean checkCellPhoneNumber(String cellPhone) {
        if (cellPhone.startsWith("+27") && cellPhone.length() == 12) {
            return true;
        } else {
            return false;
        }
    }
    
     public boolean checkPasswordComplexity(String password) {

        if (password.length() >= 8 &&
            password.matches(".*[A-Z].*") &&
            password.matches(".*[0-9].*") &&
            password.matches(".*[!@#$%^&].*")) {

            return true;
        } else {
            return false;
        }
    }

     public String registerUser(String username, String password, String cellPhone, String firstName, String lastName) {

        if (!checkUserName(username)) {
            return "Username is not correctly formatted.";
        }

        if (!checkCellPhoneNumber(cellPhone)) {
            return "Cell phone number incorrectly formatted .";
        }

        this.username = username;
        this.password = password;
        this.cellPhone = cellPhone;
        this.firstName = firstName;
        this.lastName = lastName;

        return "User registered successfully.";
    }

    public boolean loginUser(String username, String password) {

        if (this.username.equals(username) && this.password.equals(password)) {
            return true;
        } else {
            return false;
        }
    }
    
public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    LoginSystem login = new LoginSystem();
    Message msg = new Message();
    
    System.out.println("Register");

    System.out.println("Enter first name:");
    String firstName = input.nextLine();

    System.out.println("Enter last name:");
    String lastName = input.nextLine();

    // USERNAME LOOP
    String username;
    while (true) {
        System.out.println("Enter username:");
        username = input.nextLine();

        if (login.checkUserName(username)) {
            break;
        } else {
            System.out.println("Username is not correctly formatted;please ensure that your username contains an underscore and is no more than five charactersb in length. Try again.");
        }
    }

    // PASSWORD LOOP 
    String password;
    while (true) {
        System.out.println("Enter password:");
        password = input.nextLine();

        if (login.checkPasswordComplexity(password)) {   
            break;
        } else {
            System.out.println("Password is not correctly formarted;please ensure that the password contains atleast eight characters;a capital letter;a number and a special character. Try again.");
        }
    }

    // CELLPHONE LOOP
    String cellPhone;
    while (true) {
        System.out.println("Enter phone number (+27):");
        cellPhone = input.nextLine();

        if (login.checkCellPhoneNumber(cellPhone)) {
            break;
        } else {
            System.out.println("Cell phone number incorrectly formatted or does not contain international code. Try again.");
        }
    }

    String message = login.registerUser(username, password, cellPhone, firstName, lastName);
    System.out.println(message);

   
 // LOGIN
    if (message.equals("User registered successfully.")) {

        System.out.println("Login");

        while (true) {

            System.out.println("Enter username:");
            String loginUser = input.nextLine();

            System.out.println("Enter password:");
            String loginPass = input.nextLine();

            if (login.loginUser(loginUser, loginPass)) {

                System.out.println("Welcome " + firstName + " " + lastName + ", it is great to see you again.");
                System.out.println("Welcome to QuickChat.");

                System.out.println("How many messages would you like to send?");
                int numMessages = input.nextInt();
                input.nextLine();

                int sentMessages = 0;

                while (true) {

                    System.out.println("1) Send Messages");
                    System.out.println("2) Show recently sent messages");
                    System.out.println("3) Quit");

                    int choice = input.nextInt();
                    input.nextLine();

                    if (choice == 1) {

                        if (sentMessages >= numMessages) {
                            System.out.println("Message limit reached.");
                            continue;
                        }

                        System.out.println("Enter recipient number:");
                        String recipient = input.nextLine();

                        if (msg.checkRecipientCell(recipient)) {
                            System.out.println("Cell phone number successfully captured.");
                        } else {
                            System.out.println("Cell phone number is incorrectly formatted or does not contain an international code.");
                            continue;
                        }

                        System.out.println("Enter your message:");
                        String userMessage = input.nextLine();

                        String lengthResult = msg.checkMessageLength(userMessage);
                        System.out.println(lengthResult);

                        if (userMessage.length() <= 250) {

                            String hash = msg.createMessageHash("00", sentMessages, userMessage);

                            System.out.println("Choose option:");
                            System.out.println("1) Send Message");
                            System.out.println("2) Disregard Message");
                            System.out.println("3) Store Message");

                            int sendChoice = input.nextInt();
                            input.nextLine();

                            if (sendChoice == 1) {

                                sentMessages++;

                                System.out.println("Message successfully sent.");

                                System.out.println("Message Details:");
                                System.out.println("Message ID: 00");
                                System.out.println("Message Hash: " + hash);
                                System.out.println("Recipient: " + recipient);
                                System.out.println("Message: " + userMessage);

                            } else if (sendChoice == 2) {

                                System.out.println("Press 0 to delete message.");

                            } else if (sendChoice == 3) {

                                System.out.println("Message successfully stored.");
                            }
                        }

                    } else if (choice == 2) {

                        System.out.println("Coming Soon.");

                    } else if (choice == 3) {

                        System.out.println("Total messages sent: " + sentMessages);
                        System.out.println("Goodbye.");
                        break;
                    }
                }

                break;

            } else {

                System.out.println("Username or password incorrect, please try again.");
            }
        }
    } // LOGIN
    if (message.equals("User registered successfully.")) {

        System.out.println("Login");

        while (true) {

            System.out.println("Enter username:");
            String loginUser = input.nextLine();

            System.out.println("Enter password:");
            String loginPass = input.nextLine();

            if (login.loginUser(loginUser, loginPass)) {

                System.out.println("Welcome " + firstName + " " + lastName + ", it is great to see you again.");
                System.out.println("Welcome to QuickChat.");

                System.out.println("How many messages would you like to send?");
                int numMessages = input.nextInt();
                input.nextLine();

                int sentMessages = 0;

                while (true) {

                    System.out.println("1) Send Messages");
                    System.out.println("2) Show recently sent messages");
                    System.out.println("3) Quit");

                    int choice = input.nextInt();
                    input.nextLine();

                    if (choice == 1) {

                        if (sentMessages >= numMessages) {
                            System.out.println("Message limit reached.");
                            continue;
                        }

                        System.out.println("Enter recipient number:");
                        String recipient = input.nextLine();

                        if (msg.checkRecipientCell(recipient)) {
                            System.out.println("Cell phone number successfully captured.");
                        } else {
                            System.out.println("Cell phone number is incorrectly formatted or does not contain an international code.");
                            continue;
                        }

                        System.out.println("Enter your message:");
                        String userMessage = input.nextLine();

                        String lengthResult = msg.checkMessageLength(userMessage);
                        System.out.println(lengthResult);

                        if (userMessage.length() <= 250) {

                            String hash = msg.createMessageHash("00", sentMessages, userMessage);

                            System.out.println("Choose option:");
                            System.out.println("1) Send Message");
                            System.out.println("2) Disregard Message");
                            System.out.println("3) Store Message");

                            int sendChoice = input.nextInt();
                            input.nextLine();

                            if (sendChoice == 1) {

                                sentMessages++;

                                System.out.println("Message successfully sent.");

                                System.out.println("Message Details:");
                                System.out.println("Message ID: 00");
                                System.out.println("Message Hash: " + hash);
                                System.out.println("Recipient: " + recipient);
                                System.out.println("Message: " + userMessage);

                            } else if (sendChoice == 2) {

                                System.out.println("Press 0 to delete message.");

                            } else if (sendChoice == 3) {

                                System.out.println("Message successfully stored.");
                            }
                        }

                    } else if (choice == 2) {

                        System.out.println("Coming Soon.");

                    } else if (choice == 3) {

                        System.out.println("Total messages sent: " + sentMessages);
                        System.out.println("Goodbye.");
                        break;
                    }
                }

                break;

            } else {

                System.out.println("Username or password incorrect, please try again.");
            }
        }
    }
    }
}
