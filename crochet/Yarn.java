package crochet;

import java.util.ArrayList;
import java.util.List;

public class Yarn {
    private String name;
    private String description;
    private String hookSize;

    public Yarn(String name, String description, String hookSize) {
        this.name = name;
        this.description = description;
        this.hookSize = hookSize;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getHookSize() {
        return hookSize;
    }
}

class YarnInitializer {
    public static List<Yarn> initializeYarn() {
        List<Yarn> yarns = new ArrayList<>();
        yarns.add (new Yarn(
            "Cotton Yarn",
            "A soft, durable, and breathable natural fiber yarn with a smooth\n" +
            "\t     texture that showcases stitch definition.",
            "2.25 mm to 4.0 mm"
        ));
        yarns.add (new Yarn(
            "Velvet Yarn",
            "Luxurious and plush with a velvety feel, often slippery and hide\n" +
            "\t     stitches.",
            "6.0 mm to 8.0 mm"
        ));
        yarns.add (new Yarn(
            "Indophil Yarn",
            "A cotton-polyester blend with vibrant colors and a smooth, \n" +
            "\t     lightweight texture.",
            "4.0 mm to 5.0 mm"
        ));
        yarns.add (new Yarn(
            "Chunky Yarn",
            "Thick and cozy, offering quick results and a soft cushy fabric.",
            "8.0 mm to 12.0 mm"
        ));
        yarns.add (new Yarn(
            "Polyester Yarn",
            "Strong and durable, resistant to wrinkles and shrinking, with a\n" +
            "\t     smooth finish.",
            "4.0 mm to 5.5 mm"
        ));
        yarns.add (new Yarn(
            "Acrylic Yarn",
            "Affordable and versatile, lightweight with wool-like feel and a\n" +
            "\t     wide color range.",
            "4.0 mm  to 6.5 mm"
        ));
        yarns.add (new Yarn(
            "Chenille Yarn",
            "Soft and fuzzy with a thick, velvety texture, creating cuddly\n" +
            "\t     feel.",
            "6.0 mm to 8.0 mm"
        ));
        yarns.add (new Yarn(
            "Mohair Yarn",
            "Silky and lightweight, known for its warmth and luxurious sheen.",
            "2.5 mm to 3.5 mm"
        ));
        yarns.add (new Yarn(
            "T-Shirt Yarn",
            "Thich, eco-friendly yarn made from recycled T-shirts, offering\n" +
            "\t     a unique texture.",
            "10.0 mm to 15.0 mm"
        ));
        return yarns;
    }
}