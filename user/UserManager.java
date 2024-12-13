package user;

import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserManager {
    private Scanner input = new Scanner(System.in);
    private String userData;
    private String currentUser;

    public UserManager(String userData) {
        this.userData = userData;
        this.currentUser = "";
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public String setUsernameInput() {
        String username;

        while (true) {
            System.out.print("Enter a username ('x' to exit): ");
            username = input.nextLine();
            if (username.equalsIgnoreCase("x")) return "x";
            if (username.length() >= 6) break;
            clearScreen();
            System.out.println("Username must be at least 6 characters long.\n"); 
        }
        return username;
    }

    public boolean usernameExists(String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader(userData))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.split(",")[0].trim().equals(username)) {
                    clearScreen();
                    System.out.println("Username already exists.\n");
                    return true;
                }
            }
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    public String setPasswordInput() {
        String password;

        while (true) {
            System.out.print("Enter a password: ");
            password = input.nextLine();
            if (password.length() >= 8) break;
            clearScreen();
            System.out.println("Password must be at least 8 characters long.\n");
        }
        return password;
    }

    public void saveUser(String username, String password) {
        try (FileWriter fileWriter = new FileWriter(userData, true)) {
            fileWriter.write(username + ", " + password + System.lineSeparator());
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public boolean loadUser(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(userData))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.trim().split(", ", 2);
                if (parts.length == 2) {
                    String storedUsername = parts[0];
                    String storedPassword = parts[1];
                    if (username.equals(storedUsername) && password.equals(storedPassword)) {
                        currentUser = username;
                        return true;
                    }
                }
            }
            return false;
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public String getCurrentUser() {
        return currentUser;
    }

    public boolean isLoggedIn() {
        return !currentUser.isEmpty();
    }

    public void logout() {
        currentUser = "";
    }
}