package crochet;

import java.util.InputMismatchException;
import java.util.Scanner;
import user.UserManager;

public class CrochetMenu {
    private Scanner input = new Scanner(System.in);
    private UserManager userManager = new UserManager("userData.txt");
    private AboutCrochet aboutCrochet = new AboutCrochet();
    private Suggester suggester = new Suggester();
    
    public void crochetMenu(String currentUser) {
        boolean exit = false;

        YarnStash yarnStash = new YarnStash(currentUser);

        while (!exit) {
            System.out.println("+---------------------------------+");
            System.out.println("           Crochet Menu");
            System.out.println("+---------------------------------+");
            System.out.println("          1. Yarn Stash");
            System.out.println("        2. About Crochet");
            System.out.println("          3. Suggester");
            System.out.println("-----------------------------------");
            System.out.println("           4. Log Out");
            System.out.println("+---------------------------------+");
            System.out.print("  > Enter your choice (1-4): ");
            int choice = 0;

            try {
                choice = input.nextInt();
            }
            catch (InputMismatchException e) {
                userManager.clearScreen();
                System.out.println("Please enter a valid choice from the menu.");
                input.next();
                continue;
            }

            switch(choice) {
                case 1:
                    userManager.clearScreen();
                    yarnStash.displayMenu();
                    break;
                case 2:
                    userManager.clearScreen();
                    aboutCrochet.displayMenu();
                    break;
                case 3:
                    userManager.clearScreen();
                    suggester.displayMenu();
                case 4:
                    userManager.clearScreen();
                    System.out.println("Logging out...");
                    userManager.logout();
                    System.out.println();
                    return;
                default:
                    userManager.clearScreen();
                    System.out.println("Please enter a valid choice from the menu.");
            }
            input.nextLine();
        }
        input.close();
    }
}