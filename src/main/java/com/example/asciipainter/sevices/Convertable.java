package com.example.asciipainter.sevices;

import java.awt.image.BufferedImage;

/**
 * @author Nick Musinov e-mail:n.musinov@gmail.com
 * 02.11.2023
 */
public interface Convertable {
    default String convertImageToAscii(BufferedImage bufferedImage) {
        StringBuilder builder = new StringBuilder();
        int[] pixels = bufferedImage.getRGB(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), null, 0, bufferedImage.getWidth());
        char[] asciiTable = {' ', ' ', '.', '*', '-', '!', '*', '@', '[', ']'};
        for (int i = 0; i < pixels.length; i++) {
            int red = (pixels[i] >> 16) & 0xff;
            int green = (pixels[i] >> 8) & 0xff;
            int blue = pixels[i] & 0xff;
            int averageColor = (red + green + blue) / 3;
            int index = (averageColor * (asciiTable.length - 1)) / 255;
            char asciiChar = asciiTable[index];
            builder.append(asciiChar);
            if ((i + 1) % bufferedImage.getWidth() == 0) {
                builder.append("\n");
            }
        }
        return builder.toString();
    }
}
