package crochet;

import java.util.Scanner;
import java.util.List;
import java.util.InputMismatchException;
import java.util.Random;

import user.UserManager;

public class Suggester {
    private Scanner input = new Scanner(System.in);
    private UserManager userManager = new UserManager("userData.txt");

    public void displayMenu() {
        boolean exit = false;

        while (!exit) {
            userManager.clearScreen();
            System.out.println("+--------------------------------------+");
            System.out.println("                Suggester");
            System.out.println("+--------------------------------------+");
            System.out.println("            1. Palette Picker");
            System.out.println("       2. Project Ideas Generator");
            System.out.println("----------------------------------------");
            System.out.println("                3. Exit");
            System.out.println("+--------------------------------------+");
            System.out.print(" > Enter your choice (1-3): ");
            int choice;

            try {
                choice = input.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("Please enter a valid choice from the menu.");
                input.next();
                continue;
            }
            input.nextLine();

            Suggester2 suggester = switch(choice) {
                case 1 -> new ColorSuggester();
                case 2 -> new ProjectSuggester();
                case 3 -> {
                    System.out.println("Exiting...");
                    exit = true;
                    yield null;
                }
                default -> {
                    System.out.println("Please enter a valid choice from the menu.");
                    yield null;
                }
            };

            if (suggester!= null) {
                suggester.getSuggestion();
            }
        }
    }
    
    public abstract class Suggester2 {
        public abstract void getSuggestion();
    }

    public class ColorSuggester extends Suggester2 {
        private Random random = new Random();

        private class ColorPalette {
            private String name;
            private String description;
            private String hexCode;

            public ColorPalette(String name, String description, String hexCode) {
                this.name = name;
                this.description = description;
                this.hexCode = hexCode;
            }

            @Override
            public String toString() {
                return name + ("\n") + 
                ("- ") + description + ("\n") +
                ("- ") + hexCode;
            }
        }

        @Override
        public void getSuggestion() {
            boolean exit = false;

            while (!exit) {
                userManager.clearScreen();
                System.out.println("+--------------------------------------+");
                System.out.println("              Palette Idea");
                System.out.println("+--------------------------------------+");
                System.out.println("           1. 1-color Palette");
                System.out.println("           2. 2-color Palette");
                System.out.println("           3. 5-color Palette");
                System.out.println("----------------------------------------");
                System.out.println("                4. Exit");
                System.out.println("+--------------------------------------+");
                System.out.print(" > Enter your choice (1-4): ");
                int choice;

                try {
                    choice = input.nextInt();
                }
                catch (InputMismatchException e) {
                    System.out.println("Please enter a valid choice from the menu.");
                    input.next();
                    continue;
                }

                switch (choice) {
                    case 1 -> displayPalettes(1);
                    case 2 -> displayPalettes(2);
                    case 3 -> displayPalettes(5);
                    case 4 -> {
                        return;
                    }
                    default -> System.out.println("Please enter a valid choice from the list.");
                }
            }
        }

        private void displayPalettes(int numColor) {
            String lastPalette = "";

            while (true) {
                userManager.clearScreen();

                String palette = switch (numColor) {
                    case 1 -> getRandomOneColor();
                    case 2 -> getRandomTwoColors();
                    case 5 -> getRandomFiveColors();
                    default -> "No palette available for this.";
                };

                if (palette.equals(lastPalette)) {
                    continue;
                }

                lastPalette = palette;

                System.out.println("+--------------------------------------+");
                System.out.println("            Suggested Palette");
                System.out.println("+--------------------------------------+");
                System.out.println(palette);

                System.out.println();
                System.out.print("Press 'enter' for next palette or 'x' to exit: ");
                String userInput = input.nextLine();

                if (userInput.equalsIgnoreCase("x")) {
                    break;
                }
            }
        }

