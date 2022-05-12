package edu.school21.printer.logic;
import java.awt.image.BufferedImage;

public class Logic {
    private static final int WHITE = -1;

    public static void outputImage(BufferedImage image, char whileColor, char blackColor) {

        for (int i = 0; i < image.getHeight(); i++) {

            for (int j = 0; j < image.getWidth(); j++) {

                if (image.getRGB(j, i) == WHITE) {
                    System.out.print(whileColor);
                } else {
                    System.out.print(blackColor);
                }
            }
            System.out.println();
        }
    }
}
