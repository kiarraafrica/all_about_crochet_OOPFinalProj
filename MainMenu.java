import java.util.InputMismatchException;
import java.util.Scanner;
import user.User;
import user.UserManager;

public class MainMenu {
    private Scanner input = new Scanner(System.in);
    private User user = new User();
    private UserManager userManager = new UserManager("userData.txt");

    public void mainMenu() {
        boolean exit = false;

        while (!exit) {
            System.out.println("+----------------------------------+");
            System.out.println("              Main Menu");
            System.out.println("+----------------------------------+");
            System.out.println("            1. Sign Up");
            System.out.println("             2. Log In");
            System.out.println("-----------------------------------");
            System.out.println("              3. Exit");
            System.out.println("+----------------------------------+");
            System.out.print("  > Enter your choice (1-3): ");
            int choice = 0;

            try {
                choice = input.nextInt();
            }
            catch (InputMismatchException e) {
                userManager.clearScreen();
                System.out.println("Please enter a valid choice from the menu.\n");
                input.next();
                continue;
            }

            switch(choice) {
                case 1:
                    user.signUp();
                    break;
                case 2:
                    userManager.clearScreen();
                    user.logIn();
                    break;
                case 3:
                    userManager.clearScreen();
                    System.out.println("Exiting...");
                    exit = true;
                    break;
                default:
                    userManager.clearScreen();
                    System.out.println("Please enter a valid choice from the menu.");
                    System.out.println();
            }
            input.nextLine();
        }
        input.close();
    }
}