        private String getRandomOneColor() {
            List<ColorPalette> oneColor = List.of(
                new ColorPalette("Blushing Rose", "Muted pink that evokes the gentle, soft hues of a rose at dusk, creating romantic and delicate ambiance.", "B74F6F"),
                new ColorPalette("Lavender Mist", "Pastel lavender that brings to mind a serene, mist-covered landscape at dawn, offering a calming and subtle presence.", "ADBDFF"),
                new ColorPalette("Cocoa Truffle", "Rich deep brown suggests that warmth and indulgence of dark chocolate, creating a luxurious and earthy feel.", "35281D"),
                new ColorPalette("Sagebrush", "Musted green evoked the earthy, calming tones of sage leaves, creating peaceful and natural ambiance.", "648767"),
                new ColorPalette("Fresh Sprout", "Vibrant green evokes the lively and refreshing energy of new growth, symbolizing tge rejuvenation of spring and the vitality of nature.", "7CDF64"),
                new ColorPalette("Autumn Spice", "Rich earthy orange evokes the warmth and vibrancy of fall, with hints of cinnamon and spice, creating a zoccy, inviting atmosphere.", "DA7635"),
                new ColorPalette("Burnt Sienna", "Rich redding-brown hue evokes the warmth and depth of autumn leaves and natural earthy tones, adding a bold and cozy feel to any design.", "A62639"),
                new ColorPalette("Violet Dream", "Vibrant purple evokes a sense of calm and mystery, reminiscent of a twilight sky or a dreamy, ethereal landscape.", "AB81CD")
            );
            return oneColor.get(random.nextInt(oneColor.size())).toString();
        }

        private String getRandomTwoColors() {
            List<ColorPalette> twoColor = List.of(
                new ColorPalette("Midnight Glow", "The dark blue reflects the night sky's depth, while the soft white evokes the gentle starlight, creating a serene contrast.", "001F54, FEFCFB"),
                new ColorPalette("Dusky Rose", "The cool blue evokes twilight, and the muted red add richness, blending for a vintage-inspired feel.", "8ACDEA, 8C4843"),
                new ColorPalette("Golden Mocha", "Sunny yellow and deep brown evoke golden light and the warmth of coffee, offering comforting balance.", "F2DD6E & 523A34"),
                new ColorPalette("Forest Bloom", "Deep green symbolizes dense foliage, while lime green brings fresh growth, capturing the nature's vitality.", "386C0B, 38A700"),
                new ColorPalette("Silver Twilight", "Muted gray-blue and silvery hues evoke twilight's calm, blending serenity elegance.", "767B91, C7CCDB"),
                new ColorPalette("Golden Sunrise", "Amber and soft golden yellow radiate warmth and energy, like a rising sun's optimism.", "FFB627, FFC971"),
                new ColorPalette("Spiced Amber", "Rich orange and golden amber evoke autumn spices, creating cozy, inviting harvest vibe.", "CC5803, E2711D"),
                new ColorPalette("Moss and Wood", "Earthy green and rich brown reflect moss and wood, evoking a grounded, rustic harmony.", "23231A, 6A5837")
            );
            return twoColor.get(random.nextInt(twoColor.size())).toString();
        }

        private String getRandomFiveColors() {
            List<ColorPalette> fiveColor = List.of(
                new ColorPalette("Vintage Velvet", "Dark hues mixed with soft pastels create a luxurious, timeless aesthethic with an elegant, old-world charm.", "2E0E02, 581908, 983628, E2AEDD, EBCBF4"),
                new ColorPalette("Rustic Rose Garden", "Soft pinks, warm neutrals, and earth greens evokes a blooming garden with a rustic, cozy feel.", "FAB3A9, C6AD94, 7FB285, 463239, ED6B86"),
                new ColorPalette("Desert Sunset", "Deep browns, warm terracottas, and sandy tones reflect a sunlit desert, capturing an earthy and serene vibe.", "4F3130, 753742, AA5042, D8BD8A, D8D78F"),
                new ColorPalette("Spring Meadow", "Fresh blues and greens evoke a vibrant spring meadow, filled with new growth and clear skies.", "CFFCFF, AAEFDF, 9EE37D, 63C132, 358600"),
                new ColorPalette("Ocean Depths", "Deep blues and aquas capture the ocean's mystery, while creamy white adds contrast, like waves on the shore.", "0A1128, 001F54, 034078, 1282A2, FEFCFB"),
                new ColorPalette("Autumn Fireside", "Golden amber, deep browns, and spicy oranges evokes a cozy autumn fire, accented with mossy greens and glowing leaves.", "DB995A, 654236, D6D4A0, DA7635, E24E1B"),
                new ColorPalette("Crimson Ember", "Rich dark tones and fiery reds evoke glowing embers, creating a passionate, dramatic atmosphere.", "250902, 38040E, 640D14, 800E13, AD2831"),
                new ColorPalette("Cerulean Cascade", "Sky blues fading to royal indigos captures cascading water's flow, blending serenity, energy, and depth.", "ADD7F6, 87BFFF, 3F8EFC, 2667FF, 3B28CC")
            );
            return fiveColor.get(random.nextInt(fiveColor.size())).toString();
        }
    }

    public class ProjectSuggester extends Suggester2 {
        private Random random = new Random();

        private class ProjectIdea {
            private String name;
            private String yarnSuggestion;
            private String design;

