package edu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi.BColor;

public class Logic {
    public void outputImage(BColor firstColor, BColor secondColor, URL image) {

        ColoredPrinter coloredPrinter1 = new ColoredPrinter.Builder(1, false).background(firstColor).build();
        ColoredPrinter coloredPrinter2 = new ColoredPrinter.Builder(1, false).background(secondColor).build();

        try {
            BufferedImage source = ImageIO.read(image);

            for (int y = 0; y < source.getHeight(); y++) {

                for (int x = 0; x < source.getWidth(); x++) {
                    int color = source.getRGB(x, y);

                    if (color == Color.BLACK.getRGB()) {
                        coloredPrinter1.print(" ");
                    } else {
                        coloredPrinter2.print(" ");
                    }
                }
                System.out.println();
            }
        } catch (IllegalArgumentException ex) {
            System.err.println("No valid color!");
            System.err.println("Valid color are: BLACK BLUE CYAN GREEN MAGENTA NONE RED WHITE YELLOW");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
