package crochet;

import java.util.ArrayList;
import java.util.List;

public class Tips {
    private String name;
    private String tips;

    public Tips(String name, String tips) {
        this.name = name;
        this.tips = tips;
    }

    public String getName() {
        return name;
    }

    public String getTips() {
        return tips;
    }
}

class TipsInitializer {
    public static List<Tips> initializeTips() {
        List<Tips> tips = new ArrayList<>();
        tips.add (new Tips(
            "Keep a Crochet Journal",
            "Track projects, yarn types, hook sizes, and any adjustments in a\n" +
            "\t   crochet journal. This is helpful when revisiting patterns or\n" +
            "\t   keeping a record of your project."
        ));
        tips.add (new Tips(
            "Practice Yarn Tension",
            "Consistent tension is key for an even, professional-looking finish.\n" +
            "\t   Practice with various yarn weights and hook sized to find the right\n" +
            "\t   feel for your project."
        ));
        tips.add (new Tips(
            "Blocking Your Work",
            "After finishing a project, especially lacy ones, blocking can help\n" +
            "\t   smooth and shape the stitches. Wet or steam-block your work to give\n" +
            "\t   it a professional touch."
        ));
        tips.add (new Tips(
            "Learn Foundation Stitches",
            "Foundation stitches, like the foundation single or double crochet,\n" +
            "\t   allow you to start a project without a traditional chain. This is\n" +
            "\t   often more flexible and less tight than starting with a chain."
        ));
        tips.add (new Tips(
            "Chain Loosely for Foundation Rows",
            "If your foundation chain is too tight, the starting row may pucker.\n" +
            "\t   Try using a hook size up for the chain and then switch to the correct\n" +
            "\t   hook for the rest of the project."
        ));
        tips.add (new Tips(
            "Mind Your Edges",
            "To create neat edges, insert your hook under both loops of the last\n" +
            "\t   stitch in each row, or work a border around the edges to hide\n" +
            "\t   imperfections."
        ));
        tips.add (new Tips(
            "Use a Yarn Bowl",
            "Yarn bowls prevent your yarn from tangling or rolling away as you\n" +
            "\t   work, making it easier to maintain consistent tension."
        ));
        tips.add (new Tips(
            "Practice Frogging",
            "Frogging (or pulling out stitches) is part of crochet. Don't be\n" +
            "\t   afraid to unravel mistakes to improve the final look. Also,\n" +
            "\t   practice frogging without damaging the yarn."
        ));
        tips.add (new Tips(
            "Magic Circle",
            "When working in the round, start with a magic circle to create an\n" +
            "\t   adjustable, gap-free center. It's especially useful for amigurumi\n" +
            "\t   and hats."
        ));
        tips.add (new Tips(
            "Use Scraps for Smaller Projects",
            "Don't throw away small craps of yarn. Use them to make tiny projects\n" +
            "\t   like granny squares, or even practice swatching for new stitches."
        ));
        tips.add (new Tips(
            "Master the Invisible Decrease",
            "This technique is great for amigurumi or any project that needs\n" +
            "\t   hidden decreases. It prevents the 'gap' that regular decreases\n" +
            "\t   sometimes leave."
        ));
        tips.add (new Tips(
            "Changing of Colors",
            "For a seamless transition, switch to the new color on the final pull\n" +
            "\t   through of the last stitch in the current color. Starting the next\n" +
            "\t   stitch cleanly with the new color."
        ));
        return tips;
    }
}