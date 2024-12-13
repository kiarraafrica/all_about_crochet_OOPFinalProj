package crochet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import user.UserManager;

public class YarnStash {
    private ArrayList<Yarn> stash = new ArrayList<>();
    private Scanner input = new Scanner(System.in);
    private UserManager userManager = new UserManager("userData.txt");
    private String STASH_FILE;

    public YarnStash(String username) {
        this.STASH_FILE = username + "_stash.txt";
        loadStashFromFile();
    }

    public void displayMenu() {
        boolean exit = false;

        while (!exit) {
            userManager.clearScreen();
            System.out.println("+---------------------------------+");
            System.out.println("           My Yarn Stash");
            System.out.println("+---------------------------------+");
            System.out.println("         1. Display Stash");
            System.out.println("           2. Edit Stash");
            System.out.println("        3. Add to Yarn Stash");
            System.out.println("      4. Delete from Yarn Stash");
            System.out.println("-----------------------------------");
            System.out.println("             5. Exit");
            System.out.println("+---------------------------------+");
            System.out.print(" > Enter your choice (1-5): ");
            int choice;

            try {
                choice = input.nextInt();
                input.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid choice from the menu.");
                input.next();
                continue;
            }

            switch (choice) {
                case 1 -> displayStash();
                case 2 -> editStash();
                case 3 -> addYarn();
                case 4 -> removeYarn();
                case 5 -> {
                    userManager.clearScreen();
                    exit = true;
                }
                default -> System.out.println("Please enter a valid choice from the menu.");
            }
        }
    }

    public void displayStash() {
        userManager.clearScreen();
        System.out.println("+---------------------------------+");
        System.out.println("          Your Yarn Stash");
        System.out.println("+---------------------------------+");

        if (stash.isEmpty()) {
            System.out.println("---Your stash is empty.");
        } else {
            for (int k = 0; k < stash.size(); k++) {
                Yarn yarn = stash.get(k);
                System.out.println((k + 1) + ". " + yarn.displayInfo());
                System.out.println();
            }
            System.out.println("---Total yarns in stash: " + stash.size());
        }

        System.out.println();
        System.out.print("Press 'enter' to return to stash menu.");
        input.nextLine();
    }

    public void editStash() {
        userManager.clearScreen();
        if (stash.isEmpty()) {
            System.out.println("---Your stash is empty. Nothing to edit here.");

            System.out.println();
            System.out.print("Press 'enter' to return to stash menu.");
            input.nextLine();
            return;
        }

        System.out.println("+-------------------------------------------------------------------------+");
        System.out.println("                            Edit Your Yarn Stash");
        System.out.println("+-------------------------------------------------------------------------+");
        System.out.print(" > Enter the index (1-based) of the stash you want to edit ('x' to exit): ");
        String inputIndex = input.nextLine();

        if (inputIndex.equalsIgnoreCase("x")) return;

        int index;
        try {
            index = Integer.parseInt(inputIndex) - 1;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Returning to menu...");
            return;
        }

        if (index >= 0 && index < stash.size()) {
            Yarn yarn = stash.get(index);
            System.out.println("\n--- You are editing ");
            System.out.println(yarn.displayInfo());

            System.out.println();
            System.out.print(" > New Type ('k' to keep current): ");
            String newType = input.nextLine();
            if (!newType.equalsIgnoreCase("k") && !newType.isBlank()) yarn.setType(newType);

            System.out.println("-----------------------------------");
            System.out.print(" > New Color ('k' to keep current): ");
            String newColor = input.nextLine();
            if (!newColor.equalsIgnoreCase("k") && !newColor.isBlank()) yarn.setColor(newColor);

            System.out.println("-----------------------------------");
            System.out.print(" > New Weight ('k' to keep current): ");
            String newWeight = input.nextLine();
            if (!newWeight.equalsIgnoreCase("k") && !newWeight.isBlank()) yarn.setWeight(newWeight);

            System.out.println();
            System.out.println("---Yarn updated");
            saveStashToFile();
        } else {
            System.out.println("Invalid index.");
        }

        System.out.println();
        System.out.print("Press 'enter' to return to stash menu.");
        input.nextLine();
    }

    public void addYarn() {
        userManager.clearScreen();
        System.out.println("+---------------------------------+");
        System.out.println("         Add Yarn to Stash");
        System.out.println("+---------------------------------+");

        System.out.println();
        System.out.print(" > Type ('x' to exit): ");
        String type = input.nextLine();
        if (type.equalsIgnoreCase("x")) return;

        System.out.println("-----------------------------------");
        System.out.print(" > Color: ");
        String color = input.nextLine();

        System.out.println("-----------------------------------");
        System.out.print(" > Weight: ");
        String weight = input.nextLine();

        stash.add(new Yarn(type, color, weight));

        System.out.println();
        System.out.println("---Yarn added to your stash.");
        saveStashToFile();

        System.out.println();
        System.out.print("Press 'enter' to return to stash menu.");
        input.nextLine();
    }

    public void removeYarn() {
        userManager.clearScreen();
        if (stash.isEmpty()) {
            System.out.println("---Your stash is empty. Nothing to remove here.");

            System.out.println();
            System.out.print("Press 'enter' to return to stash menu.");
            input.nextLine();
            return;
        }

        System.out.println("+-------------------------------------------------------------------------+");
        System.out.println("                          Remove from Yarn Stash");
        System.out.println("+-------------------------------------------------------------------------+");
        System.out.print(" > Enter the index (1-based) of the stash you want to remove ('x' to exit): ");
        String inputIndex = input.nextLine();

        if (inputIndex.equalsIgnoreCase("x")) return;

        int index;
        try {
            index = Integer.parseInt(inputIndex) - 1;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Returning to menu...");
            return;
        }

        if (index >= 0 && index < stash.size()) {
            stash.remove(index);
            System.out.println("\n---Yarn removed from your stash.");
            saveStashToFile();
        } else {
            System.out.println("Invalid index.");
        }

        System.out.println();
        System.out.print("Press 'enter' to return to stash menu.");
        input.nextLine();
    }

    private void saveStashToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(STASH_FILE))) {
            for (Yarn yarn : stash) {
                writer.write(yarn.getType() + ", " + yarn.getColor() + ", " + yarn.getWeight());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving stash to file: " + e.getMessage());
        }
    }

    private void loadStashFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(STASH_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    stash.add(new Yarn(data[0], data[1], data[2]));
                }
            }
        } catch (IOException e) {
        }
    }

    public static class Yarn {
        private String type;
        private String color;
        private String weight;

        public Yarn(String type, String color, String weight) {
            this.type = type;
            this.color = color;
            this.weight = weight;
        }

        public String getType() {
            return type;
        }

        public String getColor() {
            return color;
        }

        public String getWeight() {
            return weight;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public String displayInfo() {
            return "Type: " + type + "\n" + "Color: " + color + "\n" + "Weight: " + weight;
        }
    }
}