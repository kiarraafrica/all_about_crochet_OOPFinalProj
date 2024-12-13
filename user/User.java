package user;

import java.util.Scanner;
import crochet.CrochetMenu;

public class User {
    private UserManager userManager = new UserManager("userData.txt");
    private Scanner input = new Scanner(System.in);

    public void signUp() {
        userManager.clearScreen();
        System.out.println("+-------------------------------------------+");
        System.out.println("|                    SIGN UP                |");
        System.out.println("+-------------------------------------------+");   
        
        String username;
        while (true) {
            username = userManager.setUsernameInput();
            if (username.equals("x")) {
                userManager.clearScreen();
                return;
            }
            if (!userManager.usernameExists(username)) break;
        }

        String password = userManager.setPasswordInput();
        userManager.saveUser(username, password);

        userManager.clearScreen();
        System.out.println("Sign-up successful!\n");
        return;
    }

    public void logIn() {
        userManager.clearScreen();
        System.out.println("+-------------------------------------------+");
        System.out.println("|                    LOG IN                 |");
        System.out.println("+-------------------------------------------+");

        String username = userManager.setUsernameInput();
        if (username.equals("x")) {
            userManager.clearScreen();
            return;
        }

        System.out.print("Enter password: ");
        String password = input.nextLine();

        if (userManager.loadUser(username, password)) {
            userManager.clearScreen();
            System.out.println("Login successful!\n");
            CrochetMenu crochetMenu = new CrochetMenu();
            crochetMenu.crochetMenu(username);
        }
        else {
            userManager.clearScreen();
            System.out.println("Invalid username or password. Please try again.\n");
        }
    }    
}