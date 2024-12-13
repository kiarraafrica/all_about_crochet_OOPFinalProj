package crochet;

import java.util.ArrayList;
import java.util.List;

public class Tool {
    private String name;
    private String description;

    public Tool(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}

class ToolInitializer {
    public static List<Tool> initializeTools() {
        List<Tool> tools = new ArrayList<>();
        tools.add (new Tool(
            "Crochet Hook",
            "Used to create stitches by pulling yarn through loops.\n" +
            "\t     - Sizes = 2.00mm, 2.25mm, 2.5mm, 2.75mm, 3.0mm, so on...\n" +
            "\t     - Materials = Metal, Plastic, or Bamboo"
        ));
        tools.add (new Tool(
            "Scissor",
            "A small, sharp scissor designed for precision cutting of yarn."
        ));
        tools.add (new Tool(
            "Stich Marker",
            "A small clip or ring used to mark crochet project, such as the\n" +
            "\t     beginning or end of a round, helping you keep track of your\n" +
            "\t     progress."
        ));
        tools.add (new Tool(
            "Tapestry Needle",
            "A large, blunt needle with a wide eye, specifically desgined for\n" +
            "\t     weaving in yarn ends and stitching pieces of your crochet projects\n" +
            "\t     together, ensuring a neat finish."
        ));
        tools.add (new Tool(
            "Measuring Tape",
            "A flexible tape measure, used to check the dimensions of your\n" +
            "\t     crochet items to ensure accuracy and fit."
        ));
        tools.add (new Tool(
            "Yarn Winder",
            "A handy tool that transform skeins or hanks of yarn into tidy,\n" +
            "\t     compact cakes, preventing tangling and allowing for easy access\n" +
            "\t     during your crochet work."
        ));
        tools.add (new Tool(
            "Safety Eyes & Nose",
            "Plastic eyes and noses designed for use in amigurumi, providing a\n" +
            "\t     secure and safe option for adding facial features without the\n" +
            "\t     risk of detachment."
        ));
        tools.add (new Tool(
            "Stuffing (polyfill)",
            "Soft, fluffy filler material used to give shape and dimension to\n" + 
            "\t     stuffed crochet items like toys and pillows, ensuring a plush\n" +
            "\t     and cuddly finish."
        ));
        tools.add (new Tool(
            "Buttons",
            "Decorative or functional fasteners available in various sizes,\n" +
            "\t     colors, and materials used to secure openings on garments or\n" +
            "\t     add a personalized touch to crochet accessories."
        ));
        tools.add (new Tool(
            "Lobster Claw or Hook",
            "A type of clasp that allows for easy attachment and detachment of\n" +
            "\t     crochet items to keychains, bags, or other accessories, providing\n" + 
            "\t     functionality and style."
        ));
        tools.add (new Tool(
            "D-Ring or Buckle",
            "Sturdy metal hardware used for attaching strap on bags, belts, or\n" + 
            "\t     other crochet projects, adding durability and a professional\n" +
            "\t     finish."
        ));
        tools.add (new Tool(
            "Keychain Ring (Metal Chain Links & Jump Rings)",
            "A metal ring for holding keys or charms, complemented by metal\n" + 
            "\t     chain links for added length and jump rings for connecting\n" +
            "\t     components ideal for creating personalized crochet keychains."
        ));
        return tools;
    }
}