            public ProjectIdea(String name, String yarnSuggestion, String design) {
                this.name = name;
                this.yarnSuggestion = yarnSuggestion;
                this.design = design;
            }

            @Override
            public String toString() {
                return "Project: " + name + "\n" + "Yarn Suggestion: " + yarnSuggestion + "\n" + "Design: " + design;
            }
        }

        @Override
        public void getSuggestion() {
            boolean exit = false;

            while (!exit) {
                userManager.clearScreen();
                System.out.println("+--------------------------------------+");
                System.out.println("         Project Idea Generator");
                System.out.println("+--------------------------------------+");
                System.out.println("            1. Simple Projects");
                System.out.println("             2. Big Projects");
                System.out.println("----------------------------------------");
                System.out.println("                 3. Exit");
                System.out.println("+--------------------------------------+");
                System.out.print(" > Enter your choice (1-3): ");
                int choice;

                try {
                    choice = input.nextInt();
                    input.nextLine();
                }
                catch (InputMismatchException e) {
                    System.out.println("Please enter a valid choice from the menu.");
                    input.next();
                    continue;
                }

                switch (choice) {
                    case 1 -> displayRandomProjects(getSimpleProjects());
                    case 2 -> displayRandomProjects(getBigProjects());
                    case 3 -> exit = true;
                    default -> System.out.println("Please enter a valid choice from the menu.");
                }
            }
        }

        private List<ProjectIdea> getSimpleProjects() {
            return List.of(
                new ProjectIdea("Keychain", "Cotton or Acrylic Yarn", "Flower/Fruit"),
                new ProjectIdea("Bookmark", "Mohair or Cotton Yarn", "Rectangular/Long Stem Leaves"),
                new ProjectIdea("Coin Purse", "Acrylic or Chenille Yarn", "Circular/Shell/Bread"),
                new ProjectIdea("Headband", "Cotton or Indophil Yarn", "Rectangular/Flower/Granny Square/Twisted Pattern"),
                new ProjectIdea("Hairclip", "Cotton or Indophil Yarn", "Flower/Bow"),
                new ProjectIdea("Coaster", "Cotton or T-shit Yarn", "Square/Round"),
                new ProjectIdea("Gloves", "Cotton or Acrylic", "Fingerless/Paw Design"),
                new ProjectIdea("Pouch", "Chunky or Indophil Yarn", "Draw String/Box Pencil Case"),
                new ProjectIdea("Scarf", "Mohair or Acrylic", "Ribbed/Textured/Granny Square"),
                new ProjectIdea("Bandana", "Cotton or Indophil Yarn", "Floral/Granny Square")
            );
        }

        private List<ProjectIdea> getBigProjects() {
            return List.of (
                new ProjectIdea("Blanket", "Acrylic or Chunky Yarn", "Granny Square"),
                new ProjectIdea("Tote Bag", "Cotton or T-shirt Yarn", "Gingham/Granny Square/Plain/Cloud"),
                new ProjectIdea("Top", "Cotton or Indophil Yarn", "Tank Top/Beach Top"),
                new ProjectIdea("Cardigan", "Acrylis, Mohair, or Polyester Yarn", "Open-front/Button-up/Cropped"),
                new ProjectIdea("Floor Rug", "Tshirt Yarn", "Circular/Rectangular"),
                new ProjectIdea("Pillow", "Velvet, Acrylic, or Polyester Yarn", "Pom-poms/Stripes"),
                new ProjectIdea("Sweater Vest", "Acryilic or Chenille Yarn", "Ribbed/Oversized"),
                new ProjectIdea("Wall Hanging", "Tshirt or Polyester Yarn", "Boho/Abstract Patterns"),
                new ProjectIdea("Plushie", "Velvet, Chunky, or Cotton Yarn", "Dinosaur/Bear/Whale")
            );
        }

        private void displayRandomProjects(List<ProjectIdea> projects) {
            String lastProject = "";
            
            while (true) {
                userManager.clearScreen();

                ProjectIdea project = projects.get(random.nextInt(projects.size()));
                String currentProject = project.toString();

                if (currentProject.equals(lastProject)) {
                    continue;
                }

                System.out.println("+--------------------------------------+");
                System.out.println("            Suggested Project");
                System.out.println("+--------------------------------------+");
                System.out.println(currentProject);

                System.out.println();
                System.out.print("Press 'enter' to view more ideas or 'x' to exit: ");
                String userInput = input.nextLine();
                if (userInput.equalsIgnoreCase("x")) {
                    break;
                }
            }
        }
    }
}