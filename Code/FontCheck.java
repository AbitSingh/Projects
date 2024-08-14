import java.awt.GraphicsEnvironment;

public class FontCheck {
    public static void main(String[] args) {
        // Get the list of available fonts on the system
        String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        // Replace "Segoe UI" with the font you want to check
        String targetFont = "Segoe UI";

        boolean fontAvailable = false;

        // Check if the target font is in the list of available fonts
        for (String fontName : fontNames) {
            if (fontName.equals(targetFont)) {
                fontAvailable = true;
                break;
            }
        }

        if (fontAvailable) {
            System.out.println(targetFont + " is available on your system.");
        } else {
            System.out.println(targetFont + " is not available on your system.");
        }
    }
